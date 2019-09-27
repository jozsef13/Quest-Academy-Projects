package parcel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import field.PlayerFieldRole;
import player.PlayerRole;
import prize.PrizeStateRole;

public class InsideParcel implements ParcelRole, Serializable{

	private PrizeStateRole currentState;
	private PlayerFieldRole field;
	private TrapStateRole trapState;

	public InsideParcel(PrizeStateRole currentState, TrapStateRole trapState) {
		super();
		this.currentState = currentState;
		this.trapState = trapState;
	}


	@Override
	public void searchForPrizeBy(PlayerRole player) {
		currentState.searchForPrizeBy(player);
		currentState = currentState.next();
		
		if(trapState.parcelHasTrap())
		{
			if(player.isNotInvincible())
			{
				trapState.takeHealth(player);				
			}
			else
			{
				player.setInvincibilityStatus("No");
				player.setInvincibility(false);
			}
			
			if(player.isDead())
			{
				player.setStatus("Dead");
				field.removePlayer(player);
			}
		}
		
	}


	@Override
	public void setPrizeState(PrizeStateRole otherCurrentState) {
		currentState = otherCurrentState;
	}

	@Override
	public void setField(PlayerFieldRole otherField) {
		this.field = otherField;
	}
	
	@Override
	public void setTrapState(TrapStateRole otherTrapState){
		trapState = otherTrapState;
	}


	@Override
	public boolean hasTrap() {
		return trapState.parcelHasTrap();
	}


	@Override
	public String trapDamage() {
		return Integer.toString(trapState.getDamage());
	}


	@Override
	public boolean hasPrize() {
		return currentState.parcelHasPrize();
	}


	@Override
	public String prizeType() {
		return currentState.getPrizeType();
	}


	@Override
	public int prizeValue() {
		return currentState.getValue();
	}

}
