package controller.AttackCellController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import cell.CellComponent;
import cell.HostCell;
import controller.MainScreenController;
import controller.StructureController;
import exception.AttackException;
import exception.GetFieldException;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import virus.Attack;
import virus.Vescile;
import virus.Virus;

public class AttackController {
    
	private Virus virus;
    private HostCell cell;
    private CellComponent vescile;
    private String virusProcessPath;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    private TranslateTransition transition;
    private Boolean Btn1pressed = false;
    private Boolean Btn2pressed = false;
    private Boolean Btn3pressed = false;

    @FXML
    protected Button step1Btn;

    @FXML
    private Button step2Btn;

    @FXML
    private Button step3Btn;

    @FXML
    private StackPane virusStackPane;

    @FXML
    private StackPane cellStackPane;
    
    @FXML
    private TextArea explainArea;

    public AttackController() {

    }

    public AttackController(Virus virus) {
        this.virus = virus;
    }
    
	public Virus getVirus() {
		return virus;
	}
	

	public HostCell getCell() {
		return cell;
	}	

	public TranslateTransition getTransition() {
		return transition;
	}

	public StackPane getVirusStackPane() {
		return virusStackPane;
	}

	public StackPane getCellStackPane() {
		return cellStackPane;
	}
	

	public CellComponent getVescile() {
		return vescile;
	}

	public void initialize() {
        try {
            cell = HostCell.createCell();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        virusStackPane.getChildren().add(virus);
        cellStackPane.getChildren().add(cell);
        virusStackPane.toFront();
        transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(3));
        transition.setNode(virusStackPane);
        
        explainArea.setEditable(false);
        virusProcessPath = virus.getName(); 
        // i set the name equal to the name of 
       	//folder that contains content about attack process of virus.
    }

    @FXML
    void step1BtnPressed(ActionEvent event) throws IOException {
        if (Btn1pressed == false) {
        	Path explainPath = Paths.get("src/Resource/AttackProcess/", virusProcessPath, "/Step1.txt");
        	String explain = Files.exists(explainPath) ? new String(Files.readAllBytes(explainPath)) : "missing data";
        	explainArea.setText(explain);
        	explainArea.setVisible(true);
        	
        	
            transition.setByX(cellStackPane.getLayoutX() - virusStackPane.getLayoutX() - 200);
            transition.setByY(cellStackPane.getLayoutY() - virusStackPane.getLayoutY() + 100);
            transition.play();
            transition.setOnFinished(actionEvent -> {
                Btn1pressed = true;
            });
        }
    }
    
    boolean step2BtnPressed() throws IOException {
    	if (Btn1pressed == true && Btn2pressed == false) {
    		Path explainPath = Paths.get("src/Resource/AttackProcess/", virusProcessPath, "/Step2.txt");
        	String explain = Files.exists(explainPath) ? new String(Files.readAllBytes(explainPath)) : "missing data";
        	explainArea.setText(explain);
            Btn2pressed = true;
            return true;
        }
        return false;
    }
    
    @FXML
    void step2BtnPressed(ActionEvent event) throws AttackException, IOException {
        if (virus instanceof Attack ) {
        	Path explainPath = Paths.get("src/Resource/AttackProcess/", virusProcessPath, "/Step2.txt");
        	String explain = Files.exists(explainPath) ? new String(Files.readAllBytes(explainPath)) : "missing data";
        	explainArea.setText(explain);
        	
        	if (Btn1pressed == true && Btn2pressed == false) {
        		((Attack) virus).attackMembrane(cell);
                if (virus instanceof Vescile) {
                	 vescile = ((Vescile) virus).setVesicle(virus);
                }
                Btn2pressed = true;
            }
        } else {
        	throw new AttackException();
        }
    }

    @FXML
    boolean step3BtnPressed() throws IOException {
        if (Btn1pressed == true && Btn2pressed == true && Btn3pressed == false) {
        	Path explainPath = Paths.get("src/Resource/AttackProcess/", virusProcessPath, "/Step3.txt");
        	String explain = Files.exists(explainPath) ? new String(Files.readAllBytes(explainPath)) : "missing data";
        	explainArea.setText(explain);
            Btn3pressed = true;
            return true;
        }
        return false;
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