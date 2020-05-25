public class Cellule {

    private Modele modele;

    protected int etat; /** 5 etats possibles : normal 0,inonde 1,submerge 2, heliport 3, zone artefact 4 */
    protected final int x,y;



    public Cellule(Modele modele, int x, int y){
        this.modele = modele;
        this.x = x;
        this.y = y;
        this.etat = 0;

    }

    public boolean isNormal(){
        return etat == 0;
    }

    public boolean isInonde(){
        return etat == 1;
    }

    public boolean isSubmerge(){
        return etat==2;
    }

    public boolean isHeliport(){
        return etat==3;
    }

    public boolean isArtefact(){
        return etat==4;
    }

    public void celluleAssecher(){
        if(this.etat == 1){
            this.etat--;
        }
    }

    public void inonder(){
        this.etat = 1;
    }

    public void submerger(){
        this.etat = 2;
    }


    public void assecher(){
        // attribut des joueurs courant , numero d'action courante, 2 variables centrales qui voient qui s'occupe de quoi
        // faire tout ca dans le controleur, etat ds controleur, 6 etats possibles au total
        etat=0;

    }



}
