
public interface FighterRole {

	void strike(FighterRole defender);

	boolean isDead();

	boolean isAttackingFirst(FighterRole fighter2);

	boolean hasSameSpeed(int speed);

	boolean isLessLucky(int luck);

	boolean isSlower(int speed);

	void defend(int strength);

}
