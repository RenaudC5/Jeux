import javax.swing.*;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;

public class Tableau implements Runnable {
    Panneau panneau;
    private int width;
    private int height;
    private Color color;
    private int x, y;
    private boolean visible;
    private int vitX;
    private int vitY;
    private boolean monte;
    private boolean droite;

    public Tableau(Panneau panneau, int x, int y, int width, int height, Color color,int vitX, int vitY) {
        this.panneau = panneau;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        visible = true;
        this.vitX = vitX;
        this.vitY = vitY;
        this.monte = false;
        this.droite = true;
    }

    public void run() {

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVitY(int y) {
        this.vitY = y;
    }
    public int getVitY() {
        return this.vitY;
    }
    public void setVitX(int x) {
        this.vitX = x;
    }
    public int getVitX() {
        return this.vitX;
    }

    public void changeMonte(){
			if (this.monte){
                this.monte = false;
                this.setVitY(-5);
            }
			else {
                this.monte = true;
                this.setVitY(5);
            }
	}
    public void changeDroite(){
			if (this.droite){

                this.droite = false;
                this.setVitX(-5);
            }
			else {
                this.droite = true;
                this.setVitX(5);
            }
	}

    public void printTableau(){

        System.out.println("X : "+this.x);
        System.out.println("Y : "+this.y);
    }

	public boolean getMonte(){return this.monte;}
	public boolean getDroite(){return this.droite;}
}
