import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Launcher {

    private static Panneau p1;

    public static void main(String args[]) {
		p1 = new Panneau(800, 600);
        testComponent("TP4", p1);

        for(int i=0;i<2000000;i++){
                p1.move();
                try{
					Thread.currentThread().sleep(50);
				} catch (Exception e){
					e.printStackTrace();
					}
				}
    }

    public static final void testComponent (final String title, final Panneau component) {
        SwingUtilities.invokeLater (new Runnable () {
            public void run () {
                JFrame jFrame = new JFrame(title);
                jFrame.addKeyListener(new keyPressedListener(p1));

                jFrame.addWindowListener (new WindowAdapter() {
                    public void windowClosing (WindowEvent e) {
                        System.exit (0);
                    }
                });
                jFrame.getContentPane().add (component, BorderLayout.CENTER);
                jFrame.pack ();
                Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
                Dimension size = jFrame.getSize ();
                jFrame.setLocation ((screenSize.width - size.width)/4, (screenSize.height - size.height)/4);
                jFrame.setSize(new Dimension(800, 800));
                jFrame.setVisible (true);


            }
        });
    }
}
