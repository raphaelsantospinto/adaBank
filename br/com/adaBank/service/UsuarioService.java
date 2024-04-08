package br.com.adaBank.service;

import br.com.adaBank.model.Conta.ContaCorrente;
import br.com.adaBank.model.usuario.Usuario;

public class UsuarioService extends Usuario {
// CLASSE PARA ACOES DO USUARIO. Alterar dados do usuario, basicamente

    public Usuario criarUsuarioComContaCorrente(){
        Usuario usuario = new Usuario();
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setUsuario(usuario);
        return usuario;
    }



}
