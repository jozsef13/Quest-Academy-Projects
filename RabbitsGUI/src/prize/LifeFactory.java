package prize;

public class LifeFactory implements LifeFactoryRole {

	private int numberOfLives;

	public LifeFactory(int numberOfLifes) {
		super();
		this.numberOfLives = numberOfLifes;
	}

	@Override
	public LifeRole build() {
		return new Life(numberOfLives);
	}

}
