package randomfonction;
import java.util.*;
import java.awt.*;


public class Aleatoire
{
    //Aleatoire
    private int nombrehasard1;
    private int nombrehasard2;

    public Aleatoire()
    {
        
    }

    public int getNombre1()
    {
        return this.nombrehasard1;
    }
    public int getNombre2()
    {
        return this.nombrehasard2;
    }

    //Fonction qui tire une case entre 0 et 255
    public int joueurAleatoire()
    {
        int nombre=0;
        Random r = new Random();
        nombre=r.nextInt(256);
        // Ne pas tirer une des quatre case du centre 
        while(nombre==119 || nombre ==120 || nombre == 135 || nombre == 136)
        {
            nombre=r.nextInt(256);
        }
        return nombre;
    }

    /////// Fonction aléatoire ////////
    // Tirer un nombre en 1 et 4 
    public int NombreAleatoire1()
    {
        int nombre=0;
        Random r = new Random();
        nombre=r.nextInt(4)+1;
        return nombre;
    }
    //Tirer un nombre aleatoire entre 0 et 7 inclus
    public int NombreAleatoire()
    {
        int nombre=0;
        Random r = new Random();
        nombre=r.nextInt(8);
        return nombre;
    }


    // Indice nombre aléatoire coté droit 
    public int QuartDroit()
    {
        int nombreAla=0;
        nombreAla=NombreAleatoire()+7;  // Tirage colonne aleatoire
        while(nombreAla>14 || nombreAla <7){
            nombreAla=NombreAleatoire()+7;
        }
        return nombreAla;
    }
    // Indice nombre aléatoire angle coté gauche
    public int AngleQuartGauche()
    {
        int nombreAla=0;
        nombreAla=NombreAleatoire();  
        while(nombreAla<1 || nombreAla >7){
            nombreAla=NombreAleatoire();
        }
        return nombreAla;
    }
/////////////////////////////////////////////////
//// Angle ///
////////Angle quart gauche haut ///////
public void TirageDeuxAngleGauche()
{

    this.nombrehasard1=AngleQuartGauche();
    this.nombrehasard2=AngleQuartGauche();
}

    ///////Angle quart droit haut////////

    public void tirageDeuxAngleGaucheDroit()
    {
        this.nombrehasard1=AngleQuartGauche();
        this.nombrehasard2=QuartDroit();
    }
    /////////Angle quart bas droit//////////

    public void tirageDeuxAngleDroitGauche()
    {
        this.nombrehasard1=QuartDroit();
        this.nombrehasard2=AngleQuartGauche();
    }
    ///////Angle quart bas droit/////////

    public void tirageDeuxAngleDroit()
    {
        this.nombrehasard1=QuartDroit();
        this.nombrehasard2=QuartDroit();
    }
    //Tirage du numero de l'angle choisi pour le placement du pion entre 1 et 17 car 17 angles 
    public int TiragePlacement()
    {    
        int nombre=0;
        Random r = new Random();
        nombre=r.nextInt(17)+1;
        return nombre;
    }
/////////////////////////////////////////////////
}