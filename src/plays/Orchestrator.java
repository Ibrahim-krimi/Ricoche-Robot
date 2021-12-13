package plays;
import games.*;
import randomfonction.*;
import joueur.*;
import java.util.*;
import java.awt.*;

public class Orchestrator {
   Scanner scanner=new Scanner(System.in);

    public Orchestrator(){
        
    }

   // Affiche le robot et ça direction 
   public void AffichageChemin(ArrayList<String> chemintoString,ArrayList<String> robotColor)
   {
      //Affichage du chemin 
      if(!chemintoString.isEmpty())
      {
         for(int i=0;i<chemintoString.size();i++)
         {
            System.out.println("Déplacement numéro : " +(i+1));
            System.out.println(robotColor.get(i) + " " + chemintoString.get(i) + "\n");
         }
      }
   }
   //Saisie du choix de la résolution 
   public int ChoixUtilisateur()
   {
      
      System.out.println("Choissir un choix de jeu : ");
      System.out.println("Choix 1 : Résolution automatique = '1'");
      System.out.println("Choix 2 : Résolution saisie clavier = '2'");
      System.out.println("Choix 3 : Affichage du chemin le plus court = '3'");
      System.out.println("Choix 4 : Quitter le jeu = '4'");
      int choix = scanner.nextInt();
      while(choix>4 || choix<1)
      {
         choix=ChoixUtilisateur();
      }
      return choix;

   }
   // Resolution autonome 
   public void resolutionAutonome(String direction,int valeur,Jeu jeu)
   {
      valeur=valeur-10;
      ArrayList<String> liste = new ArrayList<String>();
      liste=jeu.getMove(valeur);
      for(int i=0;i<liste.size();i++)
      {
         
         if(liste.get(i).equals(direction))
         {
            System.out.println(jeu.getRobot().RobotColor(valeur+10) +" "+ direction);
            jeu.play(i,valeur);
            break;
         }
      }
   }
   
   //Déclaration et partie du jeu 
   public void PlayGame()
   {
      //Object du jeu 
      Objectif pion = new Objectif();
      Robots R = new Robots(pion);
      Plateau p = new Plateau(R,pion);
      Jeu jeu = new Jeu(p,R,pion);

      ArrayList<String> liste = new ArrayList<String>();
      
        
      // Init la hashmap et centre 
      p.Initialisation();
      //Tire un plateau aleatoire 
      p.init();

      //Affichage plateau et objectif     
      System.out.println(jeu.getAffichagePlateau());
      R.Affichageobjectif();
      

      int valeurPion = jeu.getvaleurObjectif();
      Noeud depart = new Noeud(R.getRobotTabX(),R.getRobotTabY(),0,0);
      Astar As = new Astar();

      //Liste Meilleur chemin 
      ArrayList<Noeud> listeChemin = new ArrayList<Noeud>();
      ArrayList<String> robotColor = new ArrayList<String>();
      ArrayList<String> chemintoString = new ArrayList<String>();

      
      int choix = ChoixUtilisateur();
      if(choix==3)
      {
         System.out.println("Recherche du chemin...");
         listeChemin=As.cheminPlusCourt(jeu,depart,pion);
         As.ConvertListNoeud(listeChemin,R,depart);

         robotColor=As.getListecouleur();
         chemintoString=As.getListechemin();
         
         //Affichage du chemin
         AffichageChemin(chemintoString,robotColor);
         System.out.println("Nombre de déplacements total effectués : " +As.getCompteur());
      }

      if(choix<3)
      {
         // Déroulement du jeu selon choix
         while(!jeu.isOver())
         {
            //Resolution autonome 
            if(choix==1)
            {
               System.out.println("Recherche du chemin...");
               listeChemin=As.cheminPlusCourt(jeu,depart,pion);
               As.ConvertListNoeud(listeChemin,R,depart);

               robotColor=As.getListecouleur();
               chemintoString=As.getListechemin();
         
               for(int i=0;i<chemintoString.size();i++)
               {
                  resolutionAutonome(chemintoString.get(i),R.getRobot(robotColor.get(i)),jeu);
               }
               System.out.println("Nombre de déplacements total effectués : " + As.getCompteur());

            }
            //Résolution joueur clavier 
            if(choix==2)
            {
               Joueur joueur = new Joueur();
               int NumeroJoueur=joueur.Saisie();

               // Liste de pion afficher avec le numéro à entrer pour chaque direction 
               liste=jeu.getMove(NumeroJoueur);
               int cmpt=0;
               for(String i : liste)
               {
                  System.out.println(i + " = "+cmpt);
                  cmpt++;
               }
            
               System.out.println("Saisir un coup: ");
               int coup=scanner.nextInt();

               //Test coup 
               while(coup <0 || coup>=liste.size())
               {
                  System.out.println("Erreur ! Saisir un coup valide : ");
                  coup=scanner.nextInt();
               }
               jeu.play(coup,NumeroJoueur);
               System.out.println(p.AffichagePlateau());
                  
            }

         }
         System.out.println(p.AffichagePlateau());
         System.out.println("Vous avez gagné ! ");
      }
      System.out.println("Exit");
       
   }
   
}