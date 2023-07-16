package controller.AttackCellController;

import javafx.animation.TranslateTransition;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;

import cell.HostCell;
import virus.VirusComponent;
import virus.envelope_virus.Chikungunya;
import virus.envelope_virus.Covid;

public class CovidAttackController extends AttackController {


	public CovidAttackController(Covid covid) {
        super(covid);
        
    }

 
    @FXML
    void step3BtnPressed(ActionEvent event) throws IOException {
    	if (this.step3BtnPressed()) {
    		Covid covid = (Covid) this.getVirus();
    		TranslateTransition transition = this.getTransition();
            for (VirusComponent component : covid.getFields().values()) {
                if (!component.equals(covid.getAcidNucleic())) {
                    FadeTransition covidTransition = new FadeTransition(Duration.seconds(2),
                            component);
                    covidTransition.setFromValue(2); // Opacity value at the start of the
                    // transition
                    covidTransition.setToValue(0.0); // Opacity value at the end of the transition
                    covidTransition.play();
                    covidTransition.setOnFinished(actionEvent -> {
                        covid.getChildren().remove(component);
                    });
                }
            }
            transition.setDuration(Duration.seconds(1.5));
            transition.setByX(getCellStackPane().getLayoutX() - 150);
            transition.setByY(getCellStackPane().getLayoutY() - 150);
            transition.setNode(getVirusStackPane());
            transition.play();
            transition.setOnFinished(actionEvent -> {
                covid.attackNucleus(getCell(), covid);
            });

        }
    }
}
