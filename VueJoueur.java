import javax.swing.*;
import java.awt.*;

public class VueJoueur extends JPanel implements Observer {
    public Modele modele;
    private final static int TAILLE = 10;

    public VueJoueur(Modele modele){
        this.modele = modele;
        modele.addObserver(this);
        Dimension dim = new Dimension(TAILLE*modele.LARGEUR, TAILLE*modele.HAUTEUR);
        this.setPreferredSize(dim);
    }

    public void paintComponents(Graphics g) {
        super.repaint();
        g.drawOval(0,0,getWidth(),getHeight());
    }

    public void update(){
        repaint();
    }

}
