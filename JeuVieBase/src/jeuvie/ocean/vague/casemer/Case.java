package jeuvie.ocean.vague.casemer;

import jeuvie.Couleur;
import jeuvie.bestiole.IBestiole;

public abstract class Case implements ICase {
	
	protected boolean vide=true;
	protected IBestiole occupant = null;

	public abstract Couleur getCouleurCaseVide();
	protected abstract void setBestioleVivante();
	
	public Case(boolean vide, IBestiole occupant) { // Surcharge = même nom, mais pas meme methode (blabla)
		super();
		this.vide = vide;
		this.occupant = occupant;
	}
	
	public Case() {                                // Surcharge = même nom, mais pas meme methode ()
		super();
	}


	@Override
	public boolean isVide() {
		// TODO Auto-generated method stub
		return false;
	}
	public void setVivante(){
		//TODO
	}	

	public Couleur getCouleur(){
		// TODO
		return null;
	}


	public boolean contientBestioleVivante(){
		//TODO
		return true;
	}

	public void tuerEventuelOccupant(){
		//TODO
	}

	

}
