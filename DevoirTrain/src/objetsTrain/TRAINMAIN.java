/* @class TRAINMAIN
 * -MAIN CLASS-
 * 
 * Il s'agit de la fonction MAIN du programme. 
 */
package objetsTrain;

import java.util.ArrayList;
import java.util.concurrent.Delayed;
import java.util.concurrent.Semaphore;


public class TRAINMAIN {
	

	
	public static void main(String[] args) {

		// Création et lancement du Chronomètre pour mesurer le temps.
		
		Chrono c = new Chrono();
		c.startTask();
		
		// Création des Trajets des Voies.
		
	 	Voie.Voie1.addTrajet();
		Voie.Voie2.addTrajet();
		Voie.Voie3.addTrajet();
				
		
		// Placement des Gares sur les Voies
		
		Case.Gare1.setGare(3, 3, 5);
		Case.Gare2.setGare(5, 10, 10);
		Case.Gare3.setGare(10, 13, 0);
	
		// Création des 6 Threads Train
		
		Thread tr1 = new Thread(new Train("Train # 1", Voie.Voie1, Voie.Voie1.trajet.get(0).selfCase)); 
		Thread tr2 = new Thread(new Train("Train # 2", Voie.Voie1, Voie.Voie1.trajet.get(6).selfCase));
		Thread tr3 = new Thread(new Train("Train # 3", Voie.Voie2, Voie.Voie2.trajet.get(0).selfCase));
		Thread tr4 = new Thread(new Train("Train # 4", Voie.Voie2, Voie.Voie2.trajet.get(6).selfCase));
		Thread tr5 = new Thread(new Train("Train # 5", Voie.Voie3, Voie.Voie3.trajet.get(1).selfCase));
		Thread tr6 = new Thread(new Train("Train # 6", Voie.Voie3, Voie.Voie3.trajet.get(6).selfCase));
		
		// Initialisation des sémaphores pour les Cases occupées par un Train.
		
		try {
			Voie.Voie1.trajet.get(0).sema.acquire();
			Voie.Voie1.trajet.get(6).sema.acquire();
			Voie.Voie2.trajet.get(0).sema.acquire();
			Voie.Voie2.trajet.get(6).sema.acquire();
			Voie.Voie3.trajet.get(1).sema.acquire();
			Voie.Voie3.trajet.get(6).sema.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Initialisation des sémaphores pour les Gares.
		
		Case.Gare1.sema = new Semaphore(1);	
		Case.Gare2.sema = new Semaphore(1);		
		Case.Gare3.sema = new Semaphore(1);	
				
		// Lancement des 6 Threads Train.
		
		tr1.start();
		tr2.start();
		tr3.start();
		tr4.start();
		tr5.start();
		tr6.start();		
	}
}
