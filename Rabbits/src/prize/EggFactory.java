package prize;

public class EggFactory implements PrizeFactoryRole {

	@Override
	public PrizeRole build() {
		return new Egg(0);
	}


}
