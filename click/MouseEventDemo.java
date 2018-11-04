import java.awt.event.*;
public class MouseEventDemo implements MouseListener {

    private Fenetre fenetre;

    public MouseEventDemo(Fenetre fenetre){

        this.fenetre = fenetre;
    }

    public void mousePressed(MouseEvent e) {
       //TODO
    }

    public void mouseReleased(MouseEvent e) {
      //TODO
    }

    public void mouseEntered(MouseEvent e) {
      //TODO
    }

    public void mouseExited(MouseEvent e) {
       //TODO
    }

    //a chaque clic de la souris ça lance la méthode
    public void mouseClicked(MouseEvent e) {
       System.out.println("X : "+e.getX()+"\nY : "+e.getY());
       fenetre.mouseClicDraw(e.getX(),e.getY());
    }


}
