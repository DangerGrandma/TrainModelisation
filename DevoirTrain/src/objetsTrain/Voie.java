package objetsTrain;

import java.util.ArrayList;

/* 
 * Classe Voie : utilis�e afin de d�terminer le trajet emprunt� par les trains. Chaque voit se voit attribu�e les trois gares,
 * avec leurs positions respectives selon la Voie.
*/

public class Voie {

	protected ArrayList<Case> trajet; // Tableau de Cases.
	protected int trajetLongueur; // Longueur du tableau, et donc du trajet.

	// Le constructeur suivant sert � fixer � une Voie la longueur de son trajet.
	
	public Voie(int i)
	{
		this.trajetLongueur = i;
	}
	
	/*
	 * La fonction addTrajet() sert � attribuer � une Voie son tableau de Cases @param trajet en fonction de sa longueur.
	 * Un tableau temporaire @param tabCase conserve les donn�es n�cessaires avant de les transferer � @param trajet.
	 */
	
	public void addTrajet()

	{
		ArrayList<Case> tabCase = new ArrayList<Case>(); // Tableau de Cases temporaire
		for (int i = 0; i < this.trajetLongueur; i++)
			
		{
			Case caseTemp = new Case(false);			
			caseTemp.nextCase = i+1;  // Fixe � une Case sa prochaine Case
			tabCase.add(caseTemp);
			
		}
		
		this.trajet = tabCase;
	
		/*
		 * Les trois v�rifications suivantes servent � modifier le trajet de sorte que les Cases qui devraient
		 * �tre occup�es par des Gares subissent cette transformation. Elles sont con�ues afin d'initialiser
		 * les voies comme l'indique la figure dans l'�nonc�.
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
