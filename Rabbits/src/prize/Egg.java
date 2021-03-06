package prize;

public class Egg implements PrizeRole {

	private int numberOfEggs;

	public Egg(int numberOfEggs) {
		super();
		this.numberOfEggs = numberOfEggs;
	}

	@Override
	public int getEggsValue() {
		return numberOfEggs;
	}

	@Override
	public void setEggsValue(int otherNumberOfEggs) {
		numberOfEggs += otherNumberOfEggs;
	}

	@Override
	public void addEggs() {
		numberOfEggs++;
	}

}
