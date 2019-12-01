/* @class Chrono
 * La classe Chrono sert de chronom�tre pour le programme. Elle permet d'enregistrer l'�coulement
 * du temps depuis le lancement du programme. Elle permet donc de prendre note du temps auquel les
 * Trains parviennent � entrer dans les Gares.
 */
package objetsTrain;

import java.util.Timer;
import java.util.TimerTask;

public class Chrono {
	
	// Cr�ation d'un chronom�tre.
	
	static Timer timer = new Timer();
	static double temps; // Attribut du chronom�tre d�notant le temps �coul�.
	
	
	 /*
	  * T�che ex�cut�e par le Chronom�tre � chaque intervale fixe. Ici, cette t�che est simplement
	  * d'ajouter � @param temps 10 ms.
	  */	
	
	static TimerTask tempsEcoule = new TimerTask() {
		public void run()
		{
			temps += 0.010;
		}
	};

	// Intervale de temps auquel la t�che tu Chronom�tre devrait �tre ex�cut�. Donc, + 10 ms � chaque 10 ms.
	
	public static void startTask() {
		timer.scheduleAtFixedRate(tempsEcoule, 10, 10);
	}
}
