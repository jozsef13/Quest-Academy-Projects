package player;

import java.io.Serializable;

import position.PositionStateRole;

public class FoxFactory implements EnemyFactoryRole, Serializable {

	@Override
	public EnemyRole build(PositionStateRole positionState) {
		return new Fox(positionState);
	}

}
