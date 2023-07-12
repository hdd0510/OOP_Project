package virus;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Virus {// extends ImageView{
    private VirusComponent acidNucleic;
    private VirusComponent capsid;
    private Image img;
	public Virus(String image, VirusComponent acidNucleic, VirusComponent capsid) {
		super();
		this.acidNucleic = acidNucleic;
		this.capsid = capsid;
		this.img = new Image(image);
		//setImage(img);
		
	}

	
	public String toString() {
		return (getAcidNucleic().toString() + "\n" + getCapsid().toString() + "\n");
	}


	public Image getImg() {
		return img;
	}


	public VirusComponent getAcidNucleic() {
		return acidNucleic;
	}


	public VirusComponent getCapsid() {
		return capsid;
	}


	
	
}


        


