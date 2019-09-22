package field;

import java.util.List;

import player.EnemyRole;
import player.PlayerRole;
import prize.BasketFactoryRole;
import prize.BasketRole;
import prize.PrizeFactoryRole;
import prize.EggRole;

public class GameFieldFactory implements GameFieldFactoryRole{

	@Override
	public GameField build(List<PlayerRole> playersOnField, PrizeFactoryRole eggFactory, BasketFactoryRole basketFactory, List<EnemyRole> enemiesOnField){
		
		EggRole eggs = eggFactory.build();
		BasketRole basket = basketFactory.build();
		return new GameField(playersOnField, eggs, basket, enemiesOnField);
	}

}
