package virus.envelope_virus;

import virus.Virus;
import virus.VirusComponent;

public abstract class  EnvelopeVirus extends Virus {

	private VirusComponent lipidBilayer;

	private VirusComponent glycoProtein;


	public EnvelopeVirus(String name, String image, VirusComponent acidNucleic, VirusComponent capsid, VirusComponent lipidBilayer,
			VirusComponent glycoProtein) {
		super(name, image, acidNucleic, capsid);
		// TODO Auto-generated constructor stub
		this.lipidBilayer = lipidBilayer;
		this.glycoProtein = glycoProtein;
		this.getChildren().addAll(lipidBilayer, glycoProtein);
	}


	public VirusComponent getLipidBilayer() {
		return lipidBilayer;
	}

	public VirusComponent getGlycoProtein() {
		return glycoProtein;
	}

}
