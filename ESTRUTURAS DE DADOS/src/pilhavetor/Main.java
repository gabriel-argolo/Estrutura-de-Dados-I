package pilhavetor;


public class Main {
	public static void main(String[] args) {
		Pilha<String> pilha = new Pilha<>(10);

		pilha.empilhar("Base");
		pilha.empilhar("1");
		pilha.empilhar("2");
		pilha.empilhar("3");
		pilha.empilhar("4");
		pilha.empilhar("Topo");
		System.out.print(pilha.toString());
		System.out.print(pilha.tamanho());
		
	}
}
