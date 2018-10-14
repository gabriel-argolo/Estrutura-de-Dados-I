package fila_duplamente_encadeada;

public interface IFila<Tipo> extends Iterable<Tipo>{
    public void enfileirar(Tipo elemento);
    public void desenfileirar();
    public int tamanho();
    public Tipo primeiro();
    public boolean vazio();
    public void limpar();
}