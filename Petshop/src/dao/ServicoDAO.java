package dao;

import bd.BancoDeDados;
import java.util.Set;
import model.Servico;

public class ServicoDAO {
	Set<Servico> servicos;

	public ServicoDAO() {
		servicos = BancoDeDados.getServicos();
	}

	public boolean inserir(Servico servico) {
		return servicos.add(servico);
	}

	public boolean alterar(int codigo, Servico servico) {
		for (Servico aux : servicos) {
			if (aux.getCodigo() == codigo) {
				servicos.remove(aux);
				servicos.add(servico);
				return true;
			}
		}
		return false;
	}

	public boolean remover(int codigo) {
		for (Servico aux : servicos) {
			if (aux.getCodigo() == codigo) {
				servicos.remove(aux);
				return true;
			}
		}
		return false;
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
