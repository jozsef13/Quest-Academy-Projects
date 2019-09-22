package prize;

import GUI.GUIController;

public class HealthStateFactory implements PrizeStateFactoryRole {

	@Override
	public PrizeStateRole build(int value) {
		return new HealthState(value);
	}

}
