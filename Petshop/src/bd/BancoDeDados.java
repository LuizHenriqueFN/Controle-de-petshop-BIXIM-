package bd;

import model.Animal;
import model.Atendimento;
import model.Servico;

public class BancoDeDados {
    public static BancoDeDados bancoDeDados;
    public static Animal animal[];
    public static Servico servicos[];
    public static Atendimento atendimentos[];

    protected BancoDeDados() {
    }

    public BancoDeDados getInstance() {
        return bancoDeDados;
    }

    public Animal[] getAnimal() {
        return animal;
    }

    public Servico[] getServicos() {
        return servicos;
    }

    public Atendimento[] getAtendimentos() {
        return atendimentos;
    }

}
