package games;
import randomfonction.*;
import java.util.*;
import java.awt.*;

public class Plateau {

protected int[][] grille;
// Variable directions negation via leur nom
protected HashMap<String,Integer> direction;
private Robots Joueur;
private Aleatoire A;
//Direction
private final static String[] DirectionToString = {"Toute_direction","Direction_haut_gauche","Direction_bas_gauche","Direction_haut_droit","Direction_bas_droit","Direction_droit","Direction_gauche","Direction_bas","Direction_haut","Direction_bas_haut","Direction_gauche_droit"};

//Pion 
Objectif Pion_objectif;
public Plateau(Robots j,Objectif pion)
{
    this.direction= new HashMap<String,Integer>();
    this.grille = new int [16][16];
    this.A=new Aleatoire();
    this.Pion_objectif= pion;
    this.Joueur= j;
    

}

///Fonction hashmap valeur retourne clé ////
public String key(int valeur)
{
    String cle="";
    for(String i : direction.keySet())
    {
        if(direction.get(i)==valeur)
        {
            return i;
        }
    }
    return cle;
}

//Initialise le centre et hashmap direction et robot
public void Initialisation()
{
    //Initialisation direction hashmap
    for(int i=0;i<11;i++)
    {
        this.direction.put(DirectionToString[i],i);
    }
    
    // Init Robot hashmap 
    Joueur.initHashRobot();
    
    // Centre plateau 
    for(int i=7;i<9;i++) 
    { 
        for(int j=7;j<9;j++) 
        { 
            this.grille[i][j]=0;
             
        } 
    } 

    
}


////////////Mur//////////////////

public void MurVertical(int ligne,int nombre)
{
    this.grille[ligne][nombre]=direction.get("Direction_droit");
    this.grille[ligne][nombre+1]=direction.get("Direction_gauche");
}

public void MurHorizontal(int colonne,int nombre)
{
    this.grille[nombre][colonne]=direction.get("Direction_bas");
    this.grille[nombre+1][colonne]=direction.get("Direction_haut");
}

//////////////////////////////////////////////
///////////Fonction angle //////////////////

// Fonction test de l'égalité d'indice des angles et mur 
public boolean EgaliteAngle(int nombreAla1,int nombreAla2)
{
   for (int i=-1;i<2;i++)
   {
    // Test autour si la case n'est pas vide pour que deux mur ne se chevauche pas 
        if(grille[nombreAla1+(i)][nombreAla2]!=0 ||grille[nombreAla1][nombreAla2+(i)]!=0)
        {
            return true;       
        }
   }
    return false;
}

////////Angle quart gauche haut ///////

public void TestAnglequartgauche()
{
    A.TirageDeuxAngleGauche();
    while(EgaliteAngle(A.getNombre1(),A.getNombre2()))
    {   
        A.TirageDeuxAngleGauche();
    }
}
///////////////////////
///////Angle quart droit haut////////

    public void TestAnglequartdroit()
    {
        A.tirageDeuxAngleGaucheDroit();
        while(EgaliteAngle(A.getNombre1(),A.getNombre2()))
        {
            A.tirageDeuxAngleGaucheDroit();
        }
    }


////////////////////////////////////////
/////////Angle quart bas droit//////////

    
    public void TestAnglequartbasGauche()
    {
        A.tirageDeuxAngleDroitGauche();
        while(EgaliteAngle(A.getNombre1(),A.getNombre2()))
        {
            A.tirageDeuxAngleDroitGauche();
        }
    }
//////////////////////////////////////
///////Angle quart bas droit/////////

    public void TestAnglequartbasDroit()
    {
        A.tirageDeuxAngleDroit();
        while(EgaliteAngle(A.getNombre1(),A.getNombre2()))
        {
            A.tirageDeuxAngleDroit();
        }
    }

////Ajouter angle dans le plateau /////
    public void AngleBasGauche()
    {

        this.grille[A.getNombre1()][A.getNombre2()]=direction.get("Direction_bas_gauche");
        this.grille[A.getNombre1()+1][A.getNombre2()]=direction.get("Direction_haut");
        this.grille[A.getNombre1()][A.getNombre2()-1]=direction.get("Direction_droit");
    }

