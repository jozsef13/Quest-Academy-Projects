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
	private InvincibilityFactoryRole invincibilityFactory;

	public RabbitWithHealthFactory(BasketFactoryRole basketFactory, PrizeFactoryRole eggPrizeFactory,
			HealthFactoryRole healthPrizeFactory, InvincibilityFactoryRole otherInvincibilityFactory) {
		super();
		this.basketFactory = basketFactory;
		this.eggPrizeFactory = eggPrizeFactory;
		this.healthPrizeFactory = healthPrizeFactory;
		this.invincibilityFactory = otherInvincibilityFactory;
	}

	@Override
	public PlayerRole build(PositionStateRole positionState, int playerNumber) {
		BasketRole basket = basketFactory.build();
		EggRole eggs = eggPrizeFactory.build();
		HealthRole health = healthPrizeFactory.build();
		InvincibilityRole invincibility = invincibilityFactory.build();
		return new RabbitWithHealth(positionState, basket , eggs, health, playerNumber, invincibility);
	}

}
