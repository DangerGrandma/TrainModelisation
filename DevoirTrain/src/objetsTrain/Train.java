/* @classe Train
 * La classe Train gouverne l'objet principal manipul� par le programme. Il s'agit d'un Thread qui s'aventurera
 * sur un trajet d'objets Cases pr�-d�fini par la classe Voie.
 */

package objetsTrain;

public class Train implements Runnable {

	protected static int input = 0;
	protected String nom; // Num�ro du Train
	protected Voie voieTrain; // Voie sur laquelle circule le train
	protected int caseInt; // Case sur laquelle se situe le train
	
	
	// Constructeur des Trains
	
	public Train(String s, Voie v, int i) {
		this.nom = s;
		this.voieTrain = v;
		this.caseInt = i;
	}
	
	
	/*
	 * Il s'agit de la fonction principale du programme. Quand un Train l'invoque, on v�rifie d'abord sur quelle
	 * case il se situe. S'il s'agit d'une Gare, on v�rifie �galement sur quelle Voie se situe le train.
	 * On peut cons�quemment v�rifier quelle est la Case qui devrait suivre logiquement. Le Train tente alors
	 * d'invoquer @method acquire() la Case en question par l'entremise de @method entrer(). Apr�s la p�riode
 	 * d'attente de 1 seconde, le Train invoque @method sortir() afin de lib�rer son ancienne Case.
 	 */


	public void avancer()
	{
		if(voieTrain.trajet.get(caseInt) == Case.Gare1 && voieTrain == Voie.Voie1)
		{
			voieTrain.trajet.get(Case.Gare1.nextVoie1).entrer(this);
			voieTrain.trajet.get(caseInt).sortir(this);
		}
		else if(voieTrain.trajet.get(caseInt) == Case.Gare2 && voieTrain == Voie.Voie1)
		{
			voieTrain.trajet.get(Case.Gare2.nextVoie1).entrer(this);
			voieTrain.trajet.get(caseInt).sortir(this);
		}
		else if(voieTrain.trajet.get(caseInt) == Case.Gare3 && voieTrain == Voie.Voie1)
		{
			voieTrain.trajet.get(Case.Gare3.nextVoie1).entrer(this);
			voieTrain.trajet.get(caseInt).sortir(this);			
		}
		
		else if(voieTrain.trajet.get(caseInt) == Case.Gare1 && voieTrain == Voie.Voie2)
		{
			voieTrain.trajet.get(Case.Gare1.nextVoie2).entrer(this);
			voieTrain.trajet.get(caseInt).sortir(this);
		}
		else if(voieTrain.trajet.get(caseInt) == Case.Gare2 && voieTrain == Voie.Voie2)
		{
			voieTrain.trajet.get(Case.Gare2.nextVoie2).entrer(this);
			voieTrain.trajet.get(caseInt).sortir(this);
		}
		else if(voieTrain.trajet.get(caseInt) == Case.Gare3 && voieTrain == Voie.Voie2)
		{
			voieTrain.trajet.get(Case.Gare3.nextVoie2).entrer(this);
			voieTrain.trajet.get(caseInt).sortir(this);
		}
		
		else if(voieTrain.trajet.get(caseInt) == Case.Gare1 && voieTrain == Voie.Voie3)
		{
			voieTrain.trajet.get(Case.Gare1.nextVoie3).entrer(this);
			voieTrain.trajet.get(caseInt).sortir(this);
		}
		else if(voieTrain.trajet.get(caseInt) == Case.Gare2 && voieTrain == Voie.Voie3)
		{
			voieTrain.trajet.get(Case.Gare2.nextVoie3).entrer(this);
			voieTrain.trajet.get(caseInt).sortir(this);
		}
		else if(voieTrain.trajet.get(caseInt) == Case.Gare3 && voieTrain == Voie.Voie3)
		{
			voieTrain.trajet.get(Case.Gare3.nextVoie3).entrer(this);
			voieTrain.trajet.get(caseInt).sortir(this);
		}
		
		/*
		 *  Si la Case sur laquelle se situe le Train n'est pas une Gare, on proc�de tout simplement au d�placement
		 *  vers la Case suivante en fonction de la liste de Cases @param trajet relative � la voie propre au train.
		 *  Les fonctions entrer() et sortir() sont invoqu�es normalement par la suite.
		 */
		
		else {
		voieTrain.trajet.get(voieTrain.trajet.get(caseInt).nextCase).entrer(this);
		voieTrain.trajet.get(caseInt).sortir(this);
		}
		
		/*
		 * Finalement, @param caseInt est augment� de un afin de faire "bouger" le Train d'une Case. si @param caseInt
		 * devait d�passer @param trajetLonguer de la Voie sur laquelle il se trouve, on le transforme � 0 afin de 
		 * retourner au d�but du tableau.
		 */
		
		caseInt++;
		if(caseInt == voieTrain.trajetLongueur)
		{
			caseInt = 0;
		}
	}
	
	
	/*
	 *  M�thode de lancement pour les Threads Train. Les Threads seront en action tant que 60 entr�es en Gare
	 *  n'auront pas eu lieu par l'entremise de @param input.
	 */
	
	@Override
	public void run() {
		try {
			while (input <= 60) {
				avancer();
				Thread.sleep(10);
			}
			System.out.println("Termin�!");
		} catch (Exception e) {}
		
	}

}
