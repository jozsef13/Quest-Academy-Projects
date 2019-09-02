package main;

import GUI.GUIController;
import prize.HealthState;
import prize.PrizeStateFactoryRole;
import prize.PrizeStateRole;

public class HealthStateFactory implements PrizeStateFactoryRole {

	private GUIController controller;

	public HealthStateFactory(GUIController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public PrizeStateRole build(int value) {
		return new HealthState(controller, value);
	}

}
