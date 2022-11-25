package model;

public class Gato extends Animal {
    private String numeroDocumento;
    private TipoDocumento tipo;

    public Gato(){}

    public Gato(int codigo, String nome, String endereco, String cidade, String numeroDocumento, TipoDocumento tipo) {
        super(codigo, nome, endereco, cidade);
        this.numeroDocumento = numeroDocumento;
        this.tipo = tipo;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
    }

    public float getTaxa(){
        return 0.15f;
    }

    @Override
    public String toString() {
        return "Gato: - Número Documento: " + numeroDocumento + ", tipo: " + tipo;
    }
    
    
}
