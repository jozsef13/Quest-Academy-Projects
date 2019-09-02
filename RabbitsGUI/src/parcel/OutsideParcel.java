package parcel;

import java.io.Serializable;

import field.PlayerFieldRole;
import player.PlayerRole;
import prize.PrizeStateRole;

public class OutsideParcel implements ParcelRole, Serializable {

	private PlayerFieldRole field;

	public void setField(PlayerFieldRole field) {
		this.field = field;
	}

	@Override
	public void searchForPrizeBy(PlayerRole player) {
		if(player.isDead())
		{
			field.removePlayer(player);
			field.setEggs(player.getEggs());
			field.setHighestBasket(player.getBasket());
		}
		else
		{
			player.decreaseHealth();
			player.changeDirection();
		}
	}

	@Override
	public void setPrizeState(PrizeStateRole otherCurrentState) {
		// does nothing
		
	}

}
