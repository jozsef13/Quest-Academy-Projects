package prize;

import java.io.Serializable;

import GUI.GUIController;
import player.PlayerRole;

public class EggState implements PrizeStateRole,Serializable {

	private PrizeStateRole nextState;
	private int value;
	
	public EggState(int value) {
		super();
		this.value = value;
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
	}

	@Override
	public boolean parcelHasPrize() {
		return true;
	}

	@Override
	public String getPrizeType() {
		return "src/egg.gif";
	}

	@Override
	public int getValue() {
		return value;
	}

}
