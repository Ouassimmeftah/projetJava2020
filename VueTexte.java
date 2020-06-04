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
        paint(g);
        super.repaint();
    }

    public void paint(Graphics g){
        g.setColor(Color.pink);
        g.drawString("j1",(int)(getWidth()*0.8),(int)(getHeight()*0.8));
    }

    public void update(){
        repaint();
    }

}