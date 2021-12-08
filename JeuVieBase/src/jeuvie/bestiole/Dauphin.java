package jeuvie.bestiole;

import jeuvie.Couleur;


public class Dauphin extends Bestiole {

	private static final Couleur MORT = Couleur.BLEU_MARINE;
	private static final Couleur VIVANT = Couleur.BLEU_GRIS;


	public Dauphin() {
		super();
	}


	@Override
	protected Couleur getCouleurVivant() {
		return VIVANT;
	}


	@Override
	protected Couleur getCouleurMort() {
		return MORT;
	}

}
