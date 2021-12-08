package jeuvie;

import java.util.ArrayList;

import com.sun.tools.javac.util.List;

import jeuvie.bestiole.Bestiole;
import jeuvie.bestiole.Dauphin;
import jeuvie.bestiole.IBestiole;


public class JeuVie {

	public static void main(String[] args) {

		//new Controleur(new BordDeCote(Ocean.PI));
		//new Controleur(new BordDeCote(Ocean.ALEA));

		//new Controleur(new HauteMer(Ocean.ALEA));
		//new Controleur(new HauteMer(Ocean.BARRE));
		//new Controleur(new HauteMer(Ocean.CANON));
		//new Controleur(new HauteMer(Ocean.CLOWN), Controleur.ITER_CLOWN);
		//new Controleur(new HauteMer(Ocean.PI), Controleur.ITER_PI);
		//new Controleur(new HauteMer(Ocean.GRAND_VAISSEAU));
		//new Controleur(new HautIBestiolen.PETIT_VAISSEAU));

		ArrayList<IBestiole> bestioles = new ArrayList<IBestiole>(10);
		for(int i = 0; i < 10; i++) {   /* Faire dans la méthode main une boucle permettant de générer dix bestioles, en en tuant une sur
			                               deux. Les afficher dans la console, après avoir fait la méthode toString adéquate */
			Bestiole b = new Dauphin();
			if (i%2==0) {
				b.tuer();
			}
			bestioles.add(b);

		}

		System.out.println(bestioles);

	}

}
