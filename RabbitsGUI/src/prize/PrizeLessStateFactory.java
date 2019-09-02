package prize;

import java.io.Serializable;

public class PrizeLessStateFactory implements PrizelessStateFactoryRole,Serializable {

	@Override
	public PrizeStateRole build() {
		return new PrizeLessState();
	}

}
