package fila_duplamente_encadeada;

public class NoFila <Tipo>{
	private Tipo valor;
	private NoFila<Tipo> proximo;
	private NoFila<Tipo> anterior;

	public NoFila(NoFila<Tipo> anterior, NoFila<Tipo> proxima, Tipo elemento) {
		this.anterior = anterior;
		this.proximo = proxima;
		this.valor = elemento;	
	}


	public NoFila(Tipo valor) {
		this.valor = valor;
		this.proximo = null;
	}


	public NoFila(Tipo valor, NoFila<Tipo> proximo) {
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
	public NoFila<Tipo> getProximo() {
		return proximo;
	}

	/**
	 * @param proximo the proximo to set
	 */
	public void setProximo(NoFila<Tipo> proximo) {
		this.proximo = proximo;
	}


	public NoFila<Tipo> getAnterior() {
		return anterior;
	}


	public void setAnterior(NoFila<Tipo> anterior) {
		this.anterior = anterior;
	}
}