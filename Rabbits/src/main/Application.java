package main;

import java.io.FileNotFoundException;
import field.GameFieldFactory;
import field.GameFieldFactoryRole;
import inout.OutputFactory;
import inout.OutputFactoryRole;

public class Application {

	private void run() throws FileNotFoundException {
		
		GameFieldFactoryRole gameFieldFactory = new GameFieldFactory();
		OutputFactoryRole outputFactory = new OutputFactory();
		GameFactoryRole gameFactory = new GameFactory(outputFactory, gameFieldFactory);
		Game game = gameFactory.build();
		
		game.play();
		
	}

	
	public static void main(String[] args) throws FileNotFoundException {
		Application application = new Application();
		
		application.run();
	}
}
