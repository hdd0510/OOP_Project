package test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import virus.Virus;
import virus.VirusComponent;
import virus.envelope_virus.Covid;

public class TestCovid {
	public static void main(String[] args) throws IOException  {
	VirusComponent acid = VirusComponent.createVirusComponent("Covid\\AcidNucleic");
    VirusComponent capsid = VirusComponent.createVirusComponent("Covid\\Capsid");
    VirusComponent envelope = VirusComponent.createVirusComponent("Covid\\Envelope");
    VirusComponent eProtein = VirusComponent.createVirusComponent("Covid\\EProtein");
    VirusComponent mProtein = VirusComponent.createVirusComponent("Covid\\MProtein");
    VirusComponent sProtein = VirusComponent.createVirusComponent("Covid\\SProtein");
    File imgFile = new File("src/Resource/Covid/image.png");
    String img = imgFile.toURI().toString();
    Covid covid = new Covid("Covid", img, acid, capsid, envelope, sProtein, eProtein, mProtein );
    HashMap<String,VirusComponent> virusComponent = covid.getFields();
    virusComponent.toString();
    
    
}
}
