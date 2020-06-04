import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Joueur extends Modele {

    public Modele modele;
    public static int nAction;
    public Cellule pos;
    public boolean key;
    public int artefact;
    
    public Joueur(Modele modele){
        this.modele = modele;
        this.pos = this.modele.celluleRandom();
        this.nAction = 3;
        this.key = false;
        this.artefact = 0;
    }

    public void move(String key){ // besoin de récupérer une commande clavier / choix de type Direction pour marcher
        System.out.println("move");
        if(nAction >0) {
            Cellule a[]= this.modele.celluleAdjacentes(this.pos.x,this.pos.y);
            switch (key) {
                case "up":
                    if (a[2].isSubmerge() == false && this.pos.y < HAUTEUR) {
                        this.pos = getCellules(this.pos.x, this.pos.y + 1);
                        System.out.println(("up"));
                        this.nAction--;
                    }
                    break;
                case "down":
                    if (a[3].isSubmerge() == false && this.pos.y != 0) {
                        this.pos = getCellules(this.pos.x, this.pos.y - 1);
                        System.out.println(("down"));
                        this.nAction--;
                    }
                    break;
                case "left":
                    if (a[0].isSubmerge() == false && this.pos.x != 0) {
                        this.pos = getCellules(this.pos.x - 1, this.pos.y);
                        System.out.println(("left"));
                        this.nAction--;
                    }
                    break;
                case "right":
                    if (a[1].isSubmerge() == false && this.pos.y < LARGEUR) {
                        this.pos = getCellules(this.pos.x, this.pos.y - 1);
                        System.out.println(("right"));
                        this.nAction--;
                    }
                    break;
            }
        }
    }

    public void assecher(String key){ // besoin de récupérer une commande clavier / choix de type Direction pour marcher. assécher au choix les cases.
        // attribut des joueurs courant , numero d'action courante, 2 variables centrales qui voient qui s'occupe de quoi
        // faire tout ca dans le controleur, etat ds controleur, 6 etats possibles au total
        if(nAction > 0){
            Cellule a[]= this.modele.celluleAdjacentes(this.pos.x,this.pos.y);
            switch (key){
                case "up":
                    if(a[2].isInonde()){
                        this.modele.assecherCellule(this.pos.x,this.pos.y+1);
                        this.nAction--;
                        System.out.println(("assecherUp"));
                    }
                    break;
                case "down":
                    if(a[3].isInonde()){
                        this.modele.assecherCellule(this.pos.x,this.pos.y-1);
                        this.nAction--;
                        System.out.println(("assecherDown"));
                    }
                    break;
                case "left":
                    if (a[0].isInonde()){
                        this.modele.assecherCellule(this.pos.x-1,this.pos.y);
                        this.nAction--;
                        System.out.println(("assecherLeft"));
                    }
                    break;
                case "right":
                    if (a[1].isInonde()){
                        this.modele.assecherCellule(this.pos.x+1,this.pos.y);
                        this.nAction--;
                        System.out.println(("assecherRight"));
                    }
                    break;
            }
        }
    }

    public void recuperer(){
        if(nAction > 0) {
            if (this.pos.etat == 4 && key == true) {
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

    public void tour(String a) {
        switch (a) {
            case "Up":
                move("up");
                break;
            case"down":
                move("down");
                break;
            case"right":
                move("right");
                break;
            case"left":
                move("left");
                break;
            case"assecherUp":
                assecher("up");
                break;
            case"assecherDown":
                assecher("down");
                break;
            case"assecherRight":
                assecher("right");
                break;
            case"assecherLeft":
                assecher("left");
                break;
            case "recuperer":
                recuperer();
                break;
            case"fin de tour":
                chercher();
                this.modele.inonderHasard();
                break;
        }
    }

}
