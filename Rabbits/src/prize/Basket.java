package prize;

import field.BasketRole;

public class Basket implements BasketRole {

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
