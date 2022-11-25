package model;

public enum TipoDocumento {
    CPF("xxx.xxx.xxx-xx"), CNPJ("XX. XXX. XXX/0001-XX");
    
    private String tipo;
    private TipoDocumento(String tipo) {
        this.tipo = tipo;
    }
    
    public String getTipo() {
        return tipo;
    }
}
