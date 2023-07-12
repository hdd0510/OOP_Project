package application;
	

import java.util.ArrayList;

import initializer.Initializer;
import virus.Virus;


public class Main {
	
	public static void main(String[] args) {
		Initializer initializer = new Initializer();
		initializer.mainInitializer();
		ArrayList<Virus> envelopeVirusList = initializer.getEnvelopeVirusList();
		
		Virus covid = envelopeVirusList.get(0);
		System.out.println(covid);
		
	}
}
