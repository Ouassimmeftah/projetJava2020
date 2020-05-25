import javax.swing.*;

public class VueCommandes extends JPanel {
    private Modele modele;

    public VueCommandes(Modele modele){
        this.modele = modele;

        JButton boutonAction = new JButton("fin de tour");
        this.add(boutonAction);
        JButton boutonHaut = new JButton("haut");
        this.add(boutonHaut);
        JButton boutonBas = new JButton("bas");
        this.add(boutonBas);
        JButton boutonGauche = new JButton("Gauche");
        this.add(boutonGauche);
        JButton boutonDroit = new JButton("droit");
        this.add(boutonDroit);


        Controleur controleur = new Controleur(modele);
        boutonAction.addActionListener(controleur);
        boutonHaut.addActionListener(controleur);
        boutonBas.addActionListener(controleur);
        boutonGauche.addActionListener(controleur);
        boutonDroit.addActionListener(controleur);

    }



}
