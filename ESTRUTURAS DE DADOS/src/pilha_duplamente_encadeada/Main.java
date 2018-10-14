package pilha_duplamente_encadeada;


public class Main {
	public static void main(String[] args) {
		Pilha<String> pilha = new Pilha<>();

		pilha.empilhar("Primeiro");
		pilha.empilhar("Segundo");
		if(pilha.vazio()) {
			System.out.println("Zerada!");
		}else {
			System.out.println("Existem Itens");
		}
		for (String elemento : pilha) {
			System.out.println(elemento);
		}
		System.out.println(pilha.tamanho());
		System.out.println(pilha.topo());
		
		pilha.limpar();
		if (pilha.vazio()) {
			System.out.println("Vazia");
		} else {
			System.out.println("naovazia");
		}    }
}
