package player;

import java.io.FileNotFoundException;

import field.BasketRole;
import position.PositionStateRole;
import prize.BasketFactoryRole;
import prize.PrizeFactoryRole;
import prize.PrizeRole;

public class RabbitFactory implements PlayerFactoryRole {

	private BasketFactoryRole basketFactory;
	private PrizeFactoryRole prizeFactory;

	public RabbitFactory(BasketFactoryRole basketFactory, PrizeFactoryRole prizeFactory) {
		super();
		this.basketFactory = basketFactory;
		this.prizeFactory = prizeFactory;
	}

	@Override
	public PlayerRole build(PositionStateRole positionState) throws FileNotFoundException {
		
		BasketRole basket = basketFactory.build();
		PrizeRole eggs = prizeFactory.build();
		return new Rabbit(positionState, basket , eggs );
	}

}
