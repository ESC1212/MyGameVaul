package model;

import java.util.ArrayList;

public interface IListaDAO {
	public boolean cadastrar (Jogo jogo);
	public boolean excluir (int id);
	public boolean editar (Jogo jogo);
	public ArrayList <Jogo> listar();
}
