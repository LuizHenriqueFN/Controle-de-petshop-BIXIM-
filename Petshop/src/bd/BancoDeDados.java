package bd;

import model.Animal;
import model.Atendimento;
import model.Servico;

public class BancoDeDados {
    private static BancoDeDados bancoDeDados;
    private static Animal animais[];
    private static Servico servicos[];
    private static Atendimento atendimentos[];

    protected BancoDeDados() {
        animais = new Animal[10];
        servicos = new Servico[10];
        atendimentos = new Atendimento[20];
    }

    public static BancoDeDados getInstance() {
        return bancoDeDados;
    }

    public static Animal[] getAnimais() {
        return animais;
    }

    public static Servico[] getServicos() {
        return servicos;
    }

    public static Atendimento[] getAtendimentos() {
        return atendimentos;
    }

}
