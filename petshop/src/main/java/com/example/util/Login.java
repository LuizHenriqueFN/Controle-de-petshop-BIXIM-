package com.example.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;

public class Login {
	private static DB baseDados;
	private static DBCollection collection;
	private static BasicDBObject document = new BasicDBObject();

	public Login() {}

	private static void conectar(){
		try{
			//Criando conexão com o banco:
			Mongo mongo = new Mongo("localhost", 27017);

			//Conectando com a base de dados:
			baseDados = mongo.getDB("Login");

			collection = baseDados.getCollection("User_Password");
			Thread.sleep(1500);
		}catch(Exception err){
			System.out.println(err);
		}
	}

	public static boolean logar(String user, String password) {
		conectar();
		DBCursor cursor = collection.find();
		while(cursor.hasNext()){
			DBObject aux = cursor.next();
			if(
				user.equals(aux.get("user")) &&
				password.equals(aux.get("password"))
			){
				Util.limpaConsole();
				return true;
			}
		}
		Util.limpaConsole();
		return false;
	}
	
	public static boolean inserirLogin(String user, String password){
		document.put("user", user);
		document.append("password", password);

		
		if(user.isBlank() || password.isBlank()) return false;
		try{
			collection.insert(document);
		}catch(NullPointerException err){
			return false;
		}

		return true;
	}

	public static boolean deletarLogin(String user){
		document.put("user", user);

		if(user.isBlank()) return false;
		try{
			collection.remove(document);
		}catch(NullPointerException err){
			return false;
		}

		return true;
	}

	public static boolean alterarLogin(String user, String password, String userAntigo, String passwordAntigo){
		document.put("user", user);
		document.append("password", password);

		BasicDBObject documentAntigo = new BasicDBObject();
		documentAntigo.put("user", userAntigo);
		documentAntigo.append("password", passwordAntigo);

		if(
			user.isBlank() ||
			password.isBlank() ||
            userAntigo.isBlank() ||
			passwordAntigo.isBlank()
		) return false;


		try{
			collection.update(documentAntigo, document);
		}catch(NullPointerException err){
		}

		return true;
	}
}
