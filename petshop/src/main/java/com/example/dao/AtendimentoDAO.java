package com.example.dao;

import com.example.bd.BancoDeDados;
import java.util.Set;
import com.example.model.Atendimento;

public class AtendimentoDAO {
	
	public static BancoDeDados bancoDeDados = new BancoDeDados();
	private Set<Atendimento> atendimentos;

	public AtendimentoDAO() {
		atendimentos = BancoDeDados.getAtendimentos();
		BancoDeDados.leBancoDeDados();
	}

	public boolean inserir(Atendimento atendimento) {
		// bancoDeDados.inserirAtendimento(atendimento);
		return atendimentos.add(atendimento);
	}

	public boolean alterar(int codigo, Atendimento atendimento) {
		for (Atendimento aux : atendimentos) {
			if (aux.getCodigo() == codigo) {
				atendimentos.remove(aux);
				atendimentos.add(atendimento);
				return true;
			}
			bancoDeDados.atualizarAtendimento(atendimento.getCodigo(), atendimento);
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
		bancoDeDados.removerAtendimento(codigo);
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
		bancoDeDados.mostrar1(codigo);
		return null;
	}

	public Set<Atendimento> getAll() {
		return atendimentos; //retornando o vetor inteiro de atendimentos
	}
}



