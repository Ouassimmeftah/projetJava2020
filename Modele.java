import javax.swing.*;

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

    public Cellule getCellules(int x, int y) {
        return cellules[x][y];
    }

    public void assecherCellule(int x, int y){
        getCellules(x,y).celluleAssecher();
    }

    /* retourne une liste de cellules adjacentes
     *
     */
    public Cellule[] celluleAdjacentes(int x, int y){
        Cellule a[] = new Cellule[3];
        a[0] = getCellules(x+1,y);
        a[1] = getCellules(x-1,y);
        a[2] = getCellules(x,y+1);
        a[3] = getCellules(x,y-1);
        return a;
    }

}

