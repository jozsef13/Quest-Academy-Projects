package position;

import java.io.FileNotFoundException;

import field.ParcelFieldRole;

public class PositionFactory implements PositionFactoryRole {

	private ParcelFieldRole field;

	public PositionFactory(ParcelFieldRole field) {
		super();
		this.field = field;
	}

	@Override
	public PositionRole build(int x, int y) throws FileNotFoundException {
		return new Position(x, y, field );
	}

}
