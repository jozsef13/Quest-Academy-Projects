package prize;

import java.io.Serializable;

import GUI.GUIController;
import GUI.GameViewRole;
import player.PlayerRole;

public class EggState implements PrizeStateRole,Serializable {

	private PrizeStateRole nextState;
	private int value;
	private GUIController controller;
	
	public EggState(int value, GUIController controller) {
		super();
		this.value = value;
		this.controller = controller;
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
		controller.clearPrizeAt(player.getX(), player.getY());
	}

}
