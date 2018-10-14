package lista_simplesmente_encadeada;

public interface ILista<Tipo> extends Iterable<Tipo>{
	public void adicionar(Tipo elemento);	    
	public void adicionar(int posicao, Tipo elemento) ;
	public void adicionarNoInicio(Tipo elemento) throws NullPointerException;
	public boolean contem(Tipo elemento);
	public Tipo obter(int posicao);
	public int tamanho();
	public int capacidade();
	public void remover(int posicao);
	public void remover(Tipo elemento);
	public void removerDoInicio();
	public void limpar();
	public void removerDoFim();
}