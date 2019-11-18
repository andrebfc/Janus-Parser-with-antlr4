// define janus grammar

grammar janus;

program :  functions? mainFun
        ;

functions : function
          | function functions
          ;

function : functionDeclaration portDeclare? block? //functionBody
         ;


mainFun : 'procedure' 'main' '(' ')'  portDeclare? block?
        ;


functionDeclaration : 'procedure' tagName '(' parametersDeclaration? ')'
                    ;


//for the functions declaration
parametersDeclaration : paramDecFun
                      | paramDecFun ',' parametersDeclaration
                      ;


block        : localParamDeclare
             | localParamDeclare block
             | paramDeclare
             | paramDeclare block
             | assignmentExpression
             | assignmentExpression block
             | ifConstructor
             | ifConstructor block
             | loopConstructor
             | loopConstructor block
             | functionCall
             | functionCall block
             | forkandjoin
             | forkandjoin block
             | print
             | print block
             | msgpass
             | msgpass block
             | struct
             | struct block
             | localPortDeclare
             | localPortDeclare block
             | structInit
             | structInit block
             ;

portDeclare : 'port' port portDeclare?
            | 'port' port
            ;

localPortDeclare : local 'port' port portDeclare?
                 | local 'port' port
                 ;

loopConstructor : 'from' condition doExp? loopExp? 'until' condition
                ;

doExp : 'do' block
      ;

loopExp : 'loop' block
        ;

ifConstructor : ifExpression fiExpression
              | ifExpression elseExpression fiExpression
              ;

ifExpression : 'if' '('? condition ')'? 'then' block
             ;

elseExpression : 'else' block
               ;

fiExpression : 'fi' condition
             ;

forkandjoin : 'fork' (tagName variableName)? block 'and' block 'join' // tagName is struct argument
            ;

functionCall : call tagName '(' arguments? ')'
             ;

condition : '('? value opcondition value ')'?
          | condition logicalExpression condition
          ;

assignmentExpression : value assignmentOperator value
                     ;

paramDecFun : type variableName array?
            | type variableName array? paramDecFun
            ;
paramDeclare : type variableName array? assignmentOperator? value?
             | type variableName array? assignmentOperator? Digit? paramDeclare
             ;

localParamDeclare : local type variableName array? (opcondition value)?
                  ;

arguments : variableName array?
          | variableName array? ',' arguments
          ;

print : 'print' value
      | 'print' tagName'.'value
      ;

struct : 'struct' tagName paramDeclare 'end'
       ;

structInit : 'struct' tagName structName
           ;

msgpass : typemsg '(' variableName ',' port ')'
        | typemsg '(' tagName'.'value ',' port ')'
        ;

typemsg : 'ssend' | 'srcv' | 'asend' | 'arcv'
        ;

array : '[' ']'
      | '[' value ']'
      ;

opcondition: '='
           | '!='
           | '<'
           | '>'
           | '<='
           | '>='
           ;

assignmentOperator: '+='
                  | '-='
                  | '<=>'  //swap
                  | '='
                  | '^='
                  ;

operator : '*' | '+' | '-' | '/' | '%' | '^' | '&' | '~';

logicalExpression : '&&' | '||' | '!';

value : variableName array?
      | Digit
      | tagName'.'value //this for struct
      | '(' value ')'
      | value operator value
      ;


variableName : Text
             | TextDigit
             //| tagName'.'value
             ;


structName : Text
             | TextDigit
             //| tagName'.'value
             ;

local : 'local'
      | 'delocal'
      ;

type : 'int'
     ;


call : 'call'
     | 'uncall'
     ;

port : Text
     ;

tagName : Text
        | Text '_' Text
        ;

Text : [a-zA-Z_]+
     ;

Digit: [0-9]+
     ;

TextDigit : [a-z0-9]+
          ;

WS : [ \t\r\n]+ -> skip
   ;

BlockComment
    :   '/*' .*? '*/'
        -> skip
    ;

LineComment
    :   '//' ~[\r\n]*
        -> skip
;