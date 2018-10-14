package lista_simplesmente_encadeada;

import java.util.Iterator;

public class ListaSimplesmenteEncadeada<Tipo> implements ILista<Tipo> {

	private int contador;
	private NoSimplesmenteEncadeado<Tipo> inicio, fim;

	public ListaSimplesmenteEncadeada() {
		this.contador = 0;
		this.inicio = null;
		this.fim = null;
	}

	@Override
	public void adicionar(Tipo valor) {
		NoSimplesmenteEncadeado<Tipo> novoNo = new NoSimplesmenteEncadeado<>(valor);
		if (inicio == null) {
			inicio = novoNo;
			fim = novoNo;
		} else {
			novoNo.setAnterior(fim);
			this.fim.setProximo(novoNo);
			this.fim = novoNo;
		}
		this.contador++;
	}

	@Override
	public void adicionar(int posicao, Tipo valor) throws NullPointerException {
		NoSimplesmenteEncadeado<Tipo> aux = inicio;
		if (posicao == 0) {
			this.adicionarNoInicio(valor);
		} else if (posicao == this.tamanho()) {
			this.adicionar(valor);
		} else if (posicao < 0 || posicao > this.contador) {
			throw new NullPointerException("Posiçao superior ao tamanho da lista");
		} else {
			for (int i = 0; i < posicao - 1; i++) {
				aux = aux.getProximo();
			}
			NoSimplesmenteEncadeado<Tipo> anterior = aux.getProximo();
			NoSimplesmenteEncadeado<Tipo> novoNo = new NoSimplesmenteEncadeado<Tipo>(valor);
			anterior.getAnterior().setProximo(novoNo);
			novoNo.setProximo(anterior);
			novoNo.setAnterior(anterior);
			aux.setProximo(novoNo);
			this.contador++;
		}

	}

	@Override
	public void adicionarNoInicio(Tipo valor) {
		if (this.contador == 0) {
			NoSimplesmenteEncadeado<Tipo> nova = new NoSimplesmenteEncadeado<Tipo>(valor);
			this.inicio = nova;
			this.fim = nova;
		} else {
			NoSimplesmenteEncadeado<Tipo> nova = new NoSimplesmenteEncadeado<Tipo>(valor);
			nova.setProximo(this.inicio);
			inicio.setAnterior(nova);
			inicio = nova;
		}

		this.contador++;
	}

	@Override
	public boolean contem(Tipo valor) {
		NoSimplesmenteEncadeado<Tipo> atual = this.inicio;
		while (atual != null) {
			if (atual.getValor().equals(valor)) {
				return true;
			}
			atual = atual.getProximo();
		}
		return false;
	}

	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.contador;
	}

	private NoSimplesmenteEncadeado<Tipo> pegaPosicao(int posicao) {
		NoSimplesmenteEncadeado<Tipo> atual = inicio;
		for (int i = 0; i < posicao; i++) {
			atual = atual.getProximo();
		}
		return atual;
	}

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

	@Override
	public void remover(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		NoSimplesmenteEncadeado<Tipo> anterior = this.pegaPosicao(posicao - 1);
		NoSimplesmenteEncadeado<Tipo> atual = anterior.getProximo();
		NoSimplesmenteEncadeado<Tipo> proximo = atual.getProximo();

		anterior.setProximo(proximo);
		proximo.setAnterior(anterior);

		this.contador--;
	}

	@Override
	public void remover(Tipo valor) {
		NoSimplesmenteEncadeado<Tipo> anterior = null;
		NoSimplesmenteEncadeado<Tipo> atual = null;

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
						}

						anterior.setProximo(atual.getProximo());
						atual.getProximo().setAnterior(anterior);
						break;
					}
				} else {
					anterior = atual;
					atual = atual.getProximo();
				}
			}
			contador--;
		}
	}

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
		NoSimplesmenteEncadeado<Tipo> listaEncadeada;

		public IteradorListaEncadeada(NoSimplesmenteEncadeado<Tipo> ListaSimplesmenteEncadeada) {
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
		NoSimplesmenteEncadeado<Tipo> atual = inicio;

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