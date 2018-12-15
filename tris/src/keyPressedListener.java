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

          if(e.getKeyChar() == 'b') {
            p1.reset();
            Launcher.setTri("BOGO");
            p1.setChange(true);
          }
          if(e.getKeyChar() == 'x') {
            p1.reset();
            Launcher.setTri("MAX");
            p1.setChange(true);
          }
          if(e.getKeyChar() == 'm') {
            p1.reset();
            Launcher.setTri("MIN");
            p1.setChange(true);
          }
          if(e.getKeyChar() == 'i') {
            p1.reset();
            Launcher.setTri("INSERTION");
            p1.setChange(true);
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
