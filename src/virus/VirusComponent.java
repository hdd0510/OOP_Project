package virus;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VirusComponent extends ImageView {
	private String name;
	private String structure;
	private String function;
	private Image img;
	static String path = "src/Resource/";

	public VirusComponent(String name, String structure, String function, String image) {
		super();
		this.name = name;
		this.structure = structure;
		this.function = function;
		this.img = new Image(image);
		this.setFitHeight(200);
		this.setFitWidth(300);
		this.setImage(img);
	}

<<<<<<< Updated upstream:OOP_project/src/virus/VirusComponent.java
	
	public static VirusComponent readData(String folder) throws IOException {
		
		
=======
	public static VirusComponent createVirusComponent(String folder) throws IOException  {

>>>>>>> Stashed changes:src/virus/VirusComponent.java
		Path namePath = Paths.get(path, folder, "/name.txt");
		Path structurePath = Paths.get(path, folder, "/structure.txt");
		Path functionPath = Paths.get(path, folder, "/function.txt");
		File imgFile = new File(path + folder + "/image.png");

		String name = Files.exists(namePath) ? new String(Files.readAllBytes(namePath)) : null;
		String structure = Files.exists(structurePath) ? new String(Files.readAllBytes(structurePath)) : null;
		String function = Files.exists(functionPath) ? new String(Files.readAllBytes(functionPath)) : null;

<<<<<<< Updated upstream:OOP_project/src/virus/VirusComponent.java
		String img = imgFile.exists() ? imgFile.toURI().toURL().toExternalForm() : null;
				
			
=======
		String img = imgFile.toURI().toString();

>>>>>>> Stashed changes:src/virus/VirusComponent.java
		return new VirusComponent(name, structure, function, img);

	}

	public Image getImg() {
		return img;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Name : " + name + "\n" + "Structure : " + structure
				+ "\n" + "Function : " + function + "\n";
	}

}
