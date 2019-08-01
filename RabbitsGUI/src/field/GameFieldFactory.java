package field;

import java.io.FileNotFoundException;
import java.util.List;

import player.PlayerRole;
import prize.BasketFactoryRole;
import prize.BasketRole;
import prize.PrizeFactoryRole;
import prize.PrizeRole;

public class GameFieldFactory implements GameFieldFactoryRole{

	@Override
	public GameField build(List<PlayerRole> playersOnField, PrizeFactoryRole eggFactory, BasketFactoryRole basketFactory) throws FileNotFoundException {
		
		PrizeRole eggs = eggFactory.build();
		BasketRole basket = basketFactory.build();
		return new GameField(playersOnField, eggs, basket );
	}

}
