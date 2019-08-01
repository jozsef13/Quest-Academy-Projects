package GUI;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import main.Game;
import main.GameFactory;
import main.GameFactoryRole;
import player.PlayerRole;

public class GUIController {

	private GameFactoryRole gameFactory;
	private Game game;

	public GameView createGameView(int rows, int columns) throws FileNotFoundException {
		
		GameView gameView = new GameView(columns, rows);
		List<PlayerRole> playersOnField = new ArrayList<PlayerRole>();
		gameFactory = new GameFactory(rows, columns, gameView, playersOnField);
		game = gameFactory.build();
		gameView.setGame(game);
		
		return gameView;
	}

	public void addPlayersAt(int x, int y) throws FileNotFoundException {
		gameFactory.addPalyers(x, y);
	}

	public void addEggsAt(int prizeX, int prizeY, int prizeValue) throws FileNotFoundException {
		gameFactory.addEggs(prizeX, prizeY, prizeValue);
	}

	public boolean isTheGamePlayable() {
		return game.isPlayable();
	}

	public void startGame() {
		game.play();
	}
	
	
}
