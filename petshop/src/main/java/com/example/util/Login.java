package com.example.util;

import java.io.BufferedReader;
import java.io.FileReader;

public class Login {

	public Login() {}

	public static boolean logar(String nome, String password) {
		try {
			FileReader arq = new FileReader("Senhas.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = "";
			try {
				linha = lerArq.readLine();
				while (linha != null) {
					//Verificando se o usuário e senha estão salvos no arquivo
					if (linha.contains(nome) && linha.contains(password)) {
						lerArq.close();
						return true;
					}
					linha = lerArq.readLine();//Verificando linhas com usuário e senha
				}
				lerArq.close();
				arq.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
}
