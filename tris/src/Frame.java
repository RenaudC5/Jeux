import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Frame extends JFrame {

  private String title;
  private Panneau component;
  private JButton playPause;

  public Frame(String s,Panneau p1){
    this.title = s;
    this.component = p1;

    this.setTitle(title);
    this.addKeyListener(new keyPressedListener(p1));
    this.addWindowListener (new WindowAdapter() {
        public void windowClosing (WindowEvent e) {
            System.exit (0);
        }
    });
    this.getContentPane().add(component, BorderLayout.CENTER);
    //jFrame.getContentPane().add(button, BorderLayout.SOUTH);

    JPanel panel = new JPanel();

    JButton but1 = new JButton("MAX");
    but1.setFocusable(false);
    JButton but2 = new JButton("MIN");
    but2.setFocusable(false);
    JButton but3 = new JButton("BOGO");
    but3.setFocusable(false);
    JButton but4 = new JButton("INSERTION");
    but4.setFocusable(false);
    JButton but5 = new JButton("RESET");
    but5.setFocusable(false);
    this.playPause = new JButton("PAUSE");
    playPause.setFocusable(false);
    but1.addActionListener(new ClicListener(this,component,"MAX"));
    but2.addActionListener(new ClicListener(this,component,"MIN"));
    but3.addActionListener(new ClicListener(this,component,"BOGO"));
    but4.addActionListener(new ClicListener(this,component,"INSERTION"));
    but5.addActionListener(new ClicListener(this,component,"RESET"));
    playPause.addActionListener(new ClicListener(this,component,"PLAYPAUSE"));
    panel.add(but1);
    panel.add(but2);
    panel.add(but3);
    panel.add(but4);
    panel.add(but5);
    panel.add(playPause);

    this.getContentPane().add(panel, BorderLayout.SOUTH);

    this.pack ();
    Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
    Dimension size = getSize ();
    this.setLocation ((screenSize.width - size.width)/4, (screenSize.height - size.height)/4);
    this.setSize(new Dimension(800, 800));
    this.getContentPane().setBackground( Color.black );
    this.setVisible (true);
    this.setFocusable (true);

  }

  public void addComp(Component comp, String dir){
    this.getContentPane().add(comp, dir);
  }

  public void setFocusFrame(boolean b){
    this.setFocusable(b);

  }

  public void changeStatePlayPause(){
    if (this.playPause.getText() == "PLAY") this.playPause.setText("PAUSE");
    else this.playPause.setText("PLAY");
  }




}
