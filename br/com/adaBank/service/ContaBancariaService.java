package br.com.adaBank.service;

import br.com.adaBank.interfaces.OperacoesBasicas;
import br.com.adaBank.model.Conta.ContaBancaria;
import br.com.adaBank.model.extrato.ExtratoLancamento;

import java.time.LocalDateTime;


/**
 * Classe que fornece uma implementação generica para as operações basicas. 
 *
 */
public abstract class ContaBancariaService extends ContaBancaria implements OperacoesBasicas {
	@Override
	public void sacar(double valor){
		double valorAtualizado = valor * this.getUsuario().getClassificacao().taxa;
		if(this.getSaldo() < valorAtualizado) {
				System.out.println("Saldo Insuficiente");				
				this.historicoOperacoes.add( new ExtratoLancamento(LocalDateTime.now(), "SAQUE", valor, 0.0,
						this.getUsuario(), this.getUsuario(), "SAQUE NAO REALIZADO"));
        } else { // TEM SALDO
					this.setSaldo(this.getSaldo() - valorAtualizado);
					this.historicoOperacoes.add(new ExtratoLancamento(LocalDateTime.now(), "SAQUE", valorAtualizado, valorAtualizado,
							this.getUsuario(), null, "SAQUE REALIZADO"));
        }
        this.dataAtualizacao = LocalDateTime.now();
    }
		
	@Override
	public boolean depositar(double valor) {
		this.setSaldo(this.getSaldo() + valor);
		this.historicoOperacoes.add(new ExtratoLancamento(LocalDateTime.now(), "DEPOSITO", valor, valor,
				this.getUsuario(), this.getUsuario(), "DEPOSITO REALIZADO COM SUCESSO"));
		return true;
	}

	@Override
	public boolean transferir(ContaBancaria contaBancariaDestino, double valor) {

		double valorComTaxa = valor * this.getUsuario().getClassificacao().taxa; //RN
		// PASSO 1 - Verificar a existencia de usuario destino.
		if(contaBancariaDestino.getUsuario()== null){
			System.out.println("Conta bancaria destino Nula. operação cancelada");
			return false;
		}
		// PASSO 2 - CASO VALOR DA TRANSFERENCIA SUPERIOR AO SALDO

		if (this.getSaldo() < valorComTaxa) {
			System.out.println("Saldo Insuficiente");
			this.historicoOperacoes.add( new ExtratoLancamento(LocalDateTime.now(), "TRANSFERENCIA", valor, 0.0,
					this.getUsuario(), this.getUsuario(), "TRANSFERENCIA NAO REALIZADA POR FALTA DE SALDO"));
			this.dataAtualizacao = LocalDateTime.now();
			return false;
			}
		// PASSO 3 - Realiza reducao na conta origem

		this.setSaldo(this.getSaldo() - valorComTaxa);
		this.historicoOperacoes.add(new ExtratoLancamento(LocalDateTime.now(), "TRANSFERENCIA", valor, valorComTaxa,
				this.getUsuario(), contaBancariaDestino.getUsuario(), "DEBITO DE TRANSFERENCIA"));


		//passo 4 - deposita

		contaBancariaDestino.setSaldo(this.getSaldo() + valorComTaxa);
		contaBancariaDestino.getHistoricoOperacoes().add(new ExtratoLancamento(LocalDateTime.now(), "TRANSFERENCIA", valor, valorComTaxa,
				this.getUsuario(), contaBancariaDestino.getUsuario(), "CREDITO DE TRANSFERENCIA"));
		return true;
	}

	@Override
	public double consultarSaldo() {
		this.dataAtualizacao = LocalDateTime.now();
		System.out.println("Saldo consultado - Valor: " + this.getSaldo());
		this.historicoOperacoes.add(new ExtratoLancamento(LocalDateTime.now(), "CONSULTA SALDO", this.getSaldo(), this.getSaldo(),
				this.getUsuario(), null, "CONSLTA SALDO"));
		return this.getSaldo();	
		
		
	}

}
