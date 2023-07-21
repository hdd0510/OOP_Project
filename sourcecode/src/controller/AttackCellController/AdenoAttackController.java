package controller.AttackCellController;

import java.io.IOException;

import cell.CellComponent;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.util.Duration;
import virus.nonenvelope_virus.Adeno;

public class AdenoAttackController extends AttackController{

    public AdenoAttackController(Adeno adeno) {
        super(adeno);
        
    }       

    @FXML
    void step3BtnPressed(ActionEvent event) throws IOException {
        if (this.checkBtn3()) {
        	Adeno adeno = (Adeno) this.getVirus();
        	TranslateTransition transition = this.getTransition();
;           transition.setDuration(Duration.seconds(1.5));
            transition.setByX(getCellStackPane().getLayoutX() - 250);
            transition.setByY(getCellStackPane().getLayoutY() - 90);
            transition.setNode(getVirusStackPane());
            transition.play();
            transition.setOnFinished(actionEvent -> {
                CellComponent adenoVesicle = getVesicle();
                adeno.attackNucleus(this.getCell(), adeno);

                FadeTransition adenoMembraneTransition = new FadeTransition(Duration.seconds(3),
                        adenoVesicle);
                adenoMembraneTransition.setFromValue(2.0); // Opacity value at the start of the
                                                           // transition
                adenoMembraneTransition.setToValue(0.0); // Opacity value at the end of the
                                                         // transition
                adenoMembraneTransition.play();
                adenoMembraneTransition.setOnFinished(actionEventPapil -> {
                	adeno.getChildren().remove(adenoVesicle);
                });
                // after get into cell, adeno uncoat the vesicle

                for (Node component : adeno.getFields().values()) {
                    if (!component.equals(adeno.getAcidNucleic())) {
                        FadeTransition adenoTransition = new FadeTransition(Duration.seconds(2),
                                component);
                        adenoTransition.setFromValue(3); // Opacity value at the start of the
                        // transition
                        adenoTransition.setToValue(0.0); // Opacity value at the end of the transition
                        adenoTransition.play();
                        adenoTransition.setOnFinished(ActionEvent -> {
                        	adeno.getChildren().remove(component);
                        });
                    }
                }
            });
        }
    }
}
