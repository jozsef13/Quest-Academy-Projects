package player;

import java.awt.Color;
import java.io.Serializable;
import java.util.Random;

import position.PositionStateRole;
import prize.BasketRole;
import prize.HealthRole;
import prize.EggRole;

public class RabbitWithHealth implements PlayerRole, Serializable {

	private PositionStateRole positionState;
	private BasketRole basket;
	private EggRole eggs;
	private HealthRole health;
	private int playerNumber;
	private Color randomColor;
	private String status = "Alive";
	private InvincibilityRole invincibility;

	public RabbitWithHealth(PositionStateRole positionState, BasketRole basket, EggRole eggs, HealthRole health, int playerNumber2, InvincibilityRole otherInvincibility) {
		super();
		this.positionState = positionState;
		this.basket = basket;
		this.eggs = eggs;
		this.health = health;
		this.playerNumber = playerNumber2;
		this.invincibility = otherInvincibility;
		
		Random rand = new Random();

		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();

		randomColor = new Color(r, g, b);
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
	public int getPrize() {
		return eggs.getValue();
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
	public void addLife(int value) {
		health.addLife(value);
	}
	

	@Override
	public boolean isDead() {
		return health.hasNoLifes();
	}

	@Override
	public void decreaseHealth(int damage) {
		health.decreaseHealth(damage);
	}

	@Override
	public void changeDirection() {
		positionState = positionState.next().next();
	}

	@Override
	public boolean hasHealth() {
		return !health.lifeIsOver();
	}

	@Override
	public String[] setInfoData() {
		String[] infoData = {Integer.toString(playerNumber), Integer.toString(getPrize()), Integer.toString(getBasket()), Integer.toString(health.getLifes()), Integer.toString(health.getHealthLevel()), status, invincibility.getStatus() };
		return infoData;
	}
	
	@Override
	public Color getRandomColor() {
		return randomColor;
	}
	
	@Override
	public int getPlayerNumber() {
		return playerNumber;
	}

	@Override
	public String getIcon() {
		return "src/rabbitHealth.gif";
	}

	@Override
	public boolean hasSpecialHealth() {
		return true;
	}

	@Override
	public void setStatus(String otherStatus) {
		status = otherStatus;
	}
	
	@Override
	public void setInvincibility(boolean otherInvincibility) {
		invincibility.set(otherInvincibility);
	}


	@Override
	public boolean isNotInvincible() {
		return invincibility.isNotActive();
	}


	@Override
	public void setInvincibilityStatus(String otherInvincibilityStatus) {
		invincibility.setPlayerStatus(otherInvincibilityStatus);
	}
}
