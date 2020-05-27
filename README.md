
# Projet Île Interdite en java
**à rendre pour le 2 juin 2020**

Projet en contexte de l'unité d'enseignement Programation Objet et Génie Logiciel en 2è année de license informatique de l'université Paris-Sud Saclay

---
## Contributeurs

- MEFTAH Ouassim <ouassim.meftah@u-psud.fr>
- NGUYEN Minh Kha <minh-kha.nguyen@u-psud.fr> 

---
## classes et Fonctionnalités

    Class Cellule.java
        Attributs: 
            Modele Modele : le terrain de jeu
            enum etat: un état de la Cellule
            int x,y: les coordonnées de cette Cellule

        Contructeurs / Méthodes:
            constructeur Cellule qui initialise le Modele, les coordonnées x,y et les etats 
            Methodes IsAMachin qui retourne l'etat de la cellule

        (*à compléter*)
        Classe qui represente une Cellule du tableau de jeu
    ---
    Class Controleur.java 
        Attributs:
            Modele Modele: le terrain de jeu

        Contructeurs / Méthodes:
            actionPerformed: (*à compléter*)

        la classe qui écoute les actions du Controleur
    ---
    Class Cvue.java
        Attributs:
            JFrame frame 
            VueGrille grille
            VueCommandes commandes
        Methodes : 
                frame.setLocationRelativeTo(null);  // centre la fenetre au milieu de lecran


        la classe qui créer une fenêtre pour afficher le terrain de jeu pour le Controleur
    ---
    Class IleInterdite.java
        la classe main
    ---
    Class Modele.java
        Attributs:
            int HAUTEUR, LARGEUR: la taille du terrain de jeu
            Cellule[][] cellules: tableau 2D de type Cellule du terrain

        Contructeurs / Méthodes:
            Modele(): un contructeur pour remplir le terrain
            init(): pour initialiser les états du terrain
            avance(): (*à compléter*)
            getCellules(int x, int y): retourne la Cellule coordonnées (x,y)

        Modélisation du terrain de jeu 
    ---
    Class Observable.java
        Attributs:
            ArrayList<Observer> observers: un tableau d'observateur

        Constructeurs / Méthodes:
            Observable(): un constructeur pour créer un tableau d'observateurs
            addObserver(Observer o): une méthode pour ajouter un observateur o
            notifyObservers(): une méthode pour mettre à jour les observateurs

        (*à compléter*)
    ---
    Class VueCommandes.java
        Attributs:
            Modele Modele: modèle du terrain de jeu

        Constructeurs / Méthodes:
            VueCommandes(Modele Modele): initialise le bouton d'action 
        
        (*à compléter*)
    ---
    Class VueGrilles.java
        Attributs:
            Modele Modele : modèle du terrain de jeu
            int TAILLE : taille de la grille

        Constructeurs / Méthodes:
            VueGrille(Modele Modele): constructeur pour mettre en place l'observateur sur un modèle donné
            update(): Mise à jour de la grille
            paintCellule(Graphics graphics): dessiner la grille
        
        (*à compléter*)
---

## Documentations et Sources

[Le code dont on s'est inspiré](https://www.lri.fr/~blsk/POGL/Notes/Conway.html)
 
[L'énoncé du projet](https://www.lri.fr/~blsk/POGL/IleInterdite.pdf)

