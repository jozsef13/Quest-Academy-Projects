package prize;

import GUI.GameViewRole;
import player.PlayerRole;

public class EggState implements PrizeStateRole {

	private PrizeStateRole nextState;
	private int value;
	private GameViewRole gameView;

	public EggState(int value, GameViewRole gameView) {
		super();
		this.value = value;
		this.gameView = gameView;
	}
	
	@Override
	public void setNextState(PrizeStateRole nextState) {
		this.nextState = nextState;
	}

	@Override
	public PrizeStateRole next() {
		return nextState;
	}

	@Override
	public void searchForPrizeBy(PlayerRole player) {
		player.addToBasket(value);
		gameView.clearPrizeAt(player.getX(), player.getY());
	}

}
