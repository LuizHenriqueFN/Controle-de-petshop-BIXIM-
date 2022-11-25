package dao;

import model.Atendimento;

import java.util.Iterator;
import java.util.Set;

import bd.BancoDeDados;

public class AtendimentoDAO {
    private Set<Atendimento> atendimentos;
    private Iterator<Atendimento> I;

    public AtendimentoDAO() {
        atendimentos = BancoDeDados.getAtendimentos();
        I = atendimentos.iterator();
    }
    
    public boolean inserir(Atendimento atendimento) {
        return atendimentos.add(atendimento);
    }


    public boolean alterar(int codigo, Atendimento atendimento) {
        I = atendimentos.iterator();
        Atendimento temp;
        while(I.hasNext()){
            temp = (Atendimento)I.next();
            if(temp.getCodigo() == codigo){
                atendimentos.remove(temp);
                atendimentos.add(atendimento);
                return true;
            }
        }
        return false;
    }

    public boolean remover(int codigo) {
        I = atendimentos.iterator();
        Atendimento temp;
        while(I.hasNext()){
            temp = (Atendimento)I.next();
            if(temp.getCodigo() == codigo){
                atendimentos.remove(temp);
                return true;
            }
        }
        return false;
    }

    public void limpaDados(){
        atendimentos.clear();
    }

    public Atendimento getAtendimento(int codigo){
        I = atendimentos.iterator();
        Atendimento atendimento;
        while(I.hasNext()){
            atendimento = (Atendimento)I.next();
            if(atendimento.getCodigo() == codigo) return atendimento;
            
        }
        return null;
    }

    public Set<Atendimento> getAll(){
        return atendimentos;//retornando o vetor inteiro de atendimentos
    }

}
