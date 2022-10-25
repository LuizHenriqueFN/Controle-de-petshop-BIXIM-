package bd;

import model.Animal;
import model.Atendimento;
import model.Servico;

public class BancoDeDados {
    public static BancoDeDados bancoDeDados;
    public static Animal animais[] = new Animal[10];
    public static Servico servicos[] = new Servico[10];
    public static Atendimento atendimentos[] = new Atendimento[20];

    protected BancoDeDados() {
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
