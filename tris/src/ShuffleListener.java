import java.awt.*;
import java.awt.event.*;
public class ShuffleListener implements ActionListener{

  private Panneau p1;

  public ShuffleListener(Panneau p1){
    this.p1 = p1;
  }

  public void actionPerformed(ActionEvent e){
    p1.initNombre();
  }

}
