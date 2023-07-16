package virus;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

public abstract class Virus extends StackPane {
	private VirusComponent acidNucleic;
	private VirusComponent capsid;
	private Image img;
	private String name;

	public Virus(String name, String image, VirusComponent acidNucleic, VirusComponent capsid) {
		super();
		this.name = name;
		this.acidNucleic = acidNucleic;
		this.capsid = capsid;
		this.img = new Image(image);
		this.getChildren().add(acidNucleic);
		this.getChildren().add(capsid);

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

	public String getName() {
		return name;
	}
	
	

}
