package br.com.adaBank.interfaces;

import br.com.adaBank.model.Conta.ContaBancaria;
import br.com.adaBank.model.Conta.ContaInvestimento;

public interface Investimento {

	public ContaInvestimento investirNovaConta( double valor);
	public void investirContaExistente(ContaInvestimento contaInvestimento, double valor);
}
