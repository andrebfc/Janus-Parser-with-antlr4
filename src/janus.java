import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;


public class janus {
    public static void main(String[] args) throws Exception {

        File file;
        String filename;

        // opt arg
        int type_msg = 0; // 0 = message passing local struct, 1 = shared memory
        int join = 0; //0 = no pthread_join
        int no_compile = 0; // 0 = auto compile
        int auto_run = 0; // 0 = no auto run
        // for not repeat option, es: set memory before msg and after share, opt -jms is not valid
        boolean set_type_msg = false;
        boolean set_join = false;
        boolean set_no_compile = false;
        boolean set_auto_run = false;

        int limit = 65000; // standar limit queue

        //if call only help man
        if(args[0].compareTo("-h") == 0 || args[0].compareTo("--help") == 0){
            JanusHelp jh = new JanusHelp();
            jh.printHelp();
            System.exit(0);
        }


        if (args.length > 1) {
            for (int i = 1; i < args.length; i++) {
                if (args[i].charAt(0) == '-') {
                    for (int j = 1; j < args[i].length(); j++) {
                        if (args[i].charAt(j) == 'm') {
                            if (!set_type_msg) {
                                type_msg = 0;
                                set_type_msg = true;
                            } else {
                                System.out.println("Incorrect option\n");
                                System.exit(1);
                            }
                        } else if (args[i].charAt(j) == 's') {
                            if (!set_type_msg) {
                                type_msg = 1;
                                set_type_msg = true;
                            } else {
                                System.out.println("Incorrect option\n");
                                System.exit(1);
                            }
                        } else if (args[i].charAt(j) == 'j') {
                            if (!set_join) {
                                join = 1;
                                set_join = true;
                            } else {
                                System.out.println("Incorrect option\n");
                                System.exit(1);
                            }
                        } else if (args[i].charAt(j) == 'n') {
                            if (!set_no_compile && !set_auto_run) {
                                no_compile = 1;
                                set_no_compile = true;
                                set_auto_run = true;
                            } else {
                                System.out.println("Incorrect option\n");
                                System.exit(1);
                            }
                        }
                        else if (args[i].charAt(j) == 'r'){
                            if(!set_no_compile && !set_auto_run){
                                auto_run = 1;
                                set_no_compile = true;
                                set_auto_run = true;
                            }
                            else {
                                System.out.println("Incorrect option\n");
                                System.exit(1);
                            }
                        }
                        else if (args[i].charAt(j) == 'h'){
                            // only help option is allow
                            if (!set_type_msg && !set_join && !set_no_compile && !set_auto_run){
                                //System.out.println("stampo manuale opzioni ed esco");
                                JanusHelp jh = new JanusHelp();
                                jh.printHelp();
                                System.exit(0);
                            }
                            else {
                                System.out.println("Incorrect option\n");
                                System.exit(1);
                            }
                        }
                    }
                }
                else if(args[i].charAt(0) == 'l'){ // define limit queue
                    StringBuilder lim = new StringBuilder();
                    int j = 0;
                    while(args[i].charAt(j) != '='){
                        lim.append(args[i].charAt(j));
                        j++;
                    }
                    StringBuilder limit_value = new StringBuilder();
                    if(lim.toString().compareTo("limit") == 0){
                        for(j = j+1; j < args[i].length();j++){
                            limit_value.append(args[i].charAt(j));
                        }
                    }
                    else{
                        System.out.println("Incorrect option\n");
                        System.exit(1);
                    }
                    //copy limit value
                    if(Integer.parseInt(limit_value.toString()) < limit) {
                        limit = Integer.parseInt(limit_value.toString());
                    }
                }
                else {
                    System.out.println("Incorrect option\n");
                    System.exit(1);
                }
            }
        }

        System.out.println("Starting parsing to " + args[0]);

        genereteCode genCode = new genereteCode();
        genCode.checkExtension(args[0]);
        filename = args[0].substring(args[0].lastIndexOf("/") + 1, args[0].lastIndexOf("."));
        genCode.initFile(filename);

        genCode.setInclude("#include <stdio.h>\n");
        genCode.setInclude("#include <assert.h>\n");
        genCode.setInclude("#include <math.h>\n");
        genCode.setInclude("#include <stdlib.h>\n");
        genCode.setInclude("#include <semaphore.h>\n");
        genCode.setInclude("#include <string.h>\n");
        genCode.setInclude("#include \"../concurrency/queue.h\"\n\n");

        genCode.setInclude("#define limit "+ limit +"\n\n");

        janusLexer lexer = new janusLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        janusParser parser = new janusParser(tokens);
        ParseTree tree = parser.functions();
        ParseTreeWalker walker = new ParseTreeWalker();

        //port and semaphore declaration
        janusDecPort jWalkerP = new janusDecPort(genCode);
        walker.walk(jWalkerP, tree);

        //Forward and reverse function declaration
        janusDecFun jWalkerF = new janusDecFun(genCode, 0); // 0 = forward
        walker.walk(jWalkerF, tree);

        //fork and join declare, forward and reverse
        forkDecProgram forkcount = new forkDecProgram(genCode);
        walker.walk(forkcount, tree);

        genCode.setBlankLine();

        //struct declaration
        janusStructDeclare structDeclare = new janusStructDeclare(genCode);
        walker.walk(structDeclare, tree);

        //fork and join function forward
        forkInitForward forkin = new forkInitForward(genCode, 1, type_msg);//indent, //type msg passing memory
        walker.walk(forkin, tree);

        //fork and join function back
        forkInitReverse forkinB = new forkInitReverse(genCode, 1, type_msg);//indent, //type msg passing memory
        walker.walk(forkinB, tree);

        genCode.setBlankLine();
        //forward
        janusWriteF jWriterF = new janusWriteF(genCode, 0, type_msg, join);
        walker.walk(jWriterF, tree);

        //reverse
        janusWriteB jWriteB = new janusWriteB(genCode, 0, type_msg, join);//type msg passing memory
        walker.walk(jWriteB, tree);

        //main
        ParseTree maintree = parser.mainFun();
        janusWriteF jWriter = new janusWriteF(genCode, 0, type_msg, join);
        walker.walk(jWriter, maintree);


        //compile and execute c program
        if (no_compile == 0) { // ok to compile
            try {

                Process process = Runtime.getRuntime().exec("make -C ./out/ FILENAME=" + filename, null);

                StringBuilder output = new StringBuilder();

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(process.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line + "\n");
                }

                int exitVal = process.waitFor();

                // auto run
                if (auto_run == 1) {
                    try {
                        System.out.println("Execute " + filename);
                        String s = null;
                        //System.out.println("to run: " + filename);
                        Process proc_run = Runtime.getRuntime().exec("./" + filename);
                        //int exitRun = proc_run.waitFor();


                        BufferedReader stdInput = new BufferedReader(new
                                InputStreamReader(proc_run.getInputStream()));

                        BufferedReader stdError = new BufferedReader(new
                                InputStreamReader(proc_run.getErrorStream()));

                        //print output
                        while ((s = stdInput.readLine()) != null) {
                            System.out.println(s);
                        }
                        //print error
                        while ((s = stdError.readLine()) != null) {
                            System.out.println(s);
                        }

                        System.exit(0);

                    } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(-1);
                    }
                }

                if (exitVal == 0) {
                    System.exit(0);
                } else {
                    System.out.println("Error make c++ compile, try to compile into out folder");
                    System.exit(1);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

