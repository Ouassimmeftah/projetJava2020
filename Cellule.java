public class Cellule {

    private Modele modele;
    protected int etat; /** 3 etats possibles : normal 0,inonde 1,submerge 2 */
    protected final int x,y;

    public Cellule(Modele modele, int x, int y){
        this.modele = modele;
        this.x = x;
        this.y = y;
        this.etat = 0;

    }



    public void inonder(){
        this.etat = 1;
    }

    public void submerger(){
        this.etat = 2;
    }


}
