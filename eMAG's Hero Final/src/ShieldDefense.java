
public class ShieldDefense implements DefenseRole {

	private DefenseRole innerDefense;
	private int damageDivider;

	public ShieldDefense(DefenseRole innerDefense, int damageDivider) {
		super();
		this.innerDefense = innerDefense;
		this.damageDivider = damageDivider;
	}

	@Override
	public int computeDamage(int strength) {
		return innerDefense.computeDamage(strength) / damageDivider;
	}

}
