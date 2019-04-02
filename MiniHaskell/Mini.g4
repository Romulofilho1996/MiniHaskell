grammar Mini;

expression: LPAREN exp=expression RPAREN									                  # ParenthesisExpression
		 | TRUE                                       									      # TrueExpression
		 | FALSE																			  # FalseExpression
		 | Integer   																		  # IntegerExpression
		 | Identifier																		  # IdentifierExpression
		 | left=expression PLUS 		right=expression         							  # SumExpression
		 | left=expression MINUS 		right=expression									  # SubtractionExpression
		 | left=expression TIMES 		right=expression									  # MultiplicationExpression
		 | left=expression DIVIDED_BY 	right=expression									  # DivisionExpression
		 | left=expression AND 			right=expression									  # LogicAndExpression
		 | left=expression OR 			right=expression  									  # LogicOrExpression
		 | left=expression GT 			right=expression         							  # GreaterThanExpression
		 | left=expression GE 			right=expression									  # GreaterEqualExpression
		 | left=expression LT 			right=expression         							  # LessThanExpression
		 | left=expression LE 			right=expression      								  # LessEqualExpression
		 | left=expression EQ 			right=expression									  # EqualsExpression
		 | NOT exp=expression                     										      # LogicNotExpression
		 | LET nome=Identifier ATB valor=expression IN corpo=expression 					  # LetExpression
		 | nome=Identifier parametros=expression+									          # ApplyFuncExpression
		 | IF condicao=expression THEN clausula_then=expression ELSE clausula_else=expression # IfExpression;

declaration: nome=Identifier DOUBLE_COLON LPAREN args=formalParameters RPAREN ATB corpo=expression #FunctionDeclaration;



RAW_TYPE: ('Int'|'Bool');

formalParameters
    :   formalParameter (',' formalParameter)*
    ;
formalParameter
    :   type=RAW_TYPE id=Identifier
    ;


ATB: '=';
LET: 'let';
IN: 'in';
IF: 'if';
THEN: 'then';
ELSE: 'else';
INT: 'Int';
BOOL: 'Bool';
ARROW: '->';
DOUBLE_COLON: '::';




NOT: 'not';

TRUE: 'True';
FALSE: 'False';
LPAREN: '(';
RPAREN: ')';
PLUS: '+';
MINUS: '-';
TIMES: '*';
DIVIDED_BY: '/';



AND: '&&';
OR: '||';
GT: '>';
GE: '>=';
LT: '<';
LE: '<=';
EQ: '==';


Integer: [0-9]+;


Identifier: [a-zA-Z_][a-zA-Z_0-9]*;

WHITESPACE: [ \t\n\r]+ -> skip;