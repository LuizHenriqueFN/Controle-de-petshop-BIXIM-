package model;

import java.util.Date;

public class Atendimento {
    private int codigo;
    private Animal animal;
    private Servico servico;
    private Date date;

    public Atendimento() {}
    public Atendimento(int codigo, Date date) {
        this.codigo = codigo;
        this.date = date;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public Animal getAnimal() {
        return animal;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    public Servico getServico() {
        return servico;
    }
    public void setServico(Servico servico) {
        this.servico = servico;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Atendimento - Código: " + codigo + ", Animal: " + animal + ", Servico: " + servico + ", Data: " + date;
    }
    
}
