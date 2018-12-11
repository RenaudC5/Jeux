import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class keyPressedListener implements KeyListener {

    private Panneau p1;


    public keyPressedListener(){
      System.out.println("init Key pressed listener");
    }
    public void keyTyped(KeyEvent e) {


          Launcher.pause();
          if(e.getKeyChar() == ' ') Launcher.reset();


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
