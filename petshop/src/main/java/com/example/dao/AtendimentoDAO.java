package com.example.dao;

import com.example.bd.BancoDeDados;
import java.util.Set;
import com.example.model.Atendimento;

public class AtendimentoDAO {
	private Set<Atendimento> atendimentos;

	public AtendimentoDAO() {
		atendimentos = BancoDeDados.getAtendimentos();
	}

	public boolean inserir(Atendimento atendimento) {
		return atendimentos.add(atendimento);
	}

	public boolean alterar(int codigo, Atendimento atendimento) {
		for (Atendimento aux : atendimentos) {
			if (aux.getCodigo() == codigo) {
				atendimentos.remove(aux);
				atendimentos.add(atendimento);
				return true;
			}
		}
		return false;
	}

	public boolean remover(int codigo) {
		for (Atendimento aux : atendimentos) {
			if (aux.getCodigo() == codigo) {
				atendimentos.remove(aux);
				return true;
			}
		}
		return false;
	}

	public void limpaDados() {
		atendimentos.clear();
	}

	public Atendimento getAtendimento(int codigo) {
		for (Atendimento aux : atendimentos) {
			if (aux.getCodigo() == codigo) {
				return aux;
			}
		}
		return null;
	}

	public Set<Atendimento> getAll() {
		return atendimentos; //retornando o vetor inteiro de atendimentos
	}
}
