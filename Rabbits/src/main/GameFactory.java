package main;

import java.io.FileNotFoundException;

import field.GameFieldRole;
import inout.OutputFactoryRole;
import inout.OutputRole;

public class GameFactory implements GameFactoryRole {

	private GameFieldRole gameField;
	private OutputFactoryRole outputFactory;

	public GameFactory(GameFieldRole gameField, OutputFactoryRole outputFactory) {
		super();
		this.gameField = gameField;
		this.outputFactory = outputFactory;
	}

	@Override
	public Game build() throws FileNotFoundException {
		OutputRole output = outputFactory.build();
		return new Game(0, gameField, output  );
	}

}
