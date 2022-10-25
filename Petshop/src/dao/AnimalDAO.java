package dao;

import model.Animal;
import bd.BancoDeDados;

public class AnimalDAO {
    Animal animais[] = BancoDeDados.animais;

    public AnimalDAO() {
        animais = BancoDeDados.getAnimais();
    }

    public boolean inserir(Animal animal) {
            for(int i=0; i<animais.length; i++){//percorrer todo o vetor
                if(animais[i] == null){//se a posição atual estiver vazia
                    animais[i] = animal;//insere o animal naquela posição do vetor
                    return true;
                }
            }
        return false;
    }


    public boolean alterar(int codigo, Animal animal) {
        for(int i=0; i<animais.length; i++){//percorrer todo o vetor
            if(animais[i].getCodigo() == codigo){//se a posição atual for o animal que procuro
                animais[i] = animal;
                return true;
            }
        }
        return false;
    }

    public boolean remover(int codigo) {
        for(int i=0; i<animais.length; i++){//percorrer todo o vetor
            if(animais[i] != null && animais[i].getCodigo() == codigo){//se a posição atual for o animal que procuro e se a posição já não estiver vazia
                animais[i]=null;//esvazio aquela posição do vetor
            }
        }
        return false;
    }

    public void limpaDados(){
        for(int i=0; i<animais.length; i++){//percorrendo todo o vetor
            animais[i] = null;//limpando o vetor
        }
    }

    public Animal getAnimal(int codigo){
        for(int i=0; i<animais.length; i++){//percorrendo todo o vetor
            if(animais[i].getCodigo() == codigo){//se a posição atual for o animal que procuro
                return animais[i];//retornando animal específico que eu procurava
            }
        }
		return null;
    }

    public Animal[] getAll(){
        return animais;//retornando o vetor inteiro de animais
    }

}
