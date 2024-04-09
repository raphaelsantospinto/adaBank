package br.com.adaBank.service;

import br.com.adaBank.interfaces.Rendimento;

public abstract class ContaInvestimentoService extends ContaBancariaService implements Rendimento {


    @Override
    public void renderMensal() {
        this.setSaldo(this.getSaldo()*this.getUsuario().getClassificacao().getRendimentos());


    }
}
