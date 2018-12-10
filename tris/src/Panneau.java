import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Panneau extends JPanel{
    public final static int MILLIS_WAIT = 100;
    private int width;
    private int height;

    private Tableau t;

    private Tableau[] nombre;



    public Panneau (int width, int height) {
      this.width = width;
      this.height = height;
      Dimension size = new Dimension (width, height);
      setMinimumSize(size);
      setPreferredSize(size);
      setDoubleBuffered(true);

      this.nombre = new Tableau[100];
      initNombre();

    }


    public synchronized void update(){
        repaint();

    }

    private void initNombre(){
      for (int i=0; i<this.nombre.length;i++){
        this.nombre[i] = new Tableau(this,i*5,i*8,Color.BLUE);
        //Tableau(Panneau panneau, int height, int x,Color color)
      }
      //shuffle
      int index;
      Tableau temp;
      Random random = new Random();
      for (int i = 0; i<this.nombre.length; i++){
        temp = this.nombre[i];
        index = random.nextInt(99);
        this.nombre[i] = this.nombre[index];
        this.nombre[index] = temp;

      }
    }

    public void sortMax(int i){
      int max = 0;
      int index = 100-i;

      for(int j=0;j<this.nombre.length-i;j++){
        if(this.nombre[j].getHeight() > this.nombre[max].getHeight()) max = j;
      }

      //on echange les valeurs
      Tableau temp;
      System.out.println("index : "+index);
      System.out.println("this.nombre.length : "+this.nombre.length);
      temp = this.nombre[index-1];
      this.nombre[index-1] = this.nombre[max];
      this.nombre[max] = temp;

      update();

    }


    public void paint (Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground (Color.WHITE);
        g2.clearRect (0, 0, width, height);

        g2.setColor(this.nombre[0].getColor());
        for(int i=0;i<this.nombre.length;i++){
          g2.fillRect(i*7, this.height - this.nombre[i].getHeight(), Tableau.LARGEUR, this.nombre[i].getHeight());
        }

    }
}