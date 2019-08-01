package prize;

public class BasketFactory implements BasketFactoryRole {

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
