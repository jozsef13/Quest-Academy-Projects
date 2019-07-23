
public class Fighter implements FighterRole {

	private HealthRole health;
	private int speed;
	private int luckLevel;
	private int strength;
	private DefenseRole defense;
	private LuckRole luck;

	public Fighter(HealthRole health, int speed, int luckLevel, int strength, DefenseRole defense, LuckRole luck) {
		this.health = health;
		this.speed = speed;
		this.luckLevel = luckLevel;
		this.strength = strength;
		this.defense = defense;
		this.luck = luck;
	}

	@Override
	public void strike(FighterRole defender) {
		defender.defend(strength);
	}

	@Override
	public boolean isDead() {
		return health.isDead();
	}

	@Override
	public boolean isAttackingFirst(FighterRole anotherFighter) {
		if(anotherFighter.hasSameSpeed(speed)) {
			return anotherFighter.isLessLucky(luckLevel);
		}
		return anotherFighter.isSlower(speed);
	}

	@Override
	public boolean hasSameSpeed(int otherSpeed) {
		return speed == otherSpeed;
	}

	@Override
	public boolean isLessLucky(int otherLuck) {
		return luckLevel < otherLuck;
	}

	@Override
	public boolean isSlower(int otherSpeed) {
		return speed < otherSpeed;
	}

	@Override
	public void defend(int strength) {
		if(luck.iAmLucky(luckLevel)) {
			return;
		}
		int damage = defense.computeDamage(strength);
		health.applyDamage(damage);
	}

}
