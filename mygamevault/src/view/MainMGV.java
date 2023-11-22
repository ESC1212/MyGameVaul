package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.JogoDAO;
import model.Jogo;
import model.Perfil;

public class MainMGV {
public static Perfil perfil = new Perfil();
//public static ArrayList<Jogo>gamelist = new ArrayList<>();
static Scanner r = new Scanner(System.in);



	public static ArrayList<Jogo> addgame(ArrayList<Jogo> jogos) {
		JogoDAO dao =new JogoDAO();
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
		System.out.println("ID: ");
		int id = Integer.valueOf(r.nextLine());
		jogo.setId(id);

		dao.cadastrar(jogo);
		return (jogos);
	}
	
	public static void showgamecond (ArrayList<Jogo> jogos){
		JogoDAO dao =new JogoDAO();
		System.out.println("Como você deseja mostrar a lista?");
		System.out.println("(1) Por ordem de de cadastro, (2) por nota ou (3) por ano?");
		int option = Integer.valueOf(r.nextLine());
		switch (option ) {
		case 1: {
			
			showgame(dao.listar());
			break;
		}
		case 2: {
			showgame2(dao.listar());
			break;
		}
		case 3: {
			showgame3(dao.listar());
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
	
	private static void showgame3(ArrayList<Jogo> jogos) {
		int gamecount = 1;
	    for (int i = 2100; i >= 0; i--) {
	        for (Jogo jogo : jogos) {
	            if (i == Integer.valueOf(jogo.getAno())) {
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
		JogoDAO dao = JogoDAO.getInstancia();
		Scanner r = new Scanner(System.in);
		System.out.println("voce deseja deletar algun jogo? (Y/N)");
		String esc = r.nextLine();
		while (esc.equals("Y")) {
			if (esc.equals("Y")) {
				System.out.println("qual jogo voce deseja deletar? (digite o seu numero na lista) ");
				int id = Integer.valueOf(r.nextLine());
				//Jogo joguinho =	jogos.get(Delj-1);
				if (id > 0 && id <= jogos.size()+1) {
					dao.excluir(id); //Consertar saporra
					//System.out.println("Jogo: " + joguinho.getNome());
					//System.out.println("É este jogo que voce deseja deletar? (Y/N)");
					//esc = r.nextLine();
					//if (esc.equals("Y")) {
						// jogos.remove(Delj-1);
						// dao.excluir(joguinho, null)
						//System.out.println("Jogo deletado");
						//esc = "N";
					}
					else {
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
		JogoDAO dao =new JogoDAO();
		
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
					System.out.println("Qual informação você deseja editar?");
					System.out.println("Nome(1)");
					System.out.println("Ano(2)");
					System.out.println("Nota(3)");
					System.out.println("Conquistas totais(4)");
					System.out.println("Conquistas adiquiridas(5)");
					System.out.println("Revew(6)");
					System.out.println("Genero(7)");
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
					System.out.println("você deseja continuar a editar? (Y/N) ");
					esc = r.nextLine();
				} else {
					System.out.println("Mt feio isso Douglas");
				}
			}
		}
		return (jogos);
	}
	
	private static void editperfil(ArrayList<Jogo> jogos) {
		Scanner r = new Scanner(System.in);
		printperfil(jogos);
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
		printperfil(jogos);
	}

	private static void printperfil(ArrayList<Jogo> jogos) {
		int conquistas = 0;
		int conquistasj = 0;
		for (Jogo jogo : jogos) {
			conquistas = conquistas + jogo.getConc();
			conquistasj = conquistasj + jogo.getConctot();
		}
		float conc = Float.valueOf(conquistas);
		float tot = Float.valueOf(conquistasj);
		float concpc = ((conc/tot)*100);
		
		System.out.println(" ");
		System.out.println("Nome de usuário: " + perfil.getNomeusu());
		System.out.println("Jogo Favorito: " + perfil.getJogofav());
		System.out.println("Gênero Favorito: " + perfil.getGenerofav());
		System.out.println("Número de jogos adicionados: "+jogos.size());
		System.out.println("Conquistas: "+conquistas+"/"+conquistasj+" | "+concpc+"%");
		System.out.println(" ");
	}

	public static void main(String[] args) {
		//test(gamelist); alguns jogos para teste
		JogoDAO dao =new JogoDAO();
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
					editperfil(gamelist);
					break;
				}
				case 3: {
					showgame(dao.listar());
					edigame(gamelist);
					break;
				}
				case 4: {
					showgamecond(dao.listar());;
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
	
	public static ArrayList<Jogo> test(ArrayList<Jogo> jogos){
		
		Jogo doom = new Jogo();
		doom.setNome("Doom");
		doom.setAno("1993");
		doom.setNota(Float.valueOf("8"));
		doom.setConctot(0);
		doom.setConc(0);
		doom.setDesc("'musica' Eu sei oque é **** 'musica', mas eu não vou te contar. 'musica'");
		float tot = Float.valueOf(doom.getConctot());
		float con = Float.valueOf(doom.getConc());
		doom.setPerconc((con/tot)*100);
		doom.setGenero("FPS");
		jogos.add(doom);
		
		Jogo Doom = new Jogo();
		Doom.setNome("Doom (2016)");
		Doom.setAno("2016");
		Doom.setNota(Float.valueOf("9"));
		Doom.setConctot(54);
		Doom.setConc(18);
		Doom.setDesc("Jogo muito relaxante, recomendo para toda família");
		tot = Float.valueOf(Doom.getConctot());
		con = Float.valueOf(Doom.getConc());
		Doom.setPerconc((con/tot)*100);
		Doom.setGenero("FPS");
		jogos.add(Doom);
		
		Jogo Ultrakill = new Jogo();
		Ultrakill.setNome("Ultrakill");
		Ultrakill.setAno("2020");
		Ultrakill.setNota(Float.valueOf("10"));
		Ultrakill.setConctot(0);
		Ultrakill.setConc(0);
		Ultrakill.setDesc("'may your L's be many... and your bitches be few'");
		tot = Float.valueOf(Ultrakill.getConctot());
		con = Float.valueOf(Ultrakill.getConc());
		Ultrakill.setPerconc((con/tot)*100);
		Ultrakill.setGenero("FPS");
		jogos.add(Ultrakill);
		
		Jogo SeaOfThieves = new Jogo();
		SeaOfThieves.setNome("Sea Of Thieves");
		SeaOfThieves.setAno("2018");
		SeaOfThieves.setNota(Float.valueOf("8"));
		SeaOfThieves.setConctot(229);
		SeaOfThieves.setConc(103);
		SeaOfThieves.setDesc("Arr eu sou desenpregado... arr...");
		tot = Float.valueOf(SeaOfThieves.getConctot());
		con = Float.valueOf(SeaOfThieves.getConc());
		SeaOfThieves.setPerconc((con/tot)*100);
		SeaOfThieves.setGenero("Mundo Aberto, Multiplayer");
		jogos.add(SeaOfThieves);
		
		return (jogos);
	}
}