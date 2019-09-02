package field;

import java.io.FileNotFoundException;
import java.io.Serializable;

import parcel.ParcelRole;

public class ParcelFieldFactory implements ParcelFieldFactoryRole,Serializable {

	@Override
	public ParcelFieldRole build(ParcelRole[][] parcel){
		return new ParcelField(parcel);
	}

}
