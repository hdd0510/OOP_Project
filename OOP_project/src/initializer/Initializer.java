package initializer;

import java.util.ArrayList;

import virus.Virus;
import virus.VirusComponent;
import virus.envelope_virus.Covid;


public class Initializer {
	private static ArrayList<Virus> envelopeVirusList = new ArrayList<Virus>();
	
	VirusComponent acidNucleicRNA = new VirusComponent(
			"Single-stranded RNA (ribonucleic acid) genome",		    
		    "Contains several distinct regions, including the open reading frame (ORF) regions that encode viral proteins, "
		    + "as well as non-coding regions involved in viral replication and other regulatory functions.",	   		
			"The RNA encodes for major structural proteins. These proteins are involved in forming the virus's structure and aiding in its entry into host cells.");
			
	VirusComponent capsid = new VirusComponent(
			"Nucleocapsid",
			"The capsid is roughly spherical in shape and consists of repeating units of the N protein. "
			+ "The N protein forms helical structures that wrap around the viral RNA, creating a compact nucleocapsid core.",
			"Protect the viral RNA from degradation and serve as a structural framework for the virus.\n"
			+ "Interacts with the RNA genome, assisting in its folding and assembly.\n");
	
	VirusComponent lippidBilayer = new VirusComponent(
			"A","B","C");
	
	VirusComponent mProtein = new VirusComponent(
			"A","B","C");
	
	VirusComponent eProtein= new VirusComponent(
			"A","B","C");
	
	VirusComponent gProtein = new VirusComponent(
			"A","B","C");
			
	
	public void mainInitializer() {
		
		
		Covid covid = covidInitializer();
		envelopeVirusList.add(covid);
		
	}
	
	public Covid covidInitializer () {
		
		Covid covid = new Covid(acidNucleicRNA, capsid, lippidBilayer, gProtein, eProtein, mProtein);	
		return covid;
 
	}

	public static ArrayList<Virus> getEnvelopeVirusList() {
		return envelopeVirusList;
	}
	
	
	
}