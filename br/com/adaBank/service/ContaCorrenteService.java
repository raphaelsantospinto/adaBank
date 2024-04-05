package br.com.adaBank.service;

import br.com.adaBank.model.Conta.ContaBancaria;
import br.com.adaBank.model.Conta.ContaCorrente;
import br.com.adaBank.model.Conta.ContaInvestimento;

public class ContaCorrenteService extends ContaCorrente {

    @Override
    public void investir(ContaBancaria contaBancaria, double valor) {

        // VERIFICAR SE A CONTA EXISTE. SE NAO EXISTIR CRIAMOS UMA.
        if(this.getContaInvestimento() == null) this.contaInvestimento = new ContaInvestimento();
        this.setSaldo(this.getSaldo() - valor);
        this.contaInvestimento.depositar(valor);


    }
}
