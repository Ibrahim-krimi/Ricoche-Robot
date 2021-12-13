package games;
import randomfonction.*;
import java.util.*;
import java.awt.*;

public class Jeu{
    
    protected Plateau P;
    protected Robots Joueur;
    protected Objectif Pion_objectif;

    //Variable victoire
    private boolean win=false;

    public Jeu(Plateau p,Robots j,Objectif pion)
    {
        this.Pion_objectif= pion;
        this.Joueur = j;
        this.P = p;
    }
    
    

    public Plateau getPlateau()
    {
        return this.P;
    }
    public Robots getRobot()
    {
        return this.Joueur;
    }


    public String getAffichagePlateau()
    {
        return P.AffichagePlateau();
    }
    public int getvaleurObjectif()
    {
        return Pion_objectif.getJoueurPion();
    }
////////////////////// Fonction pour le play et getMove /////////////////////
    //Test si le coup est valide 
    public boolean isValid(int coup,ArrayList<String> liste)
    {
        if(liste.size()!=0 && (coup>=0 && coup<liste.size()))
        {
            return true;
        }
        return false;

    }

    //Fonction qui test selon direction entrer si il n'y a pas un pion a cet emplacement 

    public boolean validirection(int ligne,int colonne,String direction)
    {
        int robot=Joueur.getgrilleJoueur(ligne,colonne);
        //Si droit
        if(colonne!=15 && direction==P.key(5) && (Joueur.getgrilleJoueur(ligne,colonne+1)==0 || Pion_objectif.TestPionRobot(robot,0,1,ligne,colonne)))
        {
            return true;
        }
        //gauche
        if(colonne!=0 && direction==P.key(6) && (Joueur.getgrilleJoueur(ligne,colonne-1)==0 || Pion_objectif.TestPionRobot(robot,0,-1,ligne,colonne)))
        {
            return true;
        }
        //Bas
        if(ligne!=15 && direction==P.key(7) && (Joueur.getgrilleJoueur(ligne+1,colonne)==0 || Pion_objectif.TestPionRobot(robot,1,0,ligne,colonne)))
        {
            return true;
        }
        //haut
        if(ligne!=0 && direction==P.key(8) && (Joueur.getgrilleJoueur(ligne-1,colonne)==0 || Pion_objectif.TestPionRobot(robot,-1,0,ligne,colonne)))
        {
            return true;
        }
        return false;
    }

// Prends un joueur selon le numéro entré le convertis en sa valeur et trouve sa case puis recherche ces coup valide selon sa case 
public ArrayList<String> getMove(int joueur)

{
    ArrayList<String> liste = new ArrayList<String>();
    String cle;
    int robot=Joueur.retournjoueur(joueur);
    int lignejoueur=Joueur.getLigneJoueur(robot);
    int colonnejoueur=Joueur.getColonneJoueur(robot);


    String droit=P.key(5);
    String gauche=P.key(6);
    String bas=P.key(7);
    String haut=P.key(8);
    
    
////Test sur angle et et direction////
    for(int i=0;i<11;i++)
    {
        if(P.grille[lignejoueur][colonnejoueur]==i)
        {
            if(i!=3 && i!=4 && i!=5 && i!=10 && validirection(lignejoueur,colonnejoueur,droit))
            {
                liste.add(droit);
            }
            if(i!=6 && i!=1 && i!=2 && i!=10 && validirection(lignejoueur,colonnejoueur,gauche))
            {
                liste.add(gauche);
            }
            if(i!=9 && i!=4 && i!=7 && i!=2 && validirection(lignejoueur,colonnejoueur,bas))
            {
                liste.add(bas);
            }
            if(i!=9 && i!=3 && i!=8 && i!=1 && validirection(lignejoueur,colonnejoueur,haut))
            {
                liste.add(haut);
            }
            
        }
    }
   
    return liste;


}

 


public void play(int coup,int joueur)
{
    ArrayList<String> liste = new ArrayList<String>();
    liste=getMove(joueur);
    //Convertis le numero du joueur en sa valeur et sa ligne et colonne 
    int robot=Joueur.retournjoueur(joueur);
    int i=Joueur.getLigneJoueur(robot);
    int j=Joueur.getColonneJoueur(robot);

    //Garder les valeurs pour effacer la case du pion deplacer 
    int ligne=i;
    int colonne=j;



    // Variable pion 
    int colonnepion=Pion_objectif.getColonnepion();
    int lignepion=Pion_objectif.getLignepion();
    int ValeurPion=Pion_objectif.getJoueurPion();

    if(isValid(coup,liste))
    {
        // Gauche
        if(liste.get(coup)==P.key(6))
        {
            while((P.grille[i][j]!=6 && P.grille[i][j]!=2 && P.grille[i][j]!=1 && j!=0) && ((Joueur.getgrilleJoueur(i,j-1)==0) || (Joueur.getgrilleJoueur(i,j-1)==ValeurPion && robot==ValeurPion && i==lignepion && j>colonnepion)))
            {
                j--;
            }

        }
        //Droit
        if(liste.get(coup)==P.key(5))
        {
            while((P.grille[i][j]!=5 && P.grille[i][j]!=4 && P.grille[i][j]!=3 && j!=15) && ((Joueur.getgrilleJoueur(i,j+1)==0) || (Joueur.getgrilleJoueur(i,j+1)==ValeurPion && robot==ValeurPion && i==lignepion && j<colonnepion)))
            {
                j++;
            }
        }
        //Haut
        if(liste.get(coup)==P.key(8))
        {
            while((P.grille[i][j]!=8 && P.grille[i][j]!=1 && P.grille[i][j]!=3 && i!=0) && ((Joueur.getgrilleJoueur(i-1,j)==0) || (Joueur.getgrilleJoueur(i-1,j)==ValeurPion&& robot==ValeurPion && i>lignepion && j==colonnepion)))
            {
                i--;
            }
        }
        //Bas
        if(liste.get(coup)==P.key(7))
        {
            while((P.grille[i][j]!=7 && P.grille[i][j]!=4 && P.grille[i][j]!=2 && i!=15) && ((Joueur.getgrilleJoueur(i+1,j)==0) || (Joueur.getgrilleJoueur(i+1,j)==ValeurPion && robot==ValeurPion && i<lignepion && j==colonnepion)))
            {
                i++;
            }
        }
        //Tester si le joueur est sur le pion
        if(i==lignepion && j==colonnepion && robot==ValeurPion){
            this.win=true;
        }
        // Mettre la valeur du robot sur la case et mettre la case vide a 0
        Joueur.setgrilleJoueur(i,j,robot);
        Joueur.setgrilleJoueur(ligne,colonne,0);
        Joueur.setLigneJoueur(robot,i);
        Joueur.setColonneJoueur(robot,j);
    }
}




//Fonction isOver

public boolean isOver()
{
    if(this.win==true)
    {
        return true;
        
    }

    return false;
    
}

public Jeu copy(){

    // PIonObjectif
    Objectif pion = new Objectif();
    //ligne,colonne,valeur Pion
    pion.setLignePion(this.Pion_objectif.getLignepion());
    pion.setColonnePion(this.Pion_objectif.getColonnepion());
    pion.setJoueurPion(this.Pion_objectif.getJoueurPion());

    Robots r = new Robots(pion);
    for(int i=0;i<4;i++){
    r.x_Joueur[i]=this.Joueur.x_Joueur[i];
    r.y_Joueur[i]=this.Joueur.y_Joueur[i];
    }
    
    for(int i=0;i<16;i++){
        for(int j=0;j<16;j++){
        r.grilleJoueur[i][j]=this.Joueur.grilleJoueur[i][j];
        }
    }

    Plateau plateau = new Plateau(r,pion);
    for(int i=0;i<16;i++){
        for(int j=0;j<16;j++){
        plateau.grille[i][j]=this.P.grille[i][j];
        }
    }
    plateau.Initialisation();
    Jeu res = new Jeu(plateau,r,pion);
   
  return res;

}

//////////////////////////////////////////////////////////////////////////////////////////////////////////
}