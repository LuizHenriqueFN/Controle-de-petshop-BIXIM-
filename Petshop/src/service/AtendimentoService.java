package service;

import model.Atendimento;
import bd.BancoDeDados;
import dao.AtendimentoDAO;

public class AtendimentoService {
    Atendimento atendimentos[] = BancoDeDados.atendimentos;
    AtendimentoDAO atendimentodao = new AtendimentoDAO();

    public AtendimentoService() {}

    private static boolean isValid(Atendimento atendimento){
        if( atendimento.getCodigo() != 0    ||
            atendimento.getAnimal() != null ||
            atendimento.getDate() != null   ||
            atendimento.getServico() != null) return true;
        
        return false;
    }

    public boolean inserir(Atendimento atendimento) {
        if(isValid(atendimento) && atendimentodao.inserir(atendimento)) return true;

        return false;
    }

    public boolean alterar(int codigo, Atendimento atendimento) {
        if(isValid(atendimento) && atendimentodao.alterar(codigo, atendimento)) return true;
        return false;
    }

    public boolean remover(int codigo) {
        if(atendimentodao.remover(codigo)) return true;
        return false;
    }

    public void limpaDados() {
        atendimentodao.limpaDados();
    }

    public Atendimento getAtendimento(int codigo){
        Atendimento atendimento = atendimentodao.getAtendimento(codigo);
        if(atendimento != null) return atendimento;

        System.out.println("ERRO! Serviço não encontrado");
        return null;
    }

    // public String toString(){
    //     return "Nome do atendimento: "+ atendimentodao.getAtendimento(0).getNome() + "\nCodigo do atendimento: " +
    //     atendimentodao.getAtendimento(0).getCodigo() + "\nValor do atendimento: " + atendimentodao.getAtendimento(0).getValor();//retornando o vetor inteiro de atendimentos
    // }

    

}




// package service;

// import model.Atendimento;
// import bd.BancoDeDados;
// import dao.AtendimentoDAO;

// public class AtendimentoService {
//     Atendimento atendimentos[] = BancoDeDados.atendimentos;

//     // public AtendimentoService() {
//     //     atendimentos = BancoDeDados.getatendimentos();
//     // }
//     AtendimentoDAO atendimentodao = new AtendimentoDAO();

//     public void inserir(Atendimento atendimento) {
//         atendimentodao.inserir(atendimento);
//     }

//     public void alterar(int codigo, Atendimento atendimento) {
//         atendimentodao.alterar(codigo, atendimento);
//     }

//     public void remover(int codigo) {
//         atendimentodao.remover(codigo);
//     }

//     public void limpaDados() {
//         atendimentodao.limpaDados();
//     }

//     public void getAtendimento(int codigo){
//         atendimentodao.getAtendimento(codigo);
//     }

//     public String toString(){
//         return "Animal: "+ atendimentodao.getAtendimento(0).getAnimal() + "\nCodigo do atendimento: " +
//         atendimentodao.getAtendimento(0).getCodigo() + "\nServiço: " + atendimentodao.getAtendimento(0).getServico();//retornando o vetor inteiro de atendimentos
//     }

    

// }

