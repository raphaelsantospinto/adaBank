package br.com.adaBank.utils;

import br.com.adaBank.enums.Classificacao;
import br.com.adaBank.enums.StatusCadastral;
import br.com.adaBank.model.Conta.ContaCorrente;
import br.com.adaBank.model.usuario.Usuario;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@FunctionalInterface
 public interface AdaBankPromocaoLoader {

    abstract boolean load(String path);

    public static void executarProcessamentoPromocionalPF() throws Exception {

        Path entrada = Path.of("br/com/adaBank/files/pessoas.csv");
        Path saida = Path.of("br/com/adaBank/files/RelatorioDepositosPF.csv");

        Stream<String> linhasArquivos = Files.lines(entrada);

         List<String> relatorioPF = linhasArquivos
                .skip(1)
                .map(linhaCliente -> linhaCliente.split(","))
                .filter(colunaTipoClientePF -> "2".equals(colunaTipoClientePF[3]))
                .filter(coluna -> verificarAcima18(coluna[1]))
                .map((coluna) -> {
                    Usuario usuario = criarUsuarioPFcomIdeNome(coluna[2],coluna[0]);
                    ContaCorrente cc = criarContaCorrente(coluna[0], usuario);
                    cc.depositar(50.0);

                    return usuario.getNome()+","+usuario.getId()+","+usuario.getClassificacao()
                            +","+cc.getId()+","+cc.getSaldo();
                })
                .toList();

         relatorioPF.forEach(System.out::println);
         Files.write(saida, relatorioPF);
    }

    public static void executarProcessamentoPromocionalPJ()throws IOException{
        Path entrada = Path.of("br/com/adaBank/files/pessoas.csv");
        Path saida = Path.of("br/com/adaBank/files/RelatorioDepositosPJ.csv");

        Stream<String> linhasArquivos = Files.lines(entrada);
        List<String> relatorioPF = linhasArquivos
                .skip(1)
                .map(linhaCliente -> linhaCliente.split(","))
                .filter(coluna -> "1".equals(coluna[3]))
                .map((coluna) -> {
                    Usuario usuario = criarUsuarioPJcomIdeNome(coluna[2],coluna[0]);
                    ContaCorrente cc = criarContaCorrente(coluna[0], usuario);
                    cc.depositar(50.0);

                    return usuario.getNome()+","+usuario.getId()+","+usuario.getClassificacao()
                           +","+cc.getId()+","+cc.getSaldo();
                })
                .toList();

        relatorioPF.forEach(System.out::println);
        Files.write(saida, relatorioPF);

    }

    static Usuario criarUsuarioPJcomIdeNome(String id, String nome) {
        return new Usuario(id,Classificacao.PESSOA_JURIDICA, nome, LocalDateTime.now(), StatusCadastral.ATIVO);
    }


    static Usuario criarUsuarioPFcomIdeNome(String id, String nome) {
        return new Usuario(id,Classificacao.PESSOA_FISICA, nome, LocalDateTime.now(), StatusCadastral.ATIVO);
    }

    public static boolean verificarAcima18(String dataNascimento){

        // Inspirado em uma Classe feita pelo ChatGPT.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Convertendo a string para LocalDate
        LocalDate dataNasc = LocalDate.parse(dataNascimento, formatter);
        // Obtendo a data atual
        LocalDate dataAtual = LocalDate.now();
        // Calculando a diferença de anos entre as datas
        Period periodo = Period.between(dataNasc, dataAtual);

        // Uma nova mudanca aqui.

        // Verificando se a diferença é maior ou igual a 18 anos
        return periodo.getYears() >= 18;
    }

        public static ContaCorrente criarContaCorrente(String nome, Usuario usuario) {
         //int id, double saldo, ArrayList<ExtratoLancamento> historicoOperacoes, LocalDateTime dataAtualizacao, StatusCadastral statusCadastral, Usuario usuario
            ContaCorrente cc = new ContaCorrente();
            cc.setId(new Random().nextInt(1, 999999));
            cc.setUsuario(usuario);
            cc.setDataAtualizacao(LocalDateTime.now());
            cc.setStatusCadastral(StatusCadastral.ATIVO);
            return cc;

    }

}
