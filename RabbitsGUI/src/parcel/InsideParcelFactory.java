package parcel;

import java.io.FileNotFoundException;
import java.io.Serializable;

import prize.PrizeStateRole;

public class InsideParcelFactory implements ParcelFactoryRole, Serializable {

	@Override
	public ParcelRole build(PrizeStateRole currentState){
		return new InsideParcel(currentState);
	}

}
