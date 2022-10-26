package dao;

import model.Atendimento;
import bd.BancoDeDados;

public class AtendimentoDAO {
    Atendimento atendimentos[] = BancoDeDados.atendimentos;

    public AtendimentoDAO() {
        atendimentos = BancoDeDados.getAtendimentos();
    }

    public boolean inserir(Atendimento atendimento) {
            for(int i=0; i<atendimentos.length; i++){//percorrer todo o vetor
                if(atendimentos[i] == null){//se a posição atual estiver vazia
                    atendimentos[i] = atendimento;//insere o atendimento naquela posição do vetor
                    return true;
                }
            }
        return false;
    }


    public boolean alterar(int codigo, Atendimento atendimento) {
        for(int i=0; i<atendimentos.length; i++){//percorrer todo o vetor
            if(atendimentos[i].getCodigo() == codigo){//se a posição atual for o atendimento que procuro
                atendimentos[i] = atendimento;
                return true;
            }
        }
        return false;
    }

    public boolean remover(int codigo) {
        for(int i=0; i<atendimentos.length; i++){//percorrer todo o vetor
            if(atendimentos[i] != null && atendimentos[i].getCodigo() == codigo){//se a posição atual for o atendimento que procuro e se a posição já não estiver vazia
                atendimentos[i]=null;//esvazio aquela posição do vetor
                return true;
            }
        }
        return false;
    }

    public void limpaDados(){
        for(int i=0; i<atendimentos.length; i++){//percorrendo todo o vetor
            atendimentos[i] = null;//limpando o vetor
        }
    }

    public Atendimento getAtendimento(int codigo){
        for(int i=0; i<atendimentos.length; i++){//percorrendo todo o vetor
            if(atendimentos[i].getCodigo() == codigo){//se a posição atual for o atendimento que procuro
                return atendimentos[i];//retornando atendimento específico que eu procurava
            }
        }
		return null;
    }

    public Atendimento[] getAll(){
        return atendimentos;//retornando o vetor inteiro de atendimentos
    }

}
