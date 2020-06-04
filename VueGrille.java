import javax.swing.*;
import java.awt.*;


class VueGrille extends JPanel implements Observer {
    private Modele modele;
    private final static int TAILLE = 20;

    public VueGrille(Modele modele){
        this.modele = modele;
        modele.addObserver(this);
        Dimension dim = new Dimension(TAILLE*modele.LARGEUR, TAILLE*modele.HAUTEUR);
        this.setPreferredSize(dim);
    }

    public void update() {
        repaint();
    }

    public void paint(Graphics g, Cellule c, int x, int y){
        if(c.etat ==0){
            g.setColor(Color.WHITE);
        }else if( c.etat ==1){
            g.setColor(Color.blue);
        } else if(c.etat ==2){
            g.setColor(Color.BLACK);
        } else {
            g.setColor(Color.gray);
        }
        g.fillRect(x,y,TAILLE-1,TAILLE-1);

    }

    public void clear(Graphics graphics){
        graphics.setColor(new Color(19, 19,19, 4));

        graphics.fillRect(0, 0, getWidth(), getHeight());
    }

    public void paintComponent(Graphics graphics){
        clear(graphics);
        for(int i = 1; i <modele.LARGEUR;i++){
            for(int j = 1; j<=modele.HAUTEUR;j++){
                paint(graphics,modele.getCellules(i,j),(i-1)*TAILLE, (j-1)*TAILLE);
            }
        }
        super.repaint();
    }

    public int getTaille(){
        return TAILLE;
    }
}