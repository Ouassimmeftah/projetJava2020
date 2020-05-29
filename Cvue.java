import javax.swing.*;
import java.awt.*;

public class Cvue {
    private JFrame frame;
    private VueGrille grille;
    private VueCommandes Commandes;
    private VueTexte texte;
    private VueJoueur joueur;


    public Cvue(Modele modele) {
        JLabel label = new JLabel("bienvenue dans le jeu de l'ile interdite en java : By Minh Kha Nguyen and Ouassim Meftah");

        frame = new JFrame();
        frame.setTitle("Jeu de L'ile interdite");
        frame.setLayout( new FlowLayout() );  // border layout voir ce quil faut faire
        frame.setSize(400,400);

        grille = new VueGrille( modele );
        frame.add(grille);
        Commandes = new VueCommandes( modele );
        frame.add(Commandes);
        texte = new VueTexte( modele );
        frame.add(texte);
        joueur = new VueJoueur(modele);
        frame.add(label);

        frame.pack();       // ajuste la fenetre pr afficher tous les obj quelle contient
        frame.setLocationRelativeTo(null);  // centre la fenetre au milieu de l'ecran
        frame.setResizable(true);           // possibilite de redimensionner la fenetre
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}

