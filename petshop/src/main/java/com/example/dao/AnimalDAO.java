package com.example.dao;

import com.example.bd.BancoDeDados;
import java.util.Set;
import com.example.model.Animal;

public class AnimalDAO {
	public static BancoDeDados bancoDeDados = new BancoDeDados();

	Set<Animal> animais;

	public AnimalDAO() {
		animais = BancoDeDados.getAnimais();
	}

	public boolean inserir(Animal animal) {
		bancoDeDados.inserirAnimal(animal);
		return animais.add(animal);
	}

	public boolean alterar(int codigo, Animal animal) {
		bancoDeDados.atualizarAnimal(animal.getCodigo(), animal);
		return true;
	}

	public boolean remover(int codigo) {
		bancoDeDados.removerAnimal(codigo);
		return true;
	}

	public void limpaDados() {
		animais.clear();
	}

	public Animal getAnimal(int codigo) {
		for (Animal aux : animais) {
			if (aux.getCodigo() == codigo) {
				return aux;
			}
		}
		return null;
	}

	public Set<Animal> getAll() {
		return animais; //retornando o vetor inteiro de animais
	}
}



