package br.com.adaBank.enums;

public enum Classificacao {
	
	PESSOA_FISICA (1.0),
	PESSOA_JURIDICA (1.05);

	
	public final double taxa; 
	
	private Classificacao(double taxa) {
		this.taxa = taxa;
	}
	
	
}
