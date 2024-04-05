package br.com.adaBank.model;

import java.time.LocalDateTime;

/*
 * Classe que representa um registro de operacao bancaria, para ser usado no extrato
 *
 */


	public class ExtratoLancamento {
	private LocalDateTime dataOperacao;
	private String tipoOperacao;
	private double valorPretendido;
	private double valorReal;
	private Usuario usuarioOrigem;
	private Usuario usuarioDestino;
	private String Observacao;
	
	
	
	//GETTERS AND SETTERS
	public LocalDateTime getDataOperacao() {
		return dataOperacao;
	}
	public void setDataOperacao(LocalDateTime dataOperacao) {
		this.dataOperacao = dataOperacao;
	}
	public String getTipoOperacao() {
		return tipoOperacao;
	}
	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
	public double getValorPretendido() {
		return valorPretendido;
	}
	public void setValorPretendido(double valorPretendido) {
		this.valorPretendido = valorPretendido;
	}
	public double getValorReal() {
		return valorReal;
	}
	public void setValorReal(double valorReal) {
		this.valorReal = valorReal;
	}
	public Usuario getUsuarioOrigem() {
		return usuarioOrigem;
	}
	public void setUsuarioOrigem(Usuario usuarioOrigem) {
		this.usuarioOrigem = usuarioOrigem;
	}
	public Usuario getUsuarioDestino() {
		return usuarioDestino;
	}
	public void setUsuarioDestino(Usuario usuarioDestino) {
		this.usuarioDestino = usuarioDestino;
	}
	public String getObservacao() {
		return Observacao;
	}
	public void setObservacao(String observacao) {
		Observacao = observacao;
	}
	
	//Construtor usando campos
	public ExtratoLancamento(LocalDateTime dataOperacao, String tipoOperacao, double valorPretendido, double valorReal,
			Usuario usuarioOrigem, Usuario usuarioDestino, String observacao) {
		super();
		this.dataOperacao = dataOperacao;
		this.tipoOperacao = tipoOperacao;
		this.valorPretendido = valorPretendido;
		this.valorReal = valorReal;
		this.usuarioOrigem = usuarioOrigem;
		this.usuarioDestino = usuarioDestino;
		Observacao = observacao;
	}
	
	
	

}
