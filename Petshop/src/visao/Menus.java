package visao;

import java.io.IOException;
import java.util.Date;

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
            "\n12- Relatório - Atendimento entre um período;"+
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
                    servico = new Servico();
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
                    servico = new Servico();
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
        Animal animal;
        Servico servico;
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
        animal = animalService.getAnimal(Util.leInteiro());
        if(animal != null)atendimento.setAnimal(animal);
        
        System.out.print("\nCódigo do serviço: ");
        servico = servicoService.getServico(Util.leInteiro());
        if(servico != null)atendimento.setServico(servico);
        
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
        ServicoService servicoService = new ServicoService();
        System.out.println(
            "\n================================"+
            "\nLISTAGEM DE SERVIÇOS CADASTRADOS"+
            "\n================================"
        );

        System.out.println("Deseja realmente imprimir o relatório? (S/N)");
        if(Util.leChar() == 'S'){
            String servicos = servicoService.toString();

            if(servicos == "") System.out.println("\nNão existem serviços cadastros no sistema!");
            else System.out.println(servicos);
        }
    }
    
    public static void menuListagemAtendimentos(){
        AtendimentoService atendimentoService = new AtendimentoService();
        System.out.println(
            "\n===================================="+
            "\nLISTAGEM DE ATENDIMENTOS CADASTRADOS"+
            "\n===================================="
        );

        System.out.println("Deseja realmente imprimir o relatório? (S/N)");
        if(Util.leChar() == 'S'){
            String atendimentos = atendimentoService.toString();

            if(atendimentos == "") System.out.println("\nNão existem atendimentos cadastros no sistema!");
            else System.out.println(atendimentos);
        }
    }

    public static void menuNotaFiscal(){
        AtendimentoService atendimentoService = new AtendimentoService();
        System.out.print(
            "\n\tNOTA FISCAL"+
            "\nInsira o código do animal: "
        );

        System.out.println(atendimentoService.getNotaFiscal(Util.leInteiro()));
    }

    public static void menuLimparBancoDeDados(){
        // AtendimentoService atendimentoService = new AtendimentoService();
        // Banco
        AnimalService animalService = new AnimalService();
        AtendimentoService atendimentoService = new AtendimentoService();
        ServicoService servicoService = new ServicoService();
        System.out.println(
            "\n======================"+
            "\nDELETAR BANCO DE DADOS"+
            "\n======================"
        );

        System.out.println("Deseja realmente deletar o banco de dados? (S/N)");
        if(Util.leChar() == 'S'){
            animalService.limpaDados();
            atendimentoService.limpaDados();
            servicoService.limpaDados();

            System.out.println("\nBanco de dados deletado com sucesso");
        }
    }

    public static void relatorioMaiorValorAtendimento(){
        AtendimentoService atendimentoService = new AtendimentoService();
       
        System.out.print(
            "\n\tAtendimento de Maior Valor"+
            "\nInsira o código do animal: "
        );
        Atendimento atendimento = atendimentoService.getMaiorAtendimento(Util.leInteiro());

        System.out.println("RELATÓRIO - ATENDIMENTO DE MAIOR VALOR: R$"+atendimento.getServico().getValor());
    }

    public static void relatorioMenorValorAtendimento(){
        AtendimentoService atendimentoService = new AtendimentoService();
        System.out.print(
            "\n\tAtendimento de Menor Valor"+
            "\nInsira o código do animal: "
        );
        Atendimento atendimento = atendimentoService.getMenorAtendimento(Util.leInteiro());

        System.out.println("RELATÓRIO - ATENDIMENTO DE MENOR VALOR: R$"+atendimento.getServico().getValor());
    }

    public static void relatorioTotalValorAtendimento(){
        AtendimentoService atendimentoService = new AtendimentoService();
        System.out.print(
            "\n\tAtendimento de Total Valor"+
            "\nInsira o código do animal: "
        );

        System.out.println("RELATÓRIO - O TOTAL DOS ATENDIMENTOS DO ANIMAL É: R$"+atendimentoService.getTotalAtendimento(Util.leInteiro()));
    }

    public static void relatorioAtendimentoPeriodo(){
        AtendimentoService atendimentoService = new AtendimentoService();
        Date date1 = new Date();
        Date date2 = new Date();
        System.out.println(
            "\n======================"+
            "\nRELATÓRIO POR PERÍODO"+
            "\n======================"
        );
        System.out.print("\nInsira a data inicial (dd/mm/aaaa): ");
        date1 = Util.leData();
        System.out.print("\nInsira a data final (dd/mm/aaaa): ");
        date2 = Util.leData();

        if(date1.after(date2)){
            limpaConsole();
            System.out.println("ERRO! O período digitado não existe");
            return;
        }

        String string = atendimentoService.getAtendimentoPeriodo(date1, date2);
        if(string != null) System.out.println(string);
        else System.out.println("\nNenhum atendimento realizado no período.");
        
    }
}