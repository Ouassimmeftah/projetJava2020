import javax.swing.*;

public class VueCommandes extends JPanel {
    private Modele modele;      // reference au modele 

    public VueCommandes(Modele modele){
        this.modele = modele;

        JButton boutonAction = new JButton("fin de tour");  //creation d'un bouton 
        this.add(boutonAction);                             // ajout au panneau de boutons
        JButton boutonHaut = new JButton("up");
        this.add(boutonHaut);
        JButton boutonBas = new JButton("down");
        this.add(boutonBas);
        JButton boutonDroit = new JButton("right");
        this.add(boutonDroit);
        JButton boutonGauche = new JButton("left");
        this.add(boutonGauche);
        JButton boutonRecuperer = new JButton("recuperer");
        this.add(boutonRecuperer);
        JButton boutonAssecherUp = new JButton("assecherUp");
        this.add(boutonAssecherUp);
        JButton boutonAssecherDown = new JButton("assecherDown");
        this.add(boutonAssecherDown);
        JButton boutonAssecherRight = new JButton("assecherRight");
        this.add(boutonAssecherRight);
        JButton boutonAssecherLeft = new JButton("assecherLeft");
        this.add(boutonAssecherLeft);

        //Enregistrement du controleur 
        Controleur controleur = new Controleur(modele);
        //Enregistrement du controleur comme auditeur du bouton
        boutonAction.addActionListener(controleur);

        boutonHaut.addActionListener(controleur);

        boutonBas.addActionListener(controleur);

        boutonGauche.addActionListener(controleur);

        boutonDroit.addActionListener(controleur);

        boutonAssecherUp.addActionListener(controleur);
        boutonAssecherDown.addActionListener(controleur);
        boutonAssecherRight.addActionListener(controleur);
        boutonAssecherLeft.addActionListener(controleur);

        boutonRecuperer.addActionListener(controleur);
    }



}
