package parcel;

import field.PlayerFieldRole;
import player.PlayerRole;
import prize.PrizeStateRole;

public class OutsideParcel implements ParcelRole {

	private PlayerFieldRole field;

	public void setField(PlayerFieldRole field) {
		this.field = field;
	}

	@Override
	public void searchForPrizeBy(PlayerRole player) {
		field.removePlayer(player);
		field.setEggs(player.getEggs());
		field.setHighestBasket(player.getBasket());
	}

	@Override
	public void setPrizeState(PrizeStateRole otherCurrentState) {
		// does nothing
		
	}

}
