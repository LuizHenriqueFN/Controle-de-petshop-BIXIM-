package service;

import model.Animal;
import bd.BancoDeDados;
import dao.AnimalDAO;

public class AnimalService {
    Animal animais[] = BancoDeDados.animais;

    // public AnimalService() {
    //     animais = BancoDeDados.getAnimais();
    // }
    AnimalDAO animaldao = new AnimalDAO();

    public void inserir(Animal animal) {
        animaldao.inserir(animal);
    }

    public void alterar(int codigo, Animal animal) {
        animaldao.alterar(codigo, animal);
    }

    public void remover(int codigo) {
        animaldao.remover(codigo);
    }

    public void limpaDados() {
        animaldao.limpaDados();
    }

    public void getAnimal(int codigo){
        animaldao.getAnimal(codigo);
    }

    public String toString(){
        return "Nome do animal: "+ animaldao.getAnimal(0).getNome() + "\nCodigo do animal: " +
        animaldao.getAnimal(0).getCodigo() + "\nEndereço do animal: " + animaldao.getAnimal(0).getEndereco() +
        "\nCidade do animal: " + animaldao.getAnimal(0).getCidade();//retornando o vetor inteiro de animais
    }

    

}

