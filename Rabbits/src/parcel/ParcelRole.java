package parcel;

import field.PlayerFieldRole;
import player.PlayerRole;
import prize.PrizeStateRole;

public interface ParcelRole {

	void searchForPrizeBy(PlayerRole player);

	void setPrizeState(PrizeStateRole otherCurrentState);
	
	void setField(PlayerFieldRole field);

}
