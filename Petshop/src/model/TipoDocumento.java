package model;

public enum TipoDocumento {
    CPF("CPF"), CNPJ("CNPJ");
    
    private String documento;
    private TipoDocumento(String documento) {
        this.documento = documento;
    }
    
    public String getTipo() {
        return documento;
    }
}
