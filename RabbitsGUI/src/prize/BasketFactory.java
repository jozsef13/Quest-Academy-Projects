package prize;

import java.io.Serializable;

public class BasketFactory implements BasketFactoryRole,Serializable {

	private int basketValue;

	public BasketFactory(int basketValue) {
		super();
		this.basketValue = basketValue;
	}

	@Override
	public BasketRole build() {
		return new Basket(basketValue);
	}

}
