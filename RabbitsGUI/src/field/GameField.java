package field;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import player.EnemyRole;
import player.PlayerRole;
import prize.BasketRole;
import prize.EggRole;

public class GameField implements GameFieldRole, PlayerFieldRole, Serializable {

	private List<PlayerRole> playersOnField;
	private EggRole eggs;
	private BasketRole basket;
	private List<EnemyRole> enemies;

	public GameField(List<PlayerRole> playersOnField, EggRole eggs, BasketRole basket, List<EnemyRole> enemies) {
		super();
		this.playersOnField = playersOnField;
		this.eggs = eggs;
		this.basket = basket;
		this.enemies = enemies;
	}

	@Override
	public void playTurn() {
		// This was used in order to be able to delete inside for..each
		List<PlayerRole> clonePlayersOnField = new ArrayList<>(playersOnField);
		List<EnemyRole> cloneEnemies = new ArrayList<>(enemies);
		
		for (EnemyRole enemy : cloneEnemies) {
			enemy.move();
			if(enemy.isOnOutsideParcel())
			{
				enemy.changeDirection();
			}
		}
		
		for (PlayerRole player : clonePlayersOnField) {
			player.playTurn();
			
			for (EnemyRole enemy : cloneEnemies) {
				if(enemy.isOnSameParcelWith(player))
				{
					enemy.takeHealth(player);
				}
			}
			
			if(player.isDead())
			{
				player.setStatus("Dead");
				removePlayer(player);
			}
		}
	}

	@Override
	public boolean playersAreOnField() {

		if (playersOnField.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public void removePlayer(PlayerRole player) {
		playersOnField.remove(player);
	}

	@Override
	public int getEggs() {
		return eggs.getValue();
	}

	@Override
	public void setEggs(int otherEggs) {
		eggs.setValue(otherEggs);
	}

	@Override
	public void setHighestBasket(int otherBasket) {
		if(basket.isHighestValue(otherBasket))
			basket.setBasketValue(otherBasket);
	}

	@Override
	public int getHighestBasket() {
		return basket.getBasketValue();
	}

}
