package parcel;

import java.io.FileNotFoundException;

import prize.PrizeStateRole;

public class InsideParcelFactory implements ParcelFactoryRole {

	@Override
	public ParcelRole build(PrizeStateRole currentState) throws FileNotFoundException {
		return new InsideParcel(currentState);
	}

}
