package mygamevault;

import java.util.ArrayList;
import java.util.Scanner;


public class MainMGV {
	
public static Jogo addgame(Jogo[] game,int gamecount) {
	Scanner r = new Scanner(System.in);
		System.out.println("Nome: ");
		game[gamecount].setNome(r.nextLine());
		System.out.println("Ano de lancamento: ");
		game[gamecount].setAno(r.nextLine());
		System.out.println("Nota");
		game[gamecount].setNota(Float.valueOf(r.nextLine()));
		System.out.println("Revew escrita do jogo: ");
		game[gamecount].setDesc(r.nextLine());
		System.out.println("Conquistas totais no jogo: ");
		game[gamecount].setConc(Integer.valueOf(r.nextLine()));
		System.out.println("Conquistas alcancadas: ");
		game[gamecount].setConctot(Integer.valueOf(r.nextLine()));
		int 
		return game[gamecount];
	}
	
	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);
		int gamecount = 0;
		Jogo[] game = new Jogo[100];
		System.out.println("Bem-Vindo ao MyGameVault, oque deseja fazer?");
		System.out.println("Continuar(1), digite qualquer outra tecla para sair.");
		int esc = Integer.valueOf(r.nextLine()); //Tentar mudar para char
		
		if (esc == 1) {
			System.out.println("Qual seu nome? ");
			String nomeusuario = r.nextLine();
			
			
		int escolha = 0;
		while (escolha != 5) {
			
			System.out.println("- O que você deseja fazer? -");
			System.out.println("1-Adicionar Jogo");
			System.out.println("2-Perfil");
			System.out.println("2-Perfil");
			System.out.println("4-Mostrar jogos");
			System.out.println("5-Sair");

			escolha = Integer.valueOf(r.nextLine());

			switch (escolha) {
			case 1: {
				
				addgame(game,gamecount);
				gamecount++;
				break;
			}
			case 2: {
				//botar um metodo aqui
				break;
			}
			case 3: {
				//botar um metodo aqui
				break;
			}
			case 4: {
				//botar um metodo aqui
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