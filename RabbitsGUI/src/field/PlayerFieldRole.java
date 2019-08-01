package field;

import player.PlayerRole;

public interface PlayerFieldRole{

	void removePlayer(PlayerRole player);

	void setEggs(int otherEggs);

	void setHighestBasket(int otherBasket);
	
	int getEggs();

	int getHighestBasket();

}
