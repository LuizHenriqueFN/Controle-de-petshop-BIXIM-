package com.example.service;

import com.example.dao.AtendimentoDAO;
import java.util.Date;
import java.util.Set;
import com.example.model.Atendimento;

public class AtendimentoService {

	private AtendimentoDAO atendimentodao = new AtendimentoDAO();
	private Set<Atendimento> atendimentos;

	public AtendimentoService() {
		atendimentos = atendimentodao.getAll();
	}

	private boolean isValid(Atendimento atendimento) {
		if (
			atendimento.getCodigo() != 0 	||
			atendimento.getAnimal() != null ||
			atendimento.getDate() != null 	||
			atendimento.getServico() != null
		){
			for(Atendimento aux : atendimentos){
				if(atendimento.getCodigo() == aux.getCodigo()){
					System.out.println("\nCódigo já existe.");
                    return false;
                }
			}
			return true;
		}

		return false;
	}

	public boolean inserir(Atendimento atendimento) {
		if (isValid(atendimento) && atendimentodao.inserir(atendimento)) return true;
		return false;
	}

	public boolean alterar(int codigo, Atendimento atendimento) {
		if (isValid(atendimento) && atendimentodao.alterar(codigo, atendimento)) return true;
		return false;
	}

	public boolean remover(int codigo) {
		if (atendimentodao.remover(codigo)) return true;
		return false;
	}

	public void limpaDados() {
		atendimentodao.limpaDados();
	}

	public Atendimento getAtendimento(int codigo) {
		Atendimento atendimento = atendimentodao.getAtendimento(codigo);
		if (atendimento != null) return atendimento;

		System.out.println("ERRO! Serviço não encontrado");
		return null;
	}

	@Override
	public String toString() {
		String string = "";
		for (Atendimento aux : atendimentos) {
			string += aux.toString();
			string += '\n';
		}
		return string;
	}

	public Atendimento getMaiorAtendimento(int codAnimal) {
		double maior = 0.0;
		Atendimento atendimento = null;
		for (Atendimento aux : atendimentos) {
			if (
				aux.getAnimal().getCodigo() == codAnimal &&
				aux.getServico().getValor() > maior
			) {
				maior = aux.getServico().getValor();
				atendimento = aux;
			}
		}
		return atendimento;
	}

	public Atendimento getMenorAtendimento(int codAnimal) {
		double menor = 100000000.0;
		Atendimento atendimento = null;
		for (Atendimento aux : atendimentos) {
			if (
				aux.getAnimal().getCodigo() == codAnimal &&
				aux.getServico().getValor() < menor
			) {
				menor = aux.getServico().getValor();
				atendimento = aux;
			}
		}
		return atendimento;
	}

	public float getTotalAtendimento(int codAnimal) {
		float soma = 0f;
		for (Atendimento aux : atendimentos) {
			if (aux.getAnimal().getCodigo() == codAnimal) {
				soma += aux.getServico().getValor();
			}
		}
		return soma;
	}

	protected String listaAtendimentos(int codAnimal) {
		String string = "";
		for (Atendimento aux : atendimentos) {
			if (aux.getAnimal().getCodigo() == codAnimal) {
				string += aux.getAnimal().toString();
				string += '\n';
			}
		}
		return string;
	}

	public String getNotaFiscal(int codAnimal) {
		String string = "";
		boolean existe = false;

		string += "\n\t===========" + "\n\tNOTA FISCAL" + "\n\t===========\n";

		for (Atendimento aux : atendimentos) {
			if (aux.getAnimal().getCodigo() == codAnimal) {
				string += aux.getAnimal().toString();
				string += '\n';
				existe = true;
				break;
			}
		}
		if (!existe) return null;

		string += "\n===============" + "\n=== ATENDIMENTOS ===" + "\n===============\n";

		existe = false;

		for (Atendimento aux2 : atendimentos) {
			if (aux2.getAnimal().getCodigo() == codAnimal) {
				string += aux2.getServico().toString();
				string += '\n';
				existe = true;
			}
		}

		if (!existe) return null;

		string +=
			"\n===============\nTotal: R$" +
			getTotalAtendimento(codAnimal) +
			"\n===============\n";

		return string;
	}

	public String getAtendimentoPeriodo(Date data1, Date data2) {
		String string = "\nRELATÓRIO - ATENDIMENTO NO PERÍODO:\n";
		boolean existe = false;

		for (Atendimento aux : atendimentos) {
			if (data1.before(aux.getDate()) && data2.after(aux.getDate())) {
				string += aux.getServico().toString();
				string += '\n';
				existe = true;
			}
		}
		if (!existe) return null;

		return string;
	}
}
