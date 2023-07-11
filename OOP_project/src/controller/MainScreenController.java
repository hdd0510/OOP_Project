package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import virus.Virus;
import virus.VirusComponent;
import virus.envelope_virus.Covid;

public class MainScreenController {


    
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void btnCovidPressed(ActionEvent event) throws IOException {
    	
        
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        VirusComponent acid = VirusComponent.readData("Covid\\AcidNucleic");
        VirusComponent capsid = VirusComponent.readData("Covid\\Capsid");
        VirusComponent envelope = VirusComponent.readData("Covid\\Envelope");
        VirusComponent eProtein = VirusComponent.readData("Covid\\EProtein");
        VirusComponent mProtein = VirusComponent.readData("Covid\\MProtein");
        VirusComponent sProtein = VirusComponent.readData("Covid\\SProtein");
        File imgFile = new File("src/Resource/Covid/image.png");
        String img = imgFile.toURI().toString();
        Covid covid = new Covid(img, acid, capsid, envelope, sProtein, eProtein, mProtein );
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml2/VirusStructure.fxml"));
        HashMap<String,VirusComponent> virusComponent = covid.getFields();
        StructureController cov = new StructureController(covid, virusComponent);
        loader.setController(cov);
        root = loader.load();
        scene = new Scene(root);
        
        stage.setTitle("Demonstration");
        stage.setScene(scene);
        stage.show();
        

    }

	}