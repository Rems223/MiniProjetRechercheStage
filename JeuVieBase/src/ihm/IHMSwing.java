package ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import controleur.Controleur;


public class IHMSwing extends JFrame{

	private static final long serialVersionUID = 1L;
	final static int COTE = 3;

	private static final int deltaY = 16;
	private static final int deltaX = 4;

	private static int IHM_LARGEUR;
	private static int IHM_LONGUEUR;

	private List<ArrayList<Color>> matrice = null;

	public void setMatrice(List<ArrayList<Color>> matrice) {
		this.matrice = matrice;
		IHM_LONGUEUR = matrice.size() * (COTE + 1) + 1;
		if (!matrice.isEmpty()) {
			IHM_LARGEUR= ((matrice.get(0)).size()) * (COTE + 1) + 1;
		}
		setSize(IHM_LARGEUR+deltaX, IHM_LONGUEUR+deltaY);
	}

	class Fermeur extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	public IHMSwing(String title, Controleur controleur) {
		super(title);
		addWindowListener(new Fermeur());
		addMouseListener(new EcouteSouris(this, controleur));
		setVisible(true);
	}

	public void paint(Graphics g) {
		int y = 0;
		g.setColor(Color.gray);
		g.fillRect(deltaX, deltaY, IHM_LARGEUR, IHM_LONGUEUR);
		for (List<Color> ligne : matrice) {
			int x = 0;
			for (Color point : ligne) {
				g.setColor(point);
				g.fillRect(x+deltaX, y+deltaY, COTE, COTE);
				x += COTE + 1;
			}
			y += COTE + 1;
		}

	}

}
