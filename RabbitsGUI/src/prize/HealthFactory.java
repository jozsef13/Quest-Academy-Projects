package prize;

public class HealthFactory implements HealthFactoryRole {

	private int numberOfLifes;

	public HealthFactory(int numberOfLifes) {
		super();
		this.numberOfLifes = numberOfLifes;
	}

	@Override
	public HealthRole build() {
		return new Health(numberOfLifes);
	}

}
