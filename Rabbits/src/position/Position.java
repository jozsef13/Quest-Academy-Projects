package position;

import field.ParcelFieldRole;
import player.PlayerRole;

public class Position implements PositionRole {

	private int x;
	private int y;
	private ParcelFieldRole field;

	public Position(int x, int y, ParcelFieldRole field) {
		super();
		this.x = x;
		this.y = y;
		this.field = field;
	}

	@Override
	public void searchForPrizeBy(PlayerRole player) {
		field.searchForPrizeBy(player, x, y);
	}

	@Override
	public void moveSouth() {
		x++;
	}

	@Override
	public void moveNorth() {
		x--;
	}

	@Override
	public void moveEast() {
		y++;
	}

	@Override
	public void moveWest() {
		y--;
	}

	@Override
	public boolean isOnNorthBorder() {
		return x == 1;
	}

	@Override
	public boolean isOnSouthBorder() {
		return x == field.getMaxX();
	}

	@Override
	public boolean isOnWestBorder() {
		return y == 1;
	}

	@Override
	public boolean isOnEastBorder() {
		return y == field.getMaxY();
	}

}
