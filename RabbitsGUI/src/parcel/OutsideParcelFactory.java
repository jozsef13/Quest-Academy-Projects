package parcel;

import GUI.GUIController;

public class OutsideParcelFactory implements OutsideParcelFactoryRole {

	@Override
	public ParcelRole build(){
		return new OutsideParcel();
	}

}
