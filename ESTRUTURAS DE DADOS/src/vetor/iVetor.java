package vetor;

public interface iVetor<Tipo> extends Iterable<Tipo>{

	public boolean adicionar(Tipo elemento);

	public 	boolean adicionarPosicao(int posicao, Tipo elemento);

	public 	int tamanhoReal();

	public Tipo buscaPosicao(int posicao);

	public int buscaElemento(Tipo elemento);

	public void removerPosicao(int posicao);

}

