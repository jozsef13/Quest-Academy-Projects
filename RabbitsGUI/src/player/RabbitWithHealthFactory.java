package player;

import position.PositionStateRole;
import prize.BasketFactoryRole;
import prize.BasketRole;
import prize.HealthFactoryRole;
import prize.HealthRole;
import prize.PrizeFactoryRole;
import prize.EggRole;

public class RabbitWithHealthFactory implements PlayerFactoryRole {

	private BasketFactoryRole basketFactory;
	private PrizeFactoryRole eggPrizeFactory;
	private HealthFactoryRole healthPrizeFactory;

	public RabbitWithHealthFactory(BasketFactoryRole basketFactory, PrizeFactoryRole eggPrizeFactory,
			HealthFactoryRole healthPrizeFactory) {
		super();
		this.basketFactory = basketFactory;
		this.eggPrizeFactory = eggPrizeFactory;
		this.healthPrizeFactory = healthPrizeFactory;
	}

	@Override
	public PlayerRole build(PositionStateRole positionState, int playerNumber) {
		BasketRole basket = basketFactory.build();
		EggRole eggs = eggPrizeFactory.build();
		HealthRole health = healthPrizeFactory.build();
		return new RabbitWithHealth(positionState, basket , eggs, health, playerNumber);
	}

}
