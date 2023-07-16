package test;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import virus.VirusComponent;

public class VirusComponentTest extends Application {
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Pane pane = new HBox(15);
		File file = new File("src/Resource/Covid/AcidNucleic/image.png");
		System.out.println(file.toURI().toString());
		Image img = new Image(file.toURI().toString());
		ImageView view = new ImageView(img);
		pane.getChildren().add(view);
		System.out.println(file.toURI().toString());
		Scene scene = new Scene(pane, 900, 600);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		VirusComponent acid = VirusComponent.createVirusComponent("Covid/AcidNucleic");
		//System.out.println(acid.toString());
			
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	

}
