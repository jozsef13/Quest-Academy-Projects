package GUI;

import java.awt.Color;
import java.io.Serializable;
import java.util.Random;

import player.PlayerFactoryRole;
import player.RabbitFactory;
import prize.BasketFactory;
import prize.BasketFactoryRole;
import prize.EggFactory;
import prize.HealthFactory;
import prize.HealthFactoryRole;
import prize.LifeFactory;
import prize.LifeFactoryRole;
import prize.PrizeFactoryRole;

public class RabbitItem implements ItemTypeRole, Serializable{

	@Override
	public void set(int x, int y, GUIController controller){
		BasketFactoryRole basketFactory = new BasketFactory(0);
		PrizeFactoryRole eggFactory = new EggFactory(0);
		LifeFactoryRole lifeFactory = new LifeFactory(1);
		HealthFactoryRole healthFactory = new HealthFactory(100, lifeFactory );
		PlayerFactoryRole rabbitFactory = new RabbitFactory(basketFactory, eggFactory, healthFactory);
		controller.addPlayersOnGame(x, y, 1, "src/rabbit.gif", rabbitFactory);
	}

}
