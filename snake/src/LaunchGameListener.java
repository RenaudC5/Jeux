import java.awt.event.*;
public class LaunchGameListener implements ActionListener {

private GUI gui;
        public LaunchGameListener(GUI gui){

            //this.gui = gui();
        }

    public void actionPerformed(ActionEvent e) {
        gui.launchGame();
    }
}
