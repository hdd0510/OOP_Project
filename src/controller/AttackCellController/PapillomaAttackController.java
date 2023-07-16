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

import cell.CellComponent;
import cell.HostCell;
import virus.VirusComponent;
import virus.envelope_virus.Influenza;
import virus.nonenvelope_virus.Papilloma;

public class PapillomaAttackController extends AttackController{
	
	public PapillomaAttackController(Papilloma papilloma) {
        super(papilloma);
        
    }
	
	private Papilloma papilloma = (Papilloma) this.getVirus();
	
    @FXML
    void step2BtnPressed(ActionEvent event) throws IOException {
    	if (this.step2BtnPressed()) {
            papilloma.attackMembrane(getCell());
            FadeTransition papilCapsidTransition = new FadeTransition(Duration.seconds(2),
                    papilloma.getCapsid());
            papilCapsidTransition.setFromValue(1.0); // Opacity value at the start of the transition
            papilCapsidTransition.setToValue(0.0); // Opacity value at the end of the transition
            papilCapsidTransition.play();
            papilCapsidTransition.setOnFinished((actionEvent -> {
                papilloma.getChildren().remove(papilloma.getCapsid());
            }));
            // as soon as approach membrane, papilloma use CapsidL1 to get into and uncoat
            // this capsid
        }

    }

    @FXML
    void step3BtnPressed(ActionEvent event) throws IOException {
    	if (this.step3BtnPressed()) {
    		
        	TranslateTransition transition = this.getTransition();
        	
            transition.setDuration(Duration.seconds(1.5));
            transition.setByX(getCellStackPane().getLayoutX() - 250);
            transition.setByY(getCellStackPane().getLayoutY() - 250);
            transition.setNode(getVirusStackPane());
            transition.play();
            transition.setOnFinished(actionEvent -> {
                CellComponent papillomaVesicle = this.getVescile(); // it create vescicle after penetrate
                papilloma.attackNucleus(getCell(), papilloma);

                FadeTransition papilVesicleTransition = new FadeTransition(Duration.seconds(3),
                        papillomaVesicle);
                papilVesicleTransition.setFromValue(3.0); // Opacity value at the start of the
                                                          // transition
                papilVesicleTransition.setToValue(0.0); // Opacity value at the end of the
                                                        // transition
                papilVesicleTransition.play();
                papilVesicleTransition.setOnFinished(actionEventPapil -> {
                    papilloma.getChildren().remove(papillomaVesicle);
                });
                // after get into cell, papilloma uncoat the vesicle

                FadeTransition papilCapsidL2Transition = new FadeTransition(Duration.seconds(3),
                        papilloma.getCapsidL2());
                papilCapsidL2Transition.setFromValue(3.0); // Opacity value at the start of the
                                                           // transition
                papilCapsidL2Transition.setToValue(0.0); // Opacity value at the end of the
                                                         // transition
                papilCapsidL2Transition.play();
                papilCapsidL2Transition.setOnFinished(actionEventpapilloma -> { // it continues uncoat the 2nd capsid
                    papilloma.getChildren().remove(papilloma.getCapsidL2());
                });

            });
        }
    }
}
