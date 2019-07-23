package field;

public interface BasketRole {

	boolean isHighestValue(int otherBasket);

	void setBasketValue(int otherBasket);

	int getBasketValue();

	void addToBasket(int value);

}
