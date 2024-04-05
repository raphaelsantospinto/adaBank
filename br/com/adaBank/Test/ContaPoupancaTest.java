package br.com.adaBank.Test;

import br.com.adaBank.enums.Classificacao;
import br.com.adaBank.enums.StatusCadastral;
import br.com.adaBank.model.Conta.ContaPoupanca;
import br.com.adaBank.model.extrato.ExtratoLancamento;
import br.com.adaBank.model.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ContaPoupancaTest {

    public static void main(String[] args) {
        ContaPoupanca c1 = criarContaPoupanca(1034560);
        ContaPoupanca c2 = criarContaPoupanca(5204833);

        c1.depositar(100.00);
        c1.sacar(100.00);
        c1.depositar(250.00);

        c1.transferir(c2, 2000.00);

        imprimirExtratoNoConsole(c1);


    }

    private static void imprimirExtratoNoConsole(ContaPoupanca c1) {
        ArrayList<ExtratoLancamento> a1 = new ArrayList<ExtratoLancamento>();
        a1 = c1.getHistoricoOperacoes();
        a1.forEach(System.out::println);
    }

    private static ContaPoupanca criarContaPoupanca(int id) {
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setId(id);
        contaPoupanca.setSaldo(1500.00);
        contaPoupanca.setUsuario(ContaPoupancaTest.criarUsuario());

        return contaPoupanca;
    }

    private static Usuario criarUsuario() {
       return new Usuario(991201, Classificacao.PESSOA_FISICA, "Raphael", LocalDateTime.now(), StatusCadastral.ATIVO);
    }
}
