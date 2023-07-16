package controller.AttackCellController;

import java.io.IOException;

import cell.CellComponent;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.util.Duration;
import virus.nonenvelope_virus.Hav;


public class HavAttackController extends AttackController{



	public HavAttackController(Hav hav) {
        super(hav);
        
    }



    @FXML
    void step3BtnPressed(ActionEvent event) throws IOException {
    	if (this.checkBtn3()) {
        	
        	Hav hav = (Hav) this.getVirus();
        	TranslateTransition transition = this.getTransition();
            transition.setDuration(Duration.seconds(1.5));
            transition.setByX(getCellStackPane().getLayoutX() - 200);
            transition.setByY(getCellStackPane().getLayoutY() - 90);
            transition.setNode(getVirusStackPane());
            transition.play();
            CellComponent havVesicle = getVescile();
            FadeTransition havVesicleTransition = new FadeTransition(Duration.seconds(0.5),
                    havVesicle);
            havVesicleTransition.setFromValue(2.0); // Opacity value at the start of the
                                                    // transition
            havVesicleTransition.setToValue(0.0); // Opacity value at the end of the transition
            havVesicleTransition.play();
            transition.setOnFinished(actionEvent -> {
                //CellComponent havVesicle = getVescile();
                hav.attackNucleus(getCell(), hav);
                
                havVesicleTransition.setOnFinished(actionEventhav -> { // it uncoats the temporary vesicle
                    hav.getChildren().remove(havVesicle);
                });
                // HAV uncoat the vesicle
                FadeTransition havCapsidTransition = new FadeTransition(Duration.seconds(3.5),
                        hav.getCapsid());
                havCapsidTransition.setFromValue(2.0); // Opacity value at the start of the
                                                       // transition
                havCapsidTransition.setToValue(0.0); // Opacity value at the end of the transition
                havCapsidTransition.play();
                havCapsidTransition.setOnFinished(actionEventhav -> { // after get into cell, HAV uncoat its capsid
                    hav.getChildren().remove(hav.getCapsid());
                });

            });
        }
    }
}
