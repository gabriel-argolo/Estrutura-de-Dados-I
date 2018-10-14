package tabela_hash;
import lista_simplesmente_encadeada.ListaSimplesmenteEncadeada;
import vetor.Vetor;

public class Tabela_Hash<Tipo>{
	private Vetor<ListaSimplesmenteEncadeada<Tipo>> tabelaHash = new ArrayL<ListaSimplesmenteEncadeada<Tipo>>();
	private int tamanho = 0;
	
	
	public Tabela_Hash(){
		for (int i = 0; i < 16; i++) {
			ListaSimplesmenteEncadeada<Tipo> lista = new ListaSimplesmenteEncadeada<Tipo>();
			tabelaHash.adicionar(lista);
		}
	}

	private void rehash(int novaCapacidade) {
		ListaSimplesmenteEncadeada<Tipo> Elementos = this.todos();
		this.tabelaHash.limpar();

		for (int i = 0; i < novaCapacidade; i++) {
			this.tabelaHash.adicionar(new ListaSimplesmenteEncadeada<Tipo>());
		}
		for (Tipo elemento : Elementos) {
			this.inserir(elemento);
		}
	}

	private void carga() {
		int capacidade = tabelaHash.tamanhoReal();
		double carga = this.tamanho/capacidade;

		if (carga>0.75) {
			this.rehash(capacidade*2);
		}else if(carga<0.25) {
			this.rehash(Math.max(capacidade / 2, 10));
		}
	}

	private int funcaoHash(Tipo Elemento) {
		return Elemento.toString().toLowerCase().charAt(0) % 16;
	}

	public int tamanho() {
		return this.tamanho;
	}

	public boolean contemElemento(Tipo Elemento) {
		int slot = this.funcaoHash(Elemento);
		ListaSimplesmenteEncadeada<Tipo> lista = this.tabelaHash.buscaPosicao(slot);
		return lista.contem(Elemento);
	}

	public void inserir(Tipo Elemento) {
		carga();
		if(!this.contemElemento(Elemento)) {
			int slot = this.funcaoHash(Elemento);
			ListaSimplesmenteEncadeada<Tipo> lista = this.tabelaHash.buscaPosicao(slot);
			lista.adicionar(Elemento);
			this.tamanho++;
		}
	}
	public void remover(Tipo Elemento) {
		if (this.contemElemento(Elemento)) {
			int slot = this.funcaoHash(Elemento);
			ListaSimplesmenteEncadeada<Tipo> lista = this.tabelaHash.buscaPosicao(slot);
			lista.remover(Elemento);
			this.tamanho--;
			carga();
		}
	}
	public ListaSimplesmenteEncadeada<Tipo> todos (){
		ListaSimplesmenteEncadeada<Tipo> elementos = new ListaSimplesmenteEncadeada<Tipo>();
		for (int i = 0; i < this.tabelaHash.tamanhoReal(); i++) {
			elementos.adicionar((Tipo) this.tabelaHash.buscaPosicao(i));
		}
		return elementos;
	}
}
