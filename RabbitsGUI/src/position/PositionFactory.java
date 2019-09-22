package position;

import GUI.GUIController;
import field.ParcelFieldRole;

public class PositionFactory implements PositionFactoryRole {

	private ParcelFieldRole field;

	public PositionFactory(ParcelFieldRole field) {
		super();
		this.field = field;
	}

	@Override
	public PositionRole build(int x, int y){
		return new Position(x, y, field);
	}

}
