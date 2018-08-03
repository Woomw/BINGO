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
		} else {
			System.out.println("Erreur de saisi, le jeu va se relancer...");
			return false;
		}
	}

	public static void lancerLeJeu() {
		ArrayList listeDeBoulePanier = GenerateurNB.listeDesBoullesPanier();
		byte bouleActive = 0;
		while (!presenceBingo) {
			System.out.println("Pressez 1 et ENTER pour lancer la machine à boule...");
			while (!bonChoixSaisi) {
				
				String clavier = keyBoard.nextLine();
				while (!clavier.equals("1")) {
					System.out.println("faut appuyer sur 1 puis ENTER mère grand. Recommence ");
					clavier = keyBoard.nextLine();
				}
				bonChoixSaisi = true;
			} 
			bonChoixSaisi = false;
			bouleActive = (byte) listeDeBoulePanier.get(compteurDansLaListeDesBoules);
			compteurDansLaListeDesBoules++;
			System.out.println("La boule sortie est "+bouleActive+".");
			// On va écrire dans la grille
			Joueur1.ecrireAvecStylo(bouleActive);
			Joueur1.afficherGrilleJoueur();
			// IL NOUS RESTE A GERER LES CONDITIONS DE VICTOIRE
			// On a écrit dans la grille un 0 si on trouvait une concordance.
			// Il faut tester une ligne/colonne de 0

			gagnerAuBingo();
		}
			
			
	}
	

	public static void gagnerAuBingo() {
		int compteurVictoireLigne = 0;
		int compteurVictoireColonne = 0;
		presenceBingo = false;
		//Toutes les lignes
		for (int colonne = 0; colonne < 5; colonne++) {
			for (int ligne = 0; ligne < 5; ligne++) {
				compteurVictoireLigne += Short.valueOf(Joueur1.getGrille().get(colonne).get(ligne).toString());
			}
			if (compteurVictoireLigne == 0) {
				presenceBingo = true;
				System.out.println("BINGO ! Vous avez gagné !");
				return;
			} else {
				compteurVictoireLigne = 0;
			}
		}
		//Toutes les colonnes
		for (int ligne = 0; ligne < 5; ligne++) {
			for (int colonne = 0; colonne < 5; colonne++) {
				compteurVictoireColonne += Short.valueOf(Joueur1.getGrille().get(colonne).get(ligne).toString());
			}
			if (compteurVictoireColonne == 0) {
				presenceBingo = true;
				System.out.println("BINGO ! Vous avez gagné !");
				return;
			} else {
				compteurVictoireColonne = 0;
			}
		}

	}

}
