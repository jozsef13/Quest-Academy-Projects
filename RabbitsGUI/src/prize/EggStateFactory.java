package prize;

import java.io.FileNotFoundException;

import GUI.GameViewRole;

public class EggStateFactory implements PrizeStateFactoryRole {

	private GameViewRole gameView;
	
	public EggStateFactory(GameViewRole gameView) {
		super();
		this.gameView = gameView;
	}

	@Override
	public PrizeStateRole build(int value) throws FileNotFoundException {
		return new EggState(value, gameView);
	}

}
