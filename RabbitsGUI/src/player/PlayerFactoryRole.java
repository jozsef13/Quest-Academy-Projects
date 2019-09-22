package player;

import position.PositionStateRole;

public interface PlayerFactoryRole {

	PlayerRole build(PositionStateRole positionState, int playerNumber);

}
