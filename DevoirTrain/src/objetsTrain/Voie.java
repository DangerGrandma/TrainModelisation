package objetsTrain;

import java.util.ArrayList;

/* 
 * Classe Voie : utilisée afin de déterminer le trajet emprunté par les trains. Chaque voit se voit attribuée les trois gares,
 * avec leurs positions respectives selon la Voie.
*/

public class Voie {

	protected ArrayList<Case> trajet; // Tableau de Cases.
	protected int trajetLongueur; // Longueur du tableau, et donc du trajet.

	// Le constructeur suivant sert à fixer à une Voie la longueur de son trajet.
	
	public Voie(int i)
	{
		this.trajetLongueur = i;
	}
	
	/*
	 * La fonction addTrajet() sert à attribuer à une Voie son tableau de Cases @param trajet en fonction de sa longueur.
	 * Un tableau temporaire @param tabCase conserve les données nécessaires avant de les transferer à @param trajet.
	 */
	
	public void addTrajet()

	{
		ArrayList<Case> tabCase = new ArrayList<Case>(); // Tableau de Cases temporaire
		for (int i = 0; i < this.trajetLongueur; i++)
			
		{
			Case caseTemp = new Case(false);			
			caseTemp.nextCase = i+1;  // Fixe à une Case sa prochaine Case
			tabCase.add(caseTemp);
			
		}
		
		this.trajet = tabCase;
	
		/*
		 * Les trois vérifications suivantes servent à modifier le trajet de sorte que les Cases qui devraient
		 * être occupées par des Gares subissent cette transformation. Elles sont conçues afin d'initialiser
		 * les voies comme l'indique la figure dans l'énoncé.
		 * 
		 */
		
		if(this.trajetLongueur == 12)
		{
			this.trajet.set(1, Case.Gare1);
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
