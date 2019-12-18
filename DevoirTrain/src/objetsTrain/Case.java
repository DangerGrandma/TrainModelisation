/* @class Case
 * La classe Case repr�sente un objet sur lequel un Train se d�place. Une Case peut
 * �tre une Gare, ce qui peut alt�rer son comportement de fa�on mineure.
 */

package objetsTrain;

import java.util.concurrent.Semaphore;

public class Case {
	
	/* @param sema est un s�maphore qui permet de d�terminer si une case est occup�e ou non.
	 * @param trainNum sert � d�terminer quel train occupe la Case, si cette Case est occup�e.
	 * @param nextCase sert � v�rifier quelle est la Case suivante d'un objet de type Case.
	 * @param nextVoie1 � nextVoie3 servent � d�terminer quelle est la prochaine Case d'une Gare selon la Voie qui v�rifie la valeur.
	*/
	
	protected Semaphore sema;
	protected Train trainNum;
	protected int selfCase;
	protected int nextCase;
	protected int nextVoie1;
	protected int nextVoie2;
	protected int nextVoie3;

	// Cr�ation des Gares, objets globaux qui seront manipul�s constamment.
	
	 static Case Gare1 = new Case();
	 static Case Gare2 = new Case();
	 static Case Gare3 = new Case();



	/* M�thode qui sert � classifier une Case comme Gare, en fixant sa position sur une Voie selon la voie.
	 * Ne sera qu'appliqu�e @Objects Gare1, Gare2 et Gare3 dans la m�thode Main.
	 */
	
	public void setGare(int a, int b, int c)
	{
		this.nextVoie1 = a;
		this.nextVoie2 = b;
		this.nextVoie3 = c;
	}
	
	/* M�thode qui sert � placer un Train dans une Case. Si la Case � entrer par le Train est une Gare,
	 * on envoie un message en console pour signaler l'intention d'entrer cette Gare. Dans ce cas,
	 * apr�s l'acquisition du s�maphore unique de la Gare, un second message est pass� en console
	 * pour indiquer � quel moment un Train est parvenu � entrer dans la Gare, puis le Thread est
	 * mis en attente pour 1 seconde. On tient compte du nombre d'entr�es dans des Gares en augmentant
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
		 * Si la Case � entrer n'est pas une Gare, on tente d'acqu�rir le s�maphore de la prochaine Case quand m�me,
		 * sans cependant en afficher le message.
		 */
			
		}
		else if (this != Gare1 || this != Gare2 || this != Gare3) {
			this.sema.acquire();
		}
		
		// Ultimement, la Case ou la Gare entr�e aura son @param trainNum modifi� au Train qui y entre. 
			this.trainNum = t;
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	

	
	/*
	 *  M�thode qui sert � retirer un Train d'une Case. Cette case perd son @param trainNum, puis v�rifie
	 *  si la Case est en fait une Gare. Dans ce cas, un message est affich� � la console pour indiquer
	 *  ce movement. Enfin, le s�maphore de cette Case est rel�ch�.
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
