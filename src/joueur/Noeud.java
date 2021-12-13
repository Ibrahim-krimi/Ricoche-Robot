package joueur;
import java.util.*;
import java.awt.*;
import java.lang.Object;
import games.*;
import randomfonction.*;



public class Noeud {

    protected int [] x_J =new int [4]; // Stock ligne des robot
    protected int [] y_J = new int [4]; // Stock colonne des robot
    private int cout;
    private int heuristique;
    private Noeud ancetreNoeud;

    public Noeud(int [] x, int [] y,int cout,int heuristique)
    {
        this.cout=cout;
        remplissageX(x);
        remplissageY(y);
        
    }


    public int getLigneNoeud(int valeur)
    {
        return x_J[valeur-11];
    }
    public int getColonneNoeud(int valeur)
    {
        return y_J[valeur-11];
    }
    public int[] gettabX()
    {
        int[] Tab = new int [4];
        for(int i=0;i<4;i++)
        {
            Tab[i]=this.x_J[i];
        }
        return Tab;
    }

     public int[] gettabY()
    {
        int[] Tab = new int [4];
        for(int i=0;i<4;i++)
        {
            Tab[i]=this.y_J[i];
        }
        return Tab;
    }

    public void setLigneNoeud(int valeur,int x)
    {
        x_J[valeur-11]=x;
    }
    public void setColonneNoeud(int valeur,int y)
    {
        y_J[valeur-11]=y;
    }
    public void remplissageX(int [] tab)
    {
        for(int i=0;i<4;i++)
        {
            this.x_J[i]=tab[i];
        }
    }
    public void remplissageY(int [] tab)
    {
        for(int i=0;i<4;i++)
        {
            this.y_J[i]=tab[i];
        }
    }
    public int getcout()
    {
        return this.cout;
    }
    public int getheuristique()
    {
        return this.heuristique;
    }

    public void setcout(int valeur)
    {
        this.cout=valeur;
    }
    public void setheuristique(int valeur)
    {
        this.heuristique = valeur;
    }

    public Noeud getAncetre()
    {
        return this.ancetreNoeud;
    }
    public void setAncetre(Noeud u)
    {
        this.ancetreNoeud=u;
    }


    

}