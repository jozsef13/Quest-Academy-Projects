package player;

import java.io.Serializable;

import position.PositionStateRole;

public class Fox implements EnemyRole, Serializable{

	private PositionStateRole positionState;

	public Fox(PositionStateRole positionState) {
		super();
		this.positionState = positionState;
	}

	@Override
	public void takeHealth(PlayerRole player) {
		player.decreaseHealth(100);
	}

	@Override
	public void move() {
		positionState.move();
	}

	@Override
	public void changeDirection() {
		positionState = positionState.next().next();
	}

	@Override
	public boolean isOnSameParcelWith(PlayerRole player) {
		return getX() == player.getX() && getY() == player.getY();
	}

	@Override
	public int getY() {
		return positionState.getY();
	}
	
	@Override
	public int getX() {
		return positionState.getX();
	}

	@Override
	public boolean isOnOutsideParcel() {
		return positionState.isOnOutsideParcel();
	}

	@Override
	public String getIcon() {
		return "src/fox.gif";
	}

}
