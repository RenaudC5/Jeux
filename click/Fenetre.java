import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//extends JFrame creera une fenetre au lancement du main
public class Fenetre extends JFrame{

	private JTextField timerText;
	private Timer timer;

	public Fenetre(){

		initComp();
	}


	public static void main(String args[]) {
 		java.awt.EventQueue.invokeLater(new Runnable() {
 			public void run() {
				//on creer une nouvelle fenetre qui extends jFrame et on l'affiche
 			new Fenetre().setVisible(true);
 			}
 		});
 	}

 	public void initComp(){

 		//Layout
		//on ajoute le MouseListener au la fenetre, à chaque chose que fera la souris ça activera les evenements du MouseEventDemo
		this.addMouseListener(new MouseEventDemo());
		//si on clique sur la croix en haut a droite ça ferme la fenetre et ça arrete le programme
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		//on set la taille de la fenetre (en px)
		this.setSize(new Dimension(800, 800));
		//on la rend visible
		this.setVisible (true);


 	}
}
