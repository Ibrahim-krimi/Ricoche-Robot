package joueur;
import randomfonction.*;
import games.*;
import randomfonction.*;
import java.util.*;
import java.awt.*;


public class Astar {
    private ArrayList<String> listecouleurRobot = new ArrayList<String>();
    private ArrayList<String> listecheminRobot = new ArrayList<String>();
    private int compteurmouvement=0;


    public Astar()
    {
        
    }
    public int getCompteur()
    {
        return this.compteurmouvement;
    }
    public ArrayList<String> getListecouleur()
    {
        return this.listecouleurRobot;
    }
    public ArrayList<String>getListechemin()
    {
        return this.listecheminRobot;
    }
    //Test b<a (comparaison pour retourner le chemin sous une forme optimisé)
    public boolean estPlupetit(int a,int b)
    {
        if(a>b)
        {
            return true;
        }
        return false;
    }

    //Test b > a
    public boolean estPlugrand(int a,int b)
    {
        if(a<b)
        {
            return true;
        }
        return false;
    }

    //Retourne la direction emprinter selon l'anctre 
    public String RetourneDirection(int i_ancetre,int i,int j_ancetre,int j)
    {
        if(estPlupetit(i_ancetre,i))
        {
            return "Direction_haut";
        }
        if(estPlupetit(j_ancetre,j))
        {
            return "Direction_gauche";
        }
        if(estPlugrand(i_ancetre,i))
        {
            return "Direction_bas";
        }
        if(estPlugrand(j_ancetre,j))
        {
            return "Direction_droit";
        }
        return "";

    } 
    //Compare les tableau de coordonée 
    public boolean ComparaisonTab(int [] tab1,int [] tab2)
    {
        int cmpt=0;
        for(int i=0;i<4;i++)
        {
            if(tab1[i]==tab2[i])
            {
                cmpt++;
            }
        }
        if(cmpt==4)
        {
            return true;
        }
        return false;
    }

    public Integer compare2Noeuds(Noeud n1, Noeud n2)
    {
        if(n1.getheuristique() > n2.getheuristique())
        {
            return 1;
        }
        if(n1.getheuristique()  == n2.getheuristique() )
        {
            return 0;
        }
        return -1;
    }


    public int distance(int x1,int y1,int x2,int y2)
    {
        int x=x1-x2;
        int y=y1-y2;
        return Math.abs(x) + Math.abs(y);
    }
    
    
    public boolean existeCoutinf(PriorityQueue<Noeud> openList,Noeud v)
    {
        for(Noeud e : openList)
        {
            
            if(e.getcout()<= v.getcout() && ComparaisonTab(e.gettabX(),v.gettabX()) && ComparaisonTab(e.gettabY(),v.gettabY()))              
            {
                return true;
            }
            
        }
        return false;
    }

    public boolean contient(ArrayList<Noeud> closedList,Noeud v)
    {
         for(Noeud e : closedList)
        {
            
            if(ComparaisonTab(e.gettabX(),v.gettabX()) && ComparaisonTab(e.gettabY(),v.gettabY()))                
            {
                return true;
            }
            
        }
        return false;
    }
    
    //Reconstitue le chemin 
    public ArrayList<Noeud> reconstituerChemin(Noeud u)
    {
        ArrayList<Noeud> listeChemin = new ArrayList<Noeud>();
         while(u.getAncetre()!=null)
         {
            listeChemin.add(u);
            u=u.getAncetre();
         }

         return listeChemin;
    }

        // Test si les coordonnée du noeud correspond au jeu en paramètre 
        public boolean testPlateu(Jeu j,Noeud u)
        {
            for(int valeur=11;valeur<15;valeur++)
            {
                if(u.getLigneNoeud(valeur)!=j.getRobot().getLigneJoueur(valeur) || u.getColonneNoeud(valeur)!=j.getRobot().getColonneJoueur(valeur))
                {
                        return false;
                }
            }
            return true;
        }

