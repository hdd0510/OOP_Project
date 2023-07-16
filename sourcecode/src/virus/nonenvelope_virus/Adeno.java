package virus.nonenvelope_virus;

import java.util.HashMap;

import virus.Attack;
import virus.GetField;
import virus.Vescile;
import virus.VirusComponent;

public class Adeno extends NonEnvelopeVirus implements Attack, Vescile, GetField {
	private VirusComponent fiber;
	private VirusComponent pentonBase;

	// hexon is capsid , pentoBase is 2nd capsid
	public Adeno(String name, String image, VirusComponent acidNucleic, VirusComponent hexon, VirusComponent fiber,
			VirusComponent pentonBase) {
		super(name, image, acidNucleic, hexon);
		this.fiber = fiber;
		this.pentonBase = pentonBase;
		this.getChildren().addAll(fiber, pentonBase);
	}


	public VirusComponent getFiber() {
		return fiber;
	}

	public VirusComponent getPentonBase() {
		return pentonBase;
	}
	@Override
	public HashMap<String, VirusComponent> getFields() {
		HashMap<String, VirusComponent> fieldValues = new HashMap<>();

		fieldValues.put("acidNucleic", getAcidNucleic());
		fieldValues.put("hexon", getCapsid());

		fieldValues.put("pentonBase", pentonBase);
		fieldValues.put("fiber", fiber);

		return fieldValues;
	}

	

}
