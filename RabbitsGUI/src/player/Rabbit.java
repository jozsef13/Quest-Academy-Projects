package player;

import java.awt.Color;
import java.io.Serializable;
import java.util.Random;

import position.PositionStateRole;
import prize.BasketRole;
import prize.EggRole;
import prize.HealthRole;

public class Rabbit implements PlayerRole, Serializable {

	private PositionStateRole positionState;
	private BasketRole basket;
	private EggRole eggs;
	private int playerNumber;
	private HealthRole health;
	private Color randomColor;
	private String status = "Alive";
	
	public Rabbit(PositionStateRole positionState, BasketRole basket, EggRole eggs, int playerNumber, HealthRole health) {
		super();
		this.positionState = positionState;
		this.basket = basket;
		this.eggs = eggs;
		this.playerNumber = playerNumber;
		this.health = health;
		
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
	public boolean isDead() {
		return health.hasNoLifes();
	}

	@Override
	public void decreaseHealth(int damage) {
		health.decreaseHealth(100 - damage + damage);	
	}

	@Override
	public void changeDirection() {
		//does nothing
		
	}

	@Override
	public void addLife(int value) {
		//does nothing 
	}

	@Override
	public boolean hasHealth() {
		return !health.lifeIsOver();
	}


	@Override
	public String[] setInfoData() {
		String[] infoData = {Integer.toString(playerNumber), Integer.toString(getPrize()), Integer.toString(getBasket()), Integer.toString(health.getLifes()), Integer.toString(health.getHealthLevel()), status };
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
		return "src/rabbit.gif";
	}


	@Override
	public boolean hasSpecialHealth() {
		return false;
	}


	@Override
	public void setStatus(String string) {
		status = string;
	}

}
