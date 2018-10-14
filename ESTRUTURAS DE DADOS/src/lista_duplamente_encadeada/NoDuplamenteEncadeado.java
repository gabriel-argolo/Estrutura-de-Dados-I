package lista_duplamente_encadeada;

public class NoDuplamenteEncadeado<Tipo> {
	private Tipo valor;
	private NoDuplamenteEncadeado<Tipo> proximo;
	private NoDuplamenteEncadeado<Tipo> anterior;

	public NoDuplamenteEncadeado(NoDuplamenteEncadeado<Tipo> anterior, NoDuplamenteEncadeado<Tipo> proxima, Tipo elemento) {
		this.anterior = anterior;
		this.proximo = proxima;
		this.valor = elemento;	
	}


	public NoDuplamenteEncadeado(Tipo valor) {
		this.valor = valor;
		this.proximo = null;
	}


	public NoDuplamenteEncadeado(Tipo valor, NoDuplamenteEncadeado<Tipo> proximo) {
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
	public NoDuplamenteEncadeado<Tipo> getProximo() {
		return proximo;
	}

	/**
	 * @param proximo the proximo to set
	 */
	public void setProximo(NoDuplamenteEncadeado<Tipo> proximo) {
		this.proximo = proximo;
	}


	public NoDuplamenteEncadeado<Tipo> getAnterior() {
		return anterior;
	}


	public void setAnterior(NoDuplamenteEncadeado<Tipo> anterior) {
		this.anterior = anterior;
	}
}
