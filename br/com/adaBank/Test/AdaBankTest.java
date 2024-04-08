package br.com.adaBank.Test;

import br.com.adaBank.enums.Classificacao;
import br.com.adaBank.enums.StatusCadastral;
import br.com.adaBank.model.Conta.ContaBancaria;
import br.com.adaBank.model.Conta.ContaCorrente;
import br.com.adaBank.model.Conta.ContaInvestimento;
import br.com.adaBank.model.Conta.ContaPoupanca;
import br.com.adaBank.model.extrato.ExtratoLancamento;
import br.com.adaBank.model.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;


public class AdaBankTest {

    public static void main(String[] args) {
        Usuario u1 = criarUsuarioPF();
        Usuario u2 = criarUsuarioPJ();

        ContaPoupanca c1 = criarContaPoupanca();
        ContaCorrente c2 = criarContaCorrente();
        c1.setUsuario(u1);
        c2.setUsuario(u2);

        ContaInvestimento c3 = criarContaInvestimento();

        c1.depositar(100.00);
        c1.sacar(100.00);
        c1.depositar(250.00);

        c1.transferir(c2, 100.00);
        double v1 = c1.consultarSaldo();
        c2.transferir(c1, 100.0);
        System.out.println(c2.consultarSaldo());

        imprimirExtratoSimplificadoNoConsole(c1);
        imprimirExtratoSimplificadoNoConsole(c2);


    }




    private static void imprimirExtratoSimplificadoNoConsole(ContaBancaria c1) {
        //SUBSTITUICAO DE LISKOV NA VEIA BEBE!!! (troquei poupanca por ContaBancaria e o codigo rodou!
        ArrayList<ExtratoLancamento> a1 = new ArrayList<ExtratoLancamento>();
        a1 = c1.getHistoricoOperacoes();
        System.out.println( " ---- EXTRATO CONTA ID " + c1.getId() + " ---- ");
        a1.forEach((e)-> {
            System.out.println(e.getDataOperacao() +" , "+ e.getTipoOperacao() +" , "+ e.getValorPretendido()+" , "+ e.getValorReal()+" , "+e.getObservacao());
        });
    }
    private static ArrayList<ExtratoLancamento> criaExtratoLancamentoBasico(){
        ArrayList<ExtratoLancamento> a1 = new ArrayList<ExtratoLancamento>();
        a1.add(new ExtratoLancamento(LocalDateTime.now(), "Criacao de Conta", 0.0, 0.0,
        null, null, "Criacao de Conta"));
        return a1;
    }
    private static ContaPoupanca criarContaPoupanca() {
        // int id, double saldo, ArrayList<ExtratoLancamento> historicoOperacoes, LocalDateTime dataAtualizacao, StatusCadastral statusCadastral, Usuario usuario
        return new ContaPoupanca(new Random().nextInt(1, 10000),0.0, criaExtratoLancamentoBasico(), LocalDateTime.now(), StatusCadastral.ATIVO, criarUsuarioPF());
    }
    private static ContaCorrente criarContaCorrente() {
        // int id, double saldo, ArrayList<ExtratoLancamento> historicoOperacoes, LocalDateTime dataAtualizacao, StatusCadastral statusCadastral, Usuario usuario
        return new ContaCorrente(new Random().nextInt(1, 10000),0.0, criaExtratoLancamentoBasico(), LocalDateTime.now(), StatusCadastral.ATIVO, criarUsuarioPF());
    }
    private static ContaInvestimento criarContaInvestimento() {
        return new ContaInvestimento(new Random().nextInt(1, 10000),0.0, criaExtratoLancamentoBasico(), LocalDateTime.now(), StatusCadastral.ATIVO, criarUsuarioPF());
    }
    private static Usuario criarUsuarioPF(){
        return new Usuario(new Random().nextInt(1, 10000), Classificacao.PESSOA_FISICA, "Usuario Teste",
                LocalDateTime.now(), StatusCadastral.ATIVO);

    }
    private static Usuario criarUsuarioPJ() {
        Usuario usuarioTeste = new Usuario(new Random().nextInt(1, 10000), Classificacao.PESSOA_JURIDICA, "Usuario Teste",
                LocalDateTime.now(), StatusCadastral.ATIVO);
        return usuarioTeste;
    }

}
