package field;

import java.util.List;

import player.EnemyRole;
import player.PlayerRole;
import prize.BasketFactoryRole;
import prize.PrizeFactoryRole;

public interface GameFieldFactoryRole {

	GameField build(List<PlayerRole> playersOnField, PrizeFactoryRole eggFactory, BasketFactoryRole basketFactory,List<EnemyRole> enemiesOnField);

}
