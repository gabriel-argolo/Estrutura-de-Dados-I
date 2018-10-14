package lista_simplesmente_encadeada;

public class NoSimplesmenteEncadeado<Tipo> {
	private Tipo valor;
	private NoSimplesmenteEncadeado<Tipo> proximo;
	private NoSimplesmenteEncadeado<Tipo> anterior;

	public NoSimplesmenteEncadeado(NoSimplesmenteEncadeado<Tipo> anterior, NoSimplesmenteEncadeado<Tipo> proxima, Tipo elemento) {
		this.anterior = anterior;
		this.proximo = proxima;
		this.valor = elemento;	
	}


	public NoSimplesmenteEncadeado(Tipo valor) {
		this.valor = valor;
		this.proximo = null;
	}


	public NoSimplesmenteEncadeado(Tipo valor, NoSimplesmenteEncadeado<Tipo> proximo) {
		this.valor = valor;
		this.proximo = proximo;
	}

	public Tipo getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Tipo valor) {
		this.valor = valor;
	}

	/**
	 * @return the proximo
	 */
	public NoSimplesmenteEncadeado<Tipo> getProximo() {
		return proximo;
	}

	/**
	 * @param proximo the proximo to set
	 */
	public void setProximo(NoSimplesmenteEncadeado<Tipo> proximo) {
		this.proximo = proximo;
	}


	public NoSimplesmenteEncadeado<Tipo> getAnterior() {
		return anterior;
	}


	public void setAnterior(NoSimplesmenteEncadeado<Tipo> anterior) {
		this.anterior = anterior;
	}
}
