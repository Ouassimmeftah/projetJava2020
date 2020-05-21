import javax.swing.*;
import java.awt.*;


class VueGrille extends JPanel implements Observer {
    private Modele modele;
    private final static int TAILLE = 12;

    public VueGrille(Modele modele){
        this.modele = modele;
        modele.addObserver(this);
        Dimension dim = new Dimension(TAILLE*modele.LARGEUR, TAILLE*modele.HAUTEUR);
        this.setPreferredSize(dim);
    }

    public void update() {
        repaint();
    }

    public void paintCellule(Graphics graphics){
        super.repaint();
        for(int i = 1; i <modele.LARGEUR;i++){
            for(int j = 1; j<=modele.HAUTEUR;j++){
                paint(graphics,modele.getCellules(i,j),(i-1)*TAILLE, (j-1)*TAILLE);

            }
        }
    }

}
