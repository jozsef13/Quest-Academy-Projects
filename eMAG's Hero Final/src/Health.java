
public class Health implements HealthRole {

	private int currentHealth;

	public Health(int currentHealth) {
		super();
		this.currentHealth = currentHealth;
	}

	@Override
	public boolean isDead() {
		return currentHealth <= 0;
	}

	@Override
	public void applyDamage(int damage) {
		currentHealth = currentHealth - damage;
	}

}
