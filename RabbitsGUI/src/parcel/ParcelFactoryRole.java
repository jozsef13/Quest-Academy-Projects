package parcel;

import GUI.GUIController;
import prize.PrizeStateRole;

public interface ParcelFactoryRole {

	ParcelRole build(PrizeStateRole currentState, TrapStateRole trapState);

}
