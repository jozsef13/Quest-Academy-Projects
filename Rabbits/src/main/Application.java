package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import field.GameFieldFactory;
import field.GameFieldFactoryRole;
import field.GameFieldRole;
import field.ParcelFieldFactory;
import field.ParcelFieldFactoryRole;
import field.ParcelFieldRole;
import field.PlayerFieldRole;
import inout.InputFactory;
import inout.InputFactoryRole;
import inout.InputRole;
import inout.OutputFactory;
import inout.OutputFactoryRole;
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

public class Application {

	private void run() throws FileNotFoundException {
		
		InputFactoryRole inputFactory = new InputFactory();
		InputRole input = inputFactory.build();
		
		PrizeStateFactoryRole eggStateFactory = new EggStateFactory();
		PrizelessStateFactoryRole prizelessStateFactory = new PrizeLessStateFactory();
		ParcelFactoryRole insideParcelFactory = new InsideParcelFactory();		
		OutsideParcelFactoryRole outsideParcelFactory = new OutsideParcelFactory();
		
		int numberOfParcels = input.getValue();
		int numberOfPrizes = input.getValue();

		ParcelRole[][] parcel = new ParcelRole[numberOfParcels+2][numberOfParcels+2];
		
		for (int i = 1; i <= numberOfParcels; i++) {
			for (int j = 1; j <= numberOfParcels; j++) {
				PrizeStateRole prizelessState = prizelessStateFactory.build();
				parcel[i][j] = insideParcelFactory.build(prizelessState);
			}
		}
		
		for(int i = 0; i <= numberOfParcels+1; i++)
		{
			parcel[i][numberOfParcels+1] = outsideParcelFactory.build();
			parcel[numberOfParcels+1][i] = outsideParcelFactory.build();
			parcel[0][i] = outsideParcelFactory.build();
			parcel[i][0] = outsideParcelFactory.build();
		}
		
		for(int k = 0; k < numberOfPrizes; k++)
		{
			int prizeX = input.getValue();
			int prizeY = input.getValue();
			int prizeValue = input.getValue();
			PrizeStateRole eggState = eggStateFactory.build(prizeValue);
			parcel[prizeX][prizeY].setPrizeState(eggState);
		}
		
		ParcelFieldFactoryRole parcelFieldFactory = new ParcelFieldFactory();
		ParcelFieldRole parcelField = parcelFieldFactory.build(parcel);
		PositionFactoryRole positionFactory = new PositionFactory(parcelField);
		PositionStateFactoryRole positionStateFactory = new PositionStateFactory();
		BasketFactoryRole basketFactory = new BasketFactory();
		PrizeFactoryRole prizeFactory = new EggFactory();
		PlayerFactoryRole rabbitFactory = new RabbitFactory(basketFactory , prizeFactory );
		
		int numberOfPlayers = input.getValue();
		List<PlayerRole> playersOnField = new ArrayList<PlayerRole>();
		
		for(int i = 1; i <= numberOfPlayers; i++)
		{
			int x = input.getValue();
			int y = input.getValue();
			PositionRole position = positionFactory.build(x, y);
			PositionStateRole positionState = positionStateFactory.build(position);
			playersOnField.add(rabbitFactory.build(positionState));
			
		}
		
		GameFieldFactoryRole gameFieldFactory = new GameFieldFactory(playersOnField, basketFactory, prizeFactory);
		GameFieldRole gameField = gameFieldFactory.build();
		
		PlayerFieldRole playerField = (PlayerFieldRole) gameField;
		
		for(int i = 0; i <= numberOfParcels+1; i++)
		{
			parcel[i][numberOfParcels+1].setField(playerField);
			parcel[numberOfParcels+1][i].setField(playerField);
			parcel[0][i].setField(playerField);
			parcel[i][0].setField(playerField);
		}
		
		OutputFactoryRole outputFactory = new OutputFactory();
		GameFactoryRole gameFactory = new GameFactory(gameField, outputFactory );
		Game game = gameFactory.build();
		game.play();
		
	}

	
	public static void main(String[] args) throws FileNotFoundException {
		Application application = new Application();
		
		application.run();
	}
}
