package player;

import java.io.Serializable;

import position.PositionStateRole;
import prize.BasketRole;
import prize.HealthRole;
import prize.PrizeRole;

public class RabbitWithHealth implements PlayerRole, Serializable {

	private PositionStateRole positionState;
	private BasketRole basket;
	private PrizeRole eggs;
	private HealthRole health;

	public RabbitWithHealth(PositionStateRole positionState, BasketRole basket, PrizeRole eggs, HealthRole health) {
		super();
		this.positionState = positionState;
		this.basket = basket;
		this.eggs = eggs;
		this.health = health;
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
	public void addLife(int value) {
		health.addLife(value);
	}

	public int getNumberOfLifes() {
		return health.getLifes();
	}

	@Override
	public boolean isDead() {
		return health.hasNoLifes();
	}

	@Override
	public void decreaseHealth() {
		health.decreaseLifes();
	}

	@Override
	public void changeDirection() {
		positionState = positionState.next().next();
	}

	@Override
	public boolean hasHealth() {
		return true;
	}

	@Override
	public void jump() {
		positionState.move();
	}
	
	
}
