import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class keyPressedListener implements KeyListener {

    private Panneau p1;


    public keyPressedListener(Panneau p1){
      this.p1 = p1;
    }
    public void keyTyped(KeyEvent e) {



          if(e.getKeyChar() == ' ') p1.reset();
          if(e.getKeyChar() == 'z') {
            p1.pause();
          }


    }

    /** Handle the key-pressed event from the text field. */
    public void keyPressed(KeyEvent e) {

    }

    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) {

    }

    private void displayInfo(KeyEvent e, String keyStatus){
    }
}
