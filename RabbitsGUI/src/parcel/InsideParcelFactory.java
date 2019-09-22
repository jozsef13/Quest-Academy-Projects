package parcel;

import GUI.GUIController;
import prize.PrizeStateRole;

public class InsideParcelFactory implements ParcelFactoryRole {

	@Override
	public ParcelRole build(PrizeStateRole currentState, TrapStateRole trapState){
		return new InsideParcel(currentState, trapState);
	}

}
