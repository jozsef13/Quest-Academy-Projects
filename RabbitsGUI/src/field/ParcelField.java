package field;

import java.io.Serializable;

import parcel.ParcelRole;
import player.PlayerRole;

public class ParcelField implements ParcelFieldRole, Serializable {

	private ParcelRole parcel[][];

	public ParcelField(ParcelRole[][] parcel) {
		super();
		this.parcel = parcel;
	}

	@Override
	public void searchForPrizeBy(PlayerRole player, int x, int y) {
		parcel[x][y].searchForPrizeBy(player);	
	}
	
	@Override
	public int getMaxY() {
		
		return parcel[0].length - 2;
	}
	
	@Override
	public int getMaxX() {
		
		return parcel.length - 2;
	}

}
