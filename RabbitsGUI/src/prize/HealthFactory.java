package prize;

import java.io.Serializable;

public class HealthFactory implements HealthFactoryRole, Serializable {

	private int healthLevel;
	private LifeFactoryRole lifeFactory;

	public HealthFactory(int healthLevel, LifeFactoryRole lifeFactory) {
		super();
		this.healthLevel = healthLevel;
		this.lifeFactory = lifeFactory;
	}

	@Override
	public HealthRole build() {
		LifeRole life = lifeFactory.build();
		return new Health(healthLevel , life);
	}

}
