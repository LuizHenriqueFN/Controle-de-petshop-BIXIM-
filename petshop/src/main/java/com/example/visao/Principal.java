package com.example.visao;

import com.example.Menus.MenusAnimais;
import com.example.Menus.MenusAtendimentos;
import com.example.Menus.MenusAuxiliares;
import com.example.Menus.MenusServicos;
import com.example.util.DocumentoException;
import com.example.util.Util;

public class Principal {

    public static void main(String[] args) throws DocumentoException{
        MenusAuxiliares.logar();

        int opcao;

        //Organização dos menus
        do {
            MenusAuxiliares.menuInicio();
            opcao = Util.leInteiro();

            switch (opcao) {
                case 0:
                    Util.limpaConsole();
                    System.out.println("Encerrando...");
                    return;
                case 1:
                    Util.limpaConsole();
                    MenusAnimais.menuAnimal();
                    break;
                case 2:
                    Util.limpaConsole();
                    MenusServicos.menuServicos();
                    break;
                case 3:
                    Util.limpaConsole();
                    MenusAtendimentos.menuAtendimentos();
                    break;
                case 4:
                    Util.limpaConsole();
                    MenusAnimais.menuListagemAnimais();
                    break;
                case 5:
                    Util.limpaConsole();
                    MenusServicos.menuListagemServicos();
                    break;
                case 6:
                    Util.limpaConsole();
                    MenusAtendimentos.menuListagemAtendimentos();
                    break;
                case 7:
                    Util.limpaConsole();
                    MenusAtendimentos.menuNotaFiscal();
                    break;
                case 8:
                    Util.limpaConsole();
                    MenusAuxiliares.menuLimparBancoDeDados();
                    break;
                case 9:
                    Util.limpaConsole();
                    MenusAtendimentos.relatorioMaiorValorAtendimento();
                    break;
                case 10:
                    Util.limpaConsole();
                    MenusAtendimentos.relatorioMenorValorAtendimento();
                    break;
                case 11:
                    Util.limpaConsole();
                    MenusAtendimentos.relatorioTotalValorAtendimento();
                    break;
                case 12:
                    Util.limpaConsole();
                    MenusAtendimentos.relatorioAtendimentoPeriodo();
                    break;
                default:
                    Util.limpaConsole();
                    System.out.println("Opção inválida!!");
                    break;
            }
        } while (true);
    }
}
