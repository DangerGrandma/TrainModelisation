/* 
 * @class Voie
 * Utilisée afin de déterminer le trajet emprunté par les trains. Chaque Voie se voit attribuée les trois gares,
 * avec leurs positions respectives selon la Voie.
*/

package objetsTrain;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;


public class Voie {

	protected ArrayList<Case> trajet; // Tableau de Cases.
	protected int trajetLongueur; // Longueur du tableau, et donc du trajet.

	// Le constructeur suivant sert à fixer à une Voie la longueur de son trajet.
	
	public Voie(int i)
	{
		this.trajetLongueur = i;
	}
	
	static Voie Voie1 = new Voie(12);
	static Voie Voie2 = new Voie(15);
	static Voie Voie3 = new Voie(18);
	
	/*
	 * La fonction addTrajet() sert à attribuer à une Voie son tableau de Cases @param trajet en fonction de sa longueur.
	 * Un tableau temporaire @param tabCase conserve les données nécessaires avant de les transferer à @param trajet.
	 */
	
	public void addTrajet()

	{
		ArrayList<Case> tabCase = new ArrayList<Case>(); // Tableau de Cases temporaire
		for (int i = 0; i < this.trajetLongueur; i++)
			
		{
			Case caseTemp = new Case();			
			caseTemp.nextCase = i+1;  // Fixe à une Case sa prochaine Case
			caseTemp.selfCase = i;	// Fixe à une Case sa propre valeur
			caseTemp.sema = new Semaphore(1);  // Donne à une Case son sémaphore
				if(caseTemp.nextCase >= this.trajetLongueur) 
				{
					caseTemp.nextCase = 0; // Retour à la première case du tableau si cette valeur dépasse @param trajetLongueur.
				}
			tabCase.add(caseTemp); // Ajout de cette Case au tableau temporaire.
			
		}
		
		
		this.trajet = tabCase; // Ajout du tableau temporaire au vrai tableau trajet.
	
		/*
		 * Les trois vérifications suivantes servent à modifier le trajet de sorte que les Cases qui devraient
		 * être occupées par des Gares subissent cette transformation. Elles sont conçues afin d'initialiser
		 * les voies comme l'indique la figure dans l'énoncé.
		 * 
		 */
		
		if(this.trajetLongueur == 12)
		{
			this.trajet.set(2, Case.Gare1);
			this.trajet.set(4, Case.Gare2);
			this.trajet.set(9, Case.Gare3);
		}
		
		if(this.trajetLongueur == 15)
		{
			this.trajet.set(2, Case.Gare1);
			this.trajet.set(9, Case.Gare2);
			this.trajet.set(12, Case.Gare3);
		}
		
		if(this.trajetLongueur == 18)
		{
			this.trajet.set(4, Case.Gare1);
			this.trajet.set(9, Case.Gare2);
			this.trajet.set(17, Case.Gare3);
		}
	}

}
