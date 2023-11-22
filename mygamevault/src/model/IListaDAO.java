package model;

import java.util.ArrayList;

public interface IListaDAO {
	public boolean cadastrar (Jogo jogo);
	public boolean excluir (Jogo jogo, int id);
	public boolean editar (Jogo jogo);
	public ArrayList <Jogo> listar();
}
