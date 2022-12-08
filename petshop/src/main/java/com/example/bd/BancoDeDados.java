package com.example.bd;

import java.util.Date;
//declaração das importações necessárias
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.bson.Document;

import com.example.model.Animal;
import com.example.model.Atendimento;
import com.example.model.Cachorro;
import com.example.model.Gato;
import com.example.model.Servico;
import com.example.model.TipoDocumento;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.google.gson.Gson;
import static com.mongodb.client.model.Filters.eq;

public class BancoDeDados {

	static DB baseDados;
	static DBCollection collection;
	static BasicDBObject document = new BasicDBObject();

	private static BancoDeDados bancoDeDados;

	// Criando Collections para armazenar os dados:
	private static Set<Animal> animais = new HashSet<>();
	private static Set<Servico> servicos = new HashSet<>();
	private static Set<Atendimento> atendimentos = new HashSet<>();

	public BancoDeDados() {
		try {
			// Criando conexão com o banco:
			Mongo mongo = new Mongo("localhost", 27017);

			// Conectando com a base de dados:
			baseDados = mongo.getDB("BDPetshop");

			System.out.println("\nConexão efetuada com sucesso");
		} catch (Exception err) {
			System.out.println(err);
		}
	}

	public static void leBancoDeDados(){
		servicos.clear();
		animais.clear();
        atendimentos.clear();

		collection = baseDados.getCollection("Servicos");
		Servico s = new Servico();
		DBCursor cursor = collection.find();
		while (cursor.hasNext()) {
			DBObject aux = cursor.next();
			s.setCodigo((int) aux.get("codigo"));
			s.setNome((String) aux.get("nome"));
			s.setValor((double) aux.get("valor"));
			servicos.add(s);
		}

		collection = baseDados.getCollection("Animal");

		Cachorro c = new Cachorro();
		Gato g = new Gato();
		cursor = collection.find();
		while (cursor.hasNext()) {
			DBObject aux = cursor.next();
			if(aux.getClass().getSimpleName().equals("Cachorro")){
				c.setCodigo((int) aux.get("codigo"));
				c.setNome((String) aux.get("nome"));
				c.setEndereco((String) aux.get("endereco"));
				c.setCidade((String) aux.get("cidade"));
				c.setPerdigree((boolean) aux.get("perdigree"));
				animais.add(c);
			}else{
				g.setCodigo((int) aux.get("codigo"));
				g.setNome((String) aux.get("nome"));
				g.setEndereco((String) aux.get("endereco"));
				g.setCidade((String) aux.get("cidade"));
				g.setNumeroDocumento((String) aux.get("numeroDocumento"));
				g.setTipo((TipoDocumento) aux.get("tipo"));
				animais.add(g);
			}
			
		}
		

		collection = baseDados.getCollection("Atendimentos");
		Atendimento at = new Atendimento();
		cursor = collection.find();
		while (cursor.hasNext()) {
			DBObject aux = cursor.next();
			at.setCodigo((int) aux.get("codigo"));
			at.setAnimal((Animal) aux.get("animal"));
			at.setServico((Servico) aux.get("servico"));
			at.setDate((Date) aux.get("date"));
			atendimentos.add(at);
		}
	}

	public void inserirAnimal(Animal animal) {
		collection = baseDados.getCollection("Animal");
		document = new BasicDBObject();

		document.put("codigo", animal.getCodigo());
			document.append("nome", animal.getNome());
			document.append("endereco", animal.getEndereco());
			document.append("cidade", animal.getCidade());

			System.out.println(animal.getClass().getSimpleName().equals("Gato"));

		if(animal.getClass().getSimpleName().equals("Gato")){
			Gato g = (Gato) animal;
			document.append("numeroDocumento", g.getNumeroDocumento());
			// document.append("tipoDocumento", g.getTipo());
		}else{
			Cachorro c = (Cachorro) animal;
            document.append("perdigree", c.isPerdigree());

		}
		collection.insert(document);
	}

	public void atualizarAnimal(int codigoAnimalAntigo, Animal animal) {
		collection = baseDados.getCollection("Animal");
		document = new BasicDBObject();

		document.put("codigo", codigoAnimalAntigo);

		BasicDBObject novo = new BasicDBObject();
		novo.put("codigo", animal.getCodigo());
		novo.append("nome", animal.getNome());
		novo.append("endereco", animal.getEndereco());
		novo.append("cidade", animal.getCidade());

		if(animal.getClass().getSimpleName().equals("Gato")){
			Gato g = (Gato) animal;
			novo.append("numeroDocumento", g.getNumeroDocumento());
			novo.append("tipoDocumento", g.getTipo());
		}else{
			Cachorro c = (Cachorro) animal;
            novo.append("perdigree", c.isPerdigree());

		}

		collection.findAndModify(document, novo);
	}

	public void removerAnimal(int codigoAnimal) {
		
		collection = baseDados.getCollection("Animal");
		document = new BasicDBObject();

		document.put("codigo", codigoAnimal);
		collection.remove(document);
	}

	public void inserirServico(Servico servico1) {
		collection = baseDados.getCollection("Servicos");
		document = new BasicDBObject();
		document.put("codigo", servico1.getCodigo());
		document.append("nome", servico1.getNome());
		document.append("valor", servico1.getValor());
		collection.insert(document);

	}

	public void atualizarServico(int codigoServicoAntigo, Servico servico) {
		collection = baseDados.getCollection("Servicos");
		document = new BasicDBObject();

		document.put("codigo", codigoServicoAntigo);
		

		BasicDBObject novo = new BasicDBObject();
		novo.put("codigo", servico.getCodigo());
		novo.append("nome", servico.getNome());
		novo.append("valor", servico.getValor());

		collection.findAndModify(document, novo);
	}

	public void removerServico(int codigoServico) {
		collection = baseDados.getCollection("Servicos");
		document = new BasicDBObject();

		System.out.println("\n\n\t"+codigoServico+"\n");
		document.put("codigo", codigoServico);
		collection.remove(document);
	}

	public void mostrar() {
		DBCursor cursor = collection.find();
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}

	public void mostrar1(int codigo) {
		document.put("codigo", codigo);
		System.out.println(collection.findOne(document));
	}

	public void inserirAtendimento(Atendimento atendimento1) {
		collection = baseDados.getCollection("Atendimentos");
		document = new BasicDBObject();
		document.put("codigo", atendimento1.getCodigo());
		document.append("animal", atendimento1.toString());
		document.append("servico", atendimento1.toString());
		document.append("data", atendimento1.getDate());
		collection.insert(document);
	}

	public void atualizarAtendimento(int codigoAtendimentoAntigo, Atendimento atendimento) {
		collection = baseDados.getCollection("Atendimentos");
		document = new BasicDBObject();

		document.put("codigo", codigoAtendimentoAntigo);

		BasicDBObject novo = new BasicDBObject();
		novo.put("codigo", atendimento.getCodigo());
		novo.append("animal", atendimento.getAnimal());
		novo.append("servico", atendimento.getServico());
		novo.append("data", atendimento.getDate());

		collection.findAndModify(document, novo);
	}

	public void removerAtendimento(int codigoAtendimento) {
		collection = baseDados.getCollection("Atendimentos");
		document = new BasicDBObject();

		document.put("codigo", codigoAtendimento);
		collection.remove(document);
	}

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
