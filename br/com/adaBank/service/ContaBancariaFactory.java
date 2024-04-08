package br.com.adaBank.service;

import br.com.adaBank.model.Conta.ContaCorrente;
import br.com.adaBank.model.Conta.ContaInvestimento;
import br.com.adaBank.model.Conta.ContaPoupanca;
import br.com.adaBank.model.usuario.Usuario;

/*
* ESTA CLASSE NÃO POSSUI IMPLEMENTACAO NO CODIGO. CRIEI UM CONJUNTO DE METODOS ESTATICOS PARA UM PROJETO
* DE "GERENCIADOR DE OPERAÇÕES" MAIS ROBUSTO. Basicamente nao foi p frente
* */

public class ContaBancariaFactory {

    public static ContaCorrente criarContaCorrente(Usuario usuario){
        ContaCorrente c1 = new ContaCorrente();
        c1.setUsuario(usuario);
        return c1;
    }



    public static ContaPoupanca criarContaPoupanca(Usuario usuario){
        ContaPoupanca c1 = new ContaPoupanca();
        c1.setUsuario(usuario);
        return c1;
    }

    public static ContaInvestimento criarContaInvestimento(Usuario usuario){
        ContaInvestimento c1 = new ContaInvestimento();
        c1.setUsuario(usuario);
        return c1;

    }
}
