package field;

import java.io.FileNotFoundException;

import parcel.ParcelRole;

public class ParcelFieldFactory implements ParcelFieldFactoryRole {

	@Override
	public ParcelFieldRole build(ParcelRole[][] parcel) throws FileNotFoundException {
		return new ParcelField(parcel);
	}

}
