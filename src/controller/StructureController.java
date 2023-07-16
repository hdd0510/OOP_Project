package controller;

import java.io.IOException;
import java.util.HashMap;

import controller.AttackCellController.AdenoAttackController;
import controller.AttackCellController.AttackController;
import controller.AttackCellController.ChikungunyaAttackController;
import controller.AttackCellController.CovidAttackController;
import controller.AttackCellController.HavAttackController;
import controller.AttackCellController.InfluenzaAttackController;
import controller.AttackCellController.PapillomaAttackController;
import exception.GetFieldException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import virus.GetField;
import virus.Virus;
import virus.VirusComponent;
import virus.envelope_virus.Chikungunya;
import virus.envelope_virus.Covid;
import virus.envelope_virus.Influenza;
import virus.nonenvelope_virus.Adeno;
import virus.nonenvelope_virus.Hav;
import virus.nonenvelope_virus.Papilloma;

public class StructureController {
    private Button showComponent;
    private Virus virus;
    private Image virusImg;
    private HashMap<String, VirusComponent> virusComponent;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private BorderPane borderPane;

    @FXML
    private GridPane structureBtnPane;

    @FXML
    private VBox center;

    @FXML
    private ImageView imgView;

    @FXML
    private TextArea infoArea;

    public StructureController(Virus virus, HashMap<String, VirusComponent> virusComponent) {
        this.virus = virus;
        this.virusComponent = virusComponent;
    }
    
    public StructureController(Virus virus) throws GetFieldException {
        this.virus = virus;
        if (virus instanceof GetField) {
        	this.virusComponent = ((GetField) virus).getFields();
        }else {
        	throw new GetFieldException();
        }
    }

    public void initialize() {
        virusImg = virus.getImg();
        imgView.setImage(virusImg);

        int idx = 0;

        for (String componentName : virusComponent.keySet()) {
            Button componentButton = new Button(componentName);
            componentButton.setOnAction(e -> showVirusComponent(e, componentName));
            structureBtnPane.add(componentButton, 0, idx++);
        }
    }

    public void showVirusComponent(ActionEvent event, String component) {
        Button currentButton = (Button) event.getSource();

        if (currentButton.equals(showComponent)) {
            imgView.setImage(virusImg);
            infoArea.setVisible(false);
            showComponent = null;
        } else {
            imgView.setImage(virusComponent.get(component).getImg());
            infoArea.setText(virusComponent.get(component).toString());
            infoArea.setVisible(true);
            showComponent = currentButton;
        }
    }


    @FXML
    void mainBtnPressed(ActionEvent event) throws IOException {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/MainScreen.fxml"));
        MainScreenController controller = new MainScreenController();
        loader.setController(controller);
        root = loader.load();
        scene = new Scene(root);
        stage.setTitle("VIRUS MAIN MENU");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void infectBtnPressed(ActionEvent event) throws IOException {
    	
    	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/AttackCell.fxml"));
        AttackController controller = new AttackController();
        if (virus instanceof Covid) {      
        	 Covid covid = (Covid) virus;
             controller = new CovidAttackController(covid);
        }else if (virus instanceof Hav) {
            Hav hav = (Hav) virus;
            controller = new HavAttackController(hav);
        }else if (virus instanceof Adeno) {
            Adeno adeno = (Adeno) virus;
            controller = new AdenoAttackController(adeno);
        }else if (virus instanceof Influenza) {
            Influenza influenza = (Influenza) virus;
            controller = new InfluenzaAttackController(influenza);
        }else if (virus instanceof Papilloma) {
            Papilloma papilloma = (Papilloma) virus;
            controller = new PapillomaAttackController(papilloma);
        }else if (virus instanceof Chikungunya) {
            Chikungunya chikungunya = (Chikungunya) virus;
            controller = new ChikungunyaAttackController(chikungunya);
        }
        loader.setController(controller);
        root = loader.load();
        scene = new Scene(root);
        stage.setTitle("ATTACK PROCESS");
        stage.setScene(scene);
        stage.show();
    }
}
