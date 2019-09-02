package position;

import java.io.FileNotFoundException;
import java.io.Serializable;

import GUI.GUIController;
import GUI.GameViewRole;
import field.ParcelFieldRole;

public class PositionFactory implements PositionFactoryRole, Serializable {

	private ParcelFieldRole field;
	private GUIController controller;

	public PositionFactory(ParcelFieldRole field, GUIController controller) {
		super();
		this.field = field;
		this.controller = controller;
	}

	@Override
	public PositionRole build(int x, int y){
		return new Position(x, y, field, controller);
	}

}
