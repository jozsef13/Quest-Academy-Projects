package field;

import java.io.FileNotFoundException;
import java.util.List;

import player.PlayerRole;
import prize.BasketFactoryRole;
import prize.PrizeFactoryRole;

public interface GameFieldFactoryRole {

	GameField build(List<PlayerRole> playersOnField, PrizeFactoryRole eggFactory, BasketFactoryRole basketFactory);

}
