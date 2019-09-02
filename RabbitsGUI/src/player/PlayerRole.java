package player;

public interface PlayerRole {

	void playTurn();

	void addToBasket(int value);

	int getEggs();

	int getBasket();

	int getX();

	int getY();

	void updateIcon();

	void addLife(int value);

	boolean isDead();

	void decreaseHealth();

	void changeDirection();

	boolean hasHealth();

	void jump();


}
