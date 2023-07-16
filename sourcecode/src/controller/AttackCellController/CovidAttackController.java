package controller.AttackCellController;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.util.Duration;
import virus.VirusComponent;
import virus.envelope_virus.Covid;

public class CovidAttackController extends AttackController {


	public CovidAttackController(Covid covid) {
        super(covid);
        
    }

 
    @FXML
    void step3BtnPressed(ActionEvent event) throws IOException {
    	if (this.checkBtn3()) {
    		Covid covid = (Covid) this.getVirus();
    		TranslateTransition transition = this.getTransition();
            for (VirusComponent component : covid.getFields().values()) {
                if (!component.equals(covid.getAcidNucleic())) {
                    FadeTransition covidTransition = new FadeTransition(Duration.seconds(0.01),
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
            transition.setDelay(Duration.seconds(1));
            transition.play();
           
            transition.setOnFinished(actionEvent -> {
                covid.attackNucleus(getCell(), covid);
            });

        }
    }
}
