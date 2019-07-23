package field;

import java.io.FileNotFoundException;
import java.util.List;

import main.Game;
import player.PlayerRole;
import prize.BasketFactoryRole;
import prize.PrizeFactoryRole;
import prize.PrizeRole;

public class GameFieldFactory implements GameFieldFactoryRole{

	private List<PlayerRole> playersOnField;
	private BasketFactoryRole basketFactory;
	private PrizeFactoryRole eggFactory;

	public GameFieldFactory(List<PlayerRole> playersOnField, BasketFactoryRole basketFactory,
			PrizeFactoryRole eggFactory) {
		super();
		this.playersOnField = playersOnField;
		this.basketFactory = basketFactory;
		this.eggFactory = eggFactory;
	}

	@Override
	public GameField build() throws FileNotFoundException {
		
		PrizeRole eggs = eggFactory.build();
		BasketRole basket = basketFactory.build();
		return new GameField(playersOnField, eggs, basket );
	}

}
