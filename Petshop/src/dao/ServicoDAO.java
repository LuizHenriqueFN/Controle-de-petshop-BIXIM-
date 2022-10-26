package dao;

import model.Servico;
import bd.BancoDeDados;

public class ServicoDAO {
    Servico servicos[] = BancoDeDados.servicos;
    

    public ServicoDAO() {
        servicos = BancoDeDados.getServicos();
    }

    public boolean inserir(Servico servico) {
            for(int i=0; i<servicos.length; i++){//percorrer todo o vetor
                if(servicos[i] == null){//se a posição atual estiver vazia
                    servicos[i] = servico;//insere o servico naquela posição do vetor
                    return true;
                }
            }
        return false;
    }


    public boolean alterar(int codigo, Servico servico) {
        for(int i=0; i<servicos.length; i++){//percorrer todo o vetor
            if(servicos[i].getCodigo() == codigo){//se a posição atual for o servico que procuro
                servicos[i] = servico;
                return true;
            }
        }
        return false;
    }

    public boolean remover(int codigo) {
        for(int i=0; i<servicos.length; i++){//percorrer todo o vetor
            if(servicos[i] != null && servicos[i].getCodigo() == codigo){//se a posição atual for o servico que procuro e se a posição já não estiver vazia
                servicos[i]=null;//esvazio aquela posição do vetor
                return true;
            }
        }
        return false;
    }

    public void limpaDados(){
        for(int i=0; i<servicos.length; i++){//percorrendo todo o vetor
            servicos[i] = null;//limpando o vetor
        }
    }

    public Servico getServico(int codigo){
        for(int i=0; i<servicos.length; i++){//percorrendo todo o vetor
            if(servicos[i].getCodigo() == codigo){//se a posição atual for o servico que procuro
                return servicos[i];//retornando servico específico que eu procurava
            }
        }
		return null;
    }

    public Servico[] getAll(){
        return servicos;//retornando o vetor inteiro de servicos
    }

}
