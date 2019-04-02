import java.util.*;
import java.io.*;


import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;



public class MainInterpreter {

	public Expressao interpreta(Pilha pilha,int tipo){
		Expressao resultado;
		switch (pilha.get()){
			case "+":
				resultado = somar(pilha);
				break;
			case "-":
				resultado = subtrair(pilha);
				break;
			case "*":
				resultado = multiplicar(pilha);
				break;
			case "/":
				resultado = dividir(pilha);
				break;
			case "||":
				resultado = or(pilha);
				break;
			case "&&":
				resultado = and(pilha);
				break;
			case "No":
				resultado = not(pilha);
				break;
			case "==":
				resultado = igual(pilha);
				break;
			case ">":
				resultado = maior(pilha);
				break;
			case ">=":
				resultado = maiorigual(pilha);
				break;
			case "<":
				resultado = menor(pilha);
				break;
			case "<=":
				resultado = menorigual(pilha);
				break;
			case " ":
				pilha.remove();
				resultado = interpreta(pilha,tipo);
				break;
			default:

				resultado = terminal(pilha,tipo);
				break;
		}

		return resultado;
	}


	public Expressao somar(Pilha pilha){
		pilha.remove();
		Expressao dir = interpreta(pilha,1);
		pilha.remove();
		Expressao esq = interpreta(pilha,1);
		return new ExpressaoSoma(esq,dir).avaliar();
	}

	public Expressao subtrair(Pilha pilha){
		pilha.remove();
		Expressao dir = interpreta(pilha,1);
		pilha.remove();
		Expressao esq = interpreta(pilha,1);
		return new Subtracao(esq,dir).avaliar();
	}

	public Expressao multiplicar(Pilha pilha){
		pilha.remove();
		Expressao dir = interpreta(pilha,1);
		pilha.remove();
		Expressao esq = interpreta(pilha,1);
		return new Multiplicacao(esq,dir).avaliar();
	}

	public Expressao dividir(Pilha pilha){
		pilha.remove();
		Expressao dir = interpreta(pilha,1);
		pilha.remove();
		Expressao esq = interpreta(pilha,1);
		return new Divisao(esq,dir).avaliar();
	}

	public Expressao and(Pilha pilha){
		pilha.remove();
		Expressao dir = interpreta(pilha,0);
		pilha.remove();
		Expressao esq = interpreta(pilha,0);
		return new And((ValorBooleano) esq, (ValorBooleano) dir).avaliar();
	}

	public Expressao not(Pilha pilha){
		pilha.remove();
		Expressao negar = interpreta(pilha,0);
		return new Not((ValorBooleano) negar).avaliar();
	}

	public Expressao or(Pilha pilha){
		pilha.remove();
		Expressao dir = interpreta(pilha,0);
		pilha.remove();
		Expressao esq = interpreta(pilha,0);
		return new Or((ValorBooleano) esq, (ValorBooleano) dir).avaliar();
	}

	public Expressao igual(Pilha pilha){
		pilha.remove();
		Expressao dir = interpreta(pilha,1);
		pilha.remove();
		Expressao esq = interpreta(pilha,1);
		return new Igual(esq,dir).avaliar();
	}

	public Expressao maior(Pilha pilha){
		pilha.remove();
		Expressao dir = interpreta(pilha,1);
		pilha.remove();
		Expressao esq = interpreta(pilha,1);
		return new Maior(esq,dir).avaliar();
	}
	public Expressao maiorigual(Pilha pilha){
		pilha.remove();
		Expressao dir = interpreta(pilha,1);
		pilha.remove();
		Expressao esq = interpreta(pilha,1);
		return new MaiorIgual(esq,dir).avaliar();
	}
	public Expressao menor(Pilha pilha){
		pilha.remove();
		Expressao dir = interpreta(pilha,1);
		pilha.remove();
		Expressao esq = interpreta(pilha,1);
		return new Menor(esq,dir).avaliar();
	}

	public Expressao menorigual(Pilha pilha){
		pilha.remove();
		Expressao dir = interpreta(pilha,1);
		pilha.remove();
		Expressao esq = interpreta(pilha,1);
		return new MenorIgual(esq,dir).avaliar();
	}

	public Expressao terminal(Pilha pilha, int tipo){
		Expressao terminal;
		int valor = Integer.parseInt(pilha.get());
		if(tipo==1){
			terminal = new ValorInteiro(valor);
		}
		else{
			if(valor==1)
				terminal = new ValorBooleano(true);
			else
				terminal = new ValorBooleano(false);
		}
		return terminal;
	}


