package parcel;

import field.PlayerFieldRole;
import player.PlayerRole;
import prize.PrizeStateRole;

public class InsideParcel implements ParcelRole{

	PrizeStateRole currentState;
	
	public InsideParcel(PrizeStateRole currentState) {
		super();
		this.currentState = currentState;
	}

	@Override
	public void searchForPrizeBy(PlayerRole player) {
		currentState.searchForPrizeBy(player);
	}

	@Override
	public void setPrizeState(PrizeStateRole otherCurrentState) {
		currentState = otherCurrentState;
	}

	@Override
	public void setField(PlayerFieldRole field) {
		// does nothing
		
	}

}
