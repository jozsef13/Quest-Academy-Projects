package prize;

import java.io.Serializable;

import player.PlayerRole;

public class PrizeLessState implements PrizeStateRole, Serializable {

	private PrizeStateRole nextState;
	
	@Override
	public PrizeStateRole next() {
		
		return nextState;
	}

	@Override
	public void searchForPrizeBy(PlayerRole player) {
		//does nothing
	}

	@Override
	public void setNextState(PrizeStateRole nextState) {
		this.nextState = nextState;
	}

	@Override
	public boolean parcelHasPrize() {
		return false;
	}

	@Override
	public String getPrizeType() {
		return " ";
	}

	@Override
	public int getValue() {
		return 0;
	}

}
