package position;

import java.io.FileNotFoundException;

import GUI.GameViewRole;
import field.ParcelFieldRole;

public class PositionFactory implements PositionFactoryRole {

	private ParcelFieldRole field;
	private GameViewRole gameView;

	public PositionFactory(ParcelFieldRole field, GameViewRole gameView) {
		super();
		this.field = field;
		this.gameView = gameView;
	}

	@Override
	public PositionRole build(int x, int y) throws FileNotFoundException {
		return new Position(x, y, field, gameView );
	}

}
