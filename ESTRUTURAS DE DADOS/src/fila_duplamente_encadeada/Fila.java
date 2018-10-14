package fila_duplamente_encadeada;

import java.util.Iterator;

public class Fila<Tipo> implements IFila<Tipo>{

	private int contador;
	private NoFila<Tipo> inicio, fim;

	public Fila() {
		this.contador = 0;
		this.inicio = null;
		this.fim = null;
	}

	@Override
	public void enfileirar(Tipo elemento) {
		NoFila<Tipo> f = new NoFila<>(elemento);
		if (inicio == null) {
			this.inicio = f;
			this.fim = f;
			this.contador++;
		} else {
			this.fim.setProximo(f);
			f.setAnterior(fim);
			this.fim = f;
			this.contador++;
		}
	}

	@Override
	public void desenfileirar() {
		if (this.contador == 1) {
			this.limpar();
		} else {
			this.inicio = this.inicio.getProximo();
			this.inicio.setAnterior(null);
			contador--;
		}
	}

	@Override
	public int tamanho() {
		return this.contador;
	}

	@Override
	public Tipo primeiro() {
	return	this.inicio.getValor();
	}

	@Override
	public boolean vazio() {
		return tamanho()==0;
	}

	@Override
	public void limpar() {
		inicio = null;
		fim = null;
		contador=0;
	}
	@Override
	public Iterator<Tipo> iterator() {
		return new IteradorFila<>(inicio);
	}

	
	private class IteradorFila<TipoA> implements Iterator<TipoA> {
		NoFila<TipoA> fila;
		public IteradorFila(NoFila<TipoA> fila) {
			this.fila = fila;
		}

		@Override
		public boolean hasNext() {
			if (fila != null) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public TipoA next() {
			TipoA elementoAtual = fila.getValor();
			fila = fila.getProximo();
			return elementoAtual;
		}
	}
}