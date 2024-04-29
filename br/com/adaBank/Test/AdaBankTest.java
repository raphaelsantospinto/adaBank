package br.com.adaBank.Test;

import br.com.adaBank.enums.Classificacao;
import br.com.adaBank.enums.StatusCadastral;
import br.com.adaBank.model.Conta.ContaBancaria;
import br.com.adaBank.model.extrato.ExtratoLancamento;
import br.com.adaBank.model.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import static br.com.adaBank.utils.AdaBankPromocaoLoader.executarProcessamentoPromocionalPF;
import static br.com.adaBank.utils.AdaBankPromocaoLoader.executarProcessamentoPromocionalPJ;


public class AdaBankTest {
/*
    public static void main(String[] args) {
        System.out.println("Criação dos Usuarios...");
        Usuario u1 = criarUsuarioPF();
        Usuario u2 = criarUsuarioPJ();
        Usuario u3 = criarUsuarioPF();
        System.out.println("Concluida");

        System.out.println("Criação das Contas");
        ContaPoupanca c1 = criarContaPoupanca();
        ContaCorrente c2 = criarContaCorrente();
        ContaInvestimento c3 = criarContaInvestimento();
        System.out.println("Concluida");

        System.out.println("Atribui usuarios a contas...");
        c1.setUsuario(u1);
        c2.setUsuario(u2);
        c3.setUsuario(u3);
        System.out.println("Concluida");

        System.out.println("Operacoes...");

        c1.depositar(1500.00);
        c1.sacar(100.00);
        c2.depositar(2500.00);
        c2.sacar(200.00);
        c3.depositar(1000.00);
        c3.sacar(50.0);
        c1.transferir(c2, 100.00);
        c2.transferir(c1, 100.0);

        c2.investirContaExistente(c3, 250.00);
        ContaInvestimento c4 = c2.investirNovaConta(250.00);

        System.out.println("Concluida");

        System.out.println("Consulta Saldo");

        c1.consultarSaldo();
        c2.consultarSaldo();
        c3.consultarSaldo();
        System.out.println("Concluida");


        System.out.println("Extrato C1");
        imprimirExtratoSimplificadoNoConsole(c1);
        System.out.println("Extrato C2");
        imprimirExtratoSimplificadoNoConsole(c2);
        System.out.println("Extrato C3");
        imprimirExtratoSimplificadoNoConsole(c3);
        System.out.println("Extrato C4");
        imprimirExtratoSimplificadoNoConsole(c4);

        LocalDate ld = LocalDate.now();
        System.out.println(ld.toString());

    }
*/

    public static void main(String[] args) {
        try {
            executarProcessamentoPromocionalPF();
            executarProcessamentoPromocionalPJ();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    private static void imprimirExtratoSimplificadoNoConsole(ContaBancaria c1) {
        //SUBSTITUICAO DE LISKOV NA VEIA BEBE!!! (troquei poupanca por ContaBancaria e o codigo rodou!
        ArrayList<ExtratoLancamento> a1;
        a1 = c1.getHistoricoOperacoes();
        System.out.println( " ---- EXTRATO CONTA ID " + c1.getId()+ " ---- ");
        a1.forEach((e)-> {
            System.out.println(e.toString());
        });



    }
    private static ArrayList<ExtratoLancamento> criaExtratoLancamentoBasico(){
        ArrayList<ExtratoLancamento> a1 = new ArrayList<>();
        a1.add(new ExtratoLancamento(LocalDateTime.now(), "Criacao de Conta", 0.0, 0.0,
                null, null, "Criacao de Conta"));
        return a1;
    }
//    private static ContaPoupanca criarContaPoupanca() {
//        // int id, double saldo, ArrayList<ExtratoLancamento> historicoOperacoes, LocalDateTime dataAtualizacao, StatusCadastral statusCadastral, Usuario usuario
//        return new ContaPoupanca(String.valueOf(new Random().nextInt(1, 10000)),0.0,criaExtratoLancamentoBasico(),LocalDateTime.now(), StatusCadastral.ATIVO,criarUsuarioPF());
//    }
//    public static ContaCorrente criarContaCorrente() {
//        // int id, double saldo, ArrayList<ExtratoLancamento> historicoOperacoes, LocalDateTime dataAtualizacao, StatusCadastral statusCadastral, Usuario usuario
//        return new ContaCorrente(String.valueOf(new Random().nextInt(1, 10000)),0.0, criaExtratoLancamentoBasico(), LocalDateTime.now(), StatusCadastral.ATIVO, criarUsuarioPF());
//    }
//    private static ContaInvestimento criarContaInvestimento() {
//        return new ContaInvestimento(String.valueOf(new Random().nextInt(1, 10000)),0.0, criaExtratoLancamentoBasico(), LocalDateTime.now(), StatusCadastral.ATIVO, criarUsuarioPF());
//    }
//    private static Usuario criarUsuarioPF(){
//        return new Usuario(new Random().nextInt(500, 10000), Classificacao.PESSOA_FISICA, "USUARIO TESTE "+ new Random().nextInt(1, 100), LocalDateTime.now(), StatusCadastral.ATIVO);
//
//    }

    private static Usuario criarUsuarioPJ() {
        return new Usuario(String.valueOf(new Random().nextInt(1, 10000)), Classificacao.PESSOA_JURIDICA, "Usuario Teste",
                LocalDateTime.now(), StatusCadastral.ATIVO);

    }


}
