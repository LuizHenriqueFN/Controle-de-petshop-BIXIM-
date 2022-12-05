package util;

public class DocumentoException extends Exception{

    public DocumentoException() {
        super();
    }
    public DocumentoException(String numeroDocumento) {
        super(numeroDocumento);
        System.out.println("\n\tERRO! O número \"" + numeroDocumento + "\" não é um documento válido.");
    }
    
}
