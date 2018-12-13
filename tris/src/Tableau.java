import javax.swing.*;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;



public class Tableau implements Runnable {

    public static final int LARGEUR = 8;
    Panneau panneau;
    private int height;
    private Color color;
    private int x;

    public Tableau(Panneau panneau, int height, int x,Color color) {
        this.panneau = panneau;
        this.height = height;
        this.x = x;
        this.color = color;
    }

    public void run() {

    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX(){return this.x;}

    public Color getColor(){return this.color;}

}
