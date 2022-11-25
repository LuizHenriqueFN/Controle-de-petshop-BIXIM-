package dao;

import java.util.Iterator;
import java.util.Set;

import bd.BancoDeDados;
import model.Servico;

public class ServicoDAO {
    Set<Servico> servicos;
    private Iterator<Servico> I;

    public ServicoDAO() {
        servicos = BancoDeDados.getServicos();
    }

    public boolean inserir(Servico servico) {
        return servicos.add(servico);
    }


    public boolean alterar(int codigo, Servico servico) {
        I = servicos.iterator();
        Servico temp;
        while(I.hasNext()){
            temp = (Servico)I.next();
            if(temp.getCodigo() == codigo){
                servicos.remove(temp);
                servicos.add(servico);
                return true;
            }
        }
        return false;
    }

    public boolean remover(int codigo) {
        I = servicos.iterator();
        Servico temp;
        while(I.hasNext()){
            temp = (Servico)I.next();
            if(temp.getCodigo() == codigo){
                servicos.remove(temp);
                return true;
            }
        }
        return false;
    }

    public void limpaDados(){
        servicos.clear();
    }

    public Servico getServico(int codigo){
        I = servicos.iterator();
        Servico temp;
        while(I.hasNext()){
            temp = (Servico)I.next();
            if(temp.getCodigo() == codigo){
                return temp;
            }
        }
		return null;
    }

    public Set<Servico> getAll(){
        return servicos;
    }

}
