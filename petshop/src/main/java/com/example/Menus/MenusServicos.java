package com.example.Menus;

import com.example.model.Servico;
import com.example.service.ServicoService;
import com.example.util.Util;

public class MenusServicos {
    
    //Menu: 2 - Cadastro de Serviços
    public static void menuServicos() {
        int opcao;
        Servico servico = new Servico();
        ServicoService servicoService = new ServicoService();

        Util.limpaConsole();
        do {
            System.out.printf(
                "\n=========== Menu de opções do Serviços ===========" +
                "\n1 - Inserir Serviço;" +
                "\n2 - Deletar Serviço;" +
                "\n3 - Alterar Serviço;" +
                "\nDigite zero(0) para voltar ao menu anterior." +
                "\n==================================================" +
                "\n> "
            );
            opcao = Util.leInteiro();

            switch (opcao) {
                case 0:
                    Util.limpaConsole();
                    return;
                case 1:
                    servico = new Servico();
                    Util.limpaConsole();
                    System.out.println(
                        "\n\t===================" +
                        "\n\tCADASTRO DE SERVIÇO" +
                        "\n\t==================="
                    );

                    System.out.print("\nInsira o código do serviço: ");
                    servico.setCodigo(Util.leInteiro());

                    System.out.print("\nDescrição do serviço: ");
                    servico.setNome(Util.leString());

                    System.out.print("\nValor do serviço: ");
                    servico.setValor(Util.leFloat());

                    if (servicoService.inserir(servico)) System.out.println(
                        "\nDados inseridos com sucesso"
                    ); else System.out.println("\nERRO! Dados não inseridos.");
                    break;
                case 2:
                    Util.limpaConsole();
                    System.out.println(
                        "\n\t===============" +
                        "\n\tDELETAR SERVIÇO" +
                        "\n\t==============="
                    );

                    System.out.print("\nInforme o código do serviço que será deletado: ");
                    if (servicoService.remover(Util.leInteiro())) System.out.println(
                        "\nDados deletados com sucesso"
                    ); else System.out.println("\nERRO! Dados não encontrados");
                    break;
                case 3:
                    servico = new Servico();
                    int codigo;
                    Util.limpaConsole();
                    System.out.println(
                        "\n\t===============" +
                        "\n\tALTERAR SERVIÇO" +
                        "\n\t==============="
                    );

                    System.out.print("\nInforme o código do serviço que será alterado: ");
                    codigo = Util.leInteiro();

                    servico.setCodigo(codigo);

                    System.out.print("Nova descrição do serviço: ");
                    servico.setNome(Util.leString());

                    System.out.print("Novo valor do serviço: ");
                    servico.setValor(Util.leFloat());

                    if (servicoService.alterar(codigo, servico)) System.out.println(
                        "\nDados alterados com sucesso"
                    ); else System.out.println("\nERRO! Dados não encontrados");
                    break;
                default:
                    Util.limpaConsole();
                    System.out.println("Opção inválida!!");
                break;
            }
        } while (true);
    }
    
    //Menu: 5 - Listar dados dos Serviço
    public static void menuListagemServicos() {
        //declaração de variáveis e instanciamento de objetos
        char opcao;
        ServicoService servicoService = new ServicoService();
        System.out.println(
            "\n================================" +
            "\nLISTAGEM DE SERVIÇOS CADASTRADOS" +
            "\n================================"
        );

        //é dada ao usuário a opção de escolher imprimir o relatório ou não
        System.out.println("Deseja realmente imprimir o relatório? (S/N)");
        opcao = Util.leChar();
        //caso o usuário confirme a operação->
        if (opcao == 'S' || opcao == 's') {
            //a função toString é chamada, para que seja mostrado o resultado na tela
            String servicos = servicoService.toString();

            //caso não haja animais para que os dados sejam exibidos, tal mensagem é mostrada
            if (servicos == "") System.out.println("\nNão existem serviços cadastros no sistema!");
            //caso contrário, o relatório é exibido
            else System.out.println(servicos);
        }
    }
    
}
