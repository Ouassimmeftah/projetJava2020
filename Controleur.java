import java.awt.desktop.SystemEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Controleur extends Modele implements ActionListener {
    Modele modele;
    int nAction;
    int nJoueur;
    Cellule pos;
    Direction dir;
    boolean key;
    int artefact;

    public Controleur(Modele modele){
        this.modele = modele;
        this.pos = modele.celluleRandom();
        this.nAction = 3;
        this.key = false;
        this.artefact = 0;
    }

    public void detectFin(){

    }

    public void move(Direction key){ // besoin de récupérer une commande clavier / choix de type Direction pour marcher
        System.out.println("move");
        if(nAction >0) {
            if (key == Direction.up && this.pos.y < HAUTEUR) {
                this.dir = Direction.up;
                this.pos = getCellules(this.pos.x, this.pos.y + 1);
                System.out.println(("up"));
                this.nAction--;
            }

            if (key == Direction.down && this.pos.y != 0) {
                this.dir = Direction.down;
                this.pos = getCellules(this.pos.x, this.pos.y - 1);
                System.out.println(("down"));
                this.nAction--;
            }

            if (key == Direction.left && this.pos.x != 0) {
                this.dir = Direction.left;
                this.pos = getCellules(this.pos.x - 1, this.pos.y);
                System.out.println(("left"));
                this.nAction--;
            }

            if (key == Direction.right && this.pos.y < LARGEUR) {
                this.dir = Direction.right;
                this.pos = getCellules(this.pos.x, this.pos.y - 1);
                System.out.println(("right"));
                this.nAction--;
            }
        }
    }

    // besoin de récupérer une commande clavier / choix de type Direction pour marcher. assécher au choix les cases.
    // attribut des joueurs courant , numero d'action courante, 2 variables centrales qui voient qui s'occupe de quoi
    // faire tout ca dans le controleur, etat ds controleur, 6 etats possibles au total

    public void assecher(Direction key){
        if(nAction > 0){
            Cellule a[]= this.modele.celluleAdjacentes(this.pos.x,this.pos.y);
            switch (key){
                case up:
                    if(a[2].isInonde()){
                        this.modele.assecherCellule(this.pos.x,this.pos.y+1);
                        this.nAction--;
                    }
                    break;
                case down:
                    if(a[3].isInonde()){
                        this.modele.assecherCellule(this.pos.x,this.pos.y-1);
                        this.nAction--;
                    }
                    break;
                case left:
                    if (a[0].isInonde()){
                        this.modele.assecherCellule(this.pos.x-1,this.pos.y);
                        this.nAction--;
                    }
                    break;
                case right:
                    if (a[1].isInonde()){
                        this.modele.assecherCellule(this.pos.x+1,this.pos.y);
                        this.nAction--;
                    }
                    break;
            }
        }
    }

    public void recuperer(){
        if(nAction > 0) {
            if (this.pos.etat == 4 && this.key == true) {
                this.pos.etat = 0;
                this.artefact++;
                this.key = false;
                this.nAction--;
            }
        }
    }

    public void chercher(){ // 20% inonder 30% clé 50% rien
        double x = Math.random();
        if(x <= 0.2){
            this.pos.inonder();
        }

        if(x > 0.2 && x <= 0.5){
            this.key= true;
        }
    }

    public void inonderHasard(){
        Cellule[] c = new Cellule[2];
        for (int i = 0; i <c.length ; i++) {
            c[i] = celluleRandom();
            if (c[i].etat == 0){
                c[i].inonder();
            }
            if(c[i].etat == 1){
                c[i].submerger();
            }
        }
    }

    public void tour(){
        // action joueur: se déplacer / assécher / récupérer
        //move(); //besoin de récupérer une commande clavier / choix de type Direction pour marcher
        //assecher(); // besoin de récupérer une commande clavier / choix de type Direction pour marcher
        recuperer();
        System.out.println("Clic");
        // chercher une clé
        chercher();

        // inonder une cellule au hasard à chaque tour
        inonderHasard();

        notifyObservers();
    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        tour();
    }


}
