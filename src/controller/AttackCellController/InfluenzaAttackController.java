package controller.AttackCellController;

import javafx.animation.TranslateTransition;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;

import cell.CellComponent;
import cell.HostCell;
import virus.VirusComponent;
import virus.envelope_virus.Influenza;
import virus.nonenvelope_virus.Hav;

public class InfluenzaAttackController extends AttackController{
	
	public InfluenzaAttackController(Influenza influenza) {
        super(influenza);
        
    }



    @FXML
    void step3BtnPressed(ActionEvent event) throws IOException {
    	if (this.step3BtnPressed()) {
        	Influenza influenza = (Influenza) this.getVirus();
        	TranslateTransition transition = this.getTransition();
            transition.setDuration(Duration.seconds(1.5));
            transition.setByX(getCellStackPane().getLayoutX() - 150);
            transition.setByY(getCellStackPane().getLayoutY() - 150);
            transition.setNode(getVirusStackPane());
            transition.play();
            transition.setOnFinished(actionEvent -> {
                
                influenza.attackNucleus(getCell(), influenza);
                FadeTransition chikungunyaVesicleTransition = new FadeTransition(Duration.seconds(2),
                        getVescile());
                chikungunyaVesicleTransition.setFromValue(3);
                chikungunyaVesicleTransition.setToValue(0.0);
                chikungunyaVesicleTransition.play();
                chikungunyaVesicleTransition.setOnFinished(ActionEvent -> {
                    influenza.getChildren().remove(getVescile()); // uncoat vesicle
                });
                for (Node component : influenza.getFields().values()) {
                    if (!component.equals(influenza.getAcidNucleic())) {
                        FadeTransition chikungunyaTransition = new FadeTransition(Duration.seconds(2),
                                component);
                        chikungunyaTransition.setFromValue(3); // Opacity value at the start of the
                        // transition
                        chikungunyaTransition.setToValue(0.0); // Opacity value at the end of the transition
                        chikungunyaTransition.play();
                        chikungunyaTransition.setOnFinished(ActionEvent -> {
                            influenza.getChildren().remove(component);
                        });
                    }
                }
            });
        }
    }
}
