package com.example.bd;

//declaração das importações necessárias
import java.util.HashSet;
import java.util.Set;


import com.example.model.Animal;
import com.example.model.Atendimento;
import com.example.model.Servico;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

public class BancoDeDados {

	DB baseDados;
	DBCollection collection;
	BasicDBObject document = new BasicDBObject();

	private static BancoDeDados bancoDeDados;

	//Criando Collections para armazenar os dados:
	private static Set<Animal> animais = new HashSet<>();
	private static Set<Servico> servicos = new HashSet<>();
	private static Set<Atendimento> atendimentos = new HashSet<>();

	public BancoDeDados() {}


	public static BancoDeDados getInstance() {
		return bancoDeDados;
	}

	public static Set<Animal> getAnimais() {
		return animais;
	}

	public static Set<Servico> getServicos() {
		return servicos;
	}

	public static Set<Atendimento> getAtendimentos() {
		return atendimentos;
	}
}
