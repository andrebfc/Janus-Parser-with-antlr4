import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;

public class janus {
    public static void main(String[] args) throws Exception {

        File file;
        String filename;
        int type_msg = 0; // 0 = message passing local struct, 1 = shared memory
        int main_rev = 0;

        System.out.println("Starting parsing to " + args[0]);


        genereteCode genCode = new genereteCode(args[0]);


        genCode.checkExtension(args[0]);
        filename = args[0].substring(args[0].lastIndexOf("/")+1,args[0].lastIndexOf("."));
        genCode.initFile(filename);


        if(args.length > 1){ // option args
            if(args[1].compareTo("-m") == 0){
                type_msg = 0;
            }
            else if (args[1].compareTo("-s") == 0){
                type_msg = 1;
            }
            else{
                System.out.println("Incorrect option\n");
                System.exit(1);
            }
        }


        genCode.setInclude("#include <stdio.h>\n");
        genCode.setInclude("#include <assert.h>\n");
        genCode.setInclude("#include <math.h>\n");
        genCode.setInclude("#include <stdlib.h>\n");
        genCode.setInclude("#include <semaphore.h>\n");
        genCode.setInclude("#include <string.h>\n");
        genCode.setInclude("#include \"queue.h\"\n\n");

        genCode.setInclude("#define limit 65000\n\n");

        janusLexer lexer = new janusLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        janusParser parser = new janusParser(tokens);
        ParseTree tree = parser.functions();
        ParseTreeWalker walker = new ParseTreeWalker();

        //port and semaphore declaration
        janusDecPort jWalkerP = new janusDecPort(genCode);
        walker.walk(jWalkerP, tree);

        //Forward and reverse function declaration
        janusDecFun jWalkerF = new janusDecFun(genCode,0); // 0 = forward
        walker.walk(jWalkerF, tree);

        //fork and join declare, forward and reverse
        forkDecProgram forkcount = new forkDecProgram(genCode);
        walker.walk(forkcount,tree);

        genCode.setBlankLine();

        //struct declaration
        janusStructDeclare structDeclare = new janusStructDeclare(genCode);
        walker.walk(structDeclare,tree);

        //fork and join function forward
        forkInitForward forkin = new forkInitForward(genCode,1,type_msg);//indent, //type msg passing memory
        walker.walk(forkin, tree);

        //fork and join function back
        forkInitReverse forkinB = new forkInitReverse(genCode,1,type_msg);//indent, //type msg passing memory
        walker.walk(forkinB, tree);

        genCode.setBlankLine();
        //forward
        janusWriteF jWriterF = new janusWriteF(genCode,0,type_msg);
        walker.walk(jWriterF, tree);

        //reverse
        janusWriteB jWriteB = new janusWriteB(genCode,0,type_msg);//type msg passing memory
        walker.walk(jWriteB, tree);

        //main
        ParseTree maintree = parser.mainFun();
        janusWriteF jWriter = new janusWriteF(genCode,0,type_msg);
        walker.walk(jWriter, maintree);


        //compile and execute c program

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

