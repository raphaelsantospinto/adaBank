package br.com.adaBank.enums;

public enum Classificacao {
	
	PESSOA_FISICA (1.0, 1.01),
	PESSOA_JURIDICA (1.05, 1.02);

	
	public final double taxa;
	public final double rendimentos;

	
	private Classificacao(double taxa, double rendimentos) {
		this.taxa = taxa;
		this.rendimentos = rendimentos;
	}


	public double getTaxa() {
		return taxa;
	}
	public double getRendimentos() {
		return rendimentos;
	}
}
