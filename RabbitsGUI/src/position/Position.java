package position;

import GUI.GameViewRole;
import field.ParcelFieldRole;
import player.PlayerRole;

public class Position implements PositionRole {

	private int x;
	private int y;
	private ParcelFieldRole field;
	private GameViewRole gameView;

	public Position(int x, int y, ParcelFieldRole field, GameViewRole gameView) {
		super();
		this.x = x;
		this.y = y;
		this.field = field;
		this.gameView = gameView;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public void searchForPrizeBy(PlayerRole player) {
		field.searchForPrizeBy(player, x, y);
	}

	@Override
	public void moveSouth() {
		gameView.clearPlayerAt(x, y);
		System.out.println("sud");
		x++;
		gameView.addPlayerAt(x, y);
	}

	@Override
	public void moveNorth() {
		gameView.clearPlayerAt(x, y);
		System.out.println("nord");
		x--;
		gameView.addPlayerAt(x, y);
	}

	@Override
	public void moveEast() {
		gameView.clearPlayerAt(x, y);
		System.out.println("est");
		y++;
		gameView.addPlayerAt(x, y);
	}

	@Override
	public void moveWest() {
		gameView.clearPlayerAt(x, y);
		System.out.println("vest");
		y--;
		gameView.addPlayerAt(x, y);
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
