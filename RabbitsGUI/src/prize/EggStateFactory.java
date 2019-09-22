package prize;

import GUI.GUIController;

public class EggStateFactory implements PrizeStateFactoryRole {

	@Override
	public PrizeStateRole build(int value){
		return new EggState(value);
	}

}
