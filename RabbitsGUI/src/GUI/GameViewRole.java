package GUI;

import main.Game;

public interface GameViewRole {

	void addPrizesAt(int prizeX, int prizeY, int prizeValue);

	void addPlayerAt(int x, int y);

	void clearPlayerAt(int x, int y);

	void clearPrizeAt(int x, int y);

	void setVisible(boolean b);

	void setGame(Game game);
	
	void createGameView();

}
