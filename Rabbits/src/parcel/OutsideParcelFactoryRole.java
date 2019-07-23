package parcel;

import java.io.FileNotFoundException;

import field.PlayerFieldRole;

public interface OutsideParcelFactoryRole {
	
	ParcelRole build() throws FileNotFoundException;
}
