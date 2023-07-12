package cell;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import virus.Virus;

public class HostCell extends StackPane {

    private CellComponent nucleus;
    private CellComponent membrane;
	
    protected String dirPath;
    protected Image cell;
 
    private Boolean isInfected = false;

    public HostCell(String dirPath) {
        this.dirPath = dirPath;
        try {
            readData(dirPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.prefHeight(150);
        this.prefWidth(200);
        this.getChildren().add(nucleus);
        this.getChildren().add(membrane);
        
        
        //nucleus.toFront();
        //membrane.toFront();
    }

    public HostCell(HostCell that) {
        this(that.dirPath);
    }

    protected void readData(String dirPath) throws Exception {
        File folder = new File(dirPath);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isDirectory()) {
                switch ((String)file.getName()) {
                	case "Membrane" :
                		membrane.readFile(file);
                	case "Nucleus" :
                		nucleus.readFile(file);
                    default:
                        System.out.println("loi");
                }

            } else {
                this.cell = new Image(file.toURI().toURL().toExternalForm());
            }
        }
    }





}