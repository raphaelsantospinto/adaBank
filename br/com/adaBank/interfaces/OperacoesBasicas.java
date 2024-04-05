package br.com.adaBank.interfaces;

import java.time.LocalDateTime;

import br.com.adaBank.model.ContaBancaria;
import br.com.adaBank.model.Usuario;

public interface OperacoesBasicas {
	public void sacar(double valor);
	public boolean depositar(double valor);
	public boolean transferir(ContaBancaria contaBancariaDestino, double valor);
	public double consultarSaldo();
//	public void registrarOperacao(String tipoOperacao, double valorPretendido, double valorReal,
//			 Usuario usuarioDestino, String observacao);
	
	

}
