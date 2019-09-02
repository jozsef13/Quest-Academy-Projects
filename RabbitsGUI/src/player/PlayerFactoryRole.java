package player;

import java.io.FileNotFoundException;

import position.PositionStateRole;

public interface PlayerFactoryRole {

	PlayerRole build(PositionStateRole positionState);

}
