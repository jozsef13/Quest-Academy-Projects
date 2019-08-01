package prize;

import player.PlayerRole;

public class PrizeLessState implements PrizeStateRole {

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

}
