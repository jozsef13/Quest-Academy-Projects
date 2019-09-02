package player;

import java.io.FileNotFoundException;
import java.io.Serializable;

import position.PositionStateRole;
import prize.BasketFactoryRole;
import prize.BasketRole;
import prize.PrizeFactoryRole;
import prize.PrizeRole;

public class RabbitFactory implements PlayerFactoryRole, Serializable {

	private BasketFactoryRole basketFactory;
	private PrizeFactoryRole prizeFactory;

	public RabbitFactory(BasketFactoryRole basketFactory, PrizeFactoryRole prizeFactory) {
		super();
		this.basketFactory = basketFactory;
		this.prizeFactory = prizeFactory;
	}

	@Override
	public PlayerRole build(PositionStateRole positionState){
		
		BasketRole basket = basketFactory.build();
		PrizeRole eggs = prizeFactory.build();
		return new Rabbit(positionState, basket , eggs );
	}

}
