package prize;

import java.io.Serializable;

public class Health implements HealthRole, Serializable {

	private LifeRole life;
	private int healthLevel;

	public Health(int value, LifeRole life2) {
		super();
		this.life = life2;
		this.healthLevel = value;
	}
	
	@Override
	public void addLife(int value) {
		life.add(value);
	}

	@Override
	public int getLifes() {
		return life.getNumberOfLifes();
	}
	
	@Override
	public boolean hasNoLifes() {
		return life.noLifes();
	}
	
	@Override
	public void decreaseHealth(int damage) {
		takeDamage(damage);
		if(lifeIsOver()) {
			life.decreaseNumberOfLifes();
			if(!life.noLifes())
				healthLevel = 100;
		}
	}
	
	@Override
	public boolean lifeIsOver() {
		return healthLevel <= 0;
	}
	
	private void takeDamage(int damage) {
		healthLevel -= damage;
	}
	
	@Override
	public int getHealthLevel() {
		return healthLevel;
	}

}
