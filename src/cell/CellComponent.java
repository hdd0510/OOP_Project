package cell;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CellComponent extends ImageView {
    private Image uninfectedImg;
    private Image infectedImg;
    private String name;
    static String path = "src/Resource/";
    protected Boolean isInfected = false;

    public CellComponent() {
    }

    public CellComponent(String name, String uninfected, String infected) {
        this.name = name;
        uninfectedImg = new Image(uninfected);
        infectedImg = new Image(infected);
        this.setImage(uninfectedImg);

    }

    public static CellComponent createCellComponent(String folder) throws Exception {
        Path namePath = Paths.get(path, folder, "/name.txt");
        File uninfectedFile = new File(path + folder + "/uninfected.png");
        File infectedFile = new File(path + folder + "/infected.png");

        String name = Files.exists(namePath) ? new String(Files.readAllBytes(namePath)) : null;
        String uninfected = uninfectedFile.toURI().toString();
        String infected = infectedFile.toURI().toString();

        return new CellComponent(name, uninfected, infected);
    }

    public Image getUninfectedImg() {
        return uninfectedImg;
    }

    public Image getInfectedImg() {
        return infectedImg;
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