package com.example.service;

import com.example.dao.AnimalDAO;
import com.example.model.Animal;

public class AnimalService {

	private AnimalDAO animalDAO = new AnimalDAO();

	public AnimalService() {}

	private boolean isValid(Animal animal) {
		if (
			animal.getCodigo() != 0 	||
			animal.getNome() != ""  	||
			animal.getEndereco() != ""	||
			animal.getCidade() != ""
		){
			return true;
		}

		return false;
	}

	public boolean inserir(Animal animal) {
		if (isValid(animal) && animalDAO.inserir(animal)) return true;
		return false;
	}

	public boolean alterar(int codigo, Animal animal) {
		if (isValid(animal) && animalDAO.alterar(codigo, animal)) return true;
		return false;
	}

	public boolean remover(int codigo) {
		if (animalDAO.remover(codigo)) return true;
		return false;
	}

	public void limpaDados() {
		animalDAO.limpaDados();
	}

	public Animal getAnimal(int codigo) {
		Animal animal = animalDAO.getAnimal(codigo);
		if (animal != null) return animal;

		System.out.println("ERRO! Animal não encontrado");
		return null;
	}

	@Override
	public String toString() {
		Object animais[] = animalDAO.getAll().toArray();
		String string = "";

		for (int i = 0; i < animais.length; i++) {
			if (animais[i] != null) {
				string += animais[i].toString();
				string += '\n';
			}
		}

		return string;
	}
}
