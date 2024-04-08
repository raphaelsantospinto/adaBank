package br.com.adaBank.interfaces;

import br.com.adaBank.model.Conta.ContaBancaria;

public interface Investimento {

	public void investir(ContaBancaria contaBancaria, double valor);
}
