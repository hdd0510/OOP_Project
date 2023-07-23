package virus.nonenvelope_virus;

import java.util.HashMap;

import virus.Attack;
import virus.GetField;
import virus.Vesicle;
import virus.VirusComponent;

public class Papilloma extends NonEnvelopeVirus implements Attack, GetField {

	private VirusComponent histone;
	private VirusComponent capsidL2;

	// capsidL1 is capsid, capsidL2 is 2nd capsid
	public Papilloma(String name, String image, VirusComponent acidNucleic, VirusComponent capsidL1,
			VirusComponent capsidL2, VirusComponent histone) {
		super(name, image, acidNucleic, capsidL1);
		this.histone = histone;
		this.capsidL2 = capsidL2;
		this.getChildren().addAll(histone, capsidL2);

	}

	public VirusComponent getHistone() {
		return histone;
	}

	public VirusComponent getCapsidL2() {
		return capsidL2;
	}
	
	@Override
	public HashMap<String, VirusComponent> getFields() {
		HashMap<String, VirusComponent> fieldValues = new HashMap<>();

		fieldValues.put("acidNucleic", getAcidNucleic());
		fieldValues.put("capsidL1", getCapsid());

		fieldValues.put("histone", histone);
		fieldValues.put("capsidL2", capsidL2);

		return fieldValues;
	}


}
