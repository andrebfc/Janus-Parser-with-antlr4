This is a simple guide to using Janus parser.

# INSTALLATION

- Install Java(Version 1.6 or higher).

- Install atlr4 grammar from this https://github.com/antlr/antlr4/blob/master/doc/getting-started.md

(requires some exports and aliases, see website above)

- Install c++ compiler.

# USE PARSER

## COMPILE

Into 'src' folder use 'make' command to compile.

## STARTING PARSING

The parser takes in input only '.jan' extesion (example: fibinacci.jan).

To start parsing use this command:
    
     java janus [filename.jan]
     
## RUN

After the parsing use './out' command to exec program.

## EXAMPLE

    //after INSTALLATION
    
    cd ./Janus-Parser-with-antlr4/src/
    antlr4 janus.g4                     // create java parser files
    make                                // compile java files
    java janus fibonacci.jan            // start parsing
    cd out                              // enter out folder
    make                                // compile c program with queue structure
    ./out                               // lunch program
    
    
