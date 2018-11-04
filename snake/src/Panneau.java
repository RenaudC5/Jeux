import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Panneau extends JPanel{
    public final static int MILLIS_WAIT = 100;
    private int width;
    private int height;

    private ArrayList <Tableau> serpent;
    private Tableau t;
    private Tableau pomme;

    private int snakeLength;

    private Tableau mem;

    private boolean ajouter = false;

    private static final int VITESSE = 20;


    public Panneau (int width, int height) {
        this.width = width;
        this.height = height;
        Dimension size = new Dimension (width, height);
        setMinimumSize(size);
        setPreferredSize(size);
        setDoubleBuffered(true);

        this.serpent = new ArrayList<Tableau>();
        this.snakeLength = 0;
        //premier carré
        this.t = new Tableau(this, 40, 240, 20, 20, Color.GREEN,0,0);



        serpent.add(t);
        printSerpent();
        this.mem = serpent.get(0);

        newFruit();

    }


    public synchronized void update(){
        repaint();

    }


    public void paint (Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground (Color.WHITE);
        g2.clearRect (0, 0, width, height);
        int i=0;

        while (i < serpent.size()){

            Tableau tab = serpent.get(i);

            g2.setColor(tab.getColor());
            g2.fillRect(tab.getX(), tab.getY(), tab.getWidth(), tab.getHeight());
            i++;
        }
        g2.setColor(this.pomme.getColor());
        g2.fillRect(this.pomme.getX(), this.pomme.getY(), this.pomme.getWidth(), this.pomme.getHeight());

    }

    public void move(){

        boolean first = true;
        int i = 0;
        while(i < serpent.size()){
            t = serpent.get(i);

            if(!first){
                this.serpent.set(i,mem);

                this.mem = new Tableau(this,t.getX(),t.getY(),20,20,Color.GREEN,t.getVitX(),t.getVitY());
            } else {
                first = false;
                this.mem = new Tableau(this,t.getX(),t.getY(),20,20,Color.GREEN,t.getVitX(),t.getVitY());


                int vitX = t.getVitX();
                int vitY = t.getVitY();


                if(vitX>0){
                    if(vitX+t.getX() > this.width-2*(t.getWidth())){
                        endGame();
                    }
                    t.setX(t.getX()+vitX);
                } else if(vitX<0){

                    if(vitX+t.getX() < 0){
                        endGame();

                    }
                    t.setX(t.getX()+vitX);
                }

                if(vitY>0){
                    if(vitY+t.getY() > this.height-2*(t.getHeight())){
                        endGame();

                    }
                    t.setY(t.getY()+vitY);
                } else if(vitY<0){

                    if(vitY+t.getY() < 0){
                        endGame();

                    }
                    t.setY(t.getY()+vitY);
                }
            }

            i++;
        }

        if(this.serpent.get(0).getX() == pomme.getX() && this.serpent.get(0).getY() == pomme.getY()){

            //collision
            addSnakeLength();
            newFruit();


        }

        if(serpent.size() > 3){
            for (int j = 2;j<serpent.size()-1;j++){
                    if(serpent.get(0).getX() == serpent.get(j).getX() && serpent.get(0).getY() == serpent.get(j).getY()) endGame();
            }
        }

        update();
    }

    public void changeDirection(int dir){

        for(int i=0;i<this.serpent.size();i++){
            switch(dir){
                //droite
                case 0 :
                    if(this.serpent.get(0).getVitX() >= 0){
                        this.serpent.get(0).setVitX(VITESSE);
                        this.serpent.get(0).setVitY(0);
                    }

                break;
                //bas
                case 1 :
                    if(this.serpent.get(0).getVitY() >= 0){
                        this.serpent.get(0).setVitX(0);
                        this.serpent.get(0).setVitY(VITESSE);
                    }
                break;
                //gauche
                case 2 :
                if(this.serpent.get(0).getVitX() <= 0){
                    this.serpent.get(0).setVitX(-VITESSE);
                    this.serpent.get(0).setVitY(0);
                }
                break;
                //haut
                case 3 :
                    if(this.serpent.get(0).getVitY() <= 0){
                        this.serpent.get(0).setVitX(0);
                        this.serpent.get(0).setVitY(-VITESSE);
                    }
                break;
            }
        }
    }

    private void newFruit(){
        int X = 0;
        int Y = 0;
        boolean good = false;
        while(!good){
            X = new Random().nextInt(39);
            Y = new Random().nextInt(29);

            for(int i=0;i<serpent.size();i++){
                if(X != serpent.get(i).getX() || Y != serpent.get(i).getY()) good = true;
            }
        }


        pomme = new Tableau(this, X*20, Y*20, 20, 20, Color.RED,0,0);

    }

    public void addSnakeLength(){
        Tableau tab =  new Tableau(this,this.serpent.get(this.snakeLength).getX(),this.serpent.get(this.snakeLength).getY(),20,20,Color.GREEN,this.serpent.get(this.snakeLength).getVitX(),this.serpent.get(this.snakeLength).getVitY());
        this.serpent.add(tab);
        ajouter = true;
        this.snakeLength++;
    }

    public void printSerpent(){

        for (int i=0;i<serpent.size();i++){
            System.out.println("serpent["+i+"] = ["+serpent.get(i).getX()+","+serpent.get(i).getY()+"]");
        }
    }

    public void endGame(){

        this.serpent.clear();
        this.t = new Tableau(this, 40, 240, 20, 20, Color.GREEN,0,0);
        serpent.add(t);
        this.snakeLength = 0;
    }
}
