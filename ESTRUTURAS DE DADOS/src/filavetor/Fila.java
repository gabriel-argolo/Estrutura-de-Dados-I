package filavetor;

import java.util.Iterator;

public class Fila<Tipo> implements IFila<Tipo> {

	private Tipo [] elementos;
	private int tamanhoReal;

	@SuppressWarnings("unchecked")
	public Fila(int capacidade) {
		this.elementos = (Tipo[]) new Object[capacidade];
		this.tamanhoReal = 0;
	}

	@Override
	public void enfileirar(Tipo elemento) {
		if(this.tamanhoReal<this.elementos.length) {
			this.elementos[this.tamanhoReal]=elemento;
			this.tamanhoReal++;
		}else {
			System.out.println("Capacidade da fila excedida");
		}
	}

	public void desenfileirar() {
		if (this.tamanhoReal ==1) {
			this.limpar();
		}else {
			for (int i = 0; i < this.elementos.length-1; i++) {
				this.elementos[i] = this.elementos[i+1];

			}
			this.tamanhoReal--;
		}
	}
	@Override
	public int tamanho() {
		return this.tamanhoReal;
	}

	@Override
	public Tipo primeiro() {
		return this.elementos[0];
	}

	@Override
	public boolean vazio() {
		return this.tamanho()==0;
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
		s.append("[");
		for (int i = 0; i < this.tamanhoReal-1; i++) {
			s.append(this.elementos[i]);
			s.append(" | ");
		}if (this.tamanhoReal>0) {
			s.append(this.elementos[this.tamanhoReal-1]);
		}
		s.append("]");		
		return s.toString();
	}

}
