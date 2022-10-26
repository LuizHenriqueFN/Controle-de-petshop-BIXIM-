package visao;

import util.Util;

public class Principal {

    public static void main(String[] args) throws Exception {
        Menus.logar();

        int opcao;

        do {
            Menus.menuInicio();
            opcao = Util.leInteiro();

            switch (opcao) {
                case 0:
                    Menus.limpaConsole();
                    System.out.println("Encerrando...");
                    return;
                case 1:
                    Menus.limpaConsole();
                    Menus.menuAnimal();
                    break;
                case 2:
                    Menus.limpaConsole();
                    Menus.menuServicos();
                    break;
                case 3:
                    Menus.limpaConsole();
                    Menus.menuAtendimentos();
                    break;
                case 4:
                    Menus.limpaConsole();
                    Menus.menuListagemAnimais();
                    break;
                case 5:
                    Menus.limpaConsole();
                    Menus.menuListagemServicos();
                    break;
                case 6:
                    Menus.limpaConsole();
                    Menus.menuListagemAtendimentos();
                    break;
                case 7:
                    Menus.limpaConsole();
                    Menus.menuNotaFiscal();
                    break;
                case 8:
                    Menus.limpaConsole();
                    Menus.menuLimparBancoDeDados();
                    break;
                case 9:
                    Menus.limpaConsole();
                    Menus.relatorioMaiorValorAtendimento();
                    break;
                case 10:
                    Menus.limpaConsole();
                    Menus.relatorioMenorValorAtendimento();
                    break;
                case 11:
                    Menus.limpaConsole();
                    Menus.relatorioTotalValorAtendimento();
                    break;
                case 12:
                    Menus.limpaConsole();
                    Menus.relatorioAtendimentoPeriodo();
                    break;
                default:
                    Menus.limpaConsole();
                    System.out.println("Opção inválida!!");
                    break;
            }
        } while (true);
    }
}
