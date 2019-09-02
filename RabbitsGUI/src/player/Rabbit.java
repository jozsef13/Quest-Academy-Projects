package player;

import java.io.Serializable;

import position.PositionStateRole;
import prize.BasketRole;
import prize.PrizeRole;

public class Rabbit implements PlayerRole, Serializable {

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

	@Override
	public void updateIcon() {
		positionState.updateIcon();
		
	}

	@Override
	public boolean isDead() {
		return true;
	}

	@Override
	public void decreaseHealth() {
		// nothing
		
	}

	@Override
	public void changeDirection() {
		// nothing
		
	}

	@Override
	public void addLife(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasHealth() {
		return false;
	}

	@Override
	public void jump() {
		positionState.move();
	}

}
