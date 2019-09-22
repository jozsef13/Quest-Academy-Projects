package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class InsideParcelFrame extends JButton implements ParcelFrameRole, ParcelFrameActionRole, ActionListener {

	private ItemTypeRole itemType;
	private GUIController controller;
	private int x;
	private int y;
	private int state = 0;
	
	public InsideParcelFrame() {
		setBackground(Color.white);
		addActionListener(this);
	}

	@Override
	public void addPlayers(String imageFile, Color randomColor, int playerNumber) {
		setBackground(randomColor);
		Icon playerIcon = new ImageIcon(imageFile);
		setIcon(playerIcon);
		setText(Integer.toString(playerNumber));
		setDisabledIcon(playerIcon);
		setVisible(true);	
	}

	@Override
	public void addPrizes(String prizeValue, String imageFile) {	
		setBackground(Color.white);
		Icon prizeIcon = new ImageIcon(imageFile);
		setIcon(prizeIcon);
		setText(prizeValue);
		setDisabledIcon(prizeIcon);
		setVisible(true);
	}

	@Override
	public void clearPlayer() {
		setBackground(Color.white);
		setIcon(null);
		setText(" ");
		setEmptyState();
		setVisible(true);
		
	}
	
	private void setEmptyState() {
		state = 0;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		itemType.set(x, y, controller);
		removeActionListener();
		setFullState();
		setVisible(true);
	}

	private void setFullState() {
		state = 1;
	}

	@Override
	public void setItemType(ItemTypeRole otherItemType) {
		itemType = otherItemType;
	}

	@Override
	public void setController(GUIController otherController) {
		controller = otherController;
	}
	
	@Override
	public void setXAndY(int otherX, int otherY) {
		x = otherX;
		y = otherY;
	}

	@Override
	public void addActionListener() {
		addActionListener(this);
	}

	@Override
	public void removeActionListener() {
		removeActionListener(this);
	}

	@Override
	public void setEnabledTrue() {
		setEnabled(true);
	}
	
	@Override
	public void addTrap(String damage) {
		setBackground(Color.white);
		setText("T " + damage);
		setVisible(true);
	}

	@Override
	public boolean isInsideParcel() {
		return true;
	}
	
	@Override
	public boolean isEmpty() {
		return state == 0;
	}

	public void addEnemy(String enemyIcon) {
		setBackground(Color.white);
		Icon enemyIconImage = new ImageIcon(enemyIcon);
		setIcon(enemyIconImage);
		setDisabledIcon(enemyIconImage);
		setVisible(true);
	}
}
