package player;

import java.awt.Color;

public interface PlayerRole {

	void playTurn();

	void addToBasket(int value);

	int getPrize();

	int getBasket();

	int getX();

	int getY();

	void addLife(int value);

	boolean isDead();

	void changeDirection();

	boolean hasHealth();

	void decreaseHealth(int damage);

	String[] setInfoData();

	Color getRandomColor();

	int getPlayerNumber();

	String getIcon();

	boolean hasSpecialHealth();

	void setStatus(String string);

}
