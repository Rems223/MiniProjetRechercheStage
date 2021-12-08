package jeuvie.bestiole;

import jeuvie.Couleur;

public interface IBestiole extends Cloneable {

	public int getNumero() ;

	public boolean isVivante();
	public Couleur getCouleur();
	public void tuer();
}
