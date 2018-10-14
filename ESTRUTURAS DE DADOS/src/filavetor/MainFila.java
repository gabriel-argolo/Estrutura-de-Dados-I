package filavetor;

public class MainFila {
	public static void main(String[] args) {
		Fila<String> f = new Fila<>(10);
		f.enfileirar("Jose");
		f.enfileirar("Maria");
		f.enfileirar("Cleiton Rasta");
		System.out.println(f.toString());
		f.desenfileirar();
		System.out.println(f.toString());
		f.desenfileirar();
		System.out.println(f.toString());
		f.enfileirar("Edvaldo");
		System.out.println(f.toString());
		f.limpar();
		System.out.println(f.toString());
		f.enfileirar("zé");
		System.out.println(f.toString());
		f.desenfileirar();
		System.out.println(f.toString());
		f.enfileirar("CABEÇA");
		System.out.println(f.toString());

	}
}
