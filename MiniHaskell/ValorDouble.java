public class ValorDouble extends ValorParametrizado<Double> {

	public ValorDouble(Double valor) {
		super(valor);
	}

	@Override
	public Tipo tipo() {
		return Tipo.Double;
	}

	@Override
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
}