    public void AngleBasDroit()
    {
     
        this.grille[A.getNombre1()][A.getNombre2()]=direction.get("Direction_bas_droit");
        this.grille[A.getNombre1()+1][A.getNombre2()]=direction.get("Direction_haut");
        this.grille[A.getNombre1()][A.getNombre2()+1]=direction.get("Direction_gauche");
    }

    public void AngleHautDroit()
    {
        this.grille[A.getNombre1()][A.getNombre2()]=direction.get("Direction_haut_droit");
        this.grille[A.getNombre1()-1][A.getNombre2()]=direction.get("Direction_bas");
        this.grille[A.getNombre1()][A.getNombre2()+1]=direction.get("Direction_gauche");
    }

    public void AngleHautGauche()
    {
        this.grille[A.getNombre1()][A.getNombre2()]=direction.get("Direction_haut_gauche");
        this.grille[A.getNombre1()-1][A.getNombre2()]=direction.get("Direction_bas");
        this.grille[A.getNombre1()][A.getNombre2()-1]=direction.get("Direction_droit");
    }

    
//Triage selon un numéro le dernier angle parmis les quatres quart du plateau 
    public void DernierAngle(int angleAlea)
    {
        if(angleAlea==1)
        {
            AngleBasGauche();
        }
        if(angleAlea==2)
        {
            AngleBasDroit();
        }
        if(angleAlea==3)
        {
            //Troisième Angle
            AngleHautDroit();
        }
        if(angleAlea==4)
        {
            //Quatrième Angle
            AngleHautGauche();
        }
    }
////////////////////////////////////////////////////////////
////////////////////// Fonction qui genere aleatoirement les elements du plateau /////////////////////////
public void init()
 {
     for(int i=7;i<9;i++)
    {
        //Entourer le centre 
        this.grille[6][i]=direction.get("Direction_bas");
        this.grille[i][6]=direction.get("Direction_droit");
        this.grille[9][i]=direction.get("Direction_haut");
        this.grille[i][9]=direction.get("Direction_gauche");
    }
    
    //Bord plateau Angles restriction
    this.grille[0][0]=direction.get("Direction_haut_gauche");
    this.grille[0][15]=direction.get("Direction_haut_droit");
    this.grille[15][0]=direction.get("Direction_bas_gauche");
    this.grille[15][15]=direction.get("Direction_bas_droit");

    ////// Quatre premier Mur Verticaux ///////
    //Tire et test deux nombre respectant les conditions
    TestAnglequartdroit();
    // Premier quart de plateau 0 a 7
    MurVertical(0,A.getNombre1());
    // Deuxieme quart de plateau 7 a 14
    MurVertical(0,A.getNombre2());
    
    //Troisième quart 15 a 7
    TestAnglequartdroit();
    MurVertical(15,A.getNombre1());
   //Qutrième quart 15 a 15
    MurVertical(15,A.getNombre2());

    /////////  Quatre Premier mur Horizontaux //////////
    TestAnglequartdroit();
    // Premier quart de plateau 0 a 7
    MurHorizontal(0,A.getNombre1());
    // Deuxieme quart 
    MurHorizontal(0,A.getNombre2());
    // Troisième quart 
    TestAnglequartdroit();
    MurHorizontal(15,A.getNombre1());
    //Quatrième quart 
    MurHorizontal(15,A.getNombre2());
   
    ///////////////////    Angles     ///////////////////////

    ////Quart gauche ////
    //Premier Angle
    // Test pour ne pas tomber sur un Mur vertical a la colonne -1
    TestAnglequartgauche();
    AngleBasGauche();

    //Deuxieme Angle
    TestAnglequartgauche();
    AngleBasDroit();

    //Troisième Angle
    TestAnglequartgauche();
    AngleHautDroit();

    //Quatrième Angle
    TestAnglequartgauche();
    AngleHautGauche();
/////////////////////////////////


    ////// Angle coté droit  ///////
    //Premier Angle
    TestAnglequartdroit();
    AngleBasGauche();

    //Deuxieme Angle
    TestAnglequartdroit();
    AngleBasDroit();

    //Troisième Angle
    TestAnglequartdroit();
    AngleHautDroit();

    //Quatrième Angle
    TestAnglequartdroit();
    AngleHautGauche();
/////////////////////////////////////////////

///////Angle coté gauche bas//////

    //Premier Angle
    TestAnglequartbasGauche();
    AngleBasGauche();

    //Deuxieme Angle
    TestAnglequartbasGauche();
    AngleBasDroit();

    //Troisième Angle
    TestAnglequartbasGauche();
    AngleHautDroit();

    //Quatrième Angle
    TestAnglequartbasGauche();
    AngleHautGauche();

////////Angle coté droit bas ////////////////////
    //Premier Angle
    TestAnglequartbasDroit();
    AngleBasGauche();

    //Deuxieme Angle
    TestAnglequartbasDroit();
    AngleBasDroit();

    //Troisième Angle
    TestAnglequartbasDroit();
    AngleHautDroit();

    //Quatrième Angle
    TestAnglequartbasDroit();
    AngleHautGauche();


    ///////// Dernier angle aléatoire //////////////////

    // Tire un nombre entre 1 et 4 pour le quart  
    int quartalea=A.NombreAleatoire1();
    // Tire l'angle entre 1 et 4 dans le hmap
    int angleAlea=A.NombreAleatoire1();

    //Si on tire le quart gauche
    if(quartalea==1)
    {
        TestAnglequartgauche();
        DernierAngle(angleAlea);

    }
    // Si on tire le quart droit 
    if(quartalea==2)
    {
        TestAnglequartdroit();
        // Angle coté droit 
        DernierAngle(angleAlea);

    }
    
    // Quart bas gauche 
    if(quartalea==3)
    {
        TestAnglequartbasGauche();
        // Angle coté gauche bas 
        DernierAngle(angleAlea);

    }

    // Quart bas droit 
    if(quartalea==4)
    {
        TestAnglequartbasDroit();
        // Angle coté droit bas 
        DernierAngle(angleAlea);

    }


    /////// PLACEMENT DU PION //////////
    int placement=0;
    Pion_objectif.PionJoueur();
    placement=A.TiragePlacement();
    Pion_objectif.pionPlacement(placement,this.grille,Joueur.grilleJoueur);
    Joueur.setHashRobot("Pion",Pion_objectif.getJoueurPion());

    //////// PLACEMENT DES JOUEURS ////////////////
    
        Joueur.joueurplacement(Joueur.getRobot("Robot_Bleu"));
        Joueur.joueurplacement(Joueur.getRobot("Robot_Rouge"));
        Joueur.joueurplacement(Joueur.getRobot("Robot_Vert"));
        Joueur.joueurplacement(Joueur.getRobot("Robot_Jaune"));
        
    // BORD DU PLATEAU A REMPLIR APRES LES ANGLES 
    for(int i=1;i<15;i++)
    {  
        //TEST si la valeur du plateau est egale a 0 sur toute la colonne 0 et sur toute la conne 15 
        if(this.grille[i][0]==0)
        {
            this.grille[i][0]=direction.get("Direction_gauche");
        }
        if(this.grille[i][0]==direction.get("Direction_droit"))
        {
            this.grille[i][0]=direction.get("Direction_gauche_droit");
        }

         if(this.grille[i][15]==0)
        {
            this.grille[i][15]=direction.get("Direction_droit");
        }
        if(this.grille[i][15]==direction.get("Direction_gauche"))
        {
            this.grille[i][15]=direction.get("Direction_gauche_droit");
        }
       
       // Test pour ligne 0 et 15
        if(this.grille[0][i]==0)
        {
            this.grille[0][i]=direction.get("Direction_haut");
        }
        if(this.grille[0][i]==direction.get("Direction_bas"))
        {
            this.grille[0][i]=direction.get("Direction_bas_haut");
        }

        if(this.grille[15][i]==0)
        {
            this.grille[15][i]=direction.get("Direction_bas");
        }
        if(this.grille[15][i]==direction.get("Direction_haut"))
        {
            this.grille[15][i]=direction.get("Direction_bas_haut");
        }
    
        
    }

    //Initialiser les tableau ligne colonne des position des joueurs 
    Joueur.initx_yJoueur();
}

//Affichage plateau 
public String AffichagePlateau(){

    String plateau =" ";
    // Bord haut du plateeau
  for(int i=0;i<16;i++){
      plateau+="---";
  }

     for(int i=0;i<16;i++){

          plateau+=System.lineSeparator()+"|";
        
      for(int j=0;j<16;j++){

            if(grille[i][j]!=this.direction.get("Direction_gauche") && grille[i][j]!=this.direction.get("Direction_droit") && grille[i][j]!=this.direction.get("Direction_gauche_droit"))   
            {     
                if(Joueur.getgrilleJoueur(i,j)==Joueur.getRobot("Robot_Bleu"))
                {
                plateau+=" B ";
                }
                if(Joueur.getgrilleJoueur(i,j)==Joueur.getRobot("Robot_Rouge")){
                plateau+=" R ";
                }
                if(Joueur.getgrilleJoueur(i,j)==Joueur.getRobot("Robot_Vert")){
                plateau+=" V ";
                }
                if(Joueur.getgrilleJoueur(i,j)==Joueur.getRobot("Robot_Jaune")){
                plateau+=" Y ";
                }
            }

             //Mur droit 
            if(grille[i][j]==this.direction.get("Direction_droit"))
             {
                 // Test pour ne pas remplir le mur droit du plateau
                 if(j!=15)
                 { 
                    if(Joueur.getgrilleJoueur(i,j)==0)
                    {
                        plateau+=" .|";
                    }
                    if(Joueur.getgrilleJoueur(i,j)==11) 
                    {
                        plateau+=" B|";
                    }
                    if(Joueur.getgrilleJoueur(i,j)==12) 
                    {
                        plateau+=" R|";
                    }
                    if(Joueur.getgrilleJoueur(i,j)==13) 
                    {
                        plateau+=" V|";
                    }
                    if(Joueur.getgrilleJoueur(i,j)==14) 
                    {
                        plateau+=" Y|";
                    }
                 }
                 if(j==15 )
                 {
                    if(Joueur.getgrilleJoueur(i,j)==0) 
                    {
                        plateau+=" . ";
                    }
                    if(Joueur.getgrilleJoueur(i,j)==11) 
                    {
                        plateau+=" B ";
                    }
                    if(Joueur.getgrilleJoueur(i,j)==12) 
                    {
                        plateau+=" R ";
                    }
                    if(Joueur.getgrilleJoueur(i,j)==13) 
                    {
                        plateau+=" V ";
                    }
                    if(Joueur.getgrilleJoueur(i,j)==14)  
                    {
                        plateau+=" Y ";
                    }                   

                }
                 

            }
             
             //Direction gauche
            if( grille[i][j]==this.direction.get("Direction_gauche"))
            {
                if(j==0 || (j!=0 && grille[i][j-1]==this.direction.get("Direction_droit")))
                {
                    if(Joueur.getgrilleJoueur(i,j)==0)
                    {
                        plateau+=" . ";
                    }
                    if(Joueur.getgrilleJoueur(i,j)==11)
                    {
                        plateau+=" B ";
                    }
                    if(Joueur.getgrilleJoueur(i,j)==12)
                    {
                        plateau+=" R ";
                    }                    
                    if(Joueur.getgrilleJoueur(i,j)==13)
                    {
                        plateau+=" V ";
                    }
                    if(Joueur.getgrilleJoueur(i,j)==14)
                    {
                        plateau+=" Y ";
                    }
                }

                 if(j!=0 && grille[i][j-1]!=this.direction.get("Direction_droit")) 
                { 
                    if(Joueur.getgrilleJoueur(i,j)==0) 
                    {
                        plateau+="|. ";
                    }

                    if(Joueur.getgrilleJoueur(i,j)==11)
                    {
                        plateau+="|B ";
    
                    }
                    if(Joueur.getgrilleJoueur(i,j)==12)
                    {
                        plateau+="|R ";
    
                    }
                    if(Joueur.getgrilleJoueur(i,j)==13)
                    {
                        plateau+="|V ";
    
                    }
                    if(Joueur.getgrilleJoueur(i,j)==14)
                    {
                        plateau+="|Y ";
    
                    }
                }
               
            }

             if(grille[i][j]==this.direction.get("Direction_gauche_droit") )
             { 
                 if(j==0 && Joueur.getgrilleJoueur(i,j)==0)
                 {
                    plateau+=" .|";
                 }
                 if(j==0 && Joueur.getgrilleJoueur(i,j)==11)
                 {
                     plateau+=" B|";
                 }
                 if(j==0 && Joueur.getgrilleJoueur(i,j)==12)
                 {
                     plateau+=" R|";
                 }
                 if(j==0 && Joueur.getgrilleJoueur(i,j)==13)
                 {
                     plateau+=" V|";
                 }
                 if(j==0 && Joueur.getgrilleJoueur(i,j)==14)
                 {
                     plateau+=" Y|";
                 }


             }
            if(grille[i][j]==this.direction.get("Direction_gauche_droit") )
            {
                if(j==15 && Joueur.getgrilleJoueur(i,j)==0)
                {
                    plateau+="|. ";
                }
                if(j==15 && Joueur.getgrilleJoueur(i,j)==11)
                {
                    plateau+="|B ";
                }
                if(j==15 && Joueur.getgrilleJoueur(i,j)==12)
                {
                    plateau+="|R ";
                }
                if(j==15 && Joueur.getgrilleJoueur(i,j)==13)
                {
                    plateau+="|V ";
                }
                if(j==15 && Joueur.getgrilleJoueur(i,j)==14)
                {
                    plateau+="|Y ";
                }
                 
             }
            
            if(Joueur.getgrilleJoueur(i,j)==0)
            {
                // MUR VERTICAL HORIZONTAL
                if( (grille[i][j]==this.direction.get("Direction_haut") || grille[i][j]==this.direction.get("Direction_bas")))
                {
                    plateau+=" . ";
                }

                // Angle haut gauche
                if(grille[i][j]==this.direction.get("Direction_haut_gauche"))
                {                    
                    plateau+=" . ";
                }
                
                // Angle haut droit
                if(grille[i][j]==this.direction.get("Direction_haut_droit"))
                { 
                    plateau+=" . ";
                }
                // Angle bas gauche
                if(grille[i][j]==this.direction.get("Direction_bas_gauche"))
                {                    
                    plateau+=" . ";                   
                }
                // Angle bas droit
                if(grille[i][j]==this.direction.get("Direction_bas_droit"))
                {                    
                    plateau+=" . ";
                }

                if(grille[i][j]==this.direction.get("Toute_direction"))
                {
                    plateau+=" . ";                  
                }
                if(grille[i][j]==direction.get("Direction_bas_haut"))
                {
                    plateau+=" . ";
                }
            }
               if(j==15)
            {
                plateau+="|";

            }
  
      }
      //ajout bas ligne sur une case ou haut 
        plateau+=System.lineSeparator()+"|";
        for(int j=0;j<16;j++)
        { 
            if( (i!=15 && i!=0) && (grille[i][j]==this.direction.get("Direction_bas") || grille[i+1][j]==this.direction.get("Direction_haut"))||(i==0 && grille[i][j]==this.direction.get("Direction_bas_haut")) || (i==14 && grille[i+1][j]==this.direction.get("Direction_bas_haut")))
            {
                plateau+="---";
            }               
            else{
                plateau+="   ";
            }
            if(j==15)
            {
                plateau+="|";
            }
        }
   }
   // bord bas du plateau
   plateau+=System.lineSeparator();
   plateau+=" ";
   for(int i=0;i<16;i++){
      plateau+="---";
  }

          
   return plateau;
 }


}