//this is a main function
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class janus {
    public static void main(String[] args) throws Exception {

        File file;
        String filename;

        manageFileOut mfo = new manageFileOut();
        utility ut = new utility();
        //set option arguments for parsing
        ut.getArg(args);

        System.out.println("Starting parsing to " + args[0]);

        //create object to generate code, check extension and create file to output
        genereteCode genCode = new genereteCode();
        genCode.checkExtension(args[0]);
        filename = args[0].substring(args[0].lastIndexOf("/") + 1, args[0].lastIndexOf("."));
        genCode.initFile(filename);
        // set Include for c/c++
        genCode.setStInclude();

        //Lexer
        janusLexer lexer = new janusLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        //Parser
        janusParser parser = new janusParser(tokens);
        ParseTreeWalker walker = new ParseTreeWalker();

        //use to set token number
        tokens.getNumberOfOnChannelTokens();
        //main tree
        ParseTree maintree;

        ParseTree structTree;


        //se è uguale a struct dichiaro la struct
        if(tokens.get(0).getText().compareTo("struct") == 0){
            System.out.println(tokens.get(0).getText());
            structTree = parser.struct();

            janusStructDeclare structDeclare = new janusStructDeclare(genCode,ut);
            walker.walk(structDeclare, structTree);
        }
        //if(parser.struct() != null && !parser.struct().isEmpty()){
            //struct declaration
            //janusStructDeclare structDeclare = new janusStructDeclare(genCode,ut);
            //walker.walk(structDeclare, structTree);
        //}
        //if first token is not main
        if(tokens.get(1).getText().compareTo("main") != 0){

            ParseTree tree = parser.functions();

            //port and semaphore declaration, if find fork and join set Include for concurrency
            janusDecPort jWalkerP = new janusDecPort(genCode,ut);
            walker.walk(jWalkerP, tree);

            //Forward and reverse function declaration
            janusDecFun jWalkerF = new janusDecFun(genCode, 0); // 0 = forward
            walker.walk(jWalkerF, tree);

            //fork and join declare, forward and reverse
            forkDecProgram forkcount = new forkDecProgram(genCode);
            walker.walk(forkcount, tree);

            genCode.setBlankLine();

            //struct declaration
            //janusStructDeclare structDeclare = new janusStructDeclare(genCode,ut);
            //walker.walk(structDeclare, tree);

            //increment indent
            ut.incIndent();

            //fork and join function forward, implements threads functions
            forkInitForward forkin = new forkInitForward(genCode, ut);
            walker.walk(forkin, tree);

            //fork and join function back, implements threads functions
            forkInitReverse forkinB = new forkInitReverse(genCode, ut);
            walker.walk(forkinB, tree);

            genCode.setBlankLine();
            //decrement indent
            ut.decIndent();

            //forward
            janusWriteF jWriterF = new janusWriteF(genCode, ut);
            walker.walk(jWriterF, tree);

            //reverse
            janusWriteB jWriteB = new janusWriteB(genCode, ut);
            walker.walk(jWriteB, tree);
        }

        //main
        maintree = parser.mainFun();
        janusWriteF jWriterF = new janusWriteF(genCode, ut);
        walker.walk(jWriterF, maintree);


        mfo.initFile(filename);
        mfo.writeFile("ciaociao");


        //compile and execute c program
        if (ut.getCompile()) { // ok to compile
            try {
                Process process = Runtime.getRuntime().exec("make -C ./src/out/ FILENAME=" + filename, null);
                StringBuilder output = new StringBuilder();

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(process.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line + "\n");
                }

                int exitVal = process.waitFor();

                // auto run
                if (ut.getAutoRun()) {
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
                    System.out.println("End program");
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


        System.out.println("End program");

    }
}

