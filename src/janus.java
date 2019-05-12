import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;

public class janus {
    public static void main(String[] args) throws Exception {

        File file;

        System.out.println("Starting parsing to " + args[0]);


        genereteCode genCode = new genereteCode();

        genCode.checkExtension(args[0]);

        genCode.setInclude("#include <stdio.h>\n");
        genCode.setInclude("#include <assert.h>\n");
        genCode.setInclude("#include <math.h>\n");
        genCode.setInclude("#include <stdlib.h>\n");
        genCode.setInclude("#include <semaphore.h>\n");
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
        forkInitForward forkin = new forkInitForward(genCode,1);//indent
        walker.walk(forkin, tree);

        //fork and join function back
        forkInitReverse forkinB = new forkInitReverse(genCode,1);//indent
        walker.walk(forkinB, tree);

        genCode.setBlankLine();
        //forward
        janusWriteF jWriterF = new janusWriteF(genCode,0);
        walker.walk(jWriterF, tree);

        //reverse
        janusWriteB jWriteB = new janusWriteB(genCode);
        walker.walk(jWriteB, tree);

        //main
        ParseTree maintree = parser.mainFun();
        janusWriteF jWriter = new janusWriteF(genCode,0);
        walker.walk(jWriter, maintree);


        //compile and execute c program

        Runtime.getRuntime().exec("make -C ./out/");
        /*
        file = new File("./out/out");
        if(!file.exists()){
            System.err.println("file does not exist");
            exit(1);
        }
        */
        /*
        try {
            Process p = Runtime.getRuntime().exec("./out/out");
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        */
    }
}
