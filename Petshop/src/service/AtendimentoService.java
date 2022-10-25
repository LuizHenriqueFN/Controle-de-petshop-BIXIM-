package service;

import model.Atendimento;
import bd.BancoDeDados;
import dao.AtendimentoDAO;

public class AtendimentoService {
    Atendimento atendimentos[] = BancoDeDados.atendimentos;

    // public AtendimentoService() {
    //     atendimentos = BancoDeDados.getatendimentos();
    // }
    AtendimentoDAO atendimentodao = new AtendimentoDAO();

    public void inserir(Atendimento atendimento) {
        atendimentodao.inserir(atendimento);
    }

    public void alterar(int codigo, Atendimento atendimento) {
        atendimentodao.alterar(codigo, atendimento);
    }

    public void remover(int codigo) {
        atendimentodao.remover(codigo);
    }

    public void limpaDados() {
        atendimentodao.limpaDados();
    }

    public void getAtendimento(int codigo){
        atendimentodao.getAtendimento(codigo);
    }

    public String toString(){
        return "Animal: "+ atendimentodao.getAtendimento(0).getAnimal() + "\nCodigo do atendimento: " +
        atendimentodao.getAtendimento(0).getCodigo() + "\nServiço: " + atendimentodao.getAtendimento(0).getServico();//retornando o vetor inteiro de atendimentos
    }

    

}

