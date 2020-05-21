import java.awt.desktop.SystemEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Controleur extends Modele implements ActionListener {
    Modele modele;
    int nAction;
    int nJoueur;
    Cellule pos;
    Direction dir;

    public Controleur(Modele modele){
        this.modele = modele;
        this.pos = modele.celluleRandom();
        this.nAction = 3;
    }

    public void detectFin(){

    }

    public void move(Direction key){
        System.out.println("move");

        if( key == Direction.up && this.pos.y < HAUTEUR){
            this.dir = Direction.up;
            this.pos = getCellules(this.pos.x,this.pos.y+1);
            System.out.println(("up"));
        }

        if( key == Direction.down && this.pos.y != 0){
            this.dir = Direction.down;
            this.pos = getCellules(this.pos.x,this.pos.y-1);
        }

        if( key == Direction.left && this.pos.x != 0){
            this.dir = Direction.left;
            this.pos = getCellules(this.pos.x-1,this.pos.y);
        }

        if( key == Direction.right && this.pos.y < LARGEUR){
            this.dir = Direction.right;
            this.pos = getCellules(this.pos.x,this.pos.y-1);
        }
    }

    public void assecher(){
        // attribut des joueurs courant , numero d'action courante, 2 variables centrales qui voient qui s'occupe de quoi
        // faire tout ca dans le controleur, etat ds controleur, 6 etats possibles au total

    }

    public void recuperer(){

    }

    public void actionPerformed(ActionEvent e){
        modele.tour();
    }

}
