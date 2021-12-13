package games;
import randomfonction.*;
import java.util.*;
import java.awt.*;


public class Objectif {

    private Aleatoire A;

    //objectif
    private int lignepion;
    private int colonnepion;
    private int joueurPion;

    public Objectif()
    {
        this.A=new Aleatoire();
    
    }

    //Valeur du pion 
    public void setJoueurPion(int joueur)
    {
        this.joueurPion=joueur;
    }

    public int getJoueurPion()
    {
        return this.joueurPion;
    }
    public void setLignePion(int ligne)
    {
        this.lignepion=ligne;
    }
    public void setColonnePion(int colonne)
    {
        this.colonnepion=colonne;
    }
    public int getLignepion()
    {
        return this.lignepion;
    }

    public int getColonnepion()
    {
        return this.colonnepion;
    }
    // Initialise le Pion qui prends la couleur d'un joueur au hasard 
    public void PionJoueur()
    {
        // Tirer un nombre entre 1 et 4 puis rajouter 10 pour avoir la valeur d'un robot 
        int joueur=A.NombreAleatoire1();
        joueur+=10;
        setJoueurPion(joueur);
    }

    // Test si les cases ajacente contienent le pion de la meme couleur que le robot en paramètre 

    public boolean TestPionRobot(int robot,int i,int j,int ligne,int colonne)
    {
        if(robot==getJoueurPion() && ligne+i==getLignepion() && colonne+j==getColonnepion())
        {
            return true;
        }
        return false;
    }
    // Placement du pion aleatoire dans un angle 
    public void pionPlacement(int placement,int[][] grille,int [][]grilleJoueur)
    {
      
        int cmpt=0;
        // Recherche par la valeur du placement le numero de l'angle en incrémentant cmpt
        for(int i=0;i<16;i++)
        {
            for(int j=0;j<16;j++)
            {
                // Exclure l'angle de la première ligne a gauche
                if(grille[i][j]==1 && i!=0 )
                {
                    cmpt++;
                }
                // Exclure l'angle de la dernière ligne a gauche
                if(grille[i][j]==2 && i!=15)
                {
                    cmpt++;
                }
                // Exclure l'angle de la premiere ligne a droite
                if(grille[i][j]==3 && i!=0)
                {
                    cmpt++;
                }
                // Exclure l'angle de la dernière ligne a droite
                if(grille[i][j]==4 && i!=15)
                {
                    cmpt++;
                }
                // Si le compteur egale au placement aleatoire on change la valeur du deuxieme tableau puis on sors du for avec j
                if(cmpt==placement )
                {
                    grilleJoueur[i][j]=joueurPion;
                    setLignePion(i);
                    setColonnePion(j);
                    break;
                }

            }
            // puis on sort du i 
            if(cmpt==placement)
                {
                    break;
                }

        }
        
        
    }
    
}