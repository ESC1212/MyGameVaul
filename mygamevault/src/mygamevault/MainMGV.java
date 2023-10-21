package mygamevault;

import java.util.ArrayList;
import java.util.Scanner;


public class MainMGV {
	
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
		
		jogos.add(jogo);
		return (jogos);
	}
	
	public static void showgame (ArrayList<Jogo> jogos){
		int gamecount = 1;
		for (Jogo jogo : jogos) {
			System.out.println();
			System.out.println("----------"+gamecount+"----------");
			System.out.println();
			System.out.println("Nome: "+jogo.getNome());
			System.out.println("Ano: "+jogo.getAno());
			System.out.println("Nota: "+jogo.getNota());
			System.out.println("Conquistas: "+jogo.getConc()+"/"+jogo.getConctot());
			System.out.println("porcentagem de conquistas = "+jogo.getPerconc()+"%");
			System.out.println("Revew: "+jogo.getDesc());
			System.out.println();
			gamecount++;
		}
		System.out.println("---------fim--------");
		System.out.println();
	}
	
	public static ArrayList<Jogo> delgame (ArrayList<Jogo> jogos) {
		Scanner r = new Scanner(System.in);
		System.out.println("voce deseja deletar algun jogo? ");
		String esc = r.nextLine();
		while (esc.equals("Sim")) {
			if (esc.equals("Sim")) {
				System.out.println("qual jogo voce deseja deletar? (digite o seu numero na lista) ");
				int Delj = Integer.valueOf(r.nextLine());
				if (Delj > 0) {
					System.out.println();
					System.out.println(jogos.get(Delj-1));
					System.out.println();
					System.out.println("E este jogo que voce deseja deletar? ");
					esc = r.nextLine();
					if (esc.equals("Sim")) {
						jogos.remove(Delj-1);
						esc = "n";
					} else {
						System.out.println("voce deseja escolher outro jogo? ");
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
		String esc = "sim";
		while (esc.equals("sim")) {
			Scanner r = new Scanner(System.in);
			System.out.println("Qual jogo voce deseja editar?  ");
			int edij = Integer.valueOf(r.nextLine());
			if (edij > 0) {
				Jogo jogo = new Jogo();
				System.out.println();
				System.out.println(jogos.get(edij-1));
				System.out.println();
				System.out.println("E este jogo que voce deseja editar? ");
				esc = r.nextLine();
				if (esc.equals("Sim")) {
					jogo = jogos.get(edij-1);
					System.out.println("Qual informação você deseja deletar?");
					System.out.println("Nome(1)");
					System.out.println("Ano(2)");
					System.out.println("Nota(3)");
					System.out.println("conquistas totais(4)");
					System.out.println("conquistas adiquiridas(5)");
					System.out.println("Revew(6)");
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
					default : {
						System.out.println("digite um numero valido.");
					}
					
					}
				} else {
					System.out.println("então vai se fuder");
				}
			}
		}
		return (jogos);
	}
	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);
		ArrayList<Jogo>gamelist = new ArrayList<>();
		System.out.println("Bem-Vindo ao MyGameVault, oque deseja fazer?");
		System.out.println("Continuar(1), digite qualquer outra tecla para sair.");
		String esc = r.nextLine();
		
		if (esc.equals("1")) {
			System.out.println("Qual seu nome? ");
			String nomeusuario = r.nextLine();
			
			
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
					//botar um metodo aqui
					break;
				}
				case 3: {
					showgame(gamelist);
					edigame(gamelist);
					break;
				}
				case 4: {
					showgame(gamelist);
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
}