package service;

import model.Atendimento;

import java.util.Date;

import dao.AtendimentoDAO;

public class AtendimentoService {
    private AtendimentoDAO atendimentodao = new AtendimentoDAO();
    private Atendimento atendimentos[] = atendimentodao.getAll();

    public AtendimentoService() {}

    private static boolean isValid(Atendimento atendimento){
        if( atendimento.getCodigo() != 0    ||
            atendimento.getAnimal() != null ||
            atendimento.getDate() != null   ||
            atendimento.getServico() != null) return true;
        
        return false;
    }

    public boolean inserir(Atendimento atendimento) {
        if(isValid(atendimento) && atendimentodao.inserir(atendimento)) return true;

        return false;
    }

    public boolean alterar(int codigo, Atendimento atendimento) {
        if(isValid(atendimento) && atendimentodao.alterar(codigo, atendimento)) return true;
        return false;
    }

    public boolean remover(int codigo) {
        if(atendimentodao.remover(codigo)) return true;
        return false;
    }

    public void limpaDados() {
        atendimentodao.limpaDados();
    }

    public Atendimento getAtendimento(int codigo){
        Atendimento atendimento = atendimentodao.getAtendimento(codigo);
        if(atendimento != null) return atendimento;

        System.out.println("ERRO! Serviço não encontrado");
        return null;
    }

    @Override
    public String toString() {
        String string = "";

        for (int i = 0; i < atendimentos.length; i++) {
            if(atendimentos[i] != null){
                string += atendimentos[i].toString();
                string += '\n';
            }
        }

        return string;
    }

    public Atendimento getMaiorAtendimento(int codAnimal){
        float maior = 0f;
        Atendimento atendimento = null;
        for(int i=0; i<atendimentos.length; i++){
            if(atendimentos[i] != null && atendimentos[i].getAnimal().getCodigo() == codAnimal){
                if(atendimentos[i].getServico().getValor() > maior){
                    maior = atendimentos[i].getServico().getValor();
                    atendimento = atendimentos[i];
                }
            }
        }
        return atendimento;
    }

    public Atendimento getMenorAtendimento(int codAnimal){
        float menor = 100000000f;
        Atendimento atendimento = null;
        for(int i=0; i<atendimentos.length; i++){
            if(atendimentos[i] != null && atendimentos[i].getAnimal().getCodigo() == codAnimal){
                if(atendimentos[i].getServico().getValor() < menor){
                    menor = atendimentos[i].getServico().getValor();
                    atendimento = atendimentos[i];
                }
            }
        }
        return atendimento;
    }

    public float getTotalAtendimento(int codAnimal){
        float soma = 0f;
        for(int i=0; i<atendimentos.length; i++){
            if(atendimentos[i] != null && atendimentos[i].getAnimal().getCodigo() == codAnimal){
                soma+= atendimentos[i].getServico().getValor();
            }
        }
        return soma;
    }

    protected String listaAtendimentos(int codAnimal){
        String string = "";
        for (int i = 0; i < atendimentos.length; i++) {
            if(atendimentos[i] != null && atendimentos[i].getAnimal().getCodigo() == codAnimal){
                string += atendimentos[i].getAnimal().toString();
                string += '\n';
            }
        }
        return string;
    }

    public String getNotaFiscal(int codAnimal){
        String string = "";
        boolean existe = false;
        //Animal: - Código: 1, Nome: animal1, Endereço: rua1, Cidade: cidade1
        string += "\n\t==========="+"\n\tNOTA FISCAL"+"\n\t===========\n";

        for (int i = 0; i < atendimentos.length; i++) {
            if(atendimentos[i] != null && atendimentos[i].getAnimal().getCodigo() == codAnimal){
                string += atendimentos[i].getAnimal().toString();
                existe = true;
                break;
            }
        }
        if(!existe) return null;

        string += "\n==============="+"\n=== ATENDIMENTOS ==="+"\n===============\n";

        existe = false;
        for (int i = 0; i < atendimentos.length; i++) {
            if(atendimentos[i] != null && atendimentos[i].getAnimal().getCodigo() == codAnimal){
                string += atendimentos[i].getServico().toString();
                string += '\n';
                existe = true;
            }
        }
        if(!existe) return null;
        
        string += "\n===============\nTotal: R$"+ getTotalAtendimento(codAnimal) +"\n===============\n";

        return string;

    }

    public String getAtendimentoPeriodo(Date data1, Date data2){
        String string = "\nRELATÓRIO - ATENDIMENTO NO PERÍODO:\n";

        boolean existe = false;
        for (int i = 0; i < atendimentos.length; i++) {
            if(atendimentos[i] != null){
                if(data1.before(atendimentos[i].getDate()) && data2.after(atendimentos[i].getDate())){
                    string += atendimentos[i].getServico().toString();
                    string += '\n';
                    existe = true;
                }
            }
        }
        if(!existe) return null;

        return string;
    }

}
