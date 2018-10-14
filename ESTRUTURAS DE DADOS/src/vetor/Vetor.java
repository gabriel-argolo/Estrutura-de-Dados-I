package vetor;

import java.util.Iterator;

public class Vetor<Tipo> implements iVetor<Tipo>{
	private Tipo [] elementos;
	private int tamanhoReal;

	@SuppressWarnings("unchecked")
	public Vetor(int capacidade) {
		this.elementos = (Tipo[]) new Object[capacidade];
		this.tamanhoReal = 0;
	}

	@Override
	public boolean adicionar(Tipo elemento){
		this.aumentaCapacidade();
		if(this.tamanhoReal<this.elementos.length) {
			this.elementos[this.tamanhoReal]=elemento;
			this.tamanhoReal++;
			return true;
		}
		return false;
	}

	@Override
	public boolean adicionarPosicao(int posicao, Tipo elemento){
		if (!(posicao >=0 && posicao<tamanhoReal())) {
			throw new IllegalArgumentException("Posição Invalida");
		}

		this.aumentaCapacidade();

		for (int i = this.tamanhoReal-1; i >= posicao; i--) {
			this.elementos[i+1] = this.elementos[i];
		}
		this.elementos[posicao] = elemento;
		this.tamanhoReal++;
		return true;
	}

	private void aumentaCapacidade() {
		//cria o vetor novo com dobro de capacidade do anterior
		if(this.tamanhoReal == this.elementos.length) {
			@SuppressWarnings("unchecked")
			Tipo[] elementosNovos = (Tipo[]) new String [this.elementos.length*2];
			//move os elementos
			for (int i = 0; i < elementos.length; i++) {
				elementosNovos[i]=this.elementos[i];
			}
			this.elementos = elementosNovos;
		}
	}

	@Override
	public int tamanhoReal() {
		return this.tamanhoReal;
	}
	@Override
	public Tipo buscaPosicao(int posicao){
		if (!(posicao >=0 && posicao<tamanhoReal())) {
			throw new IllegalArgumentException("Posição Invalida");
		}
		return this.elementos[posicao];	
	}
	@Override
	public int buscaElemento(Tipo elemento) {
		for (int i = 0; i < this.tamanhoReal(); i++) {
			if (((String) this.elementos[i]).equalsIgnoreCase((String) elemento)) {
				return i;
			}
		}
		return -1;
	}
	@Override
	public void removerPosicao(int posicao) {
		if (!(posicao >=0 && posicao<tamanhoReal())) {
			throw new IllegalArgumentException("Posição Invalida");
		}
		for (int i = posicao; i < this.tamanhoReal()-1; i++) {
			this.elementos[i] = this.elementos[i+1];

		}
		this.tamanhoReal--;
	}
//TESTAR
	public void limpar() {
		this.elementos = null;
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

}