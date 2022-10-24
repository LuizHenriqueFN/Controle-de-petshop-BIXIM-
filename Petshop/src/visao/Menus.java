package visao;

public class Menus {
    public void menuInicio() {
        System.out.printf(
                "\n===================== Menu de opções =====================",
                "\n1 - Cadastro de Animal;",
                "\n2 - Cadastro de Serviços;",
                "\n3 - Lançamento de Atendimentos;",
                "\n4 - Listar dados dos Animais;",
                "\n5 - Listar dados dos Serviços",
                "\n6 - Listar Atendimento cadastrado;",
                "\n7 - Emitir nota Fiscal;",
                "\n8 - Limpar banco de dados;",
                "\n9 - Relatório - Maior valor do atendimento do animal;",
                "\n10- Relatório - Menor valor do atendimento do animal;",
                "\n11- Relatório - Totalizar os atendimentos do animal;",
                "\nDigite zero(0) para terminar.",
                "\n==========================================================",
                "\n> ");
    }

    public void menuLogar() {
        System.out.printf(
                "\n\t=====================================",
                "\n\tBem vindo ao Sistema de Petshop BIXIM",
                "\n\t=====================================");
    }
}