package virus;

import cell.CellComponent;

public interface Vesicle {
	default CellComponent setVesicle(Virus virus) {
		 try {
             CellComponent Vesicle = CellComponent.createCellComponent("Cell/Membrane");
             Vesicle.setFitHeight(300);
             Vesicle.setFitWidth(300);
             virus.getChildren().add(Vesicle);
             return Vesicle;
         } catch (Exception e) {
             e.printStackTrace();
             return null;
         }
}
}
