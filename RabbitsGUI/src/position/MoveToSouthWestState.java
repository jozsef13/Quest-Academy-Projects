package position;

import player.PlayerRole;

public class MoveToSouthWestState implements PositionStateRole {

	private PositionRole innerPosition;
	private PositionStateRole nextState;

	public MoveToSouthWestState(PositionRole innerPosition) {
		super();
		this.innerPosition = innerPosition;
	}

	public void setNextState(PositionStateRole nextState) {
		this.nextState = nextState;
	}

	@Override
	public void move() {
		innerPosition.moveSouthWest();
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
		return innerPosition.isOnNorthEastCorner();
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
