package parcel;

import java.io.FileNotFoundException;

public interface OutsideParcelFactoryRole {
	
	ParcelRole build() throws FileNotFoundException;
}
