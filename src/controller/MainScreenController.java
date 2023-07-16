package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import exception.GetFieldException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import virus.VirusComponent;
import virus.envelope_virus.Chikungunya;
import virus.envelope_virus.Covid;
import virus.envelope_virus.Influenza;
import virus.nonenvelope_virus.Adeno;
import virus.nonenvelope_virus.Hav;
import virus.nonenvelope_virus.Papilloma;

public class MainScreenController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    Button quitBtn;

    @FXML
    void btnCovidPressed(ActionEvent event) throws IOException {

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        VirusComponent acid = VirusComponent.createVirusComponent("EnvelopeVirus\\Covid\\AcidNucleic");
        VirusComponent capsid = VirusComponent.createVirusComponent("EnvelopeVirus\\Covid\\Capsid");
        VirusComponent envelope = VirusComponent.createVirusComponent("EnvelopeVirus\\Covid\\Envelope");
        VirusComponent eProtein = VirusComponent.createVirusComponent("EnvelopeVirus\\Covid\\EProtein");
        VirusComponent mProtein = VirusComponent.createVirusComponent("EnvelopeVirus\\Covid\\MProtein");
        VirusComponent sProtein = VirusComponent.createVirusComponent("EnvelopeVirus\\Covid\\SProtein");
        File imgFile = new File("src/Resource/EnvelopeVirus/Covid/image.png");
        String img = imgFile.toURI().toString();
        Covid covid = new Covid("Covid", img, acid, capsid, envelope, sProtein, eProtein, mProtein);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/VirusStructure.fxml"));

		try {
			StructureController controller = new StructureController(covid);
			loader.setController(controller);
			root = loader.load();
			scene = new Scene(root);
			stage.setTitle("VIRUS STRUCTURE");
			stage.setScene(scene);
			stage.show();
		} catch (GetFieldException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage()); 
		}

    }

    @FXML
    void btnHavPressed(ActionEvent event) throws IOException {

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        VirusComponent acid = VirusComponent.createVirusComponent("NonEnvelope\\HAV\\AcidNucleic");
        VirusComponent capsid = VirusComponent.createVirusComponent("NonEnvelope\\HAV\\Capsid");
        VirusComponent vpg = VirusComponent.createVirusComponent("NonEnvelope\\HAV\\vpg");
        File imgFile = new File("src/Resource/NonEnvelope/HAV/image.png");
        String img = imgFile.toURI().toString();
        Hav hav = new Hav("HAV", img, acid, capsid, vpg);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/VirusStructure.fxml"));
        StructureController controller = null;
		try {
			controller = new StructureController(hav);
		} catch (GetFieldException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage()); 
		}
        loader.setController(controller);
        root = loader.load();
        scene = new Scene(root);

        stage.setTitle("VIRUS STRUCTURE");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnAdenoPressed(ActionEvent event) throws IOException {

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        VirusComponent acid = VirusComponent.createVirusComponent("NonEnvelope\\Adeno\\AcidNucleic");
        VirusComponent capsid = VirusComponent.createVirusComponent("NonEnvelope\\Adeno\\Hexon");
        VirusComponent pentoBase = VirusComponent.createVirusComponent("NonEnvelope\\Adeno\\PentonBase");
        VirusComponent fiber = VirusComponent.createVirusComponent("NonEnvelope\\Adeno\\Fiber");
        File imgFile = new File("src/Resource/NonEnvelope/Adeno/image.png");
        String img = imgFile.toURI().toString();
        Adeno AdenoVirus = new Adeno("Adeno", img, acid, capsid, pentoBase, fiber);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/VirusStructure.fxml"));
        StructureController adeno = null;
		try {
			adeno = new StructureController(AdenoVirus);
		} catch (GetFieldException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage()); 
		}
        loader.setController(adeno);
        root = loader.load();
        scene = new Scene(root);

        stage.setTitle("VIRUS STRUCTURE");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void btnPapillomaPressed(ActionEvent event) throws IOException {

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        VirusComponent acid = VirusComponent.createVirusComponent("NonEnvelope\\Papilloma\\AcidNucleic");
        VirusComponent capsid = VirusComponent.createVirusComponent("NonEnvelope\\Papilloma\\CapsidL1");
        VirusComponent capsidL2 = VirusComponent.createVirusComponent("NonEnvelope\\Papilloma\\CapsidL2");
        VirusComponent histone = VirusComponent.createVirusComponent("NonEnvelope\\Papilloma\\Histone");
        File imgFile = new File("src/Resource/NonEnvelope/Papilloma/image.png");
        String img = imgFile.toURI().toString();
        Papilloma PapillomaVirus = new Papilloma("Papilloma", img, acid, capsid, capsidL2, histone);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/VirusStructure.fxml"));
        StructureController papilloma = null;
		try {
			papilloma = new StructureController(PapillomaVirus);
		} catch (GetFieldException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage()); 
		}
        loader.setController(papilloma);
        root = loader.load();
        scene = new Scene(root);

        stage.setTitle("VIRUS STRUCTURE");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnChikungunyaPressed(ActionEvent event) throws IOException {

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        VirusComponent acid = VirusComponent.createVirusComponent("EnvelopeVirus\\Chikungunya\\AcidNucleic");
        VirusComponent capsid = VirusComponent.createVirusComponent("EnvelopeVirus\\Chikungunya\\Capsid");
        VirusComponent lipidBilayer = VirusComponent.createVirusComponent("EnvelopeVirus\\Chikungunya\\Envelop");
        VirusComponent glycoProtein = VirusComponent.createVirusComponent("EnvelopeVirus\\Chikungunya\\GlycoProtein");

        File imgFile = new File("src/Resource/EnvelopeVirus/Chikungunya/image.png");
        String img = imgFile.toURI().toString();
        Chikungunya chikungunya = new Chikungunya("Chikungunya", img, acid, capsid, lipidBilayer, glycoProtein);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/VirusStructure.fxml"));
        StructureController controller = null;
		try {
			controller = new StructureController(chikungunya);
		} catch (GetFieldException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage()); 
		}
        loader.setController(controller);
        root = loader.load();
        scene = new Scene(root);

        stage.setTitle("VIRUS STRUCTURE");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnInfluenzaPressed(ActionEvent event) throws IOException {

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        VirusComponent acid = VirusComponent.createVirusComponent("EnvelopeVirus\\Influenza\\AcidNucleic");
        VirusComponent capsid = VirusComponent.createVirusComponent("EnvelopeVirus\\Influenza\\Capsid");
        VirusComponent lipidBilayer = VirusComponent.createVirusComponent("EnvelopeVirus\\Influenza\\LipidBilayer");
        VirusComponent glycoProtein = VirusComponent.createVirusComponent("EnvelopeVirus\\Influenza\\HaProtein");
        VirusComponent mProtein = VirusComponent.createVirusComponent("EnvelopeVirus\\Influenza\\mProtein");
        VirusComponent iProtein = VirusComponent.createVirusComponent("EnvelopeVirus\\Influenza\\iProtein");
        VirusComponent neProtein = VirusComponent.createVirusComponent("EnvelopeVirus\\Influenza\\neProtein");
        VirusComponent naProtein = VirusComponent.createVirusComponent("EnvelopeVirus\\Influenza\\NaProtein");

        File imgFile = new File("src/Resource/EnvelopeVirus/Influenza/image.png");
        String img = imgFile.toURI().toString();
        Influenza influenza = new Influenza("Influenza", img, acid, capsid, lipidBilayer, glycoProtein, naProtein, mProtein,
                iProtein, neProtein);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/VirusStructure.fxml"));
        StructureController controller = null;
		try {
			controller = new StructureController(influenza);
		} catch (GetFieldException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage()); 
		}
        loader.setController(controller);
        root = loader.load();
        scene = new Scene(root);

        stage.setTitle("VIRUS STRUCTURE");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void quitBtnPressed(ActionEvent event) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Quit");
        alert.setContentText("Are you sure?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }

    }
    
    @FXML
    void aimsBtnPressed(ActionEvent event) {
    	String message = "In recent times, COVID-19 has been spreading all over the world, " +
                "highlighting the critical importance of understanding viruses and how they infect.\n " +
                "This application aims to provide you with the basic knowledge required to prevent the spread " +
                "of viruses, including COVID-19.\n\n" +
                "The key objectives of this application are:\n" +
                "1. Educate users about the structure of different types of viruses, including COVID-19.\n" +
                "2. Provide insights into how viruses infect and spread, enabling better prevention strategies.\n" +
                "3. Offer an interactive and intuitive interface to explore various viruses and their components.\n" +
                "We hope this application will enhance your understanding of viruses and contribute to " +
                "preventing their spread. Enjoy exploring the fascinating world of viruses!";

        JOptionPane.showMessageDialog(null, message, "Virus Structure Application", JOptionPane.INFORMATION_MESSAGE);


    }

    @FXML
    void usageBtnPressed(ActionEvent event) throws IOException {
    	stage = (Stage) ((Node) quitBtn).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/BasicUsage.fxml"));
        UsageController controller = new UsageController();
        loader.setController(controller);
        root = loader.load();
        scene = new Scene(root);
        stage.setTitle("Attack Process");
        stage.setScene(scene);
        stage.show();
    }
    

}