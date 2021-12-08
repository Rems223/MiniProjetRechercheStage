package jeuvie.ocean;

import java.util.ArrayList;
import java.util.List;

import jeuvie.ocean.vague.ILigneEau;

public abstract class Ocean implements IOcean {

	public static final int CLOWN = 1;
	public static final int CANON = 2;
	public static final int PETIT_VAISSEAU = 3;
	public static final int GRAND_VAISSEAU = 4;
	public static final int PI = 5;
	public static final int ALEA = 6;
	public static final int BARRE = 7;

	protected List<ILigneEau> grille;
	protected abstract void remplirDeLignesEau();

	protected Ocean(List<ILigneEau> grille) {
		this.grille=grille;
	}

	public Ocean(int forme) {
		this.grille=new ArrayList<ILigneEau>(getNbLignes());
		this.remplirDeLignesEau();
		this.creerFormeDeVie(forme);
	}

	public ILigneEau get(int i) {
		return this.grille.get(i);
	}

	private void setBestiole(int col, int lg){
		//TODO
	}

	protected void creerFormeDeVie(int forme){

		final int BASE_X = 25;
		final int BASE_Y = 25;

		switch (forme) {
		case PETIT_VAISSEAU:
			for (int i = 0; i < this.getNbLignes()/7; i++) {
				int delta=i*7+3;
				setBestiole(3, delta);
				setBestiole(4, delta+1);
				setBestiole(2, delta+2); setBestiole(3, delta+2); setBestiole(4, delta+2);
			}
			break;
		case GRAND_VAISSEAU:
			for (int i = 0; i < this.getNbLignes()/9; i++) {
				int delta=i*9+3;
				setBestiole(2, delta);setBestiole(5, delta);
				setBestiole(6, delta+1);
				setBestiole(2, delta+2); setBestiole(6, delta+2);
				setBestiole(3, delta+3);setBestiole(4, delta+3);setBestiole(5, delta+3);setBestiole(6, delta+3);
			}

			break;
		case PI:
			for (int i = 0; i < (this.getNbLignes()/47); i++) {
				int delta= i*47 + BASE_Y;
				setBestiole(BASE_X, delta+3);
				setBestiole(BASE_X-1, delta+2);setBestiole(BASE_X+1, delta+2);
				setBestiole(BASE_X-1, delta+1);setBestiole(BASE_X+1, delta+1);
				setBestiole(BASE_X-1, delta);setBestiole(BASE_X+1, delta);
			}
			break;
		case CLOWN:
			
			// ligne haute
			setBestiole(BASE_X, BASE_Y); 			setBestiole(BASE_X+1, BASE_Y); 			setBestiole(BASE_X+2, BASE_Y);

			// deux barres parallèles
			setBestiole(BASE_X, BASE_Y+1);			setBestiole(BASE_X+2, BASE_Y+1);
			setBestiole(BASE_X, BASE_Y+2); 			setBestiole(BASE_X+2, BASE_Y+2);
			break;
		case BARRE:
			// ligne haute			
			setBestiole(BASE_X, BASE_Y); 			setBestiole(BASE_X+1, BASE_Y);	setBestiole(BASE_X-1, BASE_Y);

			break;
		case CANON:
			// le canon à planneur
			// carré gauche
			setBestiole(2, 10);setBestiole(3, 10);
			setBestiole(2, 11);setBestiole(3, 11);

			// carré droit

			// carré droit
			setBestiole(36, 8);setBestiole(37, 8);
			setBestiole(36, 9);setBestiole(37, 9);


			//flèche gauche
			setBestiole(14, 8);setBestiole(15, 8);
			setBestiole(13, 9);setBestiole(17, 9);
			setBestiole(12, 10); setBestiole(18, 10);
			setBestiole(12, 11);setBestiole(16, 11);setBestiole(18, 11);setBestiole(19, 11);
			setBestiole(12, 12);setBestiole(18, 12);
			setBestiole(13, 13); setBestiole(17, 13);
			setBestiole(14, 14);setBestiole(15, 14);

			//flèche droite
			setBestiole(26, 6);
			setBestiole(24, 7);setBestiole(26, 7);
			setBestiole(22, 8);setBestiole(23, 8);
			setBestiole(22, 9);setBestiole(23, 9);
			setBestiole(22, 10);setBestiole(23, 10);
			setBestiole(24, 11);setBestiole(26, 11);
			setBestiole(26, 12);

			break;

		default: creerDeLaVieAleatoirement();
		break;
		}

	}

	private void creerDeLaVieAleatoirement() {
		for (int lg = 0; lg < this.getNbLignes(); lg++) {
			ILigneEau ligne = get(lg);
			for (int col = 0; col < ligne.getNbColonnes(); col++) {
				double alea = Math.random();
				if (alea<0.2) {
					this.setBestiole(col, lg);
				}
			}
		}
	}

	public void etapeSuivante(){
		//TODO
	}

	public int compterVoisinsVivants(int iCol, int jLg) {
		// TODO
		return 0;
	}

}
