import java.awt.*;
public class Carre implements Runnable{

  private int cote;
  private Color color;

  private int xPos;
  private int yPos;

  private int vitX;
  private int vitY;

  public Carre(int x, int y,int cote,Color color) {
    this.cote = cote;
    this.color = color;
    this.yPos = y;
    this.xPos=  x;

    this.vitX = 0;
    this.vitY = 0;
  }

  public void setCote(int cote) {this.cote = cote;}
  public void setColor(Color color){this.color = color;}

  public Color getColor(){return this.color;}
  public int getCote(){return this.cote;}

  public void setVitX(int x){this.vitX = x;}
  public void setVitY(int y){this.vitY = y;}

  public int getVitX(){return this.vitX;}
  public int getVitY(){return this.vitY;}

  public void setXpos(int x){this.xPos = x;}
  public void setYpos(int y){this.yPos = y;}

  public int getXpos(){return this.xPos;}
  public int getYpos(){return this.yPos;}

  public void run(){}

}
