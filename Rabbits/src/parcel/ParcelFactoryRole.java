package parcel;

import java.io.FileNotFoundException;

import prize.PrizeStateRole;

public interface ParcelFactoryRole {

	ParcelRole build(PrizeStateRole currentState) throws FileNotFoundException;

}
