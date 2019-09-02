package GUI;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import main.Game;
import main.GameFactory;
import main.GameFactoryRole;
import player.PlayerRole;

public class GUIController implements Serializable {

	private GameFactoryRole gameFactory;
	private Game game;
	private GameViewFileHandler gameViewFileHandler;
	private Color randomColor;
	private GameView gameView;

	public GUIController(GameViewFileHandler gameViewFileHandler) {
		super();
		this.gameViewFileHandler = gameViewFileHandler;
	}
	
	public void setRandomColor(Color randomColor) {
		this.randomColor = randomColor;
	}
	
	public GameView createGameView(int rows, int columns){
		gameView = new GameView(columns, rows, gameViewFileHandler);
		List<PlayerRole> playersOnField = new ArrayList<PlayerRole>();
		gameFactory = new GameFactory(rows, columns, this, playersOnField);
		game = gameFactory.build();
		gameView.setGame(game);
		
		return gameView;
	}

	public void addPlayersOnGameView(int x, int y, Color otherRandomColor){
		gameView.addPlayerAt(x, y, otherRandomColor);
	}

	public void addEggsAt(int prizeX, int prizeY, int prizeValue){
		gameFactory.addEggs(prizeX, prizeY, prizeValue);
		gameView.addEggsAt(prizeX, prizeY, prizeValue);
	}

	public boolean isTheGamePlayable() {
		return game.isPlayable();
	}

	public void startGame() {
		System.out.println("start");
		game.play();
	}

	public void clearPlayerAt(int x, int y) {
		gameView.clearPlayerAt(x, y);
	}

	public void addPlayersOnGame(int x, int y) {
		gameFactory.addPalyers(x, y);
		gameView.addPlayerAt(x, y, randomColor);
	}

	public void clearPrizeAt(int x, int y) {
		gameView.clearPrizeAt(x, y);
	}

	public void addPlayersWithHealthOnGame(int x, int y) {
		gameFactory.addPalyersWithHealth(x, y);
		gameView.addPlayerAt(x, y, randomColor);
	}

	public void addHealthAt(int x, int y, int prizeValue) {
		gameFactory.addHealth(x, y, prizeValue);
		gameView.addHealthAt(x, y, prizeValue);
	}
	
	
}
