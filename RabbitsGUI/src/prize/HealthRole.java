package prize;

public interface HealthRole {

	void addLife(int value);

	int getLifes();

	boolean hasNoLifes();

	void decreaseHealth(int damage);

	int getHealthLevel();
	
	boolean lifeIsOver();

}
