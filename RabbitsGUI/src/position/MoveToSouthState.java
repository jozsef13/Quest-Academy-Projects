package position;

import java.io.Serializable;

import player.PlayerRole;

public class MoveToSouthState implements PositionStateRole, Serializable {

	private PositionRole innerPosition;
	private PositionStateRole nextState;
	
	public MoveToSouthState(PositionRole innerPosition) {
		super();
		this.innerPosition = innerPosition;
	}

	public void setNextState(PositionStateRole nextState) {
		this.nextState = nextState;
	}

	@Override
	public void move() {
		innerPosition.moveSouth();
	}

	@Override
	public void searchForPrizeBy(PlayerRole player) {
		innerPosition.searchForPrizeBy(player);
	}

	@Override
	public PositionStateRole next() {
		
		return nextState;
	}
	
	public boolean isInitialState() {
		return innerPosition.isOnNorthBorder();
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
	public void updateIcon() {
		innerPosition.updateIcon();
		
	}

}
