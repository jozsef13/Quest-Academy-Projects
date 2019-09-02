package field;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import player.PlayerRole;
import prize.BasketRole;
import prize.PrizeRole;

public class GameField implements GameFieldRole, PlayerFieldRole, Serializable {

	private List<PlayerRole> playersOnField;
	private PrizeRole eggs;
	private BasketRole basket;

	public GameField(List<PlayerRole> playersOnField, PrizeRole eggs, BasketRole basket) {
		super();
		this.playersOnField = playersOnField;
		this.eggs = eggs;
		this.basket = basket;
	}

	@Override
	public void playTurn() {
		// This was used in order to be able to delete inside for..each
		List<PlayerRole> clonePlayersOnField = new ArrayList<>(playersOnField);

		for (PlayerRole player : clonePlayersOnField) {
			player.playTurn();
		}
		
		for (PlayerRole player : clonePlayersOnField) {
			player.updateIcon();
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
		return eggs.getEggsValue();
	}

	@Override
	public void setEggs(int otherEggs) {
		eggs.setEggsValue(otherEggs);
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
	
	public int getNumberOfPlayers() {
		return playersOnField.size();
	}

}
