import java.awt.desktop.SystemEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Controleur extends Modele implements ActionListener {
    public Modele modele;

    public Controleur(Modele modele){
        this.modele = modele;
    }

    public void actionPerformed(ActionEvent e) {

        String a = e.getActionCommand();
        System.out.println((a));

        modele.joueur[0].tour(a);

        notifyObservers();
    }

}
