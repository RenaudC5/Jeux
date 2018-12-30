import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Panneau extends JPanel{
    private int width;
    private int height;

    private Carre carre;
    private double tps;

    private final int HAUTEUR_SAUT = 500;

    private final double G=9.81;

    private boolean monte;

    private boolean jumping;



    public Panneau (int width, int height) {
      this.tps = 0;
        this.width = width;
        this.height = height;
        Dimension size = new Dimension (width, height);
        setMinimumSize(size);
        setPreferredSize(size);
        setDoubleBuffered(true);

        //le personnage

        this.carre = new Carre(250,500,10,Color.RED);
    }

    public void tombe(){
      if(!monte){
        if(!(this.carre.getYpos() > this.height)){
        this.jumping = true;
        //On modifie la vitesse de y
        this.tps = this.tps + 0.01;
        double newVitY = 0.5 * G * Math.pow(this.tps,2);
        int nvitY = (int) newVitY;
        this.carre.setYpos(this.carre.getYpos()+nvitY);
      } else this.jumping = false; 
        update();

      } else monte();
    }

    public void monte(){
      if(monte){
        if(this.tps > 0.2){
            //on défini l'accélération de départ
            double newVitY = 0.5 * G * Math.pow(this.tps,2);
            int nvitY = (int) newVitY;
            this.carre.setYpos(this.carre.getYpos()-nvitY);
            this.tps = this.tps - 0.01;
            update();
        } else {
          this.changeMonte();
        }
      }
    }

    public void droite(int d){
      System.out.println("DROITE");
      this.carre.setXpos(this.carre.getXpos()+d);
    }
    public void gauche(int g){
      this.carre.setXpos(this.carre.getXpos()-g);
    }

    public void remonte(){
      this.carre.setYpos(0);
      this.tps = 0;
    }

    public synchronized void update(){
        repaint();

    }


    public void paint (Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground (new Color(242, 237, 174));
        g2.clearRect (0, 0, width, height);

        g2.setColor(this.carre.getColor());
        g2.fillRect(this.carre.getXpos(),this.carre.getYpos(),this.carre.getCote(),this.carre.getCote());
    }

    public void changeMonte(){
      if(this.monte) this.tps = 0.4;
      this.monte = !this.monte;

    }

    public void setTps(long tps){
      this.tps = tps;
    }

    public boolean isJumping(){
      System.out.println(this.jumping);
      return this.jumping;

    }
  }
