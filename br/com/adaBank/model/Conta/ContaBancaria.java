package br.com.adaBank.model.Conta;

import br.com.adaBank.enums.StatusCadastral;
import br.com.adaBank.model.extrato.ExtratoLancamento;
import br.com.adaBank.model.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class ContaBancaria{
	protected int id;
	protected double saldo;
	protected ArrayList<ExtratoLancamento> historicoOperacoes;
	protected LocalDateTime dataAtualizacao;
	protected StatusCadastral statusCadastral;
	protected Usuario usuario;
	
	
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


	public ContaBancaria() {
		this.historicoOperacoes = new ArrayList<ExtratoLancamento>();
		this.historicoOperacoes.add(new ExtratoLancamento(LocalDateTime.now(), "CRIACAO DA CONTA", 0.0, 0.0,
		null, null, "CRIACAO DA CONTA"));
	}

	public ContaBancaria(int id, double saldo, ArrayList<ExtratoLancamento> historicoOperacoes, LocalDateTime dataAtualizacao, StatusCadastral statusCadastral, Usuario usuario) {
		this.id = id;
		this.saldo = saldo;
		this.historicoOperacoes = historicoOperacoes;
		this.dataAtualizacao = dataAtualizacao;
		this.statusCadastral = statusCadastral;
		this.usuario = usuario;
	}


}
