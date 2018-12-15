import java.awt.*;
import java.awt.event.*;
public class ClicListener implements ActionListener{

  private Frame f1;
  private Panneau p1;
  private String str;

  public ClicListener(Frame f1,Panneau p1,String str){
    this.f1 = f1;
    this.p1 = p1;
    this.str = str;
  }

  public void actionPerformed(ActionEvent e){
    f1.setFocusFrame(true);

    if(str == "MAX") {
      p1.reset();
      Launcher.setTri("MAX");
      p1.setChange(true);
    }
    if(str == "MIN") {
      p1.reset();
      Launcher.setTri("MIN");
      p1.setChange(true);
    }
    if(str == "BOGO") {
      p1.reset();
      Launcher.setTri("BOGO");
      p1.setChange(true);
    }
    if(str == "INSERTION") {
      p1.reset();
      Launcher.setTri("INSERTION");
      p1.setChange(true);
    }
    if(str == "INSERTION") {
      p1.reset();
      Launcher.setTri("INSERTION");
      p1.setChange(true);
    }
    if(str == "RESET") p1.reset();
    if(str == "PLAYPAUSE") {
      p1.pause();
      f1.changeStatePlayPause();
    }


  }

}
