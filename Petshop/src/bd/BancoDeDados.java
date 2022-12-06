package bd;

//declaração das importações necessárias
import java.util.HashSet;
import java.util.Set;
import model.Animal;
import model.Atendimento;
import model.Servico;

public class BancoDeDados {

	private static BancoDeDados bancoDeDados;

	//Criando Collections para armazenar os dados:
	private static Set<Animal> animais = new HashSet<>();
	private static Set<Servico> servicos = new HashSet<>();
	private static Set<Atendimento> atendimentos = new HashSet<>();

	protected BancoDeDados() {}

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
