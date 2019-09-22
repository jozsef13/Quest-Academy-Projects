package prize;

import java.io.Serializable;

public class Egg implements EggRole, Serializable {

	private int numberOfEggs;

	public Egg(int numberOfEggs) {
		super();
		this.numberOfEggs = numberOfEggs;
	}

	@Override
	public int getValue() {
		return numberOfEggs;
	}

	@Override
	public void setValue(int otherNumberOfEggs) {
		numberOfEggs += otherNumberOfEggs;
	}

	@Override
	public void addEggs() {
		numberOfEggs++;
	}

}
