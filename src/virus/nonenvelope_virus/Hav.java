package virus.nonenvelope_virus;

import java.util.HashMap;

import virus.Attack;
import virus.GetField;
import virus.Vescile;
import virus.VirusComponent;

public class Hav extends NonEnvelopeVirus implements Attack, Vescile, GetField {
    private VirusComponent vpg;


    public Hav(String name, String image, VirusComponent acidNucleic, VirusComponent capsid, VirusComponent vpg) {
        super(name, image, acidNucleic, capsid);
        this.vpg = vpg;
        this.getChildren().add(vpg);
    }

    @Override
    public String toString() {
        return super.toString() + "vpg = " + vpg.toString() + "]";
    }
    
    @Override
    public HashMap<String, VirusComponent> getFields() {
        HashMap<String, VirusComponent> fieldValues = new HashMap<>();

        fieldValues.put("acidNucleic", getAcidNucleic());
        fieldValues.put("capsid", getCapsid());
        fieldValues.put("vpg", this.vpg);
        return fieldValues;
    }
  
}