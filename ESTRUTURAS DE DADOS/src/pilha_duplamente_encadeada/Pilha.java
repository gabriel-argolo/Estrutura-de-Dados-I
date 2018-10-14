package pilha_duplamente_encadeada;

import java.util.Iterator;

public class Pilha<Tipo> implements IPilha<Tipo> {

	private int contador;
	@SuppressWarnings("unused")
	private NoPilha<Tipo> topo, base;

	public Pilha() {
		this.contador = 0;
		this.topo = null;
		this.base = null;
	}

	@Override
	public Tipo topo() {
		return topo.getValor();
	}

	@Override
	public boolean vazio() {
		return tamanho() == 0;
	}

	@Override
	public int tamanho() {
		return this.contador;
	}

	@Override
	public void empilhar(Tipo elemento) {
		if (this.contador == 0) {
			NoPilha<Tipo> p = new NoPilha<>(elemento);
			this.topo = p;
			this.base = p;
		} else {
			NoPilha<Tipo> p = new NoPilha<Tipo>(elemento);
			p.setProximo(this.topo);
			topo.setAnterior(p);
			topo = p;
		}

		this.contador++;
	}

	@Override
	public void desempilhar() {
		if (this.contador == 1) {
			limpar();
		} else {
			this.topo = this.topo.getProximo();
			this.topo.setAnterior(null);
			this.contador--;
		}
	}

	@Override
	public void limpar() {
		this.topo = null;
		this.base = null;
		contador=0;
	}
	
	@Override
	public Iterator<Tipo> iterator() {
		return new IteradorPilha<>(topo);
	}

	
	private class IteradorPilha<TipoA> implements Iterator<TipoA> {
		NoPilha<TipoA> pilha;
		public IteradorPilha(NoPilha<TipoA> Pilha) {
			this.pilha = Pilha;
		}

		@Override
		public boolean hasNext() {
			if (pilha != null) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public TipoA next() {
			TipoA elementoAtual = pilha.getValor();
			pilha = pilha.getProximo();
			return elementoAtual;
		}
	}
}