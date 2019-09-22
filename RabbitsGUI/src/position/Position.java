package position;

import java.awt.Color;
import java.io.Serializable;
import java.util.Random;

import GUI.GUIController;
import field.ParcelFieldRole;
import player.PlayerRole;

public class Position implements PositionRole, Serializable {

	private int x;
	private int y;
	private ParcelFieldRole field;

	public Position(int x, int y, ParcelFieldRole field) {
		super();
		this.x = x;
		this.y = y;
		this.field = field;
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

	@Override
	public void moveNorthWest() {
		x--;
		y--;
	}

	@Override
	public void moveNorthEast() {
		x--;
		y++;
	}

	@Override
	public void moveSouthWest() {
		x++;
		y--;
	}

	@Override
	public void moveSouthEast() {
		x++;
		y++;
	}

	@Override
	public boolean isOnSouthEastCorner() {
		return x == field.getMaxX() && y == field.getMaxY();
	}

	@Override
	public boolean isOnSouthWestCorner() {
		return x == field.getMaxX() && y == 1;
	}

	@Override
	public boolean isOnNorthEastCorner() {
		return x == 1 && y == field.getMaxY();
	}

	@Override
	public boolean isOnNorthWestCorner() {
		return x == 1 && y == 1;
	}

	@Override
	public boolean isThePlayerDiagonal() {
		return isOnSouthEastCorner() || isOnSouthWestCorner() || isOnNorthWestCorner() || isOnNorthEastCorner();
	}

	@Override
	public boolean isOnOutsideParcel() {
		return x == 0 || y == 0 || x > field.getMaxX() || y > field.getMaxY();
	}
	
}
