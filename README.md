# Janus-Parser-with-antlr4
Janus reversible computing programming language with antlr4

This is a simple guide to using Janus parser.

# INSTALLATION

- Install Java(Version 1.6 or higher).

- Install atlr4 grammar from this https://github.com/antlr/antlr4/blob/master/doc/getting-started.md

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
    make
    java janus fibonacci.jan // start parsing
    cd out
    make // for queue structure
    cd .. // return to src directory   
    ./outexe // lunch program

