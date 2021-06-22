grammar D;

program     : stat*;

stat    : dataType ID (COMMA ID)* SEMI                              #declareStat
        | dataType? ID (COMMA ID)* '=' expr SEMI                    #assignStat
        | ID INCR SEMI                                              #incrStat
        | ID DECR SEMI                                              #decrStat
        | WHILST LPAR expr RPAR stat                                #whilstStat
        | WHENEVER LPAR expr RPAR stat (ELSEWAYS stat)?             #wheneverStat
        | LOOP LPAR stat? SEMI expr? SEMI stat? RPAR stat           #loopStat
        | LCURLY stat* RCURLY                                       #blockStat
        | PARALLEL WAIT? LCURLY stat* RCURLY                        #parallelStat
        | SEMI                                                      #doNothingStat
        ;

expr    : prefixOp expr                     #prefixExpr
        | expr POW expr                     #expoExpr
        | expr multOp expr                  #multDivExpr
        | expr addOp expr                   #addMinExpr
        | expr compOp expr                  #compareExpr
        | expr boolOp expr                  #andOrExpr
        | LPAR expr RPAR                    #parensExpr
        | ID                                #idExpr
        | INTEGER                           #integerExpr
        | BOOLEAN                           #booleanExpr
        | CHARLITERAL                       #charExpr
        | STRLITERAL                        #stringExpr
        | LBAR (expr (COMMA expr)*)? RBAR   #arrayExpr
        ;

//function    : FUNCTION returnType ID  LCURLY stat* RCURLY; // FOR functions

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

boolOp      : AND   #and
            | OR    #or
            ;

/** Data types definitions*/
dataType    : array         #arrayType
            | primitive     #primType
            ;

/*returnType  : dataType      #functionReturn
            | VOID          #procedureReturn
            ;
*/ // FOR functions
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
QUOTE       : '\'';
DQUOTE      : '"';
COMMA       : ',';

SEMI        : ';';
//VOID        : 'void';  // FOR functions
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
WAIT        : 'wait';
BOOLEAN     : ('go'|'no-go');  //true | false

CHARLITERAL : QUOTE CharLiteral QUOTE;
STRLITERAL  : DQUOTE StringLiteral* DQUOTE;
ID          : LETTER (LETTER | '_' | NUMBER)*;
INTEGER     : [1-9] NUMBER*;

WS : [ \t\n\r] -> skip; // whitespace

fragment NUMBER         : [0-9];
fragment LETTER         : [a-zA-Z];
fragment CharLiteral    : ~['\\\t\n\r] | EscapeSequence;
fragment StringLiteral  : ~["\\\t\n\r] | EscapeSequence;
fragment EscapeSequence : '\\' [btnfr"'\\];
