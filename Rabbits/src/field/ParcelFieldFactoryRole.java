package field;

import java.io.FileNotFoundException;

import parcel.ParcelRole;

public interface ParcelFieldFactoryRole {

	ParcelFieldRole build(ParcelRole[][] parcel) throws FileNotFoundException;

}
