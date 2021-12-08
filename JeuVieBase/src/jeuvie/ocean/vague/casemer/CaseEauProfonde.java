package jeuvie.ocean.vague.casemer;

import jeuvie.Couleur;
import jeuvie.bestiole.Dauphin;
import jeuvie.ocean.IOcean;

public class CaseEauProfonde extends Case {
	
	private static final Couleur CASE_VIDE = Couleur.BLEU_SOMBRE;

	public CaseEauProfonde() {
		
		
	}
	
	@Override
	public Couleur getCouleurCaseVide() {
		return CASE_VIDE;
	}
	
	
	
	public CaseEauProfonde(Dauphin occupant, boolean vide) {
		
	}
	
	
	protected void setBestioleVivante() {
		//TODO
	}

	/**
	 * À chaque étape, l’évolution d’une cellule est entièrement déterminée par l’état de ses huit voisines de la façon suivante :

	 * Une cellule morte possédant exactement trois voisines vivantes devient vivante (elle naît).
	 * Une cellule vivante possédant deux ou trois voisines vivantes le reste, sinon elle meurt.
	 * @param col la colonne dans la matrice
	 * @param j la ligne dans la matrice
	 * @return si cette case précise doit survivre ou non.
	 */
	public void evoluer(IOcean copie, int col, int lg){
		//TODO
	}

	
}
