package cell;

import javafx.scene.layout.StackPane;

public class HostCell extends StackPane {

    private CellComponent nucleus;
    private CellComponent membrane;
    static String path = "src/Resource/Cell";

    public HostCell( CellComponent nucleus, CellComponent membrane) {
        super();
        this.nucleus = nucleus;
        this.membrane = membrane;
        this.prefHeight(120);
        this.prefWidth(170);
        this.getChildren().add(nucleus);
        this.getChildren().add(membrane);
    }

    public static HostCell createCell() throws Exception {	
        CellComponent nucleus = CellComponent.createCellComponent("Cell/Nucleus");
        CellComponent membrane = CellComponent.createCellComponent("Cell/Membrane");

        return new HostCell(nucleus, membrane);
    }

    public CellComponent getMembrane() {
        return membrane;
    }


}