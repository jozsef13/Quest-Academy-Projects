package parcel;

import field.PlayerFieldRole;
import player.PlayerRole;
import prize.PrizeStateRole;

public interface ParcelRole {

	void searchForPrizeBy(PlayerRole player);

	void setPrizeState(PrizeStateRole otherCurrentState);
	
	void setField(PlayerFieldRole field);

	void setTrapState(TrapStateRole otherTrapState);

	boolean hasTrap();

	String trapDamage();

	boolean hasPrize();

	String prizeType();

	int prizeValue();

}
