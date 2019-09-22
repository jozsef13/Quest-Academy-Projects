package prize;

import player.PlayerRole;

public interface PrizeStateRole {

	PrizeStateRole next();

	void searchForPrizeBy(PlayerRole player);

	void setNextState(PrizeStateRole nextState);

	boolean parcelHasPrize();

	String getPrizeType();

	int getValue();

}
