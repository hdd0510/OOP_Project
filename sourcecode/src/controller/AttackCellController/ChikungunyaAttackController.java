package controller.AttackCellController;

import java.io.IOException;

import cell.CellComponent;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.util.Duration;
import virus.envelope_virus.Chikungunya;

public class ChikungunyaAttackController extends AttackController{
    
	public ChikungunyaAttackController(Chikungunya chikungunya) {
        super(chikungunya);
        
    }

    @FXML
    void step3BtnPressed(ActionEvent event) throws IOException {
    	if (this.checkBtn3()) {
        	Chikungunya chikungunya = ((Chikungunya)this.getVirus());
        	TranslateTransition transition = this.getTransition();
        	transition.setDuration(Duration.seconds(1.5));
        	transition.setToX(getCellStackPane().getLayoutX());
        	transition.setToY(getCellStackPane().getLayoutY());
        	transition.setNode(getVirusStackPane());
        	transition.play();
        	transition.setOnFinished(actionEvent -> {
            CellComponent chikungunyaVescile = this.getVescile(); 
            chikungunya.attackNucleus(getCell(), chikungunya);
            FadeTransition chikungunyaVesicleTransition = new FadeTransition(Duration.seconds(3),
                        chikungunyaVescile);
            chikungunyaVesicleTransition.setFromValue(1);
            chikungunyaVesicleTransition.setToValue(0.0);
            chikungunyaVesicleTransition.play();
            chikungunyaVesicleTransition.setOnFinished(ActionEvent -> {
            chikungunya.getChildren().remove(chikungunyaVescile); // uncoat vesicle
           });
            
           for (Node component : chikungunya.getFields().values()) {
             if (!component.equals(chikungunya.getAcidNucleic())) {
            	 FadeTransition chikungunyaTransition = new FadeTransition(Duration.seconds(2),
            			 component);
            	 chikungunyaTransition.setFromValue(3); // Opacity value at the start of the 
            	 // transition
            	 chikungunyaTransition.setToValue(0.0); // Opacity value at the end of the transition
            	 chikungunyaTransition.play();
            	 chikungunyaTransition.setOnFinished(ActionEvent -> {
            	 chikungunya.getChildren().remove(component);
	                        });
	                    }
	                }
	            });
           
        }
    }
}
