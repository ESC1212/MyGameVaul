package controller;

import java.util.ArrayList;

import model.IListaDAO;
import model.Jogo;

public class JogoDAO implements IListaDAO {
	
	ArrayList <Jogo> thegamelist =  new ArrayList<>();

	@Override
	public boolean cadastrar(Jogo jogo) {
		thegamelist.add(jogo);
		return false;
	}

	@Override
	public boolean excluir(Jogo jogo, string id) {
		for (Jogo jogo2 : thegamelist) {
			if (jogo2.getId() == id) {
				thegamelist.remove(jogo2);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean editar(Jogo jogo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Jogo> listar() {
		return thegamelist;
	}


}