    // Retourne une liste contenant le chemin de façon optimisé 
    public void ConvertListNoeud(ArrayList<Noeud> listeNoeud,Robots R,Noeud depart)
    {
        if(listeNoeud!=null)
        {
            
            // Ajout du depart car non stocké dans la liste 
            listeNoeud.add(depart);           

            //Noeud partant du depart jusqu'a l'arrivé 
            for(int i=listeNoeud.size()-1;i>0;i--)
            {
                
                for(int valeur=11;valeur<15;valeur++)
                {
                    int ligne=listeNoeud.get(i).getLigneNoeud(valeur);
                    int colonne=listeNoeud.get(i).getColonneNoeud(valeur);
                    if(i!=0)
                    {
                        int ligne_next=listeNoeud.get(i-1).getLigneNoeud(valeur);
                        int colonne_next=listeNoeud.get(i-1).getColonneNoeud(valeur);
                        String direction = RetourneDirection(ligne,ligne_next,colonne,colonne_next);
                        if(!direction.equals(""))
                        {
                            listecouleurRobot.add(R.RobotColor(valeur));
                            listecheminRobot.add(direction);
                        }
                    }
                    
                }
            }
        }
        else {
            System.out.println("Le plateau n'a aucun chemin possible ! ");
        }
    }

    // Recherche le chemin le plus court 
    public ArrayList<Noeud> cheminPlusCourt(Jeu jeu, Noeud depart,Objectif Pion_objectif)
    {
        //Objectif
        int LigneObjectif=Pion_objectif.getLignepion();
        int ColonneObjectif =Pion_objectif.getColonnepion();
        int valeurjoueurCourrant=Pion_objectif.getJoueurPion(); 

        //Heuristique Noeud depart 
        depart.setheuristique(depart.getcout()+distance(depart.getLigneNoeud(valeurjoueurCourrant),depart.getColonneNoeud(valeurjoueurCourrant),LigneObjectif,ColonneObjectif));
        depart.setAncetre(null);

        //Declaration liste 
        ArrayList<Noeud> closedList = new ArrayList<Noeud>();
        ArrayList<Jeu> listeJeu = new ArrayList<Jeu>();

        //Ajoute le jeu actuelle à la liste 
        listeJeu.add(jeu);
        

        //Liste comparaison
        Comparator<Noeud> comparator = (Noeud n1,Noeud n2) -> compare2Noeuds(n1, n2);
        PriorityQueue<Noeud> openList = new PriorityQueue<>(comparator);
        //AJout depart et copy du jeu 
        openList.add(depart);
        Jeu jeuCopy=jeu.copy();

        //Tant que l'open liste n'est pas vide 
        while(openList.size()!=0)
        {
           
            //Sortir le noeud trier selon comparatore et le supprimer de l'open
            Noeud u = openList.poll();   
            //Retourne le chemin Si le robot atteinds l'objectif
            if(u.getLigneNoeud(valeurjoueurCourrant) == LigneObjectif && u.getColonneNoeud(valeurjoueurCourrant) == ColonneObjectif)
            {
                return reconstituerChemin(u);
            }

            //Sinon
            //Sortir les jeu stoquer et reprendre le plateau qui correspond au noeud extrait
            for(Jeu j : listeJeu)
            {
                // Test coordonnée de u corresponde au coordonée des robots du jeu 
                if(testPlateu(j,u))
                {
                    jeuCopy = j.copy();
                    listeJeu.remove(jeuCopy);
                    break;
                }
                
            }

            //Utilisé chaque joueur pour amener le robot principal à l'objectif 
            for(int valeurjoueur=11;valeurjoueur<15;valeurjoueur++)
            {
                //Liste des coups du joueur selon valeurjoueur
                ArrayList<String> liste = new ArrayList<String>();
                liste = jeuCopy.getMove(valeurjoueur-10);

                //Parcour coups dans la liste 
                for(int i=0;i<liste.size();i++)
                {
                    //Declaration d'un nouveau jeu copie pour ne pas modifié le jeu actuelle et jouer sur la copie
                    Jeu jeuCopy2=jeuCopy.copy();
                    jeuCopy2.play(i,valeurjoueur-10);
                    compteurmouvement++;
                    //Initialisation du noeud selon le coup jouer 
                    Noeud v = new Noeud(jeuCopy2.getRobot().getRobotTabX(),jeuCopy2.getRobot().getRobotTabY(),u.getcout()+1,0);
                    v.setheuristique(v.getcout()+distance(v.getLigneNoeud(valeurjoueurCourrant),v.getColonneNoeud(valeurjoueurCourrant),LigneObjectif,ColonneObjectif));
                    v.setAncetre(u);
                    
                    // Condition d'ajout du noeud à l'openList
                    if (!contient(closedList,v) && !existeCoutinf(openList,v))
                    {   
                            //Stocker l'etat jouer seulement si le noeud est ajouter 
                            listeJeu.add(jeuCopy2);
                            openList.add(v);
                            
                    }
                    
                } 
            }
            
           closedList.add(u);
        }
        return null;
    }


}

