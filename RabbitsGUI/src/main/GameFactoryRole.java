package main;

import parcel.ParcelRole;
import player.EnemyFactoryRole;
import player.PlayerFactoryRole;
import player.PlayerRole;
import prize.PrizeStateFactoryRole;

public interface GameFactoryRole {

	Game build();

	void addPalyers(int x, int y, int numberOfLifes, PlayerFactoryRole playerFactory);

	void addTrap(int x, int y, int damageInflicted);

	ParcelRole[][] getParcel();

	void addPrize(int x, int y, int prizeValue, PrizeStateFactoryRole prizeFactory);

	void addEnemyAt(int x, int y, EnemyFactoryRole enemyFactory);

}
