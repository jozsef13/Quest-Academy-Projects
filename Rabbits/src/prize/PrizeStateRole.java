package prize;

import player.PlayerRole;

public interface PrizeStateRole {

	PrizeStateRole next();

	void searchForPrizeBy(PlayerRole player);

}
