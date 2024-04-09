package br.com.adaBank.service;

import br.com.adaBank.interfaces.Investimento;

import br.com.adaBank.model.Conta.ContaInvestimento;
import br.com.adaBank.model.extrato.ExtratoLancamento;

import java.time.LocalDateTime;

public abstract class ContaCorrenteService extends ContaBancariaService  implements Investimento {

    @Override
    public ContaInvestimento investirNovaConta(double valor) {
        ContaInvestimento contaInvestimento = new ContaInvestimento();
        investirContaExistente(contaInvestimento, valor);
        return contaInvestimento;

    }

    @Override
    public void investirContaExistente(ContaInvestimento contaInvestimento, double valor) {
        this.sacar(valor);
        contaInvestimento.setSaldo(valor);
        this.historicoOperacoes.add(new ExtratoLancamento(LocalDateTime.now(),"SAQUE",valor,valor,
                this.getUsuario(),null,"SAQUE DE CRIACAO DE CONTA INVESTIMENTO"));
        contaInvestimento.getHistoricoOperacoes().add(new ExtratoLancamento(LocalDateTime.now(),"DEPOSITO",
                valor,valor,this.getUsuario(),null,"DEPOSITO DE CRIACAO DE CONTA INVESTIMENTO"));
    }
}
