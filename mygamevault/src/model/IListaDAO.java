package model;

import java.util.ArrayList;

public interface IListaDAO {
	public boolean cadastrar (Jogo jogo);
	public boolean excluir (int id);
	public boolean editar (int id, String game, String inf);
	public ArrayList <Jogo> listar();
}
