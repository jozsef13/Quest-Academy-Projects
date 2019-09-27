package GUI;

public interface ParcelFrameActionRole {

	void addPrizes(String prizeValue, String imageFile);
	
	void clearPlayer();
	
	void setController(GUIController otherController);

	void setXAndY(int otherX, int otherY);
	
	void setItemType(ItemTypeRole itemType);

	void addActionListener();

	void removeActionListener();

	void setEnabledTrue();
	
	boolean isEmpty();

	void addTrap(String damage, String imageIcon);
}
