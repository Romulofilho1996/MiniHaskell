grammar MiniHaskell;

prog: stat+;

stat:	expression NEWLINE			# printExpression
	|	ID '=' expression NEWLINE	# assign
	|	NEWLINE						# blank
	;

expression:	expression op=('*'|'/') expression  	# MultiplicacaoEDivisao
   		  | expression op=('+'|'-') expression  	# SomaESubtracao
   		  |	expression op=('>'|'<') expression  	# MaiorEMenor
   		  | expression op=('and'|'or') expression   # AndEOr
   		  | expression op=('==') expression 		# Igual