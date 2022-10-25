package visao;

import java.io.IOException;

import dao.AtendimentoDAO;
import dao.ServicoDAO;
import model.Animal;
import model.Atendimento;
import model.Servico;
import service.AnimalService;
import service.AtendimentoService;
import service.ServicoService;
import util.Login;
import util.Util;

public class Menus {

    private static void clear() throws IOException, InterruptedException {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    }

    public static void limpaConsole() {
        try {
            clear();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void menuInicio() {
        System.out.print(
            "\n===================== Menu de opções ====================="+
            "\n1 - Cadastro de Animal;"+
            "\n2 - Cadastro de Serviços;"+
            "\n3 - Lançamento de Atendimentos;"+
            "\n4 - Listar dados dos Animais;"+
            "\n5 - Listar dados dos Serviços"+
            "\n6 - Listar Atendimento cadastrado;"+
            "\n7 - Emitir nota Fiscal;"+
            "\n8 - Limpar banco de dados;"+
            "\n9 - Relatório - Maior valor do atendimento do animal;"+
            "\n10- Relatório - Menor valor do atendimento do animal;"+
            "\n11- Relatório - Totalizar os atendimentos do animal;"+
            "\nDigite zero(0) para terminar."+
            "\n=========================================================="+
            "\n> "
        );
    }

    public static void logar() {
        limpaConsole();
        System.out.printf(
            "=====================================\n"+
            "Bem vindo ao Sistema de Petshop BIXIM\n"+
            "=====================================\n"
        );

        System.out.println("\nUsuário: ");
        String nome = Util.leString();

        System.out.println("\nSenha: ");
        String password = Util.leString();
        Menus.limpaConsole();

        if (Login.logar(nome, password))
            return;

        System.out.println("ERRO! Usuário e senha inválidos");
        System.exit(0);
    }

    public static void menuAnimal() {
        int opcao;
        Animal animal = new Animal();
        AnimalService animalService = new AnimalService();

        limpaConsole();
        do {
            System.out.printf(
                "\n=========== Menu de opções do Animal ==========="+
                "\n1 - Inserir Animal;"+
                "\n2 - Deletar Animal;"+
                "\n3 - Alterar Animal;"+
                "\nDigite zero(0) para voltar ao menu anterior."+
                "\n================================================"+
                "\n> "
            );
            opcao = Util.leInteiro();

            switch (opcao) {
                case 0:
                    limpaConsole();
                    return;
                case 1:
                    animal = new Animal();
                    limpaConsole();
                    System.out.println(
                        "\n\t=================="+
                        "\n\tCADASTRO DE ANIMAL"+
                        "\n\t=================="
                    );

                    System.out.print("\nInsira seu código: ");
                    animal.setCodigo(Util.leInteiro());

                    System.out.print("\nNome do ANIMAL: ");
                    animal.setNome(Util.leString());

                    System.out.print("\nEndereço do animal: ");
                    animal.setEndereco(Util.leString());

                    System.out.print("\nCidade do animal: ");
                    animal.setCidade(Util.leString());

                    if(animalService.inserir(animal))System.out.println("\nDados inseridos com sucesso");
                    else System.out.println("\nERRO! Espaço insuficiente");
                    break;
                case 2:
                    limpaConsole();
                    System.out.println(
                        "\n\t=============="+
                        "\n\tDELETAR ANIMAL"+
                        "\n\t=============="
                    );

                    System.out.print("\nInforme o código do animal que será deletado: ");
                    if(animalService.remover(Util.leInteiro()))System.out.println("\nDados deletados com sucesso");
                    else System.out.println("\nERRO! Dados não encontrados");
                    break;
                case 3:
                    animal = new Animal();
                    int codigo;
                    limpaConsole();
                    System.out.println(
                        "\n\t=============="+
                        "\n\tALTERAR ANIMAL"+
                        "\n\t=============="
                    );

                    System.out.print("\nInforme o código do animal que será alterado: ");
                    codigo = Util.leInteiro();

                    animal.setCodigo(codigo);

                    System.out.print("Novo nome do animal: ");
                    animal.setNome(Util.leString());

                    System.out.print("Novo endereço do animal: ");
                    animal.setEndereco(Util.leString());

                    System.out.print("Nova cidade do animal: ");
                    animal.setCidade(Util.leString());

                    if(animalService.alterar(codigo, animal)) System.out.println("\nDados alterados com sucesso");
                    else System.out.println("\nERRO! Dados não encontrados");
                    break;
                default:
                    limpaConsole();
                    System.out.println("Opção inválida!!");
                    break;
            }
        } while (opcao != 0);

    }

    public static void menuServicos() {
        int opcao;
        Servico servico = new Servico();
        ServicoService servicoService = new ServicoService();

        limpaConsole();
        do {
            System.out.printf(
                "\n=========== Menu de opções do Serviços ==========="+
                "\n1 - Inserir Serviço;"+
                "\n2 - Deletar Serviço;"+
                "\n3 - Alterar Serviço;"+
                "\nDigite zero(0) para voltar ao menu anterior."+
                "\n=================================================="+
                "\n> "
            );
            opcao = Util.leInteiro();

            switch (opcao) {
                case 0:
                    limpaConsole();
                    return;
                case 1:
                    limpaConsole();
                    System.out.println(
                        "\n\t==================="+
                        "\n\tCADASTRO DE SERVIÇO"+
                        "\n\t==================="
                    );

                    System.out.print("\nInsira o código do serviço: ");
                    servico.setCodigo(Util.leInteiro());

                    System.out.print("\nDescrição do serviço: ");
                    servico.setNome(Util.leString());

                    System.out.print("\nValor do serviço: ");
                    servico.setValor(Util.leFloat());

                    if(servicoService.inserir(servico))System.out.println("\nDados inseridos com sucesso");
                    else System.out.println("\nERRO! Espaço insuficiente.");
                    break;
                case 2:
                    limpaConsole();
                    System.out.println(
                        "\n\t==============="+
                        "\n\tDELETAR SERVIÇO"+
                        "\n\t==============="
                    );

                    System.out.print("\nInforme o código do serviço que será deletado: ");
                    if(servicoService.remover(Util.leInteiro()))System.out.println("\nDados deletados com sucesso");
                    else System.out.println("\nERRO! Dados não encontrados");
                    break;
                case 3:
                    int codigo;
                    limpaConsole();
                    System.out.println(
                        "\n\t==============="+
                        "\n\tALTERAR SERVIÇO"+
                        "\n\t==============="
                    );

                    System.out.print("\nInforme o código do serviço que será alterado: ");
                    codigo = Util.leInteiro();

                    servico.setCodigo(codigo);
                    
                    System.out.print("Nova descrição do serviço: ");
                    servico.setNome(Util.leString());
                    
                    System.out.print("Novo valor do serviço: ");
                    servico.setValor(Util.leFloat());

                    if(servicoService.alterar(codigo, servico)) System.out.println("\nDados alterados com sucesso");
                    else System.out.println("\nERRO! Dados não encontrados");
                    break;
                default:
                    limpaConsole();
                    System.out.println("Opção inválida!!");
                    break;
            }
        } while (true);
    }

    public static void menuAtendimentos(){
        Atendimento atendimento = new Atendimento();
        AtendimentoService atendimentoService = new AtendimentoService();
        AnimalService animalService = new AnimalService();
        ServicoService servicoService = new ServicoService();

        System.out.println(
            "\n\t=========================="+
            "\n\tLANÇAMENTO DE ATENDIMENTOS"+
            "\n\t=========================="
        );

        System.out.print("\nCódigo do atendimento: ");
        atendimento.setCodigo(Util.leInteiro());

        System.out.print("\nCódigo do animal: ");
        atendimento.setAnimal(animalService.getAnimal(Util.leInteiro()));
        
        System.out.print("\nCódigo do serviço: ");
        atendimento.setServico(servicoService.getServico(Util.leInteiro()));
        
        System.out.print("\nData do atendimento: ");
        atendimento.setDate(Util.leData());

        if(atendimentoService.inserir(atendimento))System.out.println("\nDados inseridos com sucesso");
        else System.out.println("\nERRO! Espaço insuficiente.");

    }

    public static void menuListagemAnimais(){
        AnimalService animalService = new AnimalService();
        System.out.println(
            "\n==============================="+
            "\nLISTAGEM DE ANIMAIS CADASTRADOS"+
            "\n==============================="
        );

        System.out.println("Deseja realmente imprimir o relatório? (S/N)");
        if(Util.leChar() == 'S'){
            String animais = animalService.toString();

            if(animais == "") System.out.println("\nNão existem animais cadastros no sistema!");
            else System.out.println(animais);
        }
    }

    public static void menuListagemServicos(){
        int i;
        ServicoDAO servicoDAO = new ServicoDAO();
        System.out.println(
            "\n================================"+
            "\nLISTAGEM DE SERVIÇOS CADASTRADOS"+
            "\n================================"
        );

        System.out.println("Deseja realmente imprimir o relatório? (S/N)");
        if(Util.leChar() == 'S'){
            Servico servicos[] = servicoDAO.getAll();

            for (i = 0; i < servicos.length; i++) {
                if(servicos[i] != null) break;
            }

            if(i == servicos.length) System.out.println("\nNão existem serviços cadastros no sistema!");
            else{
                for (i = 0; i < servicos.length; i++) {
                    if(servicos[i] != null) {
                        System.out.print(servicos[i].toString());
                    }
                }
            }
        }
    }
    
    public static void menuListagemAtendimentos(){
        int i;
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
        System.out.println(
            "\n===================================="+
            "\nLISTAGEM DE ATENDIMENTOS CADASTRADOS"+
            "\n===================================="
        );

        System.out.println("Deseja realmente imprimir o relatório? (S/N)");
        if(Util.leChar() == 'S'){
            Atendimento atendimentos[] = atendimentoDAO.getAll();

            for (i = 0; i < atendimentos.length; i++) {
                if(atendimentos[i] != null) break;
            }

            if(i == atendimentos.length) System.out.println("\nNão existem atendimentos cadastros no sistema!");
            else{
                for (i = 0; i < atendimentos.length; i++) {
                    if(atendimentos[i] != null) {
                        System.out.print(atendimentos[i].toString());
                    }
                }
            }
        }
    }

    public static void menuNotaFiscal(){
            
    }
}