package position;

import java.awt.Color;
import java.io.Serializable;
import java.util.Random;

import GUI.GUIController;
import GUI.GameViewRole;
import field.ParcelFieldRole;
import player.PlayerRole;

public class Position implements PositionRole, Serializable {

	private int x;
	private int y;
	private ParcelFieldRole field;
	private Color randomColor;
	private GUIController controller;

	public Position(int x, int y, ParcelFieldRole field, GUIController otherController) {
		super();
		this.x = x;
		this.y = y;
		this.field = field;
		this.controller = otherController;
		
		Random rand = new Random();

		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();

		randomColor = new Color(r, g, b);
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
		controller.clearPlayerAt(x, y);
		x++;
	}

	@Override
	public void moveNorth() {
		controller.clearPlayerAt(x, y);
		x--;
	}

	@Override
	public void moveEast() {
		controller.clearPlayerAt(x, y);
		y++;
	}

	@Override
	public void moveWest() {
		controller.clearPlayerAt(x, y);
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
	public void updateIcon() {
		controller.addPlayersOnGameView(x, y, randomColor);
	}
	
	@Override
	public Color getRandomColor() {
		return randomColor;
	}

}
