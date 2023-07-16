package test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import virus.Virus;
import virus.VirusComponent;
import virus.envelope_virus.Covid;

public class TestCovid {
	public static void main(String[] args) throws IOException  {
	VirusComponent acid = VirusComponent.readData("Covid\\AcidNucleic");
    VirusComponent capsid = VirusComponent.readData("Covid\\Capsid");
    VirusComponent envelope = VirusComponent.readData("Covid\\Envelope");
    VirusComponent eProtein = VirusComponent.readData("Covid\\EProtein");
    VirusComponent mProtein = VirusComponent.readData("Covid\\MProtein");
    VirusComponent sProtein = VirusComponent.readData("Covid\\SProtein");
    File imgFile = new File("src/Resource/Covid/image.png");
    String img = imgFile.toURI().toString();
<<<<<<< Updated upstream:OOP_project/src/test/TestCovid.java
    Virus covid = new Covid(img, acid, capsid, envelope, sProtein, eProtein, mProtein );
=======
    Covid covid = new Covid("Covid", img, acid, capsid, envelope, sProtein, eProtein, mProtein );
>>>>>>> Stashed changes:src/test/TestCovid.java
    HashMap<String,VirusComponent> virusComponent = covid.getFields();
    virusComponent.toString();
    
    
}
}
