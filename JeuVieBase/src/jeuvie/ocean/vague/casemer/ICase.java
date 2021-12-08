package jeuvie.ocean.vague.casemer;

import jeuvie.Couleur;
import jeuvie.ocean.IOcean;

public interface ICase extends Cloneable {

	public void setVivante();
	
	public Couleur getCouleur();
	
	public void evoluer(IOcean copie, int col, int lg);

	public boolean isVide();
	
	public void tuerEventuelOccupant();
	public boolean contientBestioleVivante();
	
}
