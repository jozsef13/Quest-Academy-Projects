package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import field.GameFieldFactoryRole;
import field.GameFieldRole;
import field.ParcelFieldFactory;
import field.ParcelFieldFactoryRole;
import field.ParcelFieldRole;
import field.PlayerFieldRole;
import inout.InputFactory;
import inout.InputFactoryRole;
import inout.InputRole;
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

	private OutputFactoryRole outputFactory;
	private GameFieldFactoryRole gameFieldFactory;
	private PrizeStateRole prizelessState;
	private ParcelRole[][] parcel;
	private InputRole input;
	private int numberOfParcels;
	private int numberOfPrizes;
	private BasketFactoryRole basketFactory;
	private PrizeFactoryRole prizeFactory;
	

	public GameFactory(OutputFactoryRole outputFactory, GameFieldFactoryRole gameFieldFactory) {
		super();
		this.outputFactory = outputFactory;
		this.gameFieldFactory = gameFieldFactory;
	}


	@Override
	public Game build() throws FileNotFoundException {
		
		InputFactoryRole inputFactory = new InputFactory();
		input = inputFactory.build();
		numberOfParcels = input.getValue();
		numberOfPrizes = input.getValue();		

		parcel = new ParcelRole[numberOfParcels+2][numberOfParcels+2];
		
		addInsideParcel();
		
		addOutsideParcel();

		addEggs();
		
		basketFactory = new BasketFactory(0);
		prizeFactory = new EggFactory(0);
		List<PlayerRole> playersOnField = addPalyers();
		OutputRole output = outputFactory.build();
		GameFieldRole gameField = gameFieldFactory.build(playersOnField, prizeFactory, basketFactory);
		PlayerFieldRole playerField = (PlayerFieldRole) gameField;
		
		playerFieldSetter(playerField);
		
		return new Game(gameField , output, playerField  );
	}


	private void playerFieldSetter(PlayerFieldRole playerField) {
		
		for(int i = 0; i <= numberOfParcels+1; i++)
		{
			parcel[i][numberOfParcels+1].setField(playerField);
			parcel[numberOfParcels+1][i].setField(playerField);
			parcel[0][i].setField(playerField);
			parcel[i][0].setField(playerField);
		}
	
	}
	
	private List<PlayerRole> addPalyers() throws FileNotFoundException {
		
		ParcelFieldFactoryRole parcelFieldFactory = new ParcelFieldFactory();
		ParcelFieldRole parcelField = parcelFieldFactory.build(parcel);
		PositionFactoryRole positionFactory = new PositionFactory(parcelField);
		PositionStateFactoryRole positionStateFactory = new PositionStateFactory();
		PlayerFactoryRole rabbitFactory = new RabbitFactory(basketFactory , prizeFactory );
		
		int numberOfPlayers = input.getValue();
		List<PlayerRole> playersOnField = new ArrayList<PlayerRole>();

		for (int i = 1; i <= numberOfPlayers; i++) {
			int x = input.getValue();
			int y = input.getValue();
			PositionRole position = positionFactory.build(x, y);
			PositionStateRole positionState = positionStateFactory.build(position);
			playersOnField.add(rabbitFactory.build(positionState));

		}
		
		return playersOnField;
	}

	private void addEggs() throws FileNotFoundException {
		
		PrizeStateFactoryRole eggStateFactory = new EggStateFactory();
		
		for (int k = 0; k < numberOfPrizes; k++) {
			int prizeX = input.getValue();
			int prizeY = input.getValue();
			int prizeValue = input.getValue();
			PrizeStateRole eggState = eggStateFactory.build(prizeValue);
			eggState.setNextState(prizelessState);
			parcel[prizeX][prizeY].setPrizeState(eggState);
		}
		
	}

	private void addOutsideParcel() throws FileNotFoundException {
		
		OutsideParcelFactoryRole outsideParcelFactory = new OutsideParcelFactory();
		
		for (int i = 0; i <= numberOfParcels + 1; i++) {
			parcel[i][numberOfParcels + 1] = outsideParcelFactory.build();
			parcel[numberOfParcels + 1][i] = outsideParcelFactory.build();
			parcel[0][i] = outsideParcelFactory.build();
			parcel[i][0] = outsideParcelFactory.build();
		}
		
	}
	
	private void addInsideParcel() throws FileNotFoundException {
		
		PrizelessStateFactoryRole prizelessStateFactory = new PrizeLessStateFactory();
		ParcelFactoryRole insideParcelFactory = new InsideParcelFactory();
		
		prizelessState = prizelessStateFactory.build();
		for (int i = 1; i <= numberOfParcels; i++) {
			for (int j = 1; j <= numberOfParcels; j++) {
				prizelessState = prizelessStateFactory.build();
				prizelessState.setNextState(prizelessState);
				parcel[i][j] = insideParcelFactory.build(prizelessState);
			}
		}
	}

	
}
