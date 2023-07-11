package virus.envelope_virus;

import virus.Virus;
import virus.VirusComponent;

public class EnvelopeVirus extends Virus {
	
	private VirusComponent lipidBilayer;
	
	private VirusComponent glycoProtein;

	public EnvelopeVirus(String image, VirusComponent acidNucleic, VirusComponent capsid, VirusComponent lipidBilayer, VirusComponent glycoProtein) {
		super(image, acidNucleic, capsid);
		// TODO Auto-generated constructor stub
		this.lipidBilayer =lipidBilayer;
		this.glycoProtein = glycoProtein;
	}
	
	public String toString() {
		return (super.toString() + getLipidBilayer() + "\n" + getGlycoProtein() + "\n"   );
	}

	public VirusComponent getLipidBilayer() {
		return lipidBilayer;
	}

	public VirusComponent getGlycoProtein() {
		return glycoProtein;
	}
	
}


