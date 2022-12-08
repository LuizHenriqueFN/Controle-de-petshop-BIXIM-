package com.example.visao;

import java.util.Date;

import com.example.Menus.MenusAnimais;
import com.example.Menus.MenusAtendimentos;
import com.example.Menus.MenusAuxiliares;
import com.example.Menus.MenusServicos;
import com.example.bd.BancoDeDados;
import com.example.model.Animal;
import com.example.model.Atendimento;
import com.example.model.Cachorro;
import com.example.model.Gato;
import com.example.model.Servico;
import com.example.model.TipoDocumento;
import com.example.util.DocumentoException;
import com.example.util.Util;

public class Principal {
    public static BancoDeDados bancoDeDados = new BancoDeDados();

    public static void main(String[] args) throws DocumentoException {
        MenusAuxiliares.logar();

        int opcao;

        // Organização dos menus
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
                    BancoDeDados.leBancoDeDados();
                    break;
                case 2:
                    Util.limpaConsole();
                    MenusServicos.menuServicos();
                    BancoDeDados.leBancoDeDados();
                    break;
                case 3:
                    Util.limpaConsole();
                    MenusAtendimentos.menuAtendimentos();
                    BancoDeDados.leBancoDeDados();
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
                case 13:
                    Util.limpaConsole();
                    MenusAuxiliares.menuLogar();
                    break;
                case 14:
                    Servico s1 = new Servico(1,"Banho", 27f);
                    Servico s2 = new Servico(1,"Tome", 30f);
                    
                    // bancoDeDados.inserirServico(s1);
                    // bancoDeDados.atualizarServico(s1.getCodigo(), s2);
                    bancoDeDados.removerServico(s1.getCodigo());
                    break;
                case 15:
                    Cachorro c1 = new Cachorro(1,"Tomas", "Rua do Tomas","Cidade do Tomas",true);
                    Cachorro c2 = new Cachorro(1,"Jose", "Rua do Jose","Cidade do Jose",true);
                    Gato g1 = new Gato(1,"TomasGato", "Rua do TomasGato","Cidade do TomasGato","237.619.580-21", TipoDocumento.CPF);
                    Gato g2 = new Gato(1,"JoseGato", "Rua do JoseGato","Cidade do JoseGato","237.619.580-21", TipoDocumento.CPF);
                    
                    // bancoDeDados.inserirAnimal(c1);
                    // bancoDeDados.inserirAnimal(g1);
                    // bancoDeDados.atualizarAnimal(c1.getCodigo(), c2);
                    // bancoDeDados.atualizarAnimal(g1.getCodigo(), g2);
                    // bancoDeDados.removerAnimal(g1.getCodigo());
                    // bancoDeDados.removerAnimal(g2.getCodigo());
                        break;
                case 16:
                    Servico s3 = new Servico(1,"Banho", 27f);
                    Servico s4 = new Servico(1,"Tome", 30f);
                    Cachorro c3 = new Cachorro(1,"Tomas", "Rua do Tomas","Cidade do Tomas",true);
                    Gato g4 = new Gato(1,"TomasGato", "Rua do TomasGato","Cidade do TomasGato","237.619.580-21", TipoDocumento.CPF);
                    Atendimento a1 = new Atendimento(1,c3, s3 , new Date("12/10/2021"));
                    // Atendimento a2 = new Atendimento(1,g4,s4, new Date("12/10/2021"));
                    
                    bancoDeDados.inserirAtendimento(a1);
                    // bancoDeDados.atualizarAtendimento(a1.getCodigo(),a2);
                    // bancoDeDados.removerAtendimento(a1.getCodigo());
                        break;
                        // case 17:
                        // Gato g5 = new Gato(10,"TomasGato10", "Rua do TomasGato10","Cidade do TomasGato10","237.619.580-21", TipoDocumento.CPF);
                        // bancoDeDados.inserirAnimal(g5);
                        // break;
                default:
                    Util.limpaConsole();
                    System.out.println("Opção inválida!!");
                    break;
            }
        } while (true);
    }
}



