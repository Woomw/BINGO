package tlambert.fr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public final class GenerateurNB {

	//Variable + Getters + Setters
	
	// Constructeurs
	
	// Méthodes
	
	public static byte randNG() {
		return ((byte) (Math.random()*100+1));
	}
	
	public static ArrayList listeDesBoullesPanier() {
		ArrayList listUnique = new ArrayList();
		for (byte numeroBoule = 1; numeroBoule < 101; numeroBoule++) {
			listUnique.add(numeroBoule);
		}
		Collections.shuffle(listUnique);
		return listUnique;
	}
	
	public static ArrayList<ArrayList> genererGrilleDeJeu() {
		ArrayList<ArrayList> Grille = new ArrayList<ArrayList>();
		ArrayList TableauDeRemplissage = listeDesBoullesPanier();
		ListIterator Iterator = TableauDeRemplissage.listIterator();
		for (int i = 0; i < 5; i++) {
			Grille.add(new ArrayList());
			Grille.get(i).add(Iterator.next());
			Grille.get(i).add(Iterator.next());
			Grille.get(i).add(Iterator.next());
			Grille.get(i).add(Iterator.next());
			Grille.get(i).add(Iterator.next());
		}
		return Grille;
	}
	
}
