package prize;

import java.io.Serializable;

public class Life implements LifeRole,Serializable {

	private int numberOfLives;

	public Life(int numberOfLifes) {
		super();
		this.numberOfLives = numberOfLifes;
	}

	@Override
	public void add(int value) {
		numberOfLives += value;
	}

	@Override
	public int getNumberOfLifes() {
		return numberOfLives;
	}

	@Override
	public boolean noLifes() {
		return numberOfLives <= 0;
	}

	@Override
	public void decreaseNumberOfLifes() {
		numberOfLives--;
	}

}
