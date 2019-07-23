package prize;

import field.BasketRole;

public class BasketFactory implements BasketFactoryRole {

	@Override
	public BasketRole build() {
		return new Basket(0);
	}

}
