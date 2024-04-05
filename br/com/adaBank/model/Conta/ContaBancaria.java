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
		this.id = 0; // quando for usar banco de dados a gente cria um novo
		this.historicoOperacoes = new ArrayList<ExtratoLancamento>();
		this.dataAtualizacao = LocalDateTime.now();
		this.saldo = 0.0;
		this.usuario = new Usuario();
		this.statusCadastral = StatusCadastral.ATIVO;

	}
}
