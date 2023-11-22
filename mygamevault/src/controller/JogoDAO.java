package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.IListaDAO;
import model.Jogo;

public class JogoDAO implements IListaDAO {
	
	private static ArrayList <Jogo> thegamelist;
	private static JogoDAO instancia;
	
	private JogoDAO() {
		
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
	public boolean excluir(int id) {
		Scanner r = new Scanner(System.in);
		for (Jogo jogo2 : thegamelist) {
			if (jogo2.getId() == id) {
				jogo2.getNome();
				System.out.println("Esse é o jogo que você deseja deletar? ");
				String yn = r.nextLine();
				if (yn == "Y") {
				thegamelist.remove(jogo2);
				}
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
