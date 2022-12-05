package Menus;

import model.Cachorro;
import model.Gato;
import model.TipoDocumento;
import service.AnimalService;
import util.DocumentoException;
import util.Util;

public class MenusAnimais {
    //Menu: 1 - Cadastro de Animal
    public static void menuAnimal() throws DocumentoException {
        //declaração das variáveis, objetos
        int opcao, codigo, tipo, animal;
        String nome, endereco, cidade, documento;
        Cachorro cachorro;
        Gato gato;
        TipoDocumento tipoDocumento;
        boolean perdigree, result = false;

        //instanciando um objeto
        AnimalService animalService = new AnimalService();

        Util.limpaConsole();
        do {
			System.out.printf(
				"\n=========== Menu de opções do Animal ===========" +
				"\n1 - Inserir Animal;" +
				"\n2 - Deletar Animal;" +
				"\n3 - Alterar Animal;" +
				"\nDigite zero(0) para voltar ao menu anterior." +
				"\n================================================" +
				"\n> "
			);
			opcao = Util.leInteiro(); //o menu acima é apresentado ao usuário e lê qual a opção escolhida por ele

			switch (opcao) {
				case 0:
					Util.limpaConsole();
					return;
				case 1:
					Util.limpaConsole();
					System.out.println(
						"\n\t==================" +
						"\n\tCADASTRO DE ANIMAL" +
						"\n\t=================="
					);
					//recebe todos os campos necessário para a criação de um objeto animal
					System.out.print("\nInsira seu código: ");
					codigo = Util.leInteiro();

					System.out.print("\nNome do animal: ");
					nome = Util.leString();

					System.out.print("\nEndereço do animal: ");
					endereco = Util.leString();

					System.out.print("\nCidade do animal: ");
					cidade = Util.leString();

					//enquanto o usuário não escolher o tipo de animal, a escolha continua sendo mostrada ao usuário
					do {
						System.out.print("\nTipo: 1) Cachorro 2) Gato\n");
						animal = Util.leInteiro();
					} while (animal < 1 && animal > 2);

					//se o animal escolhido for cachorro, é então perguntado ao usuário se o cachorro tem pedigree
					if (animal == 1) {
						System.out.println("\nTem pedigree?[true/false]");
						perdigree = Util.leBoolean();

						//Instanciando Cachorro:
						cachorro = new Cachorro(codigo, nome, endereco, cidade, perdigree);
						result = animalService.inserir(cachorro);
					} else {
						//Tipo do documento do dono:
						do {
						System.out.println("\nTipo Documento do dono: 1) CPF 2) CNPJ\n");
						tipo = Util.leInteiro();
						} while (tipo < 1 && tipo > 2);
						//se a opção escolhida for 1, o documento escolhido é o cpf
						if (tipo == 1) tipoDocumento = TipoDocumento.CPF;
						//senão, o documento escolhido é o cnpj
						else tipoDocumento = TipoDocumento.CNPJ;
						System.out.println("\nInsira o numero do documento: ");
						//Número do documento do dono:
						documento = Util.leString();

						//Instanciando Gato:
						try{
							if(Util.validar(documento, tipoDocumento)){
								gato = new Gato(
									codigo,
									nome,
									endereco,
									cidade,
									documento,
									tipoDocumento
								);
								result = animalService.inserir(gato);
							}else{
								throw new DocumentoException(documento); 
							}
							
						}catch(DocumentoException err){
							result = false;
						}
					}
					//se o resultado da inserção der certo, então obviamente os dados foram inseridos com sucesso
					if (result) System.out.println("\nDados inseridos com sucesso");
					//caso contrário, é mostrada ao usuário a mensagem de que não foi possivel inserir os dados
					else System.out.println("\nERRO! Dados não inseridos.");
					break;
				case 2:
					Util.limpaConsole();
					System.out.println(
						"\n\t==============" + "\n\tDELETAR ANIMAL" + "\n\t=============="
					);

					System.out.print("\nInforme o código do animal que será deletado: ");
					//após receber do usuário o código do animal que será deletado, caso a operação seja concluída, tal mensagem é exibida
					if (animalService.remover(Util.leInteiro())) System.out.println(
						"\nDados deletados com sucesso"
					);
					//caso o código inserido não corresponda a nenhum animal, logo, não é possível deletar
					else System.out.println("\nERRO! Dados não encontrados");
					break;
				case 3:
					Util.limpaConsole();
					System.out.println(
						"\n\t==================" +
						"\n\t  Alterar ANIMAL" +
						"\n\t=================="
					);
					//a fim de alterar o animal, o usuário informa o código do animal que ele deseja
					//e todos os outros dados que compõem o animal
					System.out.print("\nInsira seu código: ");
					codigo = Util.leInteiro();

					System.out.print("\nNome do animal: ");
					nome = Util.leString();

					System.out.print("\nEndereço do animal: ");
					endereco = Util.leString();

					System.out.print("\nCidade do animal: ");
					cidade = Util.leString();

					//enquanto o usuário não escolher o tipo de animal, a escolha continua sendo mostrada ao usuário
					do {
						System.out.print("\nTipo: 1) Cachorro 2) Gato");
						animal = Util.leInteiro();
					} while (animal < 1 && animal > 2);

					//se o animal escolhido for cachorro, é então perguntado ao usuário se o cachorro tem pedigree
					if (animal == 1) {
						System.out.println("\nTem perdigree?[true/false]");
						perdigree = Util.leBoolean();

						//Instanciando Cachorro:
						cachorro = new Cachorro(codigo, nome, endereco, cidade, perdigree);
						result = animalService.alterar(codigo, cachorro);
					} else {
						//Tipo do documento do dono:
						do {
						System.out.println("\nTipo Documento do dono: 1) CPF 2) CNPJ");
						tipo = Util.leInteiro();
						} while (tipo < 1 && tipo > 2);
						//se a opção escolhida for 1, o documento escolhido é o cpf
						if (tipo == 1) tipoDocumento = TipoDocumento.CPF;
						//senão, o documento escolhido é o cnpj
						else tipoDocumento = TipoDocumento.CNPJ;

						System.out.println("\nInsira o numero do documento: ");
						//Número do documento do dono:
						while (true) {
						documento = Util.leString();
						if (Util.validar(documento, tipoDocumento)) break;
						}

						//Instanciando Gato:
						gato =
						new Gato(
							codigo,
							nome,
							endereco,
							cidade,
							documento,
							tipoDocumento
						);
						result = animalService.alterar(codigo, gato);
					}

					//se o resultado da inserção der certo, então obviamente os dados foram inseridos com sucesso
					if (result) System.out.println("\nDados alterados com sucesso");
					//caso contrário, é mostrada ao usuário a mensagem de que não foi possivel inserir os dados
					else System.out.println("\nERRO! Dados não encontrados");
					break;
				default:
					Util.limpaConsole();
					System.out.println("Opção inválida!!");
				break;
			}
        } while (opcao != 0);
    }
    
    //Menu: 4 - Listar dados dos Animais
    public static void menuListagemAnimais() {
        //declaração de variáveis e instanciamento de objetos
        char opcao;
        AnimalService animalService = new AnimalService();
        System.out.println(
        "\n===============================" +
        "\nLISTAGEM DE ANIMAIS CADASTRADOS" +
        "\n==============================="
        );

        //é dada ao usuário a opção de escolher imprimir o relatório ou não
        System.out.println("Deseja realmente imprimir o relatório? (S/N)");
        opcao = Util.leChar();
        //caso o usuário confirme a operação->
        if (opcao == 'S' || opcao == 's') {
        //<-a função toString é chamada, para que seja mostrado o resultado na tela
        String animais = animalService.toString();

        if (animais == "") System.out.println(
            //caso não haja animais para que os dados sejam exibidos, tal mensagem é mostrada
            "\nNão existem animais cadastros no sistema!"
        );
        //caso contrário, o relatório é exibido
        else System.out.println(animais);
        }
    }
    
}
