package GUI;

import java.io.Serializable;

import prize.CarrotStateFactory;
import prize.PrizeStateFactoryRole;

public class CarrotItem implements ItemTypeRole, Serializable {

	@Override
	public void set(int x, int y, GUIController controller) {
		PrizeStateFactoryRole carrotFactory = new CarrotStateFactory();
		controller.addPrizeAt(x, y, 0, "src/carrot.gif", carrotFactory);
	}

}
