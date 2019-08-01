package player;

import position.PositionStateRole;
import prize.BasketRole;
import prize.PrizeRole;

public class Rabbit implements PlayerRole {

	private PositionStateRole positionState;
	private BasketRole basket;
	private PrizeRole eggs;

	public Rabbit(PositionStateRole positionState, BasketRole basket, PrizeRole eggs) {
		super();
		this.positionState = positionState;
		this.basket = basket;
		this.eggs = eggs;
	}

	@Override
	public void playTurn() {
		positionState.move();
		positionState.searchForPrizeBy(this);
	}

	@Override
	public void addToBasket(int value) {
		basket.addToBasket(value);
		positionState = positionState.next();
		eggs.addEggs();
	}

	@Override
	public int getEggs() {
		return eggs.getEggsValue();
	}

	@Override
	public int getBasket() {
		return basket.getBasketValue();
	}
	
	@Override
	public int getX() {
		return positionState.getX();
	}

	@Override
	public int getY() {
		return positionState.getY();
	}

}
