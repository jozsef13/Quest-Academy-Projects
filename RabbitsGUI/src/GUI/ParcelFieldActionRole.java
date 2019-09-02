package GUI;

public interface ParcelFieldActionRole {

	void clearPrize();

	void addPrizes(String prizeValue, String imageFile);
	
	void clearPlayer();
	
	void setController(GUIController otherController);

	void setXAndY(int otherX, int otherY);
	
	void setItemType(ItemTypeRole itemType);

	void addActionListener();

	void removeActionListener();

	void setEnabledTrue();
}
