package br.com.adaBank.service;

import br.com.adaBank.enums.Classificacao;
import br.com.adaBank.enums.StatusCadastral;
import br.com.adaBank.model.Conta.ContaPoupanca;
import br.com.adaBank.model.usuario.Usuario;

import java.time.LocalDateTime;

public class UsuarioService extends Usuario {

    public UsuarioService(int id, Classificacao classificacao, String nome, LocalDateTime data_cadastro, StatusCadastral statusCadastral) {
        super(id, classificacao, nome, data_cadastro, statusCadastral);
    }

    public boolean RequererContaPoupanca(){
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setUsuario(this);
        return true;

    }


}
