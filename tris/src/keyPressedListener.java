import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class keyPressedListener implements KeyListener {

    private Panneau p1;
    private static final int DROITE=0;
    private static final int BAS=1;
    private static final int GAUCHE=2;
    private static final int HAUT=3;

    public keyPressedListener(Panneau p1){

        this.p1 = p1;


    }
    public void keyTyped(KeyEvent e) {

        if(e.getKeyChar() == 'z'){p1.changeDirection(HAUT);}
        if(e.getKeyChar() == 'q'){p1.changeDirection(GAUCHE);}
        if(e.getKeyChar() == 's'){p1.changeDirection(BAS);}
        if(e.getKeyChar() == 'd'){p1.changeDirection(DROITE);}
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