	public static Boolean verifica(Context contexto, int i, Pilha pilha){
		Boolean retorno=false;
		String a,b;
		a=Character.toString(contexto.getExpressao().charAt(i)); 
		if((i+1)==contexto.getExpressao().length())
			return false;
		else
			b=Character.toString(contexto.getExpressao().charAt(i+1));

		if((a.concat(b)).equals("==")){
			pilha.insere("==");
			retorno = true;
		}
		if((a.concat(b)).equals(">=")){
			pilha.insere(">=");
			retorno = true;
		}
		if((a.concat(b)).equals("<=")){
			pilha.insere("<=");
			retorno = true;
		}
		if((a.concat(b)).equals("&&")){
			pilha.insere("&&");
			retorno = true;
		}
		if((a.concat(b)).equals("||")){
			pilha.insere("||");
			retorno = true;
		}
		if((a.concat(b)).equals("No")){
			pilha.insere("No");
			retorno = true;
		}

		return retorno;
	}






public static void main(String[] args) throws Exception {

        ANTLRInputStream input = new ANTLRInputStream(System.in);
        MiniLexer lexer = new MiniLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniParser parser = new MiniParser(tokens);
         
        ParseTree tree = parser.expression();
         

        EvalVisitor eval = new EvalVisitor();
       	eval.visit(tree);

    }

}












/*
	public static void main(String[] args){
		int i;
		MainInterpreter interpretador = new MainInterpreter();
		Scanner input = new Scanner (System.in);
		Pilha pilha = new Pilha();
		Expressao retorno;
		Context contexto = new Context();
		contexto.contextInsere("Inicia");
		PrettyPrinter print = new PrettyPrinter();
		System.out.print("Bem-vindo ao MiniHaskell!\n");
		String arquivo, linha, avaliaTamanho;



		while(!contexto.getExpressao().equals(":quit")){
			System.out.print(">> ");
			contexto.contextInsere(input.nextLine());

			if(contexto.getExpressao().length()>=4)
				avaliaTamanho = contexto.getExpressao().substring(0, 4);
			else
				avaliaTamanho = "ViaTerminal";

			if(avaliaTamanho.equals("load")){
				arquivo = contexto.getExpressao().substring(10, contexto.getExpressao().length()-2);
				 try {
      				FileReader arq = new FileReader(arquivo);
      				BufferedReader lerArq = new BufferedReader(arq);
      				linha = lerArq.readLine();
      				if(linha!=null)
      					contexto.contextInsere(linha); 
     				while(linha != null) {
       					for(i=0;i<contexto.getExpressao().length();i++){
							if(verifica(contexto,i, pilha)){
								i++;
							}else{
								pilha.insere(Character.toString(contexto.getExpressao().charAt(i)));				
							}
						}
						
						retorno = interpretador.interpreta(pilha,1);
						System.out.print(linha +" = ");
						if(retorno.tipo() == Tipo.Double)
							print.visitar((ValorDouble) retorno);
						if(retorno.tipo() == Tipo.Inteiro)
							print.visitar((ValorInteiro) retorno);
						if(retorno.tipo() == Tipo.Booleano)
							print.visitar((ValorBooleano) retorno);
						System.out.println("\n");
						linha = lerArq.readLine();
     					if(linha!=null)
       						contexto.contextInsere(linha); // lê da segunda até a última linha
					}
					arq.close();
     			}catch (IOException e) {
        			System.err.printf("Erro na abertura do arquivo: %s.\n",
        	 		e.getMessage());
        	 		System.exit(0);
    			}

			}else if(avaliaTamanho.equals("eval")){
			
				contexto.contextInsere(contexto.getExpressao().substring(6, contexto.getExpressao().length()-2)) ;

				for(i=0;i<contexto.getExpressao().length();i++){
					if(verifica(contexto,i, pilha)){
						i++;
					}else{
						pilha.insere(Character.toString(contexto.getExpressao().charAt(i)));

					
					}
				}	

				retorno = interpretador.interpreta(pilha,1);
				if(retorno.tipo() == Tipo.Double)
					print.visitar((ValorDouble) retorno);
				if(retorno.tipo() == Tipo.Inteiro)
					print.visitar((ValorInteiro) retorno);
				if(retorno.tipo() == Tipo.Booleano)
					print.visitar((ValorBooleano) retorno);
				System.out.println("\n");
				


				
			}else{
				if(!contexto.getExpressao().equals(":quit")){
					for(i=0;i<contexto.getExpressao().length();i++){
						if(verifica(contexto,i, pilha)){
							i++;
						}else{
							pilha.insere(Character.toString(contexto.getExpressao().charAt(i)));

					
						}
					}
					//Parser antlr = new Arvore("MiniHaskell.g4"); // antlr é o mpetodo que vai gerar os arquivos do antlr parser
					//Arvore root = antlr("expression"); //root é a raiz da árvore gerada após darmos a string expression
					//Expressao resultado = interpretador.interpreta(root); //temos o resultado da resolução

					retorno = interpretador.interpreta(pilha,1);
					if(retorno.tipo() == Tipo.Double)
						print.visitar((ValorDouble) retorno);
					if(retorno.tipo() == Tipo.Inteiro)
						print.visitar((ValorInteiro) retorno);
					if(retorno.tipo() == Tipo.Booleano)
						print.visitar((ValorBooleano) retorno);
					System.out.println("\n");
				}
			}
		}
		System.out.println("[Leaving Hugs]\n");
	}
}*/


 //String texto = "Hoje o Sol está forte";
	//	String procurarPor = "sol";
	//	System.out.println(texto.toLowerCase().contains(procurarPor.toLowerCase()));