/* @class Case
 * La classe Case représente un objet sur lequel un Train se déplace. Une Case peut
 * être une Gare, ce qui peut altérer son comportement de façon mineure.
 */

package objetsTrain;

import java.util.concurrent.Semaphore;

public class Case {
	
	/* @param sema est un sémaphore qui permet de déterminer si une case est occupée ou non.
	 * @param trainNum sert à déterminer quel train occupe la Case, si cette Case est occupée.
	 * @param nextCase sert à vérifier quelle est la Case suivante d'un objet de type Case.
	 * @param nextVoie1 à nextVoie3 servent à déterminer quelle est la prochaine Case d'une Gare selon la Voie qui vérifie la valeur.
	*/
	
	protected Semaphore sema;
	protected Train trainNum;
	protected int selfCase;
	protected int nextCase;
	protected int nextVoie1;
	protected int nextVoie2;
	protected int nextVoie3;

	// Création des Gares, objets globaux qui seront manipulés constamment.
	
	 static Case Gare1 = new Case();
	 static Case Gare2 = new Case();
	 static Case Gare3 = new Case();



	/* Méthode qui sert à classifier une Case comme Gare, en fixant sa position sur une Voie selon la voie.
	 * Ne sera qu'appliquée @Objects Gare1, Gare2 et Gare3 dans la méthode Main.
	 */
	
	public void setGare(int a, int b, int c)
	{
		this.nextVoie1 = a;
		this.nextVoie2 = b;
		this.nextVoie3 = c;
	}
	
	/* Méthode qui sert à placer un Train dans une Case. Si la Case à entrer par le Train est une Gare,
	 * on envoie un message en console pour signaler l'intention d'entrer cette Gare. Dans ce cas,
	 * après l'acquisition du sémaphore unique de la Gare, un second message est passé en console
	 * pour indiquer à quel moment un Train est parvenu à entrer dans la Gare, puis le Thread est
	 * mis en attente pour 1 seconde. On tient compte du nombre d'entrées dans des Gares en augmentant
	 * @param input.
	 */
	
	public void entrer(Train t)
	{
		try {
			
		if(this == Gare1) {
			System.out.println(t.nom + " demande d'entrer dans la Gare-1 au temps " + (int)Chrono.temps);
			Gare1.sema.acquire();
			System.out.println(t.nom + " entre dans la Gare-1 au temps " + (int)Chrono.temps);
			Train.input++;
			Thread.sleep(1000);
		}
		else if(this == Gare2) {
			System.out.println(t.nom + " demande d'entrer dans la Gare-2 au temps " + (int)Chrono.temps);
			Gare2.sema.acquire();
			System.out.println(t.nom + " entre dans la Gare-2 au temps " + (int)Chrono.temps);	
			Train.input++;
			Thread.sleep(1000);
		}
		else if(this == Gare3) {
			System.out.println(t.nom + " demande d'entrer dans la Gare-3 au temps " + (int)Chrono.temps);
			Gare3.sema.acquire();
			System.out.println(t.nom + " entre dans la Gare-3 au temps " + (int)Chrono.temps);
			Train.input++;
			Thread.sleep(1000);
			
		/*
		 * Si la Case à entrer n'est pas une Gare, on tente d'acquérir le sémaphore de la prochaine Case quand même,
		 * sans cependant en afficher le message.
		 */
			
		}
		else if (this != Gare1 || this != Gare2 || this != Gare3) {
			this.sema.acquire();
		}
		
		// Ultimement, la Case ou la Gare entrée aura son @param trainNum modifié au Train qui y entre. 
			this.trainNum = t;
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	

	
	/*
	 *  Méthode qui sert à retirer un Train d'une Case. Cette case perd son @param trainNum, puis vérifie
	 *  si la Case est en fait une Gare. Dans ce cas, un message est affiché à la console pour indiquer
	 *  ce movement. Enfin, le sémaphore de cette Case est relâché.
	 */
	
	public void sortir(Train t)
	{
		this.trainNum = null;
		
		if(this == Gare1) {
			System.out.println(t.nom + " quitte la Gare-1 au temps  " + (int)Chrono.temps);		
		}
		else if(this == Gare2) {
			System.out.println(t.nom + " quitte la Gare-2 au temps  " + (int)Chrono.temps);		
		}
		else if(this == Gare3) {
			System.out.println(t.nom + " quitte la Gare-3 au temps  " + (int)Chrono.temps);		
		}
		
		sema.release();
	}

}
