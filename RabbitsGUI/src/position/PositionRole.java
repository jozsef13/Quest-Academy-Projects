package position;

import java.awt.Color;

import player.PlayerRole;

public interface PositionRole {

	void searchForPrizeBy(PlayerRole player);

	void moveSouth();

	void moveNorth();

	void moveEast();

	void moveWest();

	boolean isOnNorthBorder();

	boolean isOnSouthBorder();

	boolean isOnWestBorder();

	boolean isOnEastBorder();
	
	int getX();
	
	int getY();

	void moveNorthWest();

	void moveNorthEast();

	void moveSouthWest();

	void moveSouthEast();

	boolean isOnSouthEastCorner();

	boolean isOnSouthWestCorner();

	boolean isOnNorthEastCorner();

	boolean isOnNorthWestCorner();

	boolean isThePlayerDiagonal();

	boolean isOnOutsideParcel();

}
