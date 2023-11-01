package model;

public interface IListaDAO {
	public boolean cadastrar (Jogo jogo);
	public boolean excluir (Jogo jogo);
	public boolean editar (Jogo jogo);
	public boolean listar (Jogo jogo);
}
