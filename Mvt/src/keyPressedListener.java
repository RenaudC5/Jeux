import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class keyPressedListener implements KeyListener {

    private Panneau p1;
    private int droite;
    private int gauche;

    private int pas;

    public keyPressedListener(Panneau p1){

        this.p1 = p1;
        this.droite = 2;
        this.gauche = 2;
        this.pas = 1;


    }
    public void keyTyped(KeyEvent e) {

        if(e.getKeyChar() == ' '){
          if(!p1.isJumping()){
            p1.monte();
            p1.setTps(1);
            p1.changeMonte();
          }
        } else if(e.getKeyChar() == 'q'){
          p1.gauche(2);
        } else if(e.getKeyChar() == 'd'){
          p1.droite(2);
        }



    }

    /** Handle the key-pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
      if(e.getKeyChar() == 'd') {
        p1.droite(droite);
        this.droite = 2*this.pas;
        this.pas++;
      }
      else if(e.getKeyChar() == 'q') {
        p1.gauche(gauche);
        this.gauche = 2*this.pas;
        this.pas++;
      } else {

      }
    }

    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) {
      this.pas = 1;
      this.droite = 2;
      this.gauche = 2;
    }

    private void displayInfo(KeyEvent e, String keyStatus){
    }
}
