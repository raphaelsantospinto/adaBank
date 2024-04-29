package br.com.adaBank.model.usuario;

import br.com.adaBank.enums.Classificacao;
import br.com.adaBank.enums.StatusCadastral;
import br.com.adaBank.model.Conta.ContaCorrente;

import java.time.LocalDateTime;

public class Usuario {
	protected String id;
	protected Classificacao classificacao;
	protected String nome;
	protected LocalDateTime data_cadastro;
	protected StatusCadastral statusCadastral;

	
	// GETTERS AND SETTERS
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Classificacao getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDateTime getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(LocalDateTime data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	public StatusCadastral getStatusCadastral() {
		return statusCadastral;
	}
	public void setStatusCadastral(StatusCadastral statusCadastral) {
		this.statusCadastral = statusCadastral;
	}


	public Usuario(String id, Classificacao classificacao, String nome, LocalDateTime data_cadastro, StatusCadastral statusCadastral) {
		this.id = id;
		this.classificacao = classificacao;
		this.nome = nome;
		this.data_cadastro = data_cadastro;
		this.statusCadastral = statusCadastral;
	}

	public Usuario(){}

	public Usuario criarUsuarioComContaCorrente(){
		Usuario usuario = new Usuario();
		ContaCorrente contaCorrente = new ContaCorrente();
		contaCorrente.setUsuario(usuario);
		return usuario;
	}
}
