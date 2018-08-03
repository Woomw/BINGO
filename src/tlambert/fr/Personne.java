package tlambert.fr;

import java.util.ArrayList;

public final class Personne {

	private String nom;
	private ArrayList<ArrayList> grille;
	
	public ArrayList<ArrayList> getGrille() {
		return grille;
	}


	public void setGrille(ArrayList<ArrayList> grille) {
		this.grille = grille;
	}


	public String getNom() {
		return nom;
	}

	public Personne(String nom) {
		this.nom = nom;
		this.grille = GenerateurNB.genererGrilleDeJeu();
	}
	
	public void ecrireAvecStylo(byte numeroSorti) {
		for (int colonne = 0; colonne < 5; colonne++) {
			if (this.grille.get(colonne).contains(numeroSorti)) {
				for (int ligne = 0; ligne < 5; ligne++) {
					if (Byte.valueOf(this.grille.get(colonne).get(ligne).toString()) == numeroSorti) {
						this.grille.get(colonne).set(ligne, 0);
					}
					
				}
			}
		}
	}
	
	public void afficherGrilleJoueur() {
		for (int ligne = 0; ligne < 5; ligne++) {
			System.out.println(this.grille.get(ligne));
		}
	}
}
