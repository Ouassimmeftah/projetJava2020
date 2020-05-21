import java.awt.*;

public class IleInterdite {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Modele modele = new Modele();
            Cvue vue = new Cvue(modele);
        });
    }

}
