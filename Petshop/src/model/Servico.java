package model;

public class Servico {
    private int codigo;
    private String nome;
    private float valor;

    public Servico() {}
    public Servico(int codigo, String nome, float valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Atendimento [codigo=" + codigo + ", nome=" + nome + ", valor=" + valor + "]";
    }
}
