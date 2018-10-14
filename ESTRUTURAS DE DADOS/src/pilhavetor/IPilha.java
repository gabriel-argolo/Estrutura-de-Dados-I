package pilhavetor;

public interface IPilha<Tipo> extends Iterable<Tipo>{
    public Tipo topo();
    public boolean vazio();
    public int tamanho();
    public void empilhar(Tipo elemento);
    public void desempilhar();
    public void limpar();
}
