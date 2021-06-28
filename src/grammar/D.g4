grammar D;

program     : stat*;

stat    : SHARED? dataType ID (COMMA ID)* SEMI                              #declareStat
        | (SHARED? dataType)? ID (COMMA ID)* '=' expr (COMMA expr)* SEMI    #assignStat
        | ID INCR SEMI                                                      #incrStat
        | ID DECR SEMI                                                      #decrStat
        | WHILST LPAR expr RPAR stat                                        #whilstStat
        | WHENEVER LPAR expr RPAR stat (ELSEWAYS stat)?                     #wheneverStat
        | LOOP LPAR stat SEMI expr SEMI stat RPAR stat                      #loopStat
        | LCURLY stat* RCURLY                                               #blockStat
        | PARALLEL LCURLY stat* RCURLY                                      #parallelStat
        | CRITICAL LCURLY stat* RCURLY                                      #critSectionStat
        | BREAK SEMI                                                        #breakStat
        | CONTINUE SEMI                                                     #continueStat
        | SEMI                                                              #doNothingStat
        ;

expr    : prefixOp expr                     #prefixExpr
        | expr POW expr                     #expoExpr
        | expr multOp expr                  #multDivExpr
        | expr addOp expr                   #addMinExpr
        | expr compOp expr                  #compareExpr
        | expr bitwiseOp expr               #bitwiseOpExpr
        | expr shiftOp expr                 #shiftOpExpr
        | LPAR expr RPAR                    #parensExpr
        | ID                                #idExpr
        | INTEGER                           #integerExpr
        | BOOLEAN                           #booleanExpr
        | CHARLITERAL                       #charExpr
        | STRLITERAL                        #stringExpr
        | LBAR (expr (COMMA expr)*)? RBAR   #arrayExpr
        ;


/** Operators */
prefixOp    : MINUS #negate
            | NOT   #not
            ;

compOp      : EQ    #equal
            | NEQ   #notEqual
            | LT    #lessThan
            | GT    #greaterThan
            | LEQ   #lessEqual
            | GEQ   #greaterEqual
            ;

multOp      : MULT  #multiply
            | DIV   #divide
            ;

addOp       : PLUS  #plus
            | MINUS #minus
            ;

bitwiseOp   : AND       #and
            | OR        #or
            | XOR       #xor
            ;

shiftOp     : LSHIFT    #lshift
            | RSHIFT    #rshift
            ;

/** Data types definitions*/
dataType    : array         #arrayType
            | primitive     #primType
            ;

primitive   : INT       #intType
            | BOOL      #boolType
            | CHAR      #charType
            | STRING    #stringType
            ;

array       : primitive (LBAR INTEGER RBAR)+;

EQ          : '=='; // Equal to
NEQ         : '!='; // Not equal to
LT          : '<';  // Less than
GT          : '>';  // Greater than
LEQ         : '<='; // Less than or equal to
GEQ         : '>='; // Greater than or equal to
INCR        : '++';
DECR        : '--';
POW         : '^';
NOT         : '!';
PLUS        : '+';
MINUS       : '-';
MULT        : '*';
DIV         : '/';
LPAR        : '(';
RPAR        : ')';
LCURLY      : '{';
RCURLY      : '}';
LBAR        : '[';
RBAR        : ']';
AND         : 'and';
OR          : 'or';
XOR         : 'xor';
LSHIFT      : '<<';
RSHIFT      : '>>';
QUOTE       : '\'';
DQUOTE      : '"';
COMMA       : ',';

SEMI        : ';';
SHARED      : 'shared';
CRITICAL    : 'critical';
WHILST      : 'whilst';  //while
WHENEVER    : 'whenever';  //if
ELSEWAYS    : 'elseways';  //else
LOOP        : 'loop';  //for
INT         : 'int';
BOOL        : 'bool';
CHAR        : 'char';
STRING      : 'str';
FUNCTION    : 'function';
PARALLEL    : 'parallel';
BREAK       : 'break';
CONTINUE    : 'continue';
BOOLEAN     : ('go'|'no-go');  //true | false

CHARLITERAL : QUOTE CharLiteral QUOTE;
STRLITERAL  : DQUOTE StringLiteral* DQUOTE;
ID          : LETTER (LETTER | '_' | NUMBER)*;
INTEGER     : ('0'|[1-9] NUMBER*);

WS : [ \t\n\r] -> skip; // whitespace

fragment NUMBER         : [0-9];
fragment LETTER         : [a-zA-Z];
fragment CharLiteral    : ~['\\\t\n\r] | EscapeSequence;
fragment StringLiteral  : ~["\\\t\n\r] | EscapeSequence;
fragment EscapeSequence : '\\' [btnfr"'\\];
