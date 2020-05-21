import javax.swing.*;
import java.awt.*;

public class Cvue {
    private JFrame frame;
    private VueGrille grille;
    private VueCommandes Commandes;

    public Cvue(Modele modele) {
        frame = new JFrame();
        frame.setTitle("Jeu de L'ile interdite");
        frame.setLayout(new FlowLayout());

        grille = new VueGrille(modele);
        frame.add(grille);
        Commandes = new VueCommandes(modele);
        frame.add(Commandes);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}

