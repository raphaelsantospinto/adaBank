package br.com.adaBank.model.Conta;
import br.com.adaBank.interfaces.investimento;
import br.com.adaBank.service.ContaBancariaService;

public class ContaCorrente extends ContaBancariaService implements investimento{
	
	protected ContaInvestimento contaInvestimento;

	public ContaInvestimento getContaInvestimento() {
		return contaInvestimento;
	}

	public void setContaInvestimento(ContaInvestimento contaInvestimento) {
		this.contaInvestimento = contaInvestimento;
	}

	// COnstrutor basico cria uma conta corrente com uma conta investiment nula.
	public ContaCorrente() {
		super();
		this.contaInvestimento = null;
	}


	@Override
	public void investir(ContaBancaria contaBancaria, double valor) {

	}
}
