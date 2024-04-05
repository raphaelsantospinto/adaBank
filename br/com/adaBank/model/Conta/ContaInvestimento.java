package br.com.adaBank.model.Conta;

import br.com.adaBank.interfaces.Rendimento;
import br.com.adaBank.service.ContaBancariaService;

public class ContaInvestimento extends ContaBancariaService implements Rendimento{

	@Override
	public void render(double taxaMensal, int diasDeRendimento) {
	}

	public ContaInvestimento() {
		super();
	}
}
