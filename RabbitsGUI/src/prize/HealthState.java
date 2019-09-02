package prize;

import java.io.Serializable;

import GUI.GUIController;
import player.PlayerRole;

public class HealthState implements PrizeStateRole, Serializable {
	
	private PrizeStateRole nextState;
	private GUIController controller;
	private int value;
	private PrizeStateRole auxNextState;
	
	public HealthState(GUIController controller, int value) {
		super();
		this.controller = controller;
		this.value = value;
	}

	@Override
	public void setNextState(PrizeStateRole nextState) {
		this.nextState = nextState;
		this.auxNextState = nextState;
	}

	@Override
	public PrizeStateRole next() {
		return nextState;
	}

	@Override
	public void searchForPrizeBy(PlayerRole player) {
		if(player.hasHealth())
		{
			player.addLife(value);
			controller.clearPrizeAt(player.getX(), player.getY());
			nextState = auxNextState;
		}
		else
		{
			player.jump();
			nextState = this;
		}
	}

}
