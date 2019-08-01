package field;

import player.PlayerRole;

public interface ParcelFieldRole {

	void searchForPrizeBy(PlayerRole player, int x, int y);

	int getMaxY();

	int getMaxX();


}
