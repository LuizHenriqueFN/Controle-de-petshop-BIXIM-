package service;

import model.Atendimento;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import dao.AtendimentoDAO;

public class AtendimentoService {
    private AtendimentoDAO atendimentodao = new AtendimentoDAO();
    private Set<Atendimento> atendimentos = atendimentodao.getAll();
    private Iterator<Atendimento> I;

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
        Atendimento atendimento;
        String string = "";
        I = atendimentos.iterator();

        while(I.hasNext()){
            atendimento = I.next();
            string += atendimento.toString();
            string += '\n';
        }

        return string;
    }

    public Atendimento getMaiorAtendimento(int codAnimal){
        float maior = 0f;
        Atendimento atendimento = null;
        Atendimento aux = null;
        I = atendimentos.iterator();

        while(I.hasNext()){
            aux = I.next();
            if(
                aux.getAnimal().getCodigo() == codAnimal &&
                aux.getServico().getValor() > maior
            ){
                maior = aux.getServico().getValor();
                atendimento = aux;
            }
        }
        return atendimento;
    }

    public Atendimento getMenorAtendimento(int codAnimal){
        float menor = 100000000f;
        Atendimento atendimento = null;
        Atendimento aux = null;
        I = atendimentos.iterator();

        while(I.hasNext()){
            aux = I.next();
            if(
                aux.getAnimal().getCodigo() == codAnimal &&
                aux.getServico().getValor() < menor
            ){
                menor = aux.getServico().getValor();
                atendimento = aux;
            }
        }

        return atendimento;
    }

    public float getTotalAtendimento(int codAnimal){
        float soma = 0f;
        Atendimento aux = null;
        I = atendimentos.iterator();

        while(I.hasNext()){
            aux = I.next();
            if(aux.getAnimal().getCodigo() == codAnimal){
                soma += aux.getServico().getValor();
            }
        }
        return soma;
    }

    protected String listaAtendimentos(int codAnimal){
        String string = "";
        Atendimento atendimento = null;
        I = atendimentos.iterator();

        while(I.hasNext()){
            atendimento = I.next();
            if(atendimento.getAnimal().getCodigo() == codAnimal){
                string += atendimento.getAnimal().toString();
                string += '\n';
            }
        }
        return string;
    }

    public String getNotaFiscal(int codAnimal){
        String string = "";
        boolean existe = false;
        Atendimento atendimento = null;
        I = atendimentos.iterator();

        string += "\n\t==========="+"\n\tNOTA FISCAL"+"\n\t===========\n";

        while(I.hasNext()){
            atendimento = I.next();
            if(atendimento.getAnimal().getCodigo() == codAnimal){
                string += atendimento.getAnimal().toString();
                string += '\n';
                existe = true;
                break;
            }
        }
        if(!existe) return null;

        string += "\n==============="+"\n=== ATENDIMENTOS ==="+"\n===============\n";

        existe = false;
        atendimento = null;
        I = atendimentos.iterator();

        while(I.hasNext()){
            atendimento = I.next();
            if(atendimento.getAnimal().getCodigo() == codAnimal){
                string += atendimento.getServico().toString();
                string += '\n';
                existe = true;
                break;
            }
        }
        if(!existe) return null;
        
        string += "\n===============\nTotal: R$"+ getTotalAtendimento(codAnimal) +"\n===============\n";

        return string;
    }

    public String getAtendimentoPeriodo(Date data1, Date data2){
        String string = "\nRELATÓRIO - ATENDIMENTO NO PERÍODO:\n";
        Atendimento atendimento = null;
        I = atendimentos.iterator();
        boolean existe = false;

        while(I.hasNext()){
            atendimento = I.next();

            if(data1.before(atendimento.getDate()) && data2.after(atendimento.getDate())){
                string += atendimento.getServico().toString();
                string += '\n';
                existe = true;
            }
        }
        if(!existe) return null;

        return string;
    }
}
