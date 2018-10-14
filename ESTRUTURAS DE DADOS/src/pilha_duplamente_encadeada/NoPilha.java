package pilha_duplamente_encadeada;

public class NoPilha<Tipo> {
	private Tipo valor;
	private NoPilha<Tipo> proximo;
	private NoPilha<Tipo> anterior;

	public NoPilha(NoPilha<Tipo> anterior, NoPilha<Tipo> proxima, Tipo elemento) {
		this.anterior = anterior;
		this.proximo = proxima;
		this.valor = elemento;	
	}


	public NoPilha(Tipo valor) {
		this.valor = valor;
		this.proximo = null;
	}


	public NoPilha(Tipo valor, NoPilha<Tipo> proximo) {
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
	public NoPilha<Tipo> getProximo() {
		return proximo;
	}

	/**
	 * @param proximo the proximo to set
	 */
	public void setProximo(NoPilha<Tipo> proximo) {
		this.proximo = proximo;
	}


	public NoPilha<Tipo> getAnterior() {
		return anterior;
	}


	public void setAnterior(NoPilha<Tipo> anterior) {
		this.anterior = anterior;
	}
}
