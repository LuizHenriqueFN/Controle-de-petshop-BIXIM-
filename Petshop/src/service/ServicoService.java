package service;

import model.Servico;
import bd.BancoDeDados;
import dao.ServicoDAO;

public class ServicoService {
    Servico servicos[] = BancoDeDados.servicos;
    ServicoDAO servicodao = new ServicoDAO();

    public ServicoService() {}

    private static boolean isValid(Servico servico){
        if( servico.getCodigo() != 0    ||
            servico.getNome() != ""     ||
            servico.getValor() != 0f) return true;
        
        return false;
    }

    public boolean inserir(Servico servico) {
        if(isValid(servico) && servicodao.inserir(servico)) return true;

        return false;
    }

    public boolean alterar(int codigo, Servico servico) {
        if(isValid(servico) && servicodao.alterar(codigo, servico)) return true;
        return false;
    }

    public boolean remover(int codigo) {
        if(servicodao.remover(codigo)) return true;
        return false;
    }

    public void limpaDados() {
        servicodao.limpaDados();
    }

    public Servico getServico(int codigo){
        Servico servico = servicodao.getServico(codigo);
        if(servico != null) return servico;

        System.out.println("ERRO! Serviço não encontrado");
        return null;
    }

    public String toString(){
        return "Nome do servico: "+ servicodao.getServico(0).getNome() + "\nCodigo do servico: " +
        servicodao.getServico(0).getCodigo() + "\nValor do servico: " + servicodao.getServico(0).getValor();//retornando o vetor inteiro de servicos
    }

    

}

