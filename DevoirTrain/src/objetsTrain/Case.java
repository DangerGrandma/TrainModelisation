package objetsTrain;

public class Case {
	
	/* @param occupe sert à déterminer si un case est occupée par un train ou non.
	 * @param trainNum sert à déterminer quel train occupe la Case, si cette Case est occupée.
	 * @param nextCase sert à vérifier quelle est la Case suivant d'une objet de type Case.
	 * @param nextVoie1 à nextVoie3 sert à déterminer quelle est la prochaine Case d'une Gare selon la Voie qui vérifie la valeur.
	*/
	
	protected boolean occupe;
	protected int trainNum;
	protected int nextCase;
	protected int nextVoie1;
	protected int nextVoie2;
	protected int nextVoie3;

	// Création des Gares, objets globaux qui seront manipulés constamment.
	
	 static Case Gare1 = new Case(false);
	 static Case Gare2 = new Case(false);
	 static Case Gare3 = new Case(false);

	 
	// Constructeur pour un objet de type Case régulier.
		
	public Case(boolean b)
	{
		this.occupe = b;
	}
	

	/* Méthode qui sert à classifier une Case comme Gare, en fixant sa position sur une Voie selon la voie.
	 * Ne sera qu'appliquée @Objects Gare1, Gare2 et Gare3 dans la méthode Main.
	 */
	
	public void setGare(int a, int b, int c)
	{
		this.nextVoie1 = a;
		this.nextVoie2 = b;
		this.nextVoie3 = c;
	}
	
	/* Méthode qui sert à placer un Train dans une Case. Si la case est déjà occupée par un train, un message est envoyé à la console
	 * Pour indiquer qu'il est impossible pour le train qui tente d'y entrer de le faire.
	 */
	
	public void entrer(int t)
	{
		System.out.println("");
		
		if(this.occupe == true)
		{
			System.out.println("Cette case est déjà occupée par le Train #" + this.trainNum);
		}
		
		else 
		{
			this.occupe = true;
			this.trainNum = t;
		}

	}
	
	// Méthode qui sert à retirter un Train d'une Case.
	
	public void sortir()
	{
		this.occupe = false;
		this.trainNum = 0;
	}

}
