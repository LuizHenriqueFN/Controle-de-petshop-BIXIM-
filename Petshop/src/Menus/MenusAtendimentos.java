package Menus;

import java.util.Date;

import model.Animal;
import model.Atendimento;
import model.Servico;
import service.AnimalService;
import service.AtendimentoService;
import service.ServicoService;
import util.Util;

public class MenusAtendimentos {
    
    //Menu: 3 - Lançamento de Atendimentos
    public static void menuAtendimentos() {
        //declaração de variáveis e instanciamento de objetos
        Atendimento atendimento = new Atendimento();
        Animal animal;
        Servico aux, servico;
        AtendimentoService atendimentoService = new AtendimentoService();
        AnimalService animalService = new AnimalService();
        ServicoService servicoService = new ServicoService();

        System.out.println(
        "\n\t==========================" +
        "\n\tLANÇAMENTO DE ATENDIMENTOS" +
        "\n\t=========================="
        );

        //para inserção do serviço, então são lidos os dados necessários
        System.out.print("\nCódigo do atendimento: ");
        atendimento.setCodigo(Util.leInteiro());

        System.out.print("\nCódigo do animal: ");
        animal = animalService.getAnimal(Util.leInteiro());
        if (animal != null) atendimento.setAnimal(animal); else return;

        System.out.print("\nCódigo do serviço: ");
        aux = servicoService.getServico(Util.leInteiro());
        if (aux != null) {
            //Calculando o valor do serviço de acordo com o animal
            float novoValor = aux.getValor() + (aux.getValor() * animal.getTaxa());
            //Instanciando novo objeto para não alterar o valor padrão do serviço
            servico = new Servico(aux.getCodigo(), aux.getNome(), novoValor);
            atendimento.setServico(servico);
        }else return;

        System.out.print("\nData do atendimento(dd/MM/aaaa): ");
        atendimento.setDate(Util.leData());

        //caso não ocorra nenhum erro ao inserir os dados para cadastrar o serviço, tal mensagem é então mostrada ao usuário
        if (atendimentoService.inserir(atendimento)) System.out.println("\nDados inseridos com sucesso");
        //caso contrário é mostrada ao usuário a mensagem de que não foi possível a inserção
        else System.out.println("\nERRO! Espaço insuficiente.");
    }
    
    //Menu: 6 - Listar Atendimento cadastrado
    public static void menuListagemAtendimentos() {
        //declaração de variáveis e instanciamento de objetos
        char opcao;
        AtendimentoService atendimentoService = new AtendimentoService();
        System.out.println(
        "\n====================================" +
        "\nLISTAGEM DE ATENDIMENTOS CADASTRADOS" +
        "\n===================================="
        );

        //é dada ao usuário a opção de escolher imprimir o relatório ou não
        System.out.println("Deseja realmente imprimir o relatório? (S/N)");
        opcao = Util.leChar();
        //caso o usuário confirme a operação->
        if (opcao == 'S' || opcao == 's') {
            //<-a função toString é chamada, para que seja mostrado o resultado na tela
            String atendimentos = atendimentoService.toString();

            //caso não haja animais para que os dados sejam exibidos, tal mensagem é mostrada
            if (atendimentos == "") System.out.println("\nNão existem atendimentos cadastros no sistema!");
            //caso contrário, o relatório é exibido
            else System.out.println(atendimentos);
        }
    }
    
    //Menu: 7 - Emitir nota Fiscal
    public static void menuNotaFiscal() {
        //instanciamento de objeto
        AtendimentoService atendimentoService = new AtendimentoService();
        System.out.print("\n\tNOTA FISCAL" + "\nInsira o código do animal: ");

        //exibindo na tela a note fiscal correspondente ao atendimento possuinte do código
        String notaFiscal = atendimentoService.getNotaFiscal(Util.leInteiro());
        System.out.println("\nNota: " + notaFiscal);
        if(notaFiscal != null)System.out.println(notaFiscal);
        else System.out.println("\nERRO! Atendimento não cadastrado.");
    }
    
    //Menu: 9 - Relatório - Maior valor do atendimento do animal
    public static void relatorioMaiorValorAtendimento() {
        //instanciamento de objeto
        AtendimentoService atendimentoService = new AtendimentoService();

        System.out.print("\n\tAtendimento de Maior Valor" + "\nInsira o código do animal: ");

        //chamando a função que retorna o antendimento de maior valor
        Atendimento atendimento = atendimentoService.getMaiorAtendimento(Util.leInteiro());

        //se o atendimento não for vazio, o sistema imprime tal mensagem
        if (atendimento != null) System.out.println("RELATÓRIO - ATENDIMENTO DE MAIOR VALOR: R$" +atendimento.getServico().getValor());
        //caso contrário, tal mensagem é exibida
        else System.out.println("\nNenhum atendimento cadastrado");
    }
    
    //Menu: 10- Relatório - Menor valor do atendimento do animal
    public static void relatorioMenorValorAtendimento() {
        //instanciamento de objeto
        AtendimentoService atendimentoService = new AtendimentoService();
        System.out.print("\n\tAtendimento de Menor Valor" + "\nInsira o código do animal: ");
        //chamando a função que retorna o antendimento de menor valor
        Atendimento atendimento = atendimentoService.getMenorAtendimento(Util.leInteiro());

        //se o atendimento não for vazio, o sistema imprime tal mensagem
        if (atendimento != null) System.out.println("RELATÓRIO - ATENDIMENTO DE MENOR VALOR: R$" +atendimento.getServico().getValor());
        //caso contrário, tal mensagem é exibida
        else System.out.println("\nNenhum atendimento cadastrado");
    }
    
    //Menu: 11- Relatório - Totalizar os atendimentos do animal
    public static void relatorioTotalValorAtendimento() {
        //instanciamento de objeto
        AtendimentoService atendimentoService = new AtendimentoService();
        System.out.print("\n\tAtendimento de Total Valor" + "\nInsira o código do animal: ");
        //chamando a função que retorna o valor total dos atendimentos
        float total = atendimentoService.getTotalAtendimento(Util.leInteiro());
        //se o total não for 0, a mensagem é exibida
        if (total != 0f) System.out.println("RELATÓRIO - O TOTAL DOS ATENDIMENTOS DO ANIMAL É: R$" + total);
        //caso contrário, tal mensagem é exibida
        else System.out.println("\nNenhum atendimento cadastrado");
    }
    
    //Menu: 12- Relatório - Atendimento entre um período
    public static void relatorioAtendimentoPeriodo() {
        //instanciamento de objeto
        AtendimentoService atendimentoService = new AtendimentoService();
        Date date1 = new Date();
        Date date2 = new Date();
        System.out.println(
        "\n======================" +
        "\nRELATÓRIO POR PERIODO" +
        "\n======================"
        );
        //lendo entradas do usuário
        System.out.print("\nInsira a data inicial (dd/mm/aaaa): ");
        date1 = Util.leData();
        System.out.print("\nInsira a data final (dd/mm/aaaa): ");
        date2 = Util.leData();

        //se a data inicial for depois da data final, há erro e tal mensagem é exibida
        if (date1.after(date2)) {
            Util.limpaConsole();
            System.out.println("ERRO! O período digitado não existe");
            return;
        }

        //CHamando a função para retornar os atendimentos em um período
        String string = atendimentoService.getAtendimentoPeriodo(date1, date2);
        //se a string não for null, então a mensagem é printada
        if (string != null) System.out.println(string);
        //caso contrário, tal mensagem é printada
        else System.out.println("\nNenhum atendimento realizado no período.");
  }
}
