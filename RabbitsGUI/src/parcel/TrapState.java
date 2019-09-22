package parcel;

import java.io.Serializable;

import player.PlayerRole;

public class TrapState implements TrapStateRole,Serializable {

	private int damage;

	public TrapState(int damage) {
		super();
		this.damage = damage;
	}

	@Override
	public boolean parcelHasTrap() {
		return true;
	}

	@Override
	public int getDamage() {
		return damage;
	}

	@Override
	public void takeHealth(PlayerRole player) {
		player.decreaseHealth(damage);
	}

}
