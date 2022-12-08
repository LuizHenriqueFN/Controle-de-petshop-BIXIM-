package com.example.Menus;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.example.bd.BancoDeDados;
import com.example.model.Atendimento;
import com.example.model.Cachorro;
import com.example.model.Servico;
import com.example.service.AnimalService;
import com.example.service.AtendimentoService;
import com.example.service.ServicoService;
import com.example.util.Login;
import com.example.util.Util;

public class MenusAuxiliares {
	//Função para povoar banco de dados
	public static void geraDados() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		AnimalService animalService = new AnimalService();
		ServicoService servicoService = new ServicoService();
		AtendimentoService atendimentoService = new AtendimentoService();
	
		Cachorro cachorro = new Cachorro( 1, "Jubileu", "Rua São Luiz", "Formiga", true);
		Servico servico = new Servico(1, "Banho", 50f);
		Servico servico2 = new Servico(2, "Tosa", 25f);
		Atendimento atendimento = null;
		Atendimento atendimento2 = null;
		animalService.inserir(cachorro);
		servicoService.inserir(servico);
		servicoService.inserir(servico2);
	
		Servico taxa1 = new Servico(1, "Banho", 55f);
		Servico taxa2 = new Servico(1, "Banho", 27.5f);
		try {
			atendimento = new Atendimento(1, cachorro, taxa1, sdf.parse("22/10/2002"));
			atendimento2 = new Atendimento(2, cachorro, taxa2, sdf.parse("25/10/2002"));
		} catch (ParseException e) {
		  	e.printStackTrace();
		}
		atendimentoService.inserir(atendimento);
		atendimentoService.inserir(atendimento2);
	  }
	
	//função apenas para printar as opções do menu inicial
	public static void menuInicio() {
		System.out.print(
			"\n===================== Menu de opções =====================" +
			"\n1 - Cadastro de Animal;" +
			"\n2 - Cadastro de Serviços;" +
			"\n3 - Lançamento de Atendimentos;" +
			"\n4 - Listar dados dos Animais;" +
			"\n5 - Listar dados dos Serviços" +
			"\n6 - Listar Atendimento cadastrado;" +
			"\n7 - Emitir nota Fiscal;" +
			"\n8 - Limpar banco de dados;" +
			"\n9 - Relatório - Maior valor do atendimento do animal;" +
			"\n10- Relatório - Menor valor do atendimento do animal;" +
			"\n11- Relatório - Totalizar os atendimentos do animal;" +
			"\n12- Relatório - Atendimento entre um período;" +
			"\n13- Gerenciamento de Logins;" +
			"\nDigite zero(0) para terminar." +
			"\n==========================================================" +
			"\n> "
		);
	}
	
	//função para permitir que o usuario faça login no sistema
	public static void logar() {
		Util.limpaConsole();
		System.out.printf(
			"=====================================\n" +
			"Bem vindo ao Sistema de Petshop BIXIM\n" +
			"=====================================\n"
		);

		//recebendo dados que o usuário digita
		System.out.println("\nUsuário: ");
		String nome = Util.leString();

		System.out.println("\nSenha: ");
		String password = Util.leString();
		Util.limpaConsole();

		//se o login for concluído (credenciais inclusas corretamente), return
		if (Login.logar(nome, password)) {
			geraDados();
			BancoDeDados.leBancoDeDados();
			return;
		}

		//caso não, a mensagem é então mostrada ao usuário de que não houve êxito no login
		System.out.println("ERRO! Usuário e senha inválidos");
		System.exit(0);
	}
	
	//Menu: 8 - Limpar banco de dados
	public static void menuLimparBancoDeDados() {
		//declaração de variáveis e instanciamento de objetos
		char opcao;
		AnimalService animalService = new AnimalService();
		AtendimentoService atendimentoService = new AtendimentoService();
		ServicoService servicoService = new ServicoService();
		System.out.println(
			"\n======================" +
			"\nDELETAR BANCO DE DADOS" +
			"\n======================"
		);

		//é dada ao usuário a opção de escolher deletar o banco de dados ou não
		System.out.println("Deseja realmente deletar o banco de dados? (S/N)");
		opcao = Util.leChar();
		//caso o usuário confirme a operação->
		if (opcao == 'S' || opcao == 's') {
			//o pacote service inteiro é limpo
			animalService.limpaDados();
			atendimentoService.limpaDados();
			servicoService.limpaDados();
			//é exibida na tela a mensagem de confirmação
			System.out.println("\nBanco de dados deletado com sucesso");
		}
	}

	public static void menuLogar(){
		int opcao;
		String user, password;
		String userAntigo, passwordAntigo;

		do{

			System.out.printf(
				"\n=========== Menu de opções do Login ============" +
				"\n1 - Inserir Login;" +
				"\n2 - Deletar Login;" +
				"\n3 - Alterar Login;" +
				"\nDigite zero(0) para voltar ao menu anterior." +
				"\n================================================" +
				"\n> "
			);
			opcao = Util.leInteiro();

			switch (opcao) {
				case 0:
					Util.limpaConsole();
					return;
				case 1:
					Util.limpaConsole();
						System.out.println(
							"\n\t==================" +
							"\n\t  Inserir Login" +
							"\n\t=================="
						);

						System.out.printf("\nInsira o novo usuário(user): ");
						user = Util.leString();
						System.out.printf("\nInsira a nova senha(password): ");
						password = Util.leString();

						if(Login.inserirLogin(user, password))System.out.println("\nDados inseridos com sucesso!");
						else System.out.println("\nERRO! Não foi possível inserir os dados.");

					break;
				case 2:
					Util.limpaConsole();
						System.out.println(
							"\n\t==================" +
							"\n\t  Deletar Login" +
							"\n\t=================="
						);

						System.out.printf("\nInsira o usuário(user) que deseja deletar: ");
						user = Util.leString();

						if(Login.deletarLogin(user))System.out.println("\nDados deletados com sucesso!");
						else System.out.println("\nERRO! Não foi possível deletar os dados.");

					break;
				case 3:
					Util.limpaConsole();
						System.out.println(
							"\n\t==================" +
							"\n\t  Alterar Login" +
							"\n\t=================="
						);
						System.out.printf("\nInsira o usuário(user) que deseja alterar: ");
						userAntigo = Util.leString();
						System.out.printf("\nInsira a senha(password) que deseja alterar: ");
						passwordAntigo = Util.leString();
						System.out.printf("\nInsira o novo usuário(user): ");
						user = Util.leString();
						System.out.printf("\nInsira a nova senha(password): ");
						password = Util.leString();

						if(Login.alterarLogin(user, password, userAntigo, passwordAntigo))System.out.println("\nDados alterados com sucesso!");
						else System.out.println("\nERRO! Não foi possível alterar os dados.");

					break;
				default:
					Util.limpaConsole();
					System.out.println("Opção inválida!!");
				break;
			}
		}while(opcao != 0);
	}
	
}
