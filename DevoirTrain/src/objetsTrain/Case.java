package objetsTrain;

public class Case {
	
	/* @param occupe sert � d�terminer si un case est occup�e par un train ou non.
	 * @param trainNum sert � d�terminer quel train occupe la Case, si cette Case est occup�e.
	 * @param nextCase sert � v�rifier quelle est la Case suivant d'une objet de type Case.
	 * @param nextVoie1 � nextVoie3 sert � d�terminer quelle est la prochaine Case d'une Gare selon la Voie qui v�rifie la valeur.
	*/
	
	protected boolean occupe;
	protected int trainNum;
	protected int nextCase;
	protected int nextVoie1;
	protected int nextVoie2;
	protected int nextVoie3;

	// Cr�ation des Gares, objets globaux qui seront manipul�s constamment.
	
	 static Case Gare1 = new Case(false);
	 static Case Gare2 = new Case(false);
	 static Case Gare3 = new Case(false);

	 
	// Constructeur pour un objet de type Case r�gulier.
		
	public Case(boolean b)
	{
		this.occupe = b;
	}
	

	/* M�thode qui sert � classifier une Case comme Gare, en fixant sa position sur une Voie selon la voie.
	 * Ne sera qu'appliqu�e @Objects Gare1, Gare2 et Gare3 dans la m�thode Main.
	 */
	
	public void setGare(int a, int b, int c)
	{
		this.nextVoie1 = a;
		this.nextVoie2 = b;
		this.nextVoie3 = c;
	}
	
	/* M�thode qui sert � placer un Train dans une Case. Si la case est d�j� occup�e par un train, un message est envoy� � la console
	 * Pour indiquer qu'il est impossible pour le train qui tente d'y entrer de le faire.
	 */
	
	public void entrer(int t)
	{
		System.out.println("");
		
		if(this.occupe == true)
		{
			System.out.println("Cette case est d�j� occup�e par le Train #" + this.trainNum);
		}
		
		else 
		{
			this.occupe = true;
			this.trainNum = t;
		}

	}
	
	// M�thode qui sert � retirter un Train d'une Case.
	
	public void sortir()
	{
		this.occupe = false;
		this.trainNum = 0;
	}

}
