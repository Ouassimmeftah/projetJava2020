import javax.swing.*;
import java.awt.*;

class VueTexte extends JPanel implements Observer {
    public Modele modele;
    private final static int TAILLE = 10;

    public VueTexte(Modele modele){
        this.modele = modele;
        modele.addObserver(this);
        Dimension dim = new Dimension(300, TAILLE*modele.HAUTEUR);
        this.setPreferredSize(dim);
    }

    public void paintComponents(Graphics g) {
        super.repaint();
        g.drawString("Joueur 1",300,200);

    }

    public void update(){
        repaint();
    }

}
