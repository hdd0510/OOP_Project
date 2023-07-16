package virus.nonenvelope_virus;

import virus.Virus;
import virus.VirusComponent;

public class NonEnvelopeVirus extends Virus {

    public NonEnvelopeVirus(String name, String image, VirusComponent acidNucleic, VirusComponent capsid) {
        super(name, image, acidNucleic, capsid);
    }

    public String toString() {
        return (super.toString());
    }
}
