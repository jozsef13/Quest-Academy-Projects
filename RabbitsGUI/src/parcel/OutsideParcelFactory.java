package parcel;

import java.io.FileNotFoundException;

public class OutsideParcelFactory implements OutsideParcelFactoryRole {

	@Override
	public ParcelRole build() throws FileNotFoundException {
		return new OutsideParcel();
	}

}
