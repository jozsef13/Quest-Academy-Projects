package prize;

import player.PlayerRole;

public class EggState implements PrizeStateRole {

	private PrizeStateRole nextState;
	private int value;
	
	public EggState(PrizeStateRole nextState, int value) {
		super();
		this.nextState = nextState;
		this.value = value;
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
	public void setNextState(PrizeStateRole otherNextState) {
		nextState = otherNextState;
	}

}
