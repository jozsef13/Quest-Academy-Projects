
public class Fight implements FightRole {

	private FighterRole defender;
	private FighterRole attacker;
	private int maxNrRounds;

	public Fight(FighterRole fighter1, FighterRole fighter2, int maxNrRounds) {
		if(fighter1.isAttackingFirst(fighter2)) {
			attacker = fighter1;
			defender = fighter2;
		}else {
			attacker = fighter2;
			defender = fighter1;
		}
		this.maxNrRounds = maxNrRounds;
	}

	@Override
	public void proceed() {

		for (int round = 1; round <= maxNrRounds; round++) {
			attacker.strike(defender);
			
			if(defender.isDead()) {
				return;
			}
			
			switchRoles();
		}
	}

	private void switchRoles() {
		FighterRole auxFighter;
		auxFighter = defender;
		defender = attacker;
		attacker = auxFighter;
	}

}
