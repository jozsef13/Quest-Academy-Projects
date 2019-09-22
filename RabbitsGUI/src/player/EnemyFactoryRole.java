package player;

import position.PositionStateRole;

public interface EnemyFactoryRole {

	EnemyRole build(PositionStateRole positionState);

}
