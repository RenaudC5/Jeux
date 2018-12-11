import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Launcher {

    private static Panneau p1;
    private static boolean pause;
    private static int j;

    private static final String TRI = "MAX";

    public static void main(String args[]) {
		p1 = new Panneau(800, 600);
        testComponent("tris", p1);
        for(int i=0;i<1000000;i++){

                try{

					Thread.currentThread().sleep(500);

          switch(Launcher.TRI){
            case "MAX" :
              if(!Launcher.pause) {
                Launcher.j++;
                p1.sortMax(i);
              }
              break;
            case "MIN" :
              if(!Launcher.pause) {
                Launcher.j++;
                p1.sortMin(j);
              }
              break;
            case "BONGO" :
              if(!Launcher.pause) {
                p1.bogoSort();
              }
              break;
            case "BUBBLE" :
              if(!Launcher.pause) {
                Launcher.j = p1.bubbleSort(Launcher.j);
              }
              break;
            }
          //p1.bogoSort();
          //index = p1.bubbleSort(index);
				} catch (Exception e){
					e.printStackTrace();
				}
      }
    }

    public static final void testComponent (final String title, final Panneau component) {
        SwingUtilities.invokeLater (new Runnable () {
            public void run () {
              //JButton button = new JButton("click me");
              //button.addActionListener(new ShuffleListener(p1));
                JFrame jFrame = new JFrame(title);
                jFrame.addKeyListener(new keyPressedListener());
                Launcher.pause = false;
                jFrame.addWindowListener (new WindowAdapter() {
                    public void windowClosing (WindowEvent e) {
                        System.exit (0);
                    }
                });
                jFrame.getContentPane().add (component, BorderLayout.CENTER);
                //jFrame.getContentPane().add(button, BorderLayout.SOUTH);
                jFrame.pack ();
                Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
                Dimension size = jFrame.getSize ();
                jFrame.setLocation ((screenSize.width - size.width)/4, (screenSize.height - size.height)/4);
                jFrame.setSize(new Dimension(800, 800));
                jFrame.setVisible (true);


            }
        });
    }

    protected static void pause(){
      Launcher.pause = (!Launcher.pause);
      System.out.println("PAUSE !");
    }

    protected static void reset(){
      Launcher.p1.initNombre();
      Launcher.j = 0;
    }
}
