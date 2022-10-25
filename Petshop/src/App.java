import util.Util;
import visao.Menus;

public class App {

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

                    break;
                case 8:
                    Menus.limpaConsole();

                    break;
                case 9:
                    Menus.limpaConsole();

                    break;
                case 10:
                    Menus.limpaConsole();

                    break;
                case 11:
                    Menus.limpaConsole();

                    break;
                default:
                    Menus.limpaConsole();
                    System.out.println("Opção inválida!!");
                    break;
            }
        } while (true);
    }
}
