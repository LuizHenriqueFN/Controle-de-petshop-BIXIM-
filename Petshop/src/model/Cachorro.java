package model;

public class Cachorro extends Animal{
    boolean perdigree;

    public Cachorro(){}
    public Cachorro(int codigo, String nome, String endereco, String cidade, boolean perdigree) {
        super(codigo, nome, endereco, cidade);
        this.perdigree = perdigree;
    }

    public boolean isPerdigree(){
        return perdigree;
    }
    
    public void setPerdigree(boolean perdigree) {
        this.perdigree = perdigree;
    }

    @Override
    public String toString() {
        return "Cachorro [perdigree=" + perdigree + "]";
    }

    public float getTaxa(){
        return 0.1f;
    }
}
