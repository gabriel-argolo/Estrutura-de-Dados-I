package tabela_hash;

public interface ITabela_Hash <Tipo> extends Iterable<Tipo> {
	public void funcaoHash();
	public void redimensionarTabela();
	public boolean cargaTotal();
	public void inserir(Tipo elemento);
	public void busca(Tipo elemento);
	public void remover(Tipo elemento);
}
