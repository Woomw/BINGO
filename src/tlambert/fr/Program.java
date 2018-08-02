package tlambert.fr;

import java.util.ArrayList;
import java.util.Scanner;

public final class Program {

	static Scanner keyBoard = new Scanner(System.in);
	static boolean presenceBingo = false;
	static boolean bonChoixSaisi = false;
	static byte compteurDansLaListeDesBoules = 0;
	static Personne Joueur1;
	
	
	public static void main(String[] args) {
		boolean quitterJeu = false;
		System.out.println("Donnez moi votre nom poupée...");
		String clavier2 = keyBoard.nextLine();
		Joueur1 = new Personne(clavier2);
		while (!quitterJeu) {
			quitterJeu = menu();
		}
	}

	public static boolean menu() {
		
		System.out.println("M/Mme le vioq, on va jouer au bingo !");
		System.out.println("Gardes ton dentier près de toi, c'est parti ! (Press G)");
		System.out.println("Si tu veux quitter : Press Z");
		char clavier = keyBoard.nextLine().toUpperCase().charAt(0);
		if (clavier == 'G') {
			lancerLeJeu();
			return false;
		}
		if (clavier == 'Z') {
			return true;
		}
		else {
			System.out.println("Erreur de saisi, le jeu va se relancer...");
			return false;
		}
	}
	
	public static void lancerLeJeu() {
		ArrayList listeDeBoulePanier = GenerateurNB.listeDesBoullesPanier();
		byte bouleActive = 0;
		while (presenceBingo) {
			while (!bonChoixSaisi) {
				System.out.println("Pressez 1 et ENTER pour lancer la machine à boule...");
				byte clavier = keyBoard.nextByte();
				if (clavier == 1) {
					bonChoixSaisi = true;
					bouleActive = (byte) listeDeBoulePanier.get(compteurDansLaListeDesBoules);
					compteurDansLaListeDesBoules++;
				}
			}
			bonChoixSaisi = false;
		//On va écrire dans la grille
			Joueur1.ecrireAvecStylo(bouleActive);
			
		//IL NOUS RESTE A GERER LES CONDITIONS DE VICTOIRE
			
			
			
			
			
			
		}	
	}
	
	
	
	
	
	
	
	}
	
