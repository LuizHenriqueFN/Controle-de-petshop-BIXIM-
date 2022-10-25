package service;

import model.Servico;
import bd.BancoDeDados;
import dao.ServicoDAO;

public class ServicoService {
    Servico servicos[] = BancoDeDados.servicos;

    // public ServicoService() {
    //     servicos = BancoDeDados.getAnimais();
    // }
    ServicoDAO servicodao = new ServicoDAO();

    public void inserir(Servico servico) {
        servicodao.inserir(servico);
    }

    public void alterar(int codigo, Servico servico) {
        servicodao.alterar(codigo, servico);
    }

    public void remover(int codigo) {
        servicodao.remover(codigo);
    }

    public void limpaDados() {
        servicodao.limpaDados();
    }

    public void getServico(int codigo){
        servicodao.getServico(codigo);
    }

    public String toString(){
        return "Nome do servico: "+ servicodao.getServico(0).getNome() + "\nCodigo do servico: " +
        servicodao.getServico(0).getCodigo() + "\nValor do servico: " + servicodao.getServico(0).getValor();//retornando o vetor inteiro de servicos
    }

    

}

