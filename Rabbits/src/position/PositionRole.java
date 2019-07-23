package position;

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

}
