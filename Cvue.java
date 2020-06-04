import javax.swing.*;
import java.awt.*;

public class Cvue {
    private JFrame frame;
    private VueGrille grille;
    private VueCommandes Commandes;
    private VueTexte texte;
    private VueJoueur joueur;


    public Cvue(Modele modele) {


        frame = new JFrame();
        frame.setTitle("Jeu de L'ile interdite");
        frame.setLayout(new GridBagLayout());
        frame.setSize(300, 300);

        grille = new VueGrille( modele );
        grille.setPreferredSize(new Dimension(grille.getTaille()*modele.LARGEUR, grille.getTaille()*modele.HAUTEUR));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        constraints.gridwidth = 2;

        frame.add(grille, constraints);
        frame.getContentPane().add(grille);


        Commandes = new VueCommandes( modele );
        constraints.gridx = 0;
        constraints.gridx = 1;
        frame.add(Commandes,constraints);

        texte = new VueTexte( modele );
        texte.setPreferredSize(new Dimension(200, grille.getTaille()*modele.HAUTEUR));
        constraints.gridx = 1;
        constraints.gridx = 0;
        frame.add(texte,constraints);

        joueur = new VueJoueur(modele);
        frame.add(joueur);


        frame.pack();       // ajuste la fenetre pr afficher tous les obj quelle contient
        frame.setLocationRelativeTo(null);  // centre la fenetre au milieu de l'ecran
        frame.setResizable(false);           // possibilite de redimensionner la fenetre
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}