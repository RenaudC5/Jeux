import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
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
		this.addMouseListener(new MouseEventDemo(this));
		//si on clique sur la croix en haut a droite ça ferme la fenetre et ça arrete le programme
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		//on set la taille de la fenetre (en px)
		this.setSize(new Dimension(400, 400));
		//on la rend visible
		this.setResizable(false);
		this.setTitle("Hello World");
		this.setVisible (true);


 	}

		public void paint(Graphics draw){
      getContentPane().setBackground(Color.WHITE);
    }

	public void mouseClicDraw(int x, int y){
		Graphics g = this.getGraphics();
		int red = new Random().nextInt(255);
		int green = new Random().nextInt(255);
		int blue = new Random().nextInt(255);
		g.setColor(new Color(red,green,blue));
		int r = 10;
		x = x-(r/2);
		y = y-(r/2);
		g.fillOval(x,y,r,r);
	}
}
