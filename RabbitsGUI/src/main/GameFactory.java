package main;

import java.io.Serializable;
import java.util.List;

import field.GameFieldFactory;
import field.GameFieldFactoryRole;
import field.GameFieldRole;
import field.ParcelFieldFactory;
import field.ParcelFieldFactoryRole;
import field.ParcelFieldRole;
import field.PlayerFieldRole;
import inout.OutputFactory;
import inout.OutputFactoryRole;
import inout.OutputRole;
import parcel.InsideParcelFactory;
import parcel.OutsideParcelFactory;
import parcel.OutsideParcelFactoryRole;
import parcel.ParcelFactoryRole;
import parcel.ParcelRole;
import parcel.TrapState;
import parcel.TrapStateRole;
import parcel.TraplessState;
import player.EnemyFactoryRole;
import player.EnemyRole;
import player.PlayerFactoryRole;
import player.PlayerRole;
import player.RabbitFactory;
import player.RabbitWithHealthFactory;
import position.DiagonallyPositionStateFactory;
import position.PositionFactory;
import position.PositionFactoryRole;
import position.PositionRole;
import position.PositionStateFactory;
import position.PositionStateFactoryRole;
import position.PositionStateRole;
import prize.BasketFactory;
import prize.BasketFactoryRole;
import prize.EggFactory;
import prize.EggStateFactory;
import prize.HealthFactory;
import prize.HealthFactoryRole;
import prize.HealthStateFactory;
import prize.LifeFactory;
import prize.LifeFactoryRole;
import prize.PrizeFactoryRole;
import prize.PrizeLessStateFactory;
import prize.PrizeStateFactoryRole;
import prize.PrizeStateRole;
import prize.PrizelessStateFactoryRole;

public class GameFactory implements GameFactoryRole, Serializable {

	private int rows;
	private int columns;
	private PrizeStateRole prizelessState;
	private ParcelRole[][] parcel;
	private List<PlayerRole> playersOnField;
	private int playerNumber = 0;
	private List<EnemyRole> enemiesOnField;

	public GameFactory(int rows, int columns, List<PlayerRole> playersOnField, List<EnemyRole> otherEnemiesOnField) {
		super();
		this.rows = rows;
		this.columns = columns;
		this.playersOnField = playersOnField;
		this.enemiesOnField = otherEnemiesOnField;
	}

	@Override
	public Game build(){

		parcel = new ParcelRole[rows + 2][columns + 2];
		
		addInsideParcel();

		addOutsideParcel();
		
		BasketFactoryRole basketFactory = new BasketFactory(0);
		PrizeFactoryRole eggFactory = new EggFactory(0);
		
		OutputFactoryRole outputFactory = new OutputFactory();
		OutputRole output = outputFactory.build();
		GameFieldFactoryRole gameFieldFactory = new GameFieldFactory();
		GameFieldRole gameField = gameFieldFactory.build(playersOnField, eggFactory, basketFactory, enemiesOnField);
		PlayerFieldRole playerField = (PlayerFieldRole) gameField;
		playerFieldSetter(playerField);
		
		return new Game(gameField, output, playerField);
	}

	public void playerFieldSetter(PlayerFieldRole playerField) {
		
		for (int i = 0; i <= rows + 1; i++) {
			for (int j = 0; j <= columns + 1; j++) {
				parcel[i][j].setField(playerField);
			}
		}
	}
	
	@Override
	public void addPalyers(int x, int y, int numberOfLifes, PlayerFactoryRole playerFactory){
		
		ParcelFieldFactoryRole parcelFieldFactory = new ParcelFieldFactory();
		ParcelFieldRole parcelField = parcelFieldFactory.build(parcel);
		PositionFactoryRole positionFactory = new PositionFactory(parcelField);
		PositionRole position = positionFactory.build(x, y);
		PositionStateFactoryRole positionStateFactory;
		
		if(position.isThePlayerDiagonal()) {
			positionStateFactory = new DiagonallyPositionStateFactory();
		}
		else {
			positionStateFactory = new PositionStateFactory();
		}
		
		PositionStateRole positionState = positionStateFactory.build(position);
		PlayerRole player = playerFactory.build(positionState, playerNumber);
		playersOnField.add(player);
		playerNumber++;
	
	}

	public void addOutsideParcel(){
		
		OutsideParcelFactoryRole outsideParcelFactory = new OutsideParcelFactory();
		
		for (int i = 0; i <= rows + 1; i++) {
			parcel[i][columns + 1] = outsideParcelFactory.build();
			parcel[i][0] = outsideParcelFactory.build();
		}
		
		for(int j = 0; j <= columns + 1; j++)
		{
			parcel[rows + 1][j] = outsideParcelFactory.build();
			parcel[0][j] = outsideParcelFactory.build();
		}

	}

	public void addInsideParcel(){
		
		PrizelessStateFactoryRole prizelessStateFactory = new PrizeLessStateFactory();
		ParcelFactoryRole insideParcelFactory = new InsideParcelFactory();
		prizelessState = prizelessStateFactory.build();
		
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				prizelessState = prizelessStateFactory.build();
				prizelessState.setNextState(prizelessState);
				TrapStateRole traplessState = new TraplessState();
				parcel[i][j] = insideParcelFactory.build(prizelessState, traplessState);
			}
		}
	}

	@Override
	public void addTrap(int x, int y, int damageInflicted) {
		TrapStateRole trapState = new TrapState(damageInflicted);
		parcel[x][y].setTrapState(trapState);
	}
	
	@Override
	public ParcelRole[][] getParcel() {
		return parcel;
	}

	@Override
	public void addPrize(int x, int y, int prizeValue, PrizeStateFactoryRole prizeFactory) {
		PrizeStateRole prizeState = prizeFactory.build(prizeValue);
		prizeState.setNextState(prizelessState);
		parcel[x][y].setPrizeState(prizeState);
	}

	@Override
	public void addEnemyAt(int x, int y, EnemyFactoryRole enemyFactory) {
		ParcelFieldFactoryRole parcelFieldFactory = new ParcelFieldFactory();
		ParcelFieldRole parcelField = parcelFieldFactory.build(parcel);
		PositionFactoryRole positionFactory = new PositionFactory(parcelField);
		PositionRole position = positionFactory.build(x, y);
		PositionStateFactoryRole randomPositionStateFactory = new RandomPositionStateFactory();
		
		PositionStateRole positionState = randomPositionStateFactory.build(position);
		EnemyRole enemy = enemyFactory.build(positionState);
		enemiesOnField.add(enemy);
	}

}
