import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Panneau extends JPanel{
    public final static int MILLIS_WAIT = 100;
    private int width;
    private int height;

    private Tableau t;

    private Tableau[] nombre;

    private boolean pause;



    public Panneau (int width, int height) {
      this.width = width;
      this.height = height;
      Dimension size = new Dimension (width, height);
      setMinimumSize(size);
      setPreferredSize(size);
      setDoubleBuffered(true);

      this.pause = false;
      this.nombre = new Tableau[100];
      initNombre();


    }


    public synchronized void update(){
        repaint();

    }

    protected void initNombre(){
      for (int i=0; i<this.nombre.length;i++){
        this.nombre[i] = new Tableau(this,i*5,i*8,Color.WHITE);
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


    public void paint (Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground (Color.BLACK);
        g2.clearRect (0, 0, width, height);
        System.out.println("repaint");


        for(int i=0;i<this.nombre.length;i++){
          g2.setColor(this.nombre[i].getColor());
          g2.fillRect(i*7, this.height - this.nombre[i].getHeight(), Tableau.LARGEUR, this.nombre[i].getHeight());
        }

    }

    private void invert(int index, int j){

      Tableau temp;

      for(int i=0;i<this.nombre.length;i++){
        this.nombre[i].setColor(Color.WHITE);
      }

      temp = this.nombre[j];
      this.nombre[j] = this.nombre[index];
      this.nombre[index] = temp;
      this.nombre[index].setColor(Color.red);
    }

    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%% TRI %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    public void sortMax(){
      int max = this.nombre.length-1;

      if(Launcher.j < this.nombre.length){

        for(int i = Launcher.j;i<this.nombre.length;i++){
          if(this.nombre[i].getHeight() > this.nombre[max].getHeight()){
            max = i;
          }
        }

        invert(Launcher.j,max);
        this.sleep(50);
      }
        update();
    }

    public void sortMin(){
      int min = this.nombre.length-1;

      if(Launcher.j < this.nombre.length){

        for(int i = Launcher.j;i<this.nombre.length;i++){
          if(this.nombre[i].getHeight() < this.nombre[min].getHeight()){
            min = i;
          }
        }

        invert(Launcher.j,min);
        this.sleep(50);
      }
        update();
    }

    public void bogoSort(){
      //shuffle
      int index,j;
      Random random = new Random();
        index = random.nextInt(99);
        j = random.nextInt(99);

        invert(index,j);
        this.sleep(20);

        update();

  }

  public int bubbleSort(int i){
    boolean invert = false;
    while( !invert && i<this.nombre.length-1){
      if(this.nombre[i].getHeight() > this.nombre[i+1].getHeight()) {
        invert(i,i+1);
        this.sleep(20);
        invert = true;
        if(i>=1) i--;
      } else i++;
    }
    System.out.println(i);
    update();
    return i;
  }

  public void insertion(){

    int i, j;
   for (i = 1; i < this.nombre.length; ++i) {
       Tableau elem = this.nombre[i];
       for(int k=0;k<this.nombre.length;k++){
         this.nombre[k].setColor(Color.WHITE);
       }
       elem.setColor(Color.red);

       update();
       this.sleep(50);

       for (j = i; j > 0 && this.nombre[j-1].getHeight() > elem.getHeight(); j--)
           this.nombre[j] = this.nombre[j-1];
           this.nombre[j] = elem;

   }
  }





  private int partition(int low, int high) {
        int pivot = this.nombre[high].getHeight();
        int i = (low-1);
        for (int j=low; j<high; j++){
            if (this.nombre[j].getHeight() <= pivot){
                i++;

                // swap this.nombre[i] and this.nombre[j]
                Tableau temp = this.nombre[i];
                this.nombre[i] = this.nombre[j];
                this.nombre[j] = temp;
                update();
            }
        }

        Tableau temp = this.nombre[i+1];
        this.nombre[i+1] = this.nombre[high];
        this.nombre[high] = temp;


        return i+1;
    }

    public void sort(int low, int high){
        if (low < high){
            int pi = partition(low, high);

            sort(low, pi-1);
            sort(pi+1, high);
        }
    }

    private void sleep(int tps){
      try{
        Thread.currentThread().sleep(tps);
      } catch (Exception e){
      }
    }
}
