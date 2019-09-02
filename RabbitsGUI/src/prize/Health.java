package prize;

import java.io.Serializable;

public class Health implements HealthRole, Serializable {

	private int numberOfLifes;

	public Health(int numberOfLifes) {
		super();
		this.numberOfLifes = numberOfLifes;
	}
	@Override
	public void addLife(int value) {
		numberOfLifes += value;
	}

	@Override
	public int getLifes() {
		return numberOfLifes;
	}
	@Override
	public boolean hasNoLifes() {
		return numberOfLifes <= 0;
	}
	@Override
	public void decreaseLifes() {
		numberOfLifes--;
	}

}
