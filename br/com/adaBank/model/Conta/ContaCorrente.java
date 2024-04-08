package br.com.adaBank.model.Conta;

import br.com.adaBank.enums.StatusCadastral;
import br.com.adaBank.model.extrato.ExtratoLancamento;
import br.com.adaBank.model.usuario.Usuario;
import br.com.adaBank.service.ContaBancariaService;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ContaCorrente extends ContaBancariaService {

	public ContaCorrente(){

	}

	public ContaCorrente(int id, double saldo, ArrayList<ExtratoLancamento> historicoOperacoes, LocalDateTime dataAtualizacao, StatusCadastral statusCadastral, Usuario usuario) {
		super();
	}


}
