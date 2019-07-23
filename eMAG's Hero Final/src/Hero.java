
public class Hero implements FighterRole {

	private FighterRole innerFighter;
	private LuckRole luck;
	private int rapidStrikeLuckLevel;

	public Hero(FighterRole innerFighter, LuckRole luck, int rapidStrikeLuckLevel) {
		super();
		this.innerFighter = innerFighter;
		this.luck = luck;
		this.rapidStrikeLuckLevel = rapidStrikeLuckLevel;
	}

	public boolean isDead() {
		return innerFighter.isDead();
	}

	public boolean isAttackingFirst(FighterRole fighter2) {
		return innerFighter.isAttackingFirst(fighter2);
	}

	public boolean hasSameSpeed(int speed) {
		return innerFighter.hasSameSpeed(speed);
	}

	public boolean isLessLucky(int luck) {
		return innerFighter.isLessLucky(luck);
	}

	public boolean isSlower(int speed) {
		return innerFighter.isSlower(speed);
	}

	public void defend(int strength) {
		innerFighter.defend(strength);
	}

	@Override
	public void strike(FighterRole defender) {
		innerFighter.strike(defender);

		if (luck.iAmLucky(rapidStrikeLuckLevel)) {
			innerFighter.strike(defender);
		}
	}

}
