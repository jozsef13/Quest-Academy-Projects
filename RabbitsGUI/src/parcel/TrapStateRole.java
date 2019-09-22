package parcel;

import player.PlayerRole;

public interface TrapStateRole {

	boolean parcelHasTrap();

	int getDamage();

	void takeHealth(PlayerRole player);

}
