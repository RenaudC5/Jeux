import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Launcher {

    private static Panneau p1;

    private static String tri;

    public static void main(String args[]) {
		p1 = new Panneau(800, 600);
      testComponent("tris", p1);

      while(true){
        p1.setChange(false);
        switch (Launcher.tri){
          case "BOGO" : {
              p1.bogoSort();
              break;
          }
          case "MAX" : {
              p1.sortMax();
              break;
          }
          case "MIN" : {
              p1.sortMin();
              break;
          }
          case "INSERTION" :{
              p1.insertion();
          }
        }

      }

    }

    public static final void testComponent (final String title, final Panneau component) {
      Launcher.tri = "MAX";
        SwingUtilities.invokeLater (new Runnable () {
            public void run () {


              //JButton button = new JButton("click me");
              //button.addActionListener(new ShuffleListener(p1));
              Frame frame = new Frame("Tris",component);

            }
        });
    }

    public static void setTri(String s){
      Launcher.tri = s;
    }


}
