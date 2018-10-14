package lista_duplamente_encadeada;

import java.util.Iterator;

public class ListaDuplamenteEncadeada<Tipo> implements ILista<Tipo> {

	private int contador;
	private NoDuplamenteEncadeado<Tipo> inicio, fim;

	public ListaDuplamenteEncadeada() {
		this.contador = 0;
		this.inicio = null;
		this.fim = null;
	}

	@Override
	public void adicionar(Tipo valor) {
		NoDuplamenteEncadeado<Tipo> novoNo = new NoDuplamenteEncadeado<>(valor);
		if (inicio == null) {
			this.inicio = novoNo;
			this.fim = novoNo;
			this.contador++;
		} else {
			this.fim.setProximo(novoNo);
			novoNo.setAnterior(fim);
			this.fim = novoNo;
			this.contador++;
		}
	}

	@Override
	public void adicionar(int posicao, Tipo valor) throws NullPointerException {
		NoDuplamenteEncadeado<Tipo> novoNo = new NoDuplamenteEncadeado<Tipo>(valor);
		if (posicao == 0) {
			this.adicionarNoInicio(valor);
		} else if (posicao == this.tamanho()) {
			this.adicionar(valor);
		} else if (posicao < 0 || posicao > this.contador) {
			throw new NullPointerException("Posiçao superior ao tamanho da lista");
		} else {
			NoDuplamenteEncadeado<Tipo> atual = inicio;
			for (int i = 0; i < posicao - 1; i++) {
				atual = inicio.getProximo();			
			}
			atual.getAnterior().setProximo(novoNo);
			novoNo.setProximo(atual);
			novoNo.setAnterior(atual.getAnterior());
			atual.setAnterior(novoNo);

			/*NoDuplamenteEncadeado<Tipo> anterior = aux.getProximo();
			NoDuplamenteEncadeado<Tipo> novoNo = new NoDuplamenteEncadeado<Tipo>(valor);
			anterior.getAnterior().setProximo(novoNo);
			novoNo.setProximo(anterior);
			novoNo.setAnterior(anterior);
			aux.setProximo(novoNo);*/

			this.contador++;
		}
	}

	@Override
	public void adicionarNoInicio(Tipo valor) {
		if (this.contador == 0) {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			NoDuplamenteEncadeado<Tipo> nova = new NoDuplamenteEncadeado(valor);
			this.inicio = nova;
			this.fim = nova;
		} else {
			NoDuplamenteEncadeado<Tipo> nova = new NoDuplamenteEncadeado<Tipo>(valor);
			nova.setProximo(this.inicio);
			inicio.setAnterior(nova);
			inicio = nova;
		}

		this.contador++;
	}

	private boolean contem(NoDuplamenteEncadeado<Tipo> no, Tipo valor) {
		if(no == null) {
			return false;
		}
		if(no.getValor().equals(valor)) {
			return true;
		}

		return this.contem(no.getProximo(), valor);
	}

	@Override
	public boolean contem(Tipo valor) {
		return this.contem(this.inicio, valor);

		/*
		while (atual != null) {
			if (atual.getValor().equals(valor)) {
				return true;
			}
			atual = atual.getProximo();
		}
		return false;*/
	}

	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.contador;
	}

	@SuppressWarnings("rawtypes")
	private NoDuplamenteEncadeado pegaPosicao(int posicao) {
		NoDuplamenteEncadeado<Tipo> atual = inicio;
		for (int i = 0; i < posicao; i++) {
			atual = atual.getProximo();
		}
		return atual;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Tipo obter(int posicao) {
		return (Tipo) this.pegaPosicao(posicao).getValor();

	}

	@Override
	public int tamanho() {
		return this.contador;
	}

	@Override
	public int capacidade() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
		// Tools | Templates.
	}

	@SuppressWarnings("unchecked")
	@Override
	public void remover(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		NoDuplamenteEncadeado<Tipo> anterior = this.pegaPosicao(posicao - 1);
		NoDuplamenteEncadeado<Tipo> atual = anterior.getProximo();
		NoDuplamenteEncadeado<Tipo> proximo = atual.getProximo();

		anterior.setProximo(proximo);
		proximo.setAnterior(anterior);

		this.contador--;
	}

	@Override
	public boolean remover(Tipo valor) {
		NoDuplamenteEncadeado<Tipo> atual = this.inicio;
		if(this.inicio.getValor() == valor){
			if (this.contador == 1) {
				this.inicio = this.fim = null;
				contador = 0;
				return true;
			} else {
				this.inicio = inicio.getProximo();
				this.inicio.setAnterior(null);
				contador--;
				return true;
			}
		} else if (valor == this.fim.getValor()) {
			this.fim = this.fim.getAnterior();
			this.fim.setProximo(null);
			contador--;
			return true;
		} else {
			for (int i = 0; i < contador; i++) {
				if (atual.getValor() == (valor)) {
					atual.getAnterior().setProximo(atual.getProximo());
					atual.getProximo().setAnterior(atual.getAnterior());
					contador--;
					return true;
				}
				atual = atual.getProximo();
			}
		}
		return false;	
	}

	/*
		NoDuplamenteEncadeado<Tipo> anterior = null;
		NoDuplamenteEncadeado<Tipo> atual = null;

		if (inicio == null) {
			System.out.println("Lista Vazia");
		} else {
			anterior = this.inicio;
			atual = this.inicio;
			while (atual != null) {
				if ((atual.getValor().equals(valor))) {
					if (atual==inicio) {
						this.removerDoInicio();
						break;
					} else {
						if (atual == this.fim) {
							this.removerDoFim();
							break;
						}else {
						anterior.setProximo(atual.getProximo());
						atual.getProximo().setAnterior(atual.getAnterior());
						contador--;
						break;
					}
				} else {
					anterior = atual;
					atual = atual.getProximo();
					contador--;
				}
			}
		}
	}
	 */

	@Override
	public void removerDoInicio() {
		if (!this.posicaoOcupada(0)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		this.contador--;

		if (this.contador == 1) {
			this.fim = null;
			this.inicio = null;
		} else {

			this.inicio = this.inicio.getProximo();
			this.inicio.setAnterior(null);
		}
	}

	@Override
	public void removerDoFim() {
		this.fim = this.fim.getAnterior();
		this.fim.setProximo(null);
		this.contador--;
	}

	@Override
	public void limpar() {
		this.inicio = null;
		this.fim = null;
		this.contador = 0;
	}

	@Override
	public Iterator<Tipo> iterator() {
		return new IteradorListaEncadeada<>(inicio);
	}

	@SuppressWarnings("hiding")
	private class IteradorListaEncadeada<Tipo> implements Iterator<Tipo> {
		NoDuplamenteEncadeado<Tipo> listaEncadeada;

		public IteradorListaEncadeada(NoDuplamenteEncadeado<Tipo> ListaSimplesmenteEncadeada) {
			this.listaEncadeada = ListaSimplesmenteEncadeada;
		}

		@Override
		public boolean hasNext() {
			if (listaEncadeada != null) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public Tipo next() {
			Tipo elementoAtual = listaEncadeada.getValor();
			listaEncadeada = listaEncadeada.getProximo();
			return elementoAtual;
		}
	}

	public String toString() {
		if (this.contador == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder("[");
		NoDuplamenteEncadeado<Tipo> atual = inicio;

		for (int i = 0; i < this.contador - 1; i++) {
			builder.append(atual.getValor());
			builder.append(", ");
			atual = atual.getProximo();
		}

		builder.append(atual.getValor());
		builder.append("]");
		return builder.toString();
	}
}