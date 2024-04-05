package br.com.adaBank.model;

import br.com.adaBank.enums.StatusCadastral;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class ContaBancaria {
	int id;
	double saldo;
	ArrayList<br.com.adaBank.model.ExtratoLancamento> historicoOperacoes;
	LocalDateTime dataAtualizacao;
	StatusCadastral statusCadastral;
	br.com.adaBank.model.Usuario usuario;
	
	
	//Getters and Setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public ArrayList<ExtratoLancamento> getHistoricoOperacoes() {
		return historicoOperacoes;
	}
	public void setHistoricoOperacoes(ArrayList<ExtratoLancamento> historicoOperacoes) {
		this.historicoOperacoes = historicoOperacoes;
	}
	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	public StatusCadastral getStatusCadastral() {
		return statusCadastral;
	}
	public void setStatusCadastral(StatusCadastral statusCadastral) {
		this.statusCadastral = statusCadastral;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	} 
	
	
	
	
	

}
