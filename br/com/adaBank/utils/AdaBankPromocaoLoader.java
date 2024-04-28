package br.com.adaBank.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

@FunctionalInterface
 public interface AdaBankPromocaoLoader {

    abstract boolean load(String path);

    public static void executarProcessamento() throws Exception {


        Path path = Path.of("C:\\Users\\rapha\\IdeaProjects\\adaBank\\br\\com\\adaBank\\files\\pessoas.csv");

        Stream<String> linhasArquivos = Files.lines(path);

        List<String> pessoasFisicasMaiores18 = linhasArquivos
                .skip(1)
                .map(linhaCliente -> linhaCliente.split(","))
                .filter(colunaTipoClientePF -> "2".equals(colunaTipoClientePF[3]))
                .filter(coluna -> verificarAcima18(coluna[1]))
                .map(linhaCliente -> {
                    String nomeCliente = linhaCliente[0]+","+linhaCliente[1]+","+linhaCliente[2];
                    return  nomeCliente;
                    })
                .toList();

        pessoasFisicasMaiores18.forEach(System.out::println);

    }

    private static boolean verificarAcima18(String dataNascimento){

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
}
