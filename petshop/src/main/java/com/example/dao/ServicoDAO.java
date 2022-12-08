package com.example.dao;

import com.example.bd.BancoDeDados;
import java.util.Set;
import com.example.model.Servico;

public class ServicoDAO {
	public static BancoDeDados bancoDeDados = new BancoDeDados();
	Set<Servico> servicos;

	public ServicoDAO() {
		servicos = BancoDeDados.getServicos();
	}

	public boolean inserir(Servico servico) {
		bancoDeDados.inserirServico(servico);
		return servicos.add(servico);
	}

	public boolean alterar(int codigo, Servico servico) {
		bancoDeDados.atualizarServico(codigo, servico);
		return false;
	}

	public boolean remover(int codigo) {
		bancoDeDados.removerServico(codigo);
		return true;
	}

	public void limpaDados() {
		servicos.clear();
	}

	public Servico getServico(int codigo) {
		for (Servico aux : servicos) {
			if (aux.getCodigo() == codigo) {
				return aux;
			}
		}
		return null;
	}

	public Set<Servico> getAll() {
		return servicos; //retornando o vetor inteiro de atendimentos
	}
}



