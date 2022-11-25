package bd;

import java.util.HashSet;
import java.util.Set;

import model.Animal;
import model.Atendimento;
import model.Servico;

public class BancoDeDados {
    private static BancoDeDados bancoDeDados;
    private static Set<Animal> animais;
    private static Set<Servico> servicos;
    private static Set<Atendimento> atendimentos;

    protected BancoDeDados() {
        animais = new HashSet<>();
        servicos = new HashSet<>();
        atendimentos = new HashSet<>();
    }

    public static BancoDeDados getInstance() {
        return bancoDeDados;
    }

    public static Set<Animal> getAnimais() {
        return animais;
    }

    public static Set<Servico> getServicos() {
        return servicos;
    }

    public static Set<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    
}
