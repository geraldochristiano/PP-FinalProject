grammar D;

program     : stat*;

stat    : (type|array) ID SEMI                                      #declareStat
        | (type|array)? ID '=' expr SEMI                            #assignStat
        | ID INCR SEMI                                              #incrStat
        | ID DECR SEMI                                              #decrStat
        | WHILST LPAR expr RPAR (stat)?                             #whilstStat
        | WHENEVER LPAR expr RPAR (stat)? (ELSEWAYS stat)?          #wheneverStat
        | LOOP LPAR (stat)? SEMI (expr)? SEMI (expr)? RPAR (stat)?  #loopStat
        | LCURLY stat* RCURLY                                       #blockStat
        ;

expr    : (MINUS|NOT) expr                  #prefixExpr
        | expr POW expr                     #expoExpr
        | expr (MULT|DIV) expr              #multDivExpr
        | expr (PLUS|MINUS) expr            #addMinExpr
        | expr (EQ|NEQ|LT|GT|LEQ|GEQ) expr  #compareExpr
        | expr (AND|OR) expr                #andOrExpr
        | LPAR expr RPAR                    #parensExpr
        | ID                                #idExpr
        | INTEGER                           #integerExpr
        | BOOLEAN                           #booleanExpr
        | '\'' ANYCHAR '\''                 #charExpr
        ;

/** Data types*/
type        : INT | BOOL | CHAR ;
array       : type LBAR INTEGER RBAR;

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

INT         : 'int';
BOOL        : 'bool';
CHAR        : 'char';
FUNCTION    : 'F';
ID          : LETTER (LETTER | '_' | NUMBER)*;
INTEGER     : [1-9] NUMBER*;
BOOLEAN     : ('go'|'no-go');  //true | false
ANYCHAR     : .;

SEMI        : ';';
WHILST      : 'whilst';  //while
WHENEVER    : 'whenever';  //if
ELSEWAYS    : 'elseways';  //else
LOOP        : 'loop';  //for

fragment NUMBER : [0-9];
fragment LETTER : [a-zA-Z];
WS : [ \t\n\r] -> skip; // whitespace

