package prize;

import java.io.Serializable;

import GUI.GUIController;
import player.PlayerRole;

public class HealthState implements PrizeStateRole, Serializable {
	
	private PrizeStateRole nextState;
	private int numberOfLives;
	private PrizeStateRole auxNextState;
	
	public HealthState(int value) {
		super();
		this.numberOfLives = value;
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
		if(!player.hasSpecialHealth())
		{
			player.addLife(numberOfLives);
			nextState = auxNextState;
		}
		else
		{
			nextState = this;
		}
	}

	@Override
	public boolean parcelHasPrize() {
		return true;
	}

	@Override
	public String getPrizeType() {
		return "src/health.gif";
	}

	@Override
	public int getValue() {
		return numberOfLives;
	}

}
