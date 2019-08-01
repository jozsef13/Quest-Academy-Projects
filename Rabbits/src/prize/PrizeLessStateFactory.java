package prize;

public class PrizeLessStateFactory implements PrizelessStateFactoryRole {


	private PrizeStateRole nextState;

	public void setNextState(PrizeStateRole nextState) {
		this.nextState = nextState;
	}

	@Override
	public PrizeStateRole build() {
		return new PirzeLessState(nextState);
	}

}
