package virus;

import cell.CellComponent;
import cell.HostCell;

public interface Attack {
	default void attackMembrane(HostCell cell) {
		CellComponent cellMembrane = cell.getMembrane();
        cellMembrane.setInfected(true);
	}

    default void attackNucleus(HostCell cell, Virus virus) {
    	cell.getChildren().add(virus);
    }

}
