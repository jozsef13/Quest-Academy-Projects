package prize;

public class CarrotStateFactory implements PrizeStateFactoryRole {

	@Override
	public PrizeStateRole build(int value) {
		return new CarrotState(value);
	}

}
