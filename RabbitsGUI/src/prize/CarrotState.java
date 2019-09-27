package prize;

import java.io.Serializable;

import player.PlayerRole;

public class CarrotState implements PrizeStateRole, Serializable {

	private PrizeStateRole nextState;
	private int value;

	public CarrotState(int value) {
		super();
		this.value = value;
	}

	@Override
	public PrizeStateRole next() {
		return nextState;
	}

	@Override
	public void searchForPrizeBy(PlayerRole player) {
		player.setInvincibilityStatus("Yes");
		player.setInvincibility(true);
	}

	@Override
	public void setNextState(PrizeStateRole otherNextState) {
		this.nextState = otherNextState;
	}

	@Override
	public boolean parcelHasPrize() {
		return true;
	}

	@Override
	public String getPrizeType() {
		return "src/carrot.gif";
	}

	@Override
	public int getValue() {
		return value;
	}

}
