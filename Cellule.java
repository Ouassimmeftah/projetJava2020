public class Cellule {

    private Modele modele;

    protected int etat; /** 5 etats possibles : normal 0,inonde 1,submerge 2, heliport 3, zone artefact 4 */
    protected final int x,y;
    private int element; /**0 rien, 1 feu, 2 eau, 3 terre, 4 vent */



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

    public void eleRandom(){
        int range = 4 - 1 + 1;
        int randEle = (int) (Math.random() * range) + 1;
        this.element = randEle;
    }

}
