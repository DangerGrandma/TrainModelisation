/* @class Chrono
 * La classe Chrono sert de chronomètre pour le programme. Elle permet d'enregistrer l'écoulement
 * du temps depuis le lancement du programme. Elle permet donc de prendre note du temps auquel les
 * Trains parviennent à entrer dans les Gares.
 */
package objetsTrain;

import java.util.Timer;
import java.util.TimerTask;

public class Chrono {
	
	// Création d'un chronomètre.
	
	static Timer timer = new Timer();
	static double temps; // Attribut du chronomètre dénotant le temps écoulé.
	
	
	 /*
	  * Tâche exécutée par le Chronomètre à chaque intervale fixe. Ici, cette tâche est simplement
	  * d'ajouter à @param temps 10 ms.
	  */	
	
	static TimerTask tempsEcoule = new TimerTask() {
		public void run()
		{
			temps += 0.010;
		}
	};

	// Intervale de temps auquel la tâche tu Chronomètre devrait être exécuté. Donc, + 10 ms à chaque 10 ms.
	
	public static void startTask() {
		timer.scheduleAtFixedRate(tempsEcoule, 10, 10);
	}
}
