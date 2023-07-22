package cell;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CellComponent extends ImageView {
    private Image uninfectedImg;
    private Image infectedImg;
    private static String path = "src/Resource/";
    private Boolean isInfected = false;

    public CellComponent() {
    }

    public CellComponent(String uninfected, String infected) {
        uninfectedImg = new Image(uninfected);
        infectedImg = new Image(infected);
        this.setImage(uninfectedImg);

    }

    public static CellComponent createCellComponent(String folder) throws Exception {

        File uninfectedFile = new File(path + folder + "/uninfected.png");
        File infectedFile = new File(path + folder + "/infected.png");

        String uninfected = uninfectedFile.toURI().toString();
        String infected = infectedFile.toURI().toString();

        return new CellComponent(uninfected, infected);
    }

    public void setInfected(Boolean blinfected) {
        isInfected = blinfected;
        if (isInfected) {
            setImage(infectedImg);
            blinfected = true;
        } else {
            setImage(uninfectedImg);
        }
    }

}