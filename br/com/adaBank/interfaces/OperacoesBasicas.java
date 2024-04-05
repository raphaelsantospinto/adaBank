package br.com.adaBank.interfaces;

import br.com.adaBank.model.Conta.ContaBancaria;

public interface OperacoesBasicas {
	public void sacar(double valor);
	public boolean depositar(double valor);
	public boolean transferir(ContaBancaria contaBancariaDestino, double valor);
	public double consultarSaldo();
//	public void registrarOperacao(String tipoOperacao, double valorPretendido, double valorReal,
//			 Usuario usuarioDestino, String observacao);
	
	

}
