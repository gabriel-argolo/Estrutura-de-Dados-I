package pilhavetor;

import java.util.Iterator;

public class Pilha<Tipo> implements IPilha<Tipo> {
	private Tipo [] elementos;
	private int tamanhoReal;

	@SuppressWarnings("unchecked")
	public Pilha(int capacidade) {
		this.elementos = (Tipo[]) new Object[capacidade];
		this.tamanhoReal = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Tipo topo() {
		if(tamanhoReal-1 < 0 ) {
			return  (Tipo) "Pilha Vazia";
		}else {
			return elementos[tamanhoReal-1];
		}
	}



	@Override
	public boolean vazio() {
		return this.tamanho() == 0;
	}

	@Override
	public int tamanho() {
		return this.tamanhoReal;
	}

	@Override
	public void empilhar(Tipo elemento) {
		if(this.tamanhoReal<this.elementos.length) {
			this.elementos[this.tamanhoReal]=elemento;
			this.tamanhoReal++;
		}
	}

	@Override
	public void desempilhar() {
		if (this.tamanhoReal ==1) {
			this.limpar();
		}else {
			for (int i = tamanhoReal; i > this.elementos.length-1; i--) {
				this.elementos[i] = this.elementos[i+1];
			}
			this.tamanhoReal--;
		}
	}

	@Override
	public void limpar() {
		this.tamanhoReal=0;
	}

	@Override
	public Iterator<Tipo> iterator() {
		// TODO Auto-generated method stub
		return new IteradorVetor();
	}
	private class IteradorVetor implements Iterator<Tipo> {
		@Override
		public boolean hasNext() {
			// if(i < tamanho()) {
			// return true;
			// }
			return false;
		}
		@Override
		public Tipo next() {
			return null; // return elementos[i];
		}
	}
	public String toString() {
		StringBuilder s = new StringBuilder();		
		s.append("");
		for (int i = this.tamanhoReal-1; i >=0 ; i--) {
			s.append(this.elementos[i]);
			s.append("\n");
		}
		s.append("");		
		return s.toString();
	}
}