package prize;

public class Egg implements PrizeRole {

	private int eggValue;

	public Egg(int eggValue) {
		super();
		this.eggValue = eggValue;
	}

	@Override
	public int getEggsValue() {
		return eggValue;
	}

	@Override
	public void setEggsValue(int otherEggs) {
		eggValue += otherEggs;
	}

	@Override
	public void addEggs() {
		eggValue++;
	}

}
