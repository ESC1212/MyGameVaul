package mygamevault;

import java.util.ArrayList;
import java.util.Scanner;


public class MainMGV {
public static Perfil perfil = new Perfil();
public static ArrayList<Jogo>gamelist = new ArrayList<>();
static Scanner r = new Scanner(System.in);
	
	public static ArrayList<Jogo> addgame(ArrayList<Jogo> jogos) {
		
		Jogo jogo = new Jogo();			
		Scanner r = new Scanner(System.in);
		System.out.println("Nome: ");
		String nome = r.nextLine();
		jogo.setNome(nome);
		System.out.println("Ano: ");
		String ano = r.nextLine();
		jogo.setAno(ano);
		System.err.println("Nota: ");
		Float nota = Float.valueOf(r.nextLine());
		jogo.setNota(nota);
		System.out.println("conquistas totais no jogo: ");
		int conctot = Integer.valueOf(r.nextLine());
		jogo.setConctot(conctot);
		System.out.println("conquistas alcançadas: ");
		int conc = Integer.valueOf(r.nextLine());
		jogo.setConc(conc);
		System.out.println("Revew: ");
		String desc = r.nextLine();
		jogo.setDesc(desc);
		float tot = Float.valueOf(jogo.getConctot());
		float con = Float.valueOf(jogo.getConc());
		jogo.setPerconc((con/tot)*100);
		System.out.println("Gênero: ");
		String gen = r.nextLine();
		jogo.setGenero(gen);
		jogos.add(jogo);
		return (jogos);
	}
	
	public static void showgamecond (ArrayList<Jogo> jogos){
		System.out.println("Como você deseja mostrar a lista?");
		System.out.println("(1) Por ordem de de cadastro ou (2) por nota?");
		int option = Integer.valueOf(r.nextLine());
		switch (option ) {
		case 1: {
			showgame(gamelist);
			break;
		}
		case 2: {
			showgame2(gamelist);
			break;
		}
		}

		System.out.println("---------fim--------");
		System.out.println();
	}
	private static void showgame2(ArrayList<Jogo> jogos) {
	    int gamecount = 1;
	    for (int i = 10; i >= 0; i--) {
	        for (Jogo jogo : jogos) {
	            if (jogo.getNota() == i) {
	                System.out.println();
	                System.out.println("----------"+gamecount+"----------");
	                System.out.println();
	                System.out.println("Nome: "+jogo.getNome());
	                System.out.println("Ano: "+jogo.getAno());
	                System.out.println("Gênero: "+jogo.getGenero());
	                System.out.println("Nota: "+jogo.getNota());
	                System.out.println("Conquistas: "+jogo.getConc()+"/"+jogo.getConctot());
	                System.out.println("porcentagem de conquistas = "+jogo.getPerconc()+"%");
	                System.out.println("Revew: "+jogo.getDesc());
	                System.out.println();
	                gamecount++;
	            }
	        }
	    }
	}

	private static void showgame(ArrayList<Jogo> jogos) {
		int gamecount = 1;
		for (Jogo jogo : jogos) {
			System.out.println();
			System.out.println("----------"+gamecount+"----------");
			System.out.println();
			System.out.println("Nome: "+jogo.getNome());
			System.out.println("Ano: "+jogo.getAno());
			System.out.println("Gênero: "+jogo.getGenero());
			System.out.println("Nota: "+jogo.getNota());
			System.out.println("Conquistas: "+jogo.getConc()+"/"+jogo.getConctot());
			System.out.println("porcentagem de conquistas = "+jogo.getPerconc()+"%");
			System.out.println("Revew: "+jogo.getDesc());
			System.out.println();
			gamecount++;
	}
}
	
	public static ArrayList<Jogo> delgame (ArrayList<Jogo> jogos) {

		Scanner r = new Scanner(System.in);
		System.out.println("voce deseja deletar algun jogo? (Y/N)");
		String esc = r.nextLine();
		while (esc.equals("Y")) {
			if (esc.equals("Y")) {
				System.out.println("qual jogo voce deseja deletar? (digite o seu numero na lista) ");
				int Delj = Integer.valueOf(r.nextLine());
				Jogo joguinho =	jogos.get(Delj-1);
				if (Delj > 0 && Delj <= jogos.size()+1) {
					System.out.println("Jogo: " + joguinho.getNome());
					System.out.println("É este jogo que voce deseja deletar? (Y/N)");
					esc = r.nextLine();
					if (esc.equals("Y")) {
						jogos.remove(Delj-1);
						System.out.println("Jogo deletado");
						esc = "N";
					} else {
						System.out.println("voce deseja deletar outro jogo? (Y/N)");
						esc = r.nextLine();
					}
				} else {
					System.out.println("Digite um numero valido");
				}
			}else {
			}
		}
		return (jogos);
	}
	
