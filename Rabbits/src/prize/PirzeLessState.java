package prize;

import player.PlayerRole;

public class PirzeLessState implements PrizeStateRole {

	private PrizeStateRole nextState;
	
	public PirzeLessState(PrizeStateRole nextState) {
		super();
		this.nextState = nextState;
	}

	@Override
	public PrizeStateRole next() {
		
		return nextState;
	}

	@Override
	public void searchForPrizeBy(PlayerRole player) {


	}

}
