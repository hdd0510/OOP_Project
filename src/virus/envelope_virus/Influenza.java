package virus.envelope_virus;

import java.util.HashMap;

import virus.Attack;
import virus.GetField;
import virus.Vescile;
import virus.VirusComponent;

public class Influenza extends EnvelopeVirus implements Attack, Vescile, GetField{
    private boolean attackedMembrane = false;

    private VirusComponent iProtein;
    private VirusComponent mProtein;
    private VirusComponent neProtein;
    private VirusComponent naProtein;

    public Influenza(String name, String image, VirusComponent acidNucleic, VirusComponent capsid, VirusComponent lipidBilayer,
            VirusComponent haProtein, VirusComponent naProtein, VirusComponent mProtein, VirusComponent iProtein,
            VirusComponent neProtein) {
        super(name, image, acidNucleic, capsid, lipidBilayer, haProtein);
        this.iProtein = iProtein;
        this.mProtein = mProtein;
        this.neProtein = neProtein;
        this.naProtein = naProtein;
        this.getChildren().addAll(iProtein, mProtein, neProtein, naProtein);
    }
    // @Override
    // public String toString() {
    // return super.toString() + "eProtein = " + eProtein.toString() + ", mProtein="
    // + mProtein.toString() + "]";
    // }
    @Override
    public HashMap<String, VirusComponent> getFields() {
        HashMap<String, VirusComponent> fieldValues = new HashMap<>();

        fieldValues.put("acidNucleic", getAcidNucleic());
        fieldValues.put("capsid", getCapsid());
        fieldValues.put("lipidBilayer", getLipidBilayer());
        fieldValues.put("haProtein", getGlycoProtein());

        fieldValues.put("mProtein", mProtein);
        fieldValues.put("iProtein", iProtein);
        fieldValues.put("neProtein", neProtein);
        fieldValues.put("naProtein", naProtein);

        return fieldValues;
    }

 
}