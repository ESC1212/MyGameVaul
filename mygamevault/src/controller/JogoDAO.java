package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.IListaDAO;
import model.Jogo;

public class JogoDAO implements IListaDAO {
	
	private static ArrayList <Jogo> thegamelist = new ArrayList<>();
	private static JogoDAO instancia;
	
	public JogoDAO() {//private
		
	}
	public static JogoDAO getInstancia() {
			if(instancia == null) {
				instancia = new JogoDAO();
				thegamelist  =  new ArrayList<>();
			}
			return instancia;
		}

	@Override
	public boolean cadastrar(Jogo jogo) {
		thegamelist.add(jogo);
		return false;
	}

	@Override
	public boolean excluir (int id) {
		
		for (Jogo jogo2 : thegamelist) {
			if (jogo2.getId() == id) {
				thegamelist.remove(jogo2);
				return true;
			}
		}
		return false;
	}

	@Override

	public boolean editar(int id, String info) {
		Scanner r = new Scanner(System.in);
		for (Jogo jogo2 : thegamelist) {
			switch (id) {
			case 1: {
				jogo2.setNome(info);
				break;
			}
			case 2:{
				jogo2.setAno(info);
				break;
			}
			case 3: {
				jogo2.setNota(Float.valueOf(info));
				break;
			}
			case 4: {
				jogo2.setConctot(Integer.valueOf(info));
				break;
			}
			case 5: {
				jogo2.setConc(Integer.valueOf(info));
				break;
			}
			case 6: {
				jogo2.setDesc(info);
				break;
			}
			case 7: {
				jogo2.setGenero(info);
				break;
			}
			}
		}
		return true;
	}

	@Override
	public ArrayList<Jogo> listar() {
		return thegamelist;
	}


}
