
public class HeroDefense implements DefenseRole {

	private DefenseRole innerDefense;
	private LuckRole luck;
	private int defenseLuckLevel;
	private DefenseRole shieldDefense;

	public HeroDefense(DefenseRole innerDefense, LuckRole luck, int defenseLuckLevel, DefenseRole shieldDefense) {
		super();
		this.innerDefense = innerDefense;
		this.luck = luck;
		this.defenseLuckLevel = defenseLuckLevel;
		this.shieldDefense = shieldDefense;
	}

	@Override
	public int computeDamage(int strength) {

		if (luck.iAmLucky(defenseLuckLevel)) {
			return shieldDefense.computeDamage(strength);
		}
		
		return innerDefense.computeDamage(strength);
	}

}
