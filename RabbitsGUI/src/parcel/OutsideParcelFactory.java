package parcel;

import java.io.FileNotFoundException;
import java.io.Serializable;

public class OutsideParcelFactory implements OutsideParcelFactoryRole, Serializable {

	@Override
	public ParcelRole build(){
		return new OutsideParcel();
	}

}
