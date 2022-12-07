package com.example.dao;

import com.example.bd.BancoDeDados;
import java.util.Set;
import com.example.model.Animal;

public class AnimalDAO {

	Set<Animal> animais;

	public AnimalDAO() {
		animais = BancoDeDados.getAnimais();
	}

	public boolean inserir(Animal animal) {
		return animais.add(animal);
	}

	public boolean alterar(int codigo, Animal animal) {
		for (Animal aux : animais) {
			if (aux.getCodigo() == codigo) {
				animais.remove(aux);
				animais.add(animal);
				return true;
			}
		}
		return false;
	}

	public boolean remover(int codigo) {
		for (Animal aux : animais) {
			if (aux.getCodigo() == codigo) {
				animais.remove(aux);
				return true;
			}
		}
		return false;
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