	public static ArrayList<Jogo> edigame (ArrayList<Jogo> jogos) {
		String esc = "Y";
		while (esc.equals("Y")) {
			Scanner r = new Scanner(System.in);
			System.out.println("Qual jogo voce deseja editar?  ");
			int edij = Integer.valueOf(r.nextLine());
			if (edij > 0 && edij <= jogos.size()+1) {
				Jogo jogo = new Jogo();
				System.out.println();
				Jogo joguinho =	jogos.get(edij-1);
				System.out.println("Jogo: " + joguinho.getNome());
				System.out.println();
				System.out.println("E este jogo que voce deseja editar? (Y/N)");
				esc = r.nextLine();
				if (esc.equals("Y")) {
					jogo = jogos.get(edij-1);
					System.out.println("Qual informação você deseja deletar?");
					System.out.println("Nome(1)");
					System.out.println("Ano(2)");
					System.out.println("Gênero(3)");
					System.out.println("Nota(4)");
					System.out.println("conquistas totais(5)");
					System.out.println("conquistas adiquiridas(6)");
					System.out.println("Revew(7)");
					String game = r.nextLine();
					switch (game) {
					case "1" : {
						System.out.println("informação atual: "+jogo.getNome());
						System.out.println("Nova informação: ");
						String info = r.nextLine();
						jogo.setNome(info);
						break;
					}
					case "2" : {
						System.out.println("informação atual: "+jogo.getAno());
						System.out.println("Nova informação: ");
						String info = r.nextLine();
						jogo.setNome(info);
						break;
					}
					case "3" : {
						System.out.println("informação atual: "+jogo.getNota());
						System.out.println("Nova informação: ");
						String info = r.nextLine();
						jogo.setNota(Float.valueOf(info));
						break;
					}
					case "4" : {
						System.out.println("informação atual: "+jogo.getConctot());
						System.out.println("Nova informação: ");
						String info = r.nextLine();
						jogo.setConctot(Integer.valueOf(info));
						float tot = Float.valueOf(jogo.getConctot());
						float con = Float.valueOf(jogo.getConc());
						jogo.setPerconc((con/tot)*100);
						break;
					}
					case "5" : {
						System.out.println("informação atual: "+jogo.getConc());
						System.out.println("Nova informação: ");
						String info = r.nextLine();
						jogo.setConc(Integer.valueOf(info));
						float tot = Float.valueOf(jogo.getConctot());
						float con = Float.valueOf(jogo.getConc());
						jogo.setPerconc((con/tot)*100);
						break;
					}
					case "6" : {
						System.out.println("informação atual: "+jogo.getDesc());
						System.out.println("Nova informação: ");
						String info = r.nextLine();
						jogo.setDesc(info);
						break;
					}
					case "7":{
						System.out.println("informação atual: "+jogo.getGenero());
						System.out.println("Nova informação: ");
						String info = r.nextLine();
						jogo.setGenero(info);
						break;
					}
					default : {
						System.out.println("digite um numero valido.");
					}
					
					}
				} else {
					System.out.println("Mt feio isso Eduardo");
				}
			}
		}
		return (jogos);
	}
	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);
		System.out.println("Bem-Vindo ao MyGameVault, oque deseja fazer?");
		System.out.println("Continuar(1), digite qualquer outra tecla para sair.");
		String esc = r.nextLine();
		perfil.setGenerofav("N/A");
		perfil.setJogofav("N/A");
		
		if (esc.equals("1")) {
			System.out.println("Qual seu nome? ");
			perfil.setNomeusu(r.nextLine());
			System.out.println(perfil.getNomeusu());
			
			
			int escolha = 0;
			while (escolha != 5) {
				
				System.out.println("- O que você deseja fazer? -");
				System.out.println("1-Adicionar Jogo");
				System.out.println("2-Perfil");
				System.out.println("3-Editar Jogo");
				System.out.println("4-Mostrar jogos");
				System.out.println("5-Sair");
	
				escolha = Integer.valueOf(r.nextLine());
	
				switch (escolha) {
				case 1: {
					gamelist = (addgame(gamelist));
					break;
				}
				case 2: {
					editperfil();
					break;
				}
				case 3: {
					showgame(gamelist);
					edigame(gamelist);
					break;
				}
				case 4: {
					showgamecond(gamelist);
					gamelist = (delgame(gamelist));	
					break;
					}
				case 5: {
					System.out.println("Você escolhei sair.");
					break;
					}
				}
	
				}

		}else {
			System.out.println("Você escolheu sair.");
		}
	}
	private static void editperfil() {
		Scanner r = new Scanner(System.in);
		printperfil();
		System.out.println("Deseja editar o perfil? (Y/N)");
		String yn = r.nextLine();
		System.out.println(yn);
		while (yn.equals("Y")) {
			System.out.println("Selecione o que você deseja editar: 1-Nome 2-Jogo Favorito 3-Gênero Favorito");
			int opperfil = Integer.valueOf(r.nextLine());
			switch(opperfil) {
			case 1: {
				System.out.println("Digite o novo nome de usuário: ");
				perfil.setNomeusu(r.nextLine());
				break;
			}
			case 2:{
				System.out.println("Digite o novo jogo favorito: ");
				perfil.setJogofav(r.nextLine());
				break;
			}
			case 3:{
				System.out.println("Digite o novo gênero favorito: ");
				perfil.setGenerofav(r.nextLine());
				break;
			}
			}
			if (opperfil != 1 && opperfil != 2 && opperfil != 3) {
				System.out.println("Erro, comando não compreendido");
			}
			System.out.println("Deseja continuar editando? (Y/N)");
			yn = r.nextLine();
		}
		System.out.println("Novo Perfil: ");
		printperfil();
	}

	private static void printperfil() {
		System.out.println(" ");
		System.out.println("Nome de usuário: " + perfil.getNomeusu());
		System.out.println("Jogo Favorito: " + perfil.getJogofav());
		System.out.println("Gênero Favorito: " + perfil.getGenerofav());
		System.out.println(" ");
	}

}