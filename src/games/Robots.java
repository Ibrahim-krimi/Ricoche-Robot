package games;
import randomfonction.*;
import games.*;
import randomfonction.*;
import java.util.*;
import java.awt.*;

public class Robots {

Objectif Pion_objectif;
Aleatoire A;

private HashMap<String,Integer> Robot;
private final static String[] JoueurCouleur = {"Robot_Bleu","Robot_Rouge","Robot_Vert","Robot_Jaune"}; // Tableau couleur joueur
protected int[][] grilleJoueur; // Grille qui stoquera les joueur 
protected int [] x_Joueur; // Stock ligne des joueurs
protected int [] y_Joueur; // Stock colonne des joueurs


    public Robots(Objectif p)
    {
        this.Pion_objectif = p;
        this.A = new Aleatoire();
        this.Robot= new HashMap<String,Integer>();
        this.grilleJoueur = new int [16][16];
        this.x_Joueur = new int [4];
        this.y_Joueur = new int [4];

        
    }
    ////////////////////Acceceurs /////////////

    public int[] getRobotTabX()
    {
        int[] Tab = new int[4];
        for(int i=0;i<4;i++)
        {
            Tab[i]=this.x_Joueur[i];
        }
        return Tab;
    }

     public int[] getRobotTabY()
    {
        int[] Tab = new int[4];
        for(int i=0;i<4;i++)
        {
            Tab[i]=this.y_Joueur[i];
        }
        return Tab;
    }

    // Affichage de la couleur robot selon sa valeur 
    public String RobotColor(int valeur)
    {
        return JoueurCouleur[valeur-11];
    }
    public String getCurrentPlayer(int valeurPion)
    {
        return RobotColor(valeurPion);
    }
    public int getgrilleJoueur(int ligne,int colonne)
    {
        return this.grilleJoueur[ligne][colonne];
    }
    public void setgrilleJoueur(int ligne,int colonne,int valeur)
    {
        this.grilleJoueur[ligne][colonne]=valeur;
    }
    public int getRobot(String nom)
    {
        return this.Robot.get(nom);
    }
    public void setHashRobot(String nom,int valeur)
    {
        this.Robot.put(nom,valeur);
    }
    //Initialise la hashmap
    public void initHashRobot()
    {
        for(int valeur=11;valeur<15;valeur++)
        {
            setHashRobot(RobotColor(valeur),valeur);
        }
    }

      public void initx_yJoueur()
    {
        for(int valeur=11;valeur<15;valeur++)
        {
            x_Joueur[valeur-11]=Ligne(recherchejoueur(valeur));
            y_Joueur[valeur-11]=Colonne(recherchejoueur(valeur));
        }
        
    }
    public int getLigneJoueur(int valeur)
    {
        return x_Joueur[valeur-11];
    }
    public int getColonneJoueur(int valeur)
    {
        return y_Joueur[valeur-11];
    }
    public void setLigneJoueur(int valeur,int x)
    {
        x_Joueur[valeur-11]=x;
    }
    public void setColonneJoueur(int valeur,int y)
    {
        y_Joueur[valeur-11]=y;
    }
//////////////////////////////////////////////////////////

    //Retourn la valeur d'un joueur(11  À 14) selon l'entier entré en parametre ( 1 à 4 )
    public int retournjoueur(int joueur)
    {
        int i=1;
        int ValeurJoueur=0;
        while(i!=5)
        {
            if(joueur==i)
            {
                ValeurJoueur=i+10;
                break;
            }
            i++;
        }
        return ValeurJoueur;

    }
    ////Convertis un entier en une ligne de la grille //////

    public int Ligne(int coup)
    {
        int ligne=0;
        int i=0;
        int debut=0;
        int fin=16;
        // incrémenter les lignes de 0 jusqu'a 15 
        while(i!=16)
        {   
            // Tester si le coup est entre deux valeurs 
            if(coup>=debut && coup<fin)
            {
                ligne=i;
                break;
            }
            i++;
            debut+=16;
            fin+=16;

        }
        return ligne;    
    }

         

    public int Colonne(int coup)
    {
        int colonne=0;
        
        return colonne = coup%16;

    }
    //Place le robot sur le plateau selon sa valeur en paramètre de la fonction (dans une case contenant aucun robot)
    public void joueurplacement(int robot)
    {
        int joueur=A.joueurAleatoire();
        int ligne=Ligne(joueur);
        int colonne=Colonne(joueur);

        // Test si case vide , et si le robot n'est pas sur la ligne ou la colonne du pion 
        while(getgrilleJoueur(ligne,colonne)!=0 || Pion_objectif.getLignepion()==ligne || colonne==Pion_objectif.getColonnepion())
        {
             joueur=A.joueurAleatoire();
             ligne=Ligne(joueur);
             colonne=Colonne(joueur);
        }
        setgrilleJoueur(ligne,colonne,robot);
    }

      //Recherche un joueur selon sa valeur et retourne sa place sous forme de numéro de case sur la grille 
    public int recherchejoueur(int joueur)
    {
        int placejoueur=0;
        for(int i=0;i<16;i++)
        {
            for(int j=0;j<16;j++)
            {
                //Test si la case n'est pas egale et joueur ou si la on se trouve sur la ligne && colonne du pion pour ne pas retourner le joueur egale au pion
                if(getgrilleJoueur(i,j)!=joueur || (i==Pion_objectif.getLignepion() && j==Pion_objectif.getColonnepion()))
                {
                    placejoueur++;
                }
                // retourner le joueur si on tombe sur la valeur du joueur et pas sur la ligne et colonne du pion
                if(getgrilleJoueur(i,j)==joueur && (i!=Pion_objectif.getLignepion() || j!=Pion_objectif.getColonnepion()))
                {
                
                    return placejoueur;
                }
            }
        }
        return placejoueur;
    }



    public void Affichageobjectif()
    {
        System.out.println("\n L'objectif est le "+RobotColor(Pion_objectif.getJoueurPion())+ " se trouvant à la ligne : " + Pion_objectif.getLignepion()+" colonne : " + Pion_objectif.getColonnepion()+ "\n");

    }
}