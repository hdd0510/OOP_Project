package virus.envelope_virus;

import java.util.HashMap;

import virus.Attack;
import virus.GetField;
import virus.Vesicle;
import virus.VirusComponent;

public class Chikungunya extends EnvelopeVirus implements Attack, Vesicle, GetField {

    public Chikungunya(String name, String image, VirusComponent acidNucleic, VirusComponent capsid, VirusComponent lipidBilayer,
            VirusComponent glycoProtein) {
        super(name, image, acidNucleic, capsid, lipidBilayer, glycoProtein);
    }
    @Override
    public HashMap<String, VirusComponent> getFields() {
        HashMap<String, VirusComponent> fieldValues = new HashMap<>();

        fieldValues.put("acidNucleic", getAcidNucleic());
        fieldValues.put("capsid", getCapsid());
        fieldValues.put("lipidBilayer", getLipidBilayer());
        fieldValues.put("glycoProtein", getGlycoProtein());

        return fieldValues;
    }


}