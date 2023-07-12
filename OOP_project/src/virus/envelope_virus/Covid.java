package virus.envelope_virus;

import java.util.HashMap;

import virus.VirusComponent;

public class Covid extends  EnvelopeVirus{
	
	private VirusComponent eProtein;
	
	private VirusComponent mProtein;

	public Covid(String image, VirusComponent acidNucleic, VirusComponent capsid, VirusComponent lipidBilayer, VirusComponent glycoProtein,
			VirusComponent eProtein, VirusComponent mProtein) {
		super(image, acidNucleic, capsid, lipidBilayer, glycoProtein);
		this.eProtein = eProtein;
		this.mProtein = mProtein;
	}

	@Override
	public String toString() {
		return super.toString()  + "eProtein = " + eProtein.toString() + ", mProtein=" + mProtein.toString() + "]";
	}
	
	
    public HashMap<String, VirusComponent> getFields() {
        HashMap<String, VirusComponent> fieldValues = new HashMap<>();

        
        fieldValues.put("acidNucleic", getAcidNucleic());
        fieldValues.put("capsid", getCapsid());
        fieldValues.put("lipidBilayer", getLipidBilayer());
        fieldValues.put("glycoProtein", getGlycoProtein());
 
        fieldValues.put("eProtein", eProtein);
        fieldValues.put("mProtein", mProtein);

        	
        

        return fieldValues;
    }
	
	
	
	

	
	
	


		

	
	

}