package position;

import player.PlayerRole;

public class MoveToEastState implements PositionStateRole {

	private PositionRole innerPosition;
	private PositionStateRole nextState;

	public MoveToEastState(PositionRole innerPosition) {
		super();
		this.innerPosition = innerPosition;
	}

	public void setNextState(PositionStateRole nextState) {
		this.nextState = nextState;
	}

	@Override
	public void move() {
		innerPosition.moveEast();
	}

	@Override
	public void searchForPrizeBy(PlayerRole player) {
		innerPosition.searchForPrizeBy(player);
	}

	@Override
	public PositionStateRole next() {
		return nextState;
	}

	@Override
	public boolean isInitialState() {
		return innerPosition.isOnWestBorder();
	}

}
