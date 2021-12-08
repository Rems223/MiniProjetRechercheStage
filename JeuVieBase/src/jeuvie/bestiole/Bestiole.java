package jeuvie.bestiole;
import jeuvie.Couleur;

public abstract class Bestiole implements IBestiole { // class "abstract" = on peut pas faire de new dessus

	private static int compteur = 0;

	protected final int numero;
	protected Couleur couleur;
	protected boolean vivante=true;

	protected abstract Couleur getCouleurVivant();
	protected abstract Couleur getCouleurMort();

	public Bestiole() {
		super();
		this.numero = ++compteur;
		this.couleur = getCouleurVivant();
	}	

	@Override                   // overide = redefinition
	public int getNumero() {
		return this.numero;
	}


	@Override
	public boolean isVivante() {
		return this.vivante;
	}


	@Override
	public Couleur getCouleur() {
		return this.couleur;
	}

	public void tuer(){
		this.vivante = false;
		this.couleur = getCouleurMort();

	}
	@Override
	public String toString() {
		return "Bestiole [numero=" + numero + ", couleur=" + couleur + ", vivante=" + vivante + "]";
	}


}

