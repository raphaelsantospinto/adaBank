package br.com.adaBank.model.Conta;

import br.com.adaBank.enums.StatusCadastral;
import br.com.adaBank.model.extrato.ExtratoLancamento;
import br.com.adaBank.model.usuario.Usuario;
import br.com.adaBank.service.ContaBancariaService;
import br.com.adaBank.service.ContaPoupancaService;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ContaPoupanca extends ContaPoupancaService {

    public ContaPoupanca() {
        this.historicoOperacoes = new ArrayList<ExtratoLancamento>();
        this.historicoOperacoes.add(new ExtratoLancamento(LocalDateTime.now(), "CRIACAO DA CONTA", 0.0, 0.0,
                null, null, "CRIACAO DA CONTA POUPANCA"));

    }

    public ContaPoupanca(int id, double saldo, ArrayList<ExtratoLancamento> historicoOperacoes, LocalDateTime dataAtualizacao, StatusCadastral statusCadastral, Usuario usuario) {
        this.id = id;
        this.saldo = saldo;
        this.historicoOperacoes = historicoOperacoes;
        this.dataAtualizacao = dataAtualizacao;
        this.statusCadastral = statusCadastral;
        this.usuario = usuario;
    }



}
