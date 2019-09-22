package parcel;

import java.io.Serializable;

import player.PlayerRole;

public class TraplessState implements TrapStateRole, Serializable {

	@Override
	public boolean parcelHasTrap() {
		return false;
	}

	@Override
	public int getDamage() {
		return 0;
	}

	@Override
	public void takeHealth(PlayerRole player) {
		// does nothing
		
	}

}
