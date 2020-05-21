public class Modele extends Observable{
    public static final int HAUTEUR = 40, LARGEUR =60;
    private Cellule [][] cellules;

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
                    cellules[i][j].etat = 0; //mettre aléatoirement une case normal
                }
            }
        }
    }

    public Cellule celluleRandom(){
        int x;
        int y;
        int rangeX = LARGEUR - 1 + 1;
        int rangeY = HAUTEUR - 1 + 1;
        x = (int) (Math.random() * rangeX) + 1;
        y = (int) (Math.random() * rangeY) + 1;
        return getCellules(x,y);
    }


    public void tour(){
        //cellules.choisir;
        //cellules.chercher;

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

        notifyObservers();
    }

    public Cellule getCellules(int x, int y) {
        return cellules[x][y];
    }


}
