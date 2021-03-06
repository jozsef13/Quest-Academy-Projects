package prize;

import java.io.Serializable;

public class EggFactory implements PrizeFactoryRole, Serializable {

	private int numberOfEggs;

	public EggFactory(int numberOfEggs) {
		super();
		this.numberOfEggs = numberOfEggs;
	}

	@Override
	public EggRole build() {
		return new Egg(numberOfEggs);
	}


}
