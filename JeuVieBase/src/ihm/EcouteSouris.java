package ihm;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controleur.Controleur;


public class EcouteSouris extends MouseAdapter {

	IHMSwing fenetre = null;
	Controleur controleur;
	
	public EcouteSouris(IHMSwing fenetre, Controleur controleur) {
		super();
		this.fenetre = fenetre;		
		this.controleur = controleur;		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		controleur.etapeSuivante();
	}

	
	
}
