package player;

public interface EnemyRole {

	void takeHealth(PlayerRole player);

	void move();

	void changeDirection();

	boolean isOnSameParcelWith(PlayerRole player);

	boolean isOnOutsideParcel();

	int getY();

	int getX();

	String getIcon();

}
