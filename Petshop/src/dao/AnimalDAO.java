package dao;

import model.Animal;

import java.util.Iterator;
import java.util.Set;

import bd.BancoDeDados;

public class AnimalDAO {
    Set<Animal> animais;
    Iterator<Animal> i;
    public AnimalDAO() {
        animais = BancoDeDados.getAnimais();
    }

    public boolean inserir(Animal animal) {
            return (animais.add(animal));
        
    }

    public boolean alterar(int codigo, Animal animal) {
        Animal temp;
          while(i.hasNext()){
            temp = (Animal)i.next();
            if(temp.getCodigo() == codigo){
                animais.remove(temp);
                animais.add(animal);
                return true;
            }
          }
          return false;
    }

    public boolean remover(int codigo) {
        Animal temp;
          while(i.hasNext()){
            temp = (Animal)i.next();
            if(temp.getCodigo() == codigo){
                animais.remove(temp);
                return true;
            }
          }
          return false;
    }

    public void limpaDados(){
         animais.clear();
    }

    public Animal getAnimal(int codigo){
        Animal temp;
          while(i.hasNext()){
            temp = (Animal)i.next();
            if(temp.getCodigo() == codigo){
                return temp;
            }
          }
		return null;
    }

    public Set<Animal> getAll(){
        return animais;//retornando o vetor inteiro de animais
    }

}
