package prize;

public class PrizeLessStateFactory implements PrizelessStateFactoryRole {

	@Override
	public PrizeStateRole build() {
		return new PrizeLessState();
	}

}
