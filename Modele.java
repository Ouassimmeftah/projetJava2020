public class Modele extends Observable{
    public static final int HAUTEUR = 40, LARGEUR =60;
    private Cellule[][] cellules;

    public Modele(){
        cellules = new Cellule[LARGEUR+2][HAUTEUR+2];
        for(int i=0; i<LARGEUR+2; i++) {
            for(int j=0; j<HAUTEUR+2; j++) {
                cellules[i][j] = new Cellule(this,i, j);
            }
        }
        init();
    }

    public void init() {
        for(int i=1;i<=LARGEUR;i++){
            for(int j=1;j<=HAUTEUR;j++){
                if(Math.random() < .2){
                    cellules[i][j].etat = 0;
                }

            }
        }
    }

    public void avance(){

        notifyObservers();
    }

    public Cellule getCellules(int x, int y) {
        return cellules[x][y];
    }
}
