package main;

import java.io.FileNotFoundException;
import java.util.List;

import GUI.GameViewRole;
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
import player.PlayerFactoryRole;
import player.PlayerRole;
import player.RabbitFactory;
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
import prize.PrizeFactoryRole;
import prize.PrizeLessStateFactory;
import prize.PrizeStateFactoryRole;
import prize.PrizeStateRole;
import prize.PrizelessStateFactoryRole;

public class GameFactory implements GameFactoryRole {

	private int rows;
	private int columns;
	private GameViewRole gameView;
	private PrizeStateRole prizelessState;
	private ParcelRole[][] parcel;
	private List<PlayerRole> playersOnField;
	private BasketFactoryRole basketFactory;
	private PrizeFactoryRole eggFactory;

	public GameFactory(int rows, int columns, GameViewRole gameView, List<PlayerRole> playersOnField) {
		super();
		this.rows = rows;
		this.columns = columns;
		this.gameView = gameView;
		this.playersOnField = playersOnField;
	}

	@Override
	public Game build() throws FileNotFoundException {

		parcel = new ParcelRole[rows + 2][columns + 2];

		addInsideParcel();

		addOutsideParcel();

		basketFactory = new BasketFactory(0);
		eggFactory = new EggFactory(0);
		OutputFactoryRole outputFactory = new OutputFactory();
		OutputRole output = outputFactory.build();
		GameFieldFactoryRole gameFieldFactory = new GameFieldFactory();
		GameFieldRole gameField = gameFieldFactory.build(playersOnField, eggFactory, basketFactory);
		PlayerFieldRole playerField = (PlayerFieldRole) gameField;
		playerFieldSetter(playerField);

		return new Game(gameField, output, playerField);
	}

	public void playerFieldSetter(PlayerFieldRole playerField) {
		
		for (int i = 0; i <= rows + 1; i++) {
			parcel[i][columns + 1].setField(playerField);
			parcel[i][0].setField(playerField);
		}

		for (int j = 0; j <= columns + 1; j++)
		{
			parcel[rows + 1][j].setField(playerField);
			parcel[0][j].setField(playerField);
		}
	}
	
	@Override
	public void addPalyers(int x, int y) throws FileNotFoundException {
		
		ParcelFieldFactoryRole parcelFieldFactory = new ParcelFieldFactory();
		ParcelFieldRole parcelField = parcelFieldFactory.build(parcel);
		PositionFactoryRole positionFactory = new PositionFactory(parcelField, gameView);
		PositionStateFactoryRole positionStateFactory = new PositionStateFactory();
		PlayerFactoryRole rabbitFactory = new RabbitFactory(basketFactory, eggFactory);
		
		gameView.addPlayerAt(x, y);
		PositionRole position = positionFactory.build(x, y);
		PositionStateRole positionState = positionStateFactory.build(position);
		playersOnField.add(rabbitFactory.build(positionState));
	}
	
	@Override
	public void addEggs(int prizeX, int prizeY, int prizeValue) throws FileNotFoundException {
		
		PrizeStateFactoryRole eggStateFactory = new EggStateFactory(gameView);
		
		gameView.addPrizesAt(prizeX, prizeY, prizeValue);
		PrizeStateRole eggState = eggStateFactory.build(prizeValue);
		eggState.setNextState(prizelessState);
		parcel[prizeX][prizeY].setPrizeState(eggState);

	}

	public void addOutsideParcel() throws FileNotFoundException {
		
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

	public void addInsideParcel() throws FileNotFoundException {
		
		PrizelessStateFactoryRole prizelessStateFactory = new PrizeLessStateFactory();
		ParcelFactoryRole insideParcelFactory = new InsideParcelFactory();
		prizelessState = prizelessStateFactory.build();
		
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				prizelessState = prizelessStateFactory.build();
				prizelessState.setNextState(prizelessState);
				parcel[i][j] = insideParcelFactory.build(prizelessState);
			}
		}
	}

}
