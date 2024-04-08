package br.com.adaBank.service;

import br.com.adaBank.interfaces.Investimento;

import br.com.adaBank.model.Conta.ContaInvestimento;

public abstract class ContaCorrenteService extends ContaBancariaService  implements Investimento {

    @Override
    public ContaInvestimento investirNovaConta(double valor) {
        ContaInvestimento contaInvestimento = new ContaInvestimento();
        this.transferir(contaInvestimento, valor);
        return contaInvestimento;

    }

    @Override
    public void investirContaExistente(ContaInvestimento contaInvestimento, double valor) {
        this.transferir(contaInvestimento, valor);

    }
}
