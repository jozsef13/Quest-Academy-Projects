package field;

import player.PlayerRole;

public interface GameFieldRole{

	boolean playersAreOnField();

	void playTurn();

	void removePlayer(PlayerRole player);
	
	int getNumberOfPlayers();

}
