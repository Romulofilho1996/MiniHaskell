public class Divisao extends ExpressaoBinaria {

	public Divisao(Expressao expDireita, Expressao expEsquerda) {
		super(expDireita, expEsquerda);
	}

	@Override
	public ValorDouble avaliar() {
		try{
			ValorInteiro v1 = (ValorInteiro) expDireita.avaliar();
			ValorInteiro v2 = (ValorInteiro) expEsquerda.avaliar();
			Double v3 =  (double) v1.getValor();
			Double v4 =  (double) v2.getValor();
			Double v5 =  (v3 / v4);
			return new ValorDouble(v5);

		}catch(Exception e){
			System.out.println("ERRO");
			System.exit(0);
			return new ValorDouble(null);
		}


	}

	@Override
	public Tipo tipo() {
		return (expEsquerda.tipo() == Tipo.Inteiro && expDireita.tipo() == Tipo.Inteiro) ? Tipo.Inteiro : Tipo.Error;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

}
