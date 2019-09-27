package player;

import position.PositionStateRole;
import prize.BasketFactoryRole;
import prize.BasketRole;
import prize.PrizeFactoryRole;
import prize.EggRole;
import prize.HealthFactoryRole;
import prize.HealthRole;

public class RabbitFactory implements PlayerFactoryRole {

	private BasketFactoryRole basketFactory;
	private PrizeFactoryRole prizeFactory;
	private HealthFactoryRole healthPrizeFactory;
	private InvincibilityFactoryRole invincibilityFactory;

	public RabbitFactory(BasketFactoryRole basketFactory, PrizeFactoryRole prizeFactory,
			HealthFactoryRole healthPrizeFactory, InvincibilityFactoryRole otherInvincibilityFactory) {
		super();
		this.basketFactory = basketFactory;
		this.prizeFactory = prizeFactory;
		this.healthPrizeFactory = healthPrizeFactory;
		this.invincibilityFactory = otherInvincibilityFactory;
	}

	@Override
	public PlayerRole build(PositionStateRole positionState, int playerNumber){
		
		BasketRole basket = basketFactory.build();
		EggRole eggs = prizeFactory.build();
		HealthRole health = healthPrizeFactory.build();
		InvincibilityRole invincibility = invincibilityFactory.build();
		return new Rabbit(positionState, basket , eggs , playerNumber, health, invincibility);
	}

}
