package objetsTrain;

import java.util.ArrayList;

//Case.Gare1.nextVoie3
//Voie1.trajet.get(Case.Gare1.nextVoie3).occupe

public class test {
	
	public static void main(String[] args) {
		
		Voie Voie1 = new Voie(5);
		
		Case.Gare1.setGare(3, 3, 5);
		Case.Gare2.setGare(5, 10, 10);
		Case.Gare3.setGare(10, 13, 17);
		
	Voie1.addTrajet();
	
	System.out.println("avant");
	
	for(int i = 0; i < Voie1.trajet.size(); i++) 
	{
		System.out.println(Voie1.trajet.get(i).occupe);
	}
	
	Voie1.trajet.get(2).entrer(0);
	
	System.out.println("après");
	for(int i = 0; i < Voie1.trajet.size(); i++) 
	{
		System.out.println(Voie1.trajet.get(i).occupe);
	}
	
	/*for(int i = 0; i < Voie1.trajet.size(); i++) 
	{
		if(i == 4 && Voie1.trajetLongueur == 18)
		{
			System.out.println(Voie1.trajet.get(Case.Gare1.nextVoie3).occupe);
		}
		else
			System.out.println(Voie1.trajet.get(i).nextCase);
	}
	*/
	

	//System.out.println(Voie1.trajet.get(3).occupe);
		
	}
}
