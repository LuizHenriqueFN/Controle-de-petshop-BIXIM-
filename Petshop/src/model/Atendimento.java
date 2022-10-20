package model;

import java.util.Date;

public class Atendimento {
    private int codigo;
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
    
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Atendimento [codigo=" + codigo + ", date=" + date + "]";
    }
}
