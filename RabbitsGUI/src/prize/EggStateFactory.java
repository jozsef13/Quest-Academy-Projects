package prize;

import java.io.Serializable;

import GUI.GUIController;
import GUI.GameViewRole;

public class EggStateFactory implements PrizeStateFactoryRole, Serializable {

	private GUIController controller;

	public EggStateFactory(GUIController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public PrizeStateRole build(int value){
		return new EggState(value, controller);
	}

}
