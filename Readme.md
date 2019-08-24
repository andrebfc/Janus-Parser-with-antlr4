This is a simple guide to using Janus parser.

# INSTALLATION

- Install Java(Version 1.6 or higher).

- Install atlr4 grammar from this https://github.com/antlr/antlr4/blob/master/doc/getting-started.md

- Install c++ compiler.

# USE PARSER

## COMPILE

Into main folder use 'make' command to compile.

## STARTING PARSING

The parser takes in input only '.jan' extesion (example: fibinacci.jan).

To start parsing use this command:
    
     java janus [filename.jan]
     
If you want to use 'print' function compile with -j option      
     
## RUN

After the parsing use './filename' command to exec program.

## EXAMPLE

    //after INSTALLATION
    
    cd ./Janus-Parser-with-antlr4/src/
    antlr4 src/janus.g4                     // create java parser files
    make                                // compile java files
    cd src/                             // enter source dir
    java janus fibonacci.jan            // start parsing
    ./out                               // lunch program
    



    
    
