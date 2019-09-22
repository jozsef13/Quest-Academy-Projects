package GUI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import main.Game;
import main.GameFactory;
import main.GameFactoryRole;
import parcel.ParcelRole;
import player.EnemyFactoryRole;
import player.EnemyRole;
import player.PlayerFactoryRole;
import player.PlayerRole;
import prize.PrizeStateFactoryRole;

public class GUIController implements Serializable {

	private GameFactoryRole gameFactory;
	private Game game;
	private GameViewFileHandler gameViewFileHandler;
	private GameView gameView;
	private ParcelRole parcel[][];
	private List<PlayerRole> playersOnField;
	private List<PlayerRole> allPlayersOnField;
	private String[] infoData;
	private List<EnemyRole> enemiesOnField;

	public GUIController(GameViewFileHandler gameViewFileHandler) {
		super();
		this.gameViewFileHandler = gameViewFileHandler;
		allPlayersOnField = new ArrayList<PlayerRole>();
		infoData = new String[6]; 
	}
	
	public void setParcel(ParcelRole[][] parcel) {
		this.parcel = parcel;
	}
	
	public GameView createGameView(int rows, int columns){
		gameView = new GameView(columns, rows, gameViewFileHandler);
		playersOnField = new ArrayList<PlayerRole>();
		enemiesOnField = new ArrayList<EnemyRole>();
		gameFactory = new GameFactory(rows, columns, playersOnField, enemiesOnField);
		game = gameFactory.build();
		gameView.setGame(game);
		parcel = gameFactory.getParcel();
		
		return gameView;
	}


	public void addPlayersOnGame(int x, int y, int numberOfLifes, String playerIcon, PlayerFactoryRole playerFactory) {
		gameFactory.addPalyers(x, y, numberOfLifes, playerFactory);
		PlayerRole player = playersOnField.get(playersOnField.size() - 1);
		gameView.addPlayerAt(x, y, player.getRandomColor(), playerIcon,player.getPlayerNumber());
		allPlayersOnField.add(player);
		infoData = player.setInfoData();
		addRowsToTable();	
	}

	public void addTrapsAt(int x, int y, int damageInflicted) {
		gameFactory.addTrap(x, y, damageInflicted);
		gameView.addTrapAt(x, y, Integer.toString(damageInflicted));
	}

	public void addRowsToTable() {
		gameView.addRowsToTable(infoData);
	}

	public void updateInfo() {
		gameView.updateInfo(infoData);
	}

	public void play() {
		game.play();
	}

	public boolean theGameIsNotPlayable() {
		return !game.isPlayable();
	}

	public void updateTrapOnGameView(int x, int y, String damage) {
		gameView.addTrapAt(x, y, damage);
	}

	public void updateGameView() {
		
		for(int x = 0; x < parcel.length - 2; x++)
		{
			for(int y = 0; y < parcel[0].length - 2; y++)
			{
				if(parcel[x][y].hasTrap())
				{
					updateTrapOnGameView(x, y, parcel[x][y].trapDamage());
				}
				else if(parcel[x][y].hasPrize())
				{
					updatePrizeOnGameView(x, y, parcel[x][y].prizeValue(), parcel[x][y].prizeType());
				}
			}
		}
		
		updateEnemiesOnGameView();
		updatePlayersOnGameView();
		
	}

	private void updateEnemiesOnGameView() {
		List<EnemyRole> cloneEnemiesOnField = new ArrayList<>(enemiesOnField);
		
		for (EnemyRole enemy : cloneEnemiesOnField) {
			gameView.addEnemyAt(enemy.getX(), enemy.getY(), enemy.getIcon());
		}
	}

	private void updatePlayersOnGameView() {
		List<PlayerRole> clonePlayersOnField = new ArrayList<>(playersOnField);
		
		for(PlayerRole player : clonePlayersOnField) {
			gameView.addPlayerAt(player.getX(), player.getY(), player.getRandomColor(), player.getIcon(), player.getPlayerNumber());
		}
	}

	private void updatePrizeOnGameView(int x, int y, int prizeValue, String prizeType) {
		gameView.addPrizeAt(x, y, prizeValue, prizeType);
	}

	public void clearPlayers() {
		List<PlayerRole> clonePlayersOnField = new ArrayList<>(playersOnField);
		
		for (PlayerRole player : clonePlayersOnField) {
			gameView.clearPlayerAt(player.getX(), player.getY());
		}
	}

	public void updateInfoTable() {
		List<PlayerRole> clonePlayersOnField = new ArrayList<>(allPlayersOnField);

		for (PlayerRole player : clonePlayersOnField) {
			infoData = player.setInfoData();
			updateInfo();
		}
	}

	public void addPrizeAt(int x, int y, int prizeValue, String prizeIcon, PrizeStateFactoryRole prizeFactory) {
		gameView.addPrizeAt(x, y, prizeValue, prizeIcon);
		gameFactory.addPrize(x, y, prizeValue, prizeFactory);
	}

	public void addEnemyAt(int x, int y, String enemyIcon, EnemyFactoryRole enemyFactory) {
		gameView.addEnemyAt(x, y, enemyIcon);
		gameFactory.addEnemyAt(x, y, enemyFactory);
	}

	public void clearEnemies() {
		List<EnemyRole> cloneEnemiesOnField = new ArrayList<>(enemiesOnField);
		
		for (EnemyRole enemy : cloneEnemiesOnField) {
			gameView.clearEnemyAt(enemy.getX(), enemy.getY());
		}
	}
	
}
