package prize;

import java.io.Serializable;

public class Basket implements BasketRole, Serializable {

	private int basketValue;

	public Basket(int basketValue) {
		super();
		this.basketValue = basketValue;
	}

	@Override
	public boolean isHighestValue(int otherBasket) {
		return basketValue < otherBasket;
	}

	@Override
	public void setBasketValue(int otherBasket) {
		basketValue = otherBasket;
	}

	@Override
	public int getBasketValue() {
		return basketValue;
	}

	@Override
	public void addToBasket(int value) {
		basketValue += value;
	}

}
