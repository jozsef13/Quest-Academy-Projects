package player;

public class InvincibilityFactory implements InvincibilityFactoryRole {

	@Override
	public InvincibilityRole build() {
		return new Invincibility(false, "No");
	}

}
