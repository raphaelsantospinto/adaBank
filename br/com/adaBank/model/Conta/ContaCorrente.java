package br.com.adaBank.model.Conta;
import br.com.adaBank.interfaces.investimento;
import br.com.adaBank.service.ContaBancariaOperacoesBasicasImpl;

public class ContaCorrente extends ContaBancariaOperacoesBasicasImpl implements investimento{
	
	ContaInvestimento contaInvestimento;
	
	
	// COnstrutor basico cria uma conta corrente com uma conta investiment nula. 
	public ContaCorrente() {
		super();
		this.contaInvestimento = null;
	}
	@Override
	public void investir(ContaBancaria contaBancaria, double valor) {
		// TODO AINDA FALTA DEPOISTAR O VALOR DA CONTA CORRENTE NA INV
		// VERIFICAR SE A CONTA EXISTE. SE NAO EXISTIR CRIAMOS UMA. 
		if(this.contaInvestimento.equals(null)) {
			this.contaInvestimento = new ContaInvestimento();
		}
		
	}

	

	

}
