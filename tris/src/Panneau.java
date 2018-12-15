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
    private boolean change;

    private int cpt;



    public Panneau (int width, int height) {
      this.width = width;
      this.cpt = 0;
      this.height = height;
      Dimension size = new Dimension (width, height);
      setMinimumSize(size);
      setPreferredSize(size);
      setDoubleBuffered(true);

      this.pause = false;
      this.change = false;
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
      update();
    }


    public void paint (Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground (Color.BLACK);
        g2.clearRect (0, 0, width, height);

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

    /*public void sortMax(){
      int max = this.nombre.length-1;

      if(j < this.nombre.length){

        for(int i = Launcher.j;i<this.nombre.length;i++){
          if(this.nombre[i].getHeight() > this.nombre[max].getHeight()){
            max = i;
          }
        }

        invert(Launcher.j,max);
      }
        update();
    }*/



    public void sortMin(){
      if(!this.pause){
          if(this.cpt <= 0) this.cpt = 0;
        while(this.cpt < this.nombre.length && !(this.pause) && !change){
          int min = this.nombre.length-1;

          if(!this.pause){
            for(int i = this.cpt;i<this.nombre.length;i++){

              if(this.nombre[i].getHeight() < this.nombre[min].getHeight()){
                min = i;
              }
            }
              invert(this.cpt,min);
              sleep(50);
              update();
              this.cpt++;
            }
          }
      }
    }

    public void sortMax(){
      sleep(1);
      //sans la ligne ci dessus, le tri bug (???)
      if(!this.pause){
        if(this.cpt <= 0) this.cpt = this.nombre.length-1;

        while(this.cpt > 0 && !(this.pause) && !change){

          int max = 0;

          if(!this.pause){
            for(int i = this.cpt;i>0;i--){

              if(this.nombre[i].getHeight() > this.nombre[max].getHeight()){
                max = i;
              }
            }
              invert(this.cpt,max);
              sleep(50);
              update();
              this.cpt--;
            }
          }
      }
    }

    public void bogoSort(){
      //shuffle
      sleep(1);
      if(!pause){
        Random rand = new Random();
        int j = rand.nextInt(this.nombre.length);
        int i = rand.nextInt(this.nombre.length);
        invert(j,i);
        update();
        this.sleep(10);
      }
  }

  public void bubbleSort(){

    sleep(1);
    if(!pause){
      if(this.cpt <0) this.cpt = 0;
      boolean invert = false;
      while( !invert && this.cpt<this.nombre.length-1){
        if(this.nombre[this.cpt].getHeight() > this.nombre[this.cpt+1].getHeight()) {
          invert(this.cpt,this.cpt+1);
          this.sleep(10);
          invert = true;
          if(this.cpt>=1) this.cpt--;
        } else this.cpt++;
      }
      update();
    }
  }

  public void insertion(){

    int j;
   while(cpt < this.nombre.length && !change){
     sleep(1);
     if(this.cpt < 0) this.cpt = 1;
     if(!pause){

       Tableau elem = this.nombre[this.cpt];
       for(int k=0;k<this.nombre.length;k++){
         this.nombre[k].setColor(Color.WHITE);
       }
       elem.setColor(Color.red);

       update();
       this.sleep(50);

       for (j = this.cpt; j > 0 && this.nombre[j-1].getHeight() > elem.getHeight(); j--) this.nombre[j] = this.nombre[j-1];
       if(j>0) this.nombre[j] = elem;
       else this.nombre[0] = elem;
        this.cpt++;
    }


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
        e.printStackTrace();
      }
    }

    protected void pause(){
      this.pause = (!this.pause);
    }

    protected void reset(){
      initNombre();
      this.cpt = -1;
      update();
    }

    protected void setChange(boolean b){
      this.change = b;
    }
}
