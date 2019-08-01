package prize;

public class EggFactory implements PrizeFactoryRole {

	private int numberOfEggs;

	public EggFactory(int numberOfEggs) {
		super();
		this.numberOfEggs = numberOfEggs;
	}

	@Override
	public PrizeRole build() {
		return new Egg(numberOfEggs);
	}


}
