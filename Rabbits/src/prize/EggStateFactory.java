package prize;

import java.io.FileNotFoundException;

public class EggStateFactory implements PrizeStateFactoryRole {

	private PrizeStateRole nextState;
	
	@Override
	public void setNextState(PrizeStateRole nextState) {
		this.nextState = nextState;
	}

	@Override
	public PrizeStateRole build(int value) throws FileNotFoundException {
		return new EggState(nextState , value);
	}

}
