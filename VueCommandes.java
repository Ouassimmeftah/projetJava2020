import javax.swing.*;

public class VueCommandes extends JPanel {
    private Modele modele;

    public VueCommandes(Modele modele){
        this.modele = modele;

        JButton boutonAction = new JButton("fin de tour");
        this.add(boutonAction);

        Controleur controleur = new Controleur(modele);
        boutonAction.addActionListener(controleur);
    }


}
