package controller;

import java.io.IOException;
import java.nio.file.Paths;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class UsageController {
	
    private Stage stage;
    private Scene scene;
    private Parent root;
    
	private int page = 1;
	private static int nbPage = 4;
	
    @FXML
    private Button preBtn;
    
    @FXML
    private Button nextBtn;
    
    @FXML
    private ImageView usageImg;
    
    public void initialize() {
    	usageImg.setImage(new Image(Paths.get("src/Resource/Usage/page1.png").toUri().toString()));

    }
    

    @FXML
    void nextBtnPressed(ActionEvent event) {

    	page++;
    	String path = "src/Resource/Usage/page" + page +".png";
    	usageImg.setImage(new Image(Paths.get(path).toUri().toString()));
    	if(page == nbPage) {
    		nextBtn.setVisible(false);
    	}
    	if(page == 2) {
    		preBtn.setVisible(true);
    	}
    	
    }

    @FXML
    void preBtnPressed(ActionEvent event) {
    	if(page == nbPage) {
    		nextBtn.setVisible(true);
    		
    	}
    	if (page == 2) {
    		preBtn.setVisible(false);
    	}
    	page--;
    	String path = "src/Resource/Usage/page" + page +".png";
    	usageImg.setImage(new Image(Paths.get(path).toUri().toString()));
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

}
