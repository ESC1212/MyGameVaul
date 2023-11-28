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
	public boolean editar(int id, String game, String info) {
		// Switch no Main krl
		Scanner r = new Scanner(System.in);
		for (Jogo jogo2 : thegamelist) {
			switch (game) {
			case "1" : {
				jogo2.setNome(info);
				break;
			}
			case "2" : {
				jogo2.setNome(info);
				break;
			}
			case "3" : {
				jogo2.setNota(Float.valueOf(info));
				break;
			}
			case "4" : {
				info = r.nextLine();
				jogo2.setConctot(Integer.valueOf(info));
				float tot = Float.valueOf(jogo2.getConctot());
				float con = Float.valueOf(jogo2.getConc());
				jogo2.setPerconc((con/tot)*100);
				break;
			}
			case "5" : {
				info = r.nextLine();
				jogo2.setConc(Integer.valueOf(info));
				float tot = Float.valueOf(jogo2.getConctot());
				float con = Float.valueOf(jogo2.getConc());
				jogo2.setPerconc((con/tot)*100);
				break;
			}
			case "6" : {
				info = r.nextLine();
				jogo2.setDesc(info);
				break;
			}
			case "7":{
				info = r.nextLine();
				jogo2.setGenero(info);
				break;
			}
			default : {
				System.out.println("digite um numero valido.");
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
