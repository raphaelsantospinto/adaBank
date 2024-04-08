package br.com.adaBank.service;

import br.com.adaBank.interfaces.Investimento;
import br.com.adaBank.model.Conta.ContaBancaria;

public abstract class ContaCorrenteService extends ContaBancariaService  implements Investimento {

    @Override
    public void investir(ContaBancaria contaBancaria, double valor) {
    }
}
