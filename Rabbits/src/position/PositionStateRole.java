package position;

import player.PlayerRole;

public interface PositionStateRole {

	void move();

	void searchForPrizeBy(PlayerRole player);

	PositionStateRole next();
	
	boolean isInitialState();
	
	void setNextState(PositionStateRole nextState);

}
