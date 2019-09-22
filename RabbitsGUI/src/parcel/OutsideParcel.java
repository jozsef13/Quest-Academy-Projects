package parcel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import GUI.GUIController;
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
		
		player.decreaseHealth(100);
		player.changeDirection();
		
		if(player.isDead())
		{
			player.setStatus("Dead");
			field.removePlayer(player);
			field.setEggs(player.getPrize());
			field.setHighestBasket(player.getBasket());
		}
	}

	@Override
	public void setPrizeState(PrizeStateRole otherCurrentState) {
		// does nothing
		
	}

	@Override
	public void setTrapState(TrapStateRole otherTrapState) {
		//does nothing
	}

	@Override
	public boolean hasTrap() {
		return false;
	}

	@Override
	public String trapDamage() {
		return "0";
	}

	@Override
	public boolean hasPrize() {
		return false;
	}

	@Override
	public String prizeType() {
		return " ";
	}

	@Override
	public int prizeValue() {
		return 0;
	}

}
