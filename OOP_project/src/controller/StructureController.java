package controller;

import java.io.IOException;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import virus.Virus;
import virus.VirusComponent;

public class StructureController   {
	private Virus virus;

	private ImageView virusImg;
	private ImageView hoverView;
	private Boolean presentMode = false;
	private HashMap<String,VirusComponent> virusComponent = new HashMap<>();
	
    private Stage stage;
    private Scene scene;
    private Parent root;

    public StructureController(Virus virus, HashMap<String,VirusComponent> virusComponent) {
        this.virus = virus;
        this.virusComponent = virusComponent;
    }
    
   
    public void initialize() {

         virusImg = new ImageView(virus.getImg());
        center.getChildren().add(virusImg);
        hoverView = new ImageView();
        GridPane left = new GridPane();
        int idx = 0;
        
        for (String componentName : virusComponent.keySet()) {
        	Button componentButton = new Button(componentName);
            //buttonHashMap.put(virusComponent, new Button());
            setHoverProperty(componentButton,componentName);
            componentButton.setOnAction(e -> {
                setCenterPic(e, componentName);
            });
            left.add(componentButton, 0, idx++);
            
        }

        left.setVgap(10);
        left.setAlignment(Pos.CENTER);
        borderPane.setLeft(left);
        BorderPane.setAlignment(left, Pos.CENTER);
        
    }
    
    public void setHoverProperty(Node node, String component) {
        node.hoverProperty().addListener((javafx.beans.value.ChangeListener<? super Boolean>) (observable, oldValue, newValue) -> {
            setHoverPic(newValue, component);
        });
    }
    public void setCenterPic(ActionEvent event, String component) {
        if (!presentMode) {
            ((Button) event.getSource()).setText("Return to Overview");
            presentMode = true;
            center.getChildren().clear();
            TextArea des = new TextArea(virusComponent.get(component).toString());
            des.setEditable(false);
            
            hoverView.setImage(virusComponent.get(component).getImg());
            center.getChildren().add(hoverView);
            center.getChildren().add(des);
            
        } else {
            presentMode = false;
            ((Button) event.getSource()).setText(component);
            
        }
    }
    
    protected void setHoverPic(Boolean newValue, String component) {
        if (newValue && !center.getChildren().contains(hoverView)) {
            center.getChildren().clear();
            hoverView.setImage(virusComponent.get(component).getImg());
            center.getChildren().add(hoverView);
        }

        if (!newValue && !center.getChildren().contains(virusImg) && !presentMode) {
            center.getChildren().clear();
            center.getChildren().add(virusImg);
        }
    }
    
    @FXML
    private BorderPane borderPane;
    
    @FXML
    private VBox center;

    @FXML
    void helpBtnPressed(ActionEvent event) {

    }

    @FXML
    void mainBtnPressed(ActionEvent event) throws IOException {
    	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml2/Main.fxml"));
    	MainScreenController controller = new MainScreenController();
    	loader.setController(controller);
    	root = loader.load();
        scene = new Scene(root);
        stage.setTitle("Demonstration");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void quitButtonPressed(ActionEvent event) {

    }



    
    
    
}
