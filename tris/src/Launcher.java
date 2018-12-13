import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Launcher {

    private static Panneau p1;

    private static final String TRI = "BONGO";

    public static void main(String args[]) {
		p1 = new Panneau(800, 600);
      testComponent("tris", p1);

      while(true){
        p1.insertion();
      }

    }

    public static final void testComponent (final String title, final Panneau component) {
        SwingUtilities.invokeLater (new Runnable () {
            public void run () {
              //JButton button = new JButton("click me");
              //button.addActionListener(new ShuffleListener(p1));
                JFrame jFrame = new JFrame(title);
                jFrame.addKeyListener(new keyPressedListener(p1));
                jFrame.addWindowListener (new WindowAdapter() {
                    public void windowClosing (WindowEvent e) {
                        System.exit (0);
                    }
                });
                jFrame.getContentPane().add(component, BorderLayout.CENTER);
                //jFrame.getContentPane().add(button, BorderLayout.SOUTH);
                jFrame.pack ();
                Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
                Dimension size = jFrame.getSize ();
                jFrame.setLocation ((screenSize.width - size.width)/4, (screenSize.height - size.height)/4);
                jFrame.setSize(new Dimension(800, 800));
                jFrame.getContentPane().setBackground( Color.black );
                jFrame.setVisible (true);


            }
        });
    }


}
