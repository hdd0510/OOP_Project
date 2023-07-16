package virus;

import javafx.scene.image.Image;
<<<<<<< Updated upstream:OOP_project/src/virus/Virus.java
import javafx.scene.image.ImageView;

public abstract class Virus {// extends ImageView{
    private VirusComponent acidNucleic;
    private VirusComponent capsid;
    private Image img;
	public Virus(String image, VirusComponent acidNucleic, VirusComponent capsid) {
=======
import javafx.scene.layout.StackPane;

public abstract class Virus extends StackPane {
	private VirusComponent acidNucleic;
	private VirusComponent capsid;
	private Image img;
	private String name;

	public Virus(String name, String image, VirusComponent acidNucleic, VirusComponent capsid) {
>>>>>>> Stashed changes:src/virus/Virus.java
		super();
		this.name = name;
		this.acidNucleic = acidNucleic;
		this.capsid = capsid;
		this.img = new Image(image);
<<<<<<< Updated upstream:OOP_project/src/virus/Virus.java
		//setImage(img);
		
=======
		this.getChildren().add(acidNucleic);
		this.getChildren().add(capsid);

>>>>>>> Stashed changes:src/virus/Virus.java
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

	public String getName() {
		return name;
	}
	
	

}
