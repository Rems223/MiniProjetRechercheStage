package controleur;

import ihm.IHMSwing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import jeuvie.ocean.IOcean;
import jeuvie.ocean.vague.ILigneEau;
import jeuvie.ocean.vague.casemer.ICase;

public class Controleur implements ActionListener{

	private Timer timer;
	private final int ATTENTE = 50;
	//private boolean infini = true;
	private boolean infini = false;
	public static final int ITER_CLOWN = 111;
	public static final int ITER_PI = 46;
	private final int NB_ITER;
	private int nbIterCourant=0;

	private IHMSwing fenetre;
	private IOcean ocean;

	public Controleur(IOcean ocean, int nbIter) {
		
		// TODO Placez ici vos appels aux constructeurs d'Ocean puis initialiser
		// la matrice avec votre instance d'Ocean.
		super();
		this.ocean=ocean;
		NB_ITER=nbIter;
		fenetre = new IHMSwing("jeu de la vie", this);
		initialiserMatrice(ocean);
	}

	public Controleur(IOcean ocean) {
		this(ocean, 1);
		infini=true;
	}

	
	private List<ArrayList<Color>> reduireBestioles(IOcean ocean){
		// Restreindre les Bestioles à leur couleur
		List<ArrayList<Color>> matrice = new ArrayList<ArrayList<Color>>(ocean.getNbColonnes());

		for (int j = 0; j < ocean.getNbLignes(); j++) {
			ILigneEau cases = ocean.get(j);
			ArrayList<Color> ligne = new ArrayList<Color> (cases.getNbColonnes());
			for (int i = 0; i < cases.getNbColonnes(); i++) {
				ligne.add(Controleur.getCouleur(cases.get(i)));
			}
			matrice.add(ligne);
		}
		return matrice;
	}
	
	private void initialiserMatrice(IOcean matriceBestioles) {
		
		fenetre.setMatrice(reduireBestioles(matriceBestioles));
	}

	public void etapeSuivante() {
		timer = new Timer(ATTENTE, this);
		timer.restart();
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == timer)
		{
			initialiserMatrice(ocean);
			ocean.etapeSuivante();
			fenetre.repaint();
			if (!infini) {nbIterCourant++;}
		}
		if (NB_ITER==nbIterCourant){
			timer.stop();
			nbIterCourant=0;
		}
	}

	/**
	 * Cette méthode privée permet de transformer une couleur du métier (enum Couleur) en couleur pour l'ihm (Color)
	 * NB: cette méthode est statique car elle ne dépend pas de l'instance de Controleur, son résultat ne dépend que de son paramètre
	 * Elle est rangée ici car elle sert de tampon entre le métier et l'ihm  
	 *  
	 * @param uneCase la case qui détermine sa couleur (celle-ci pouvant être la couleur de la case vide ou celle de son éventuel occupant)
	 * @return la couleur d'affichage selon les instances de la classe Color
	 */
	private static Color getCouleur(ICase uneCase) {
	
		Color reponse = Color.black;
		
		switch (uneCase.getCouleur()) {
		case BLEU_CLAIR :
			reponse = new Color(102,204,204);
			break;
		case BLEU_SOMBRE :
			reponse = new Color(0,0,102);
			break;
		case GRIS_CLAIR :
			reponse= Color.LIGHT_GRAY;
			break;
		case NOIR :
			reponse= Color.BLACK;
			break;
		case BLEU_GRIS :
			reponse= new Color(204,204,255);
			break;
		case BLEU_MARINE :
			reponse= new Color(51,51,153);
			break;
		case ORANGE :
			reponse = Color.ORANGE; 
			break;
		case ROUGE :
			reponse = Color.RED ;
			break;
		case VERT :
			reponse = Color.GREEN ;
			break;
		default:
			break;
		}
		
		return reponse;
	}	

}


