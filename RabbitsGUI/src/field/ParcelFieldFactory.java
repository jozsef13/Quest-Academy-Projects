package field;

import parcel.ParcelRole;

public class ParcelFieldFactory implements ParcelFieldFactoryRole {

	@Override
	public ParcelFieldRole build(ParcelRole[][] parcel){
		return new ParcelField(parcel);
	}

}
