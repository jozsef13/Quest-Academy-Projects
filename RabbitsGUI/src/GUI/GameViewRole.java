package GUI;

import java.awt.Color;

import main.Game;

public interface GameViewRole {

	void addEggsAt(int prizeX, int prizeY, int prizeValue);

	void addPlayerAt(int x, int y, Color randomColor);

	void clearPlayerAt(int x, int y);

	void clearPrizeAt(int x, int y);

	void setVisible(boolean b);

	void setGame(Game game);
	
	void createGameView();

}
