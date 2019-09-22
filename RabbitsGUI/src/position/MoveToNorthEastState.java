package position;

import player.PlayerRole;

public class MoveToNorthEastState implements PositionStateRole {

	private PositionRole innerPosition;
	private PositionStateRole nextState;

	public MoveToNorthEastState(PositionRole innerPosition) {
		super();
		this.innerPosition = innerPosition;
	}

	public void setNextState(PositionStateRole nextState) {
		this.nextState = nextState;
	}

	@Override
	public void move() {
		innerPosition.moveNorthEast();
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
		return innerPosition.isOnSouthWestCorner();
	}

	@Override
	public int getX() {
		return innerPosition.getX();
	}

	@Override
	public int getY() {
		return innerPosition.getY();
	}

	@Override
	public boolean isOnOutsideParcel() {
		return innerPosition.isOnOutsideParcel();
	}
}
