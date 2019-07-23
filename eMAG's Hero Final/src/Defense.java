
public class Defense implements DefenseRole {

	private int defense;

	public Defense(int defense) {
		this.defense = defense;
	}

	@Override
	public int computeDamage(int attackerStrength) {
		return attackerStrength - defense;
	}

}
