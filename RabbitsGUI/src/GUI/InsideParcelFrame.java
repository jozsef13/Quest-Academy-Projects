package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InsideParcelFrame extends JButton implements ParcelFrameRole, ParcelFieldActionRole, ActionListener {

	private ItemTypeRole itemType;
	private GUIController controller;
	private int x;
	private int y;
	
	public InsideParcelFrame() {
		setBackground(Color.white);
		addActionListener(this);
	}

	@Override
	public void addPlayers(String imageFile, Color randomColor) {
		setBackground(randomColor);
		Icon playerIcon = new ImageIcon(imageFile);
		setIcon(playerIcon);
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
		setVisible(true);
	}
	
	@Override
	public void clearPrize() {
		setBackground(Color.white);
		setIcon(null);
		setText("X");
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		itemType.set(x, y, controller);
		setEnabled(false);
		setVisible(true);
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

	public void updateHealthIcon(String filename) {
		Icon healthIcon = new ImageIcon(filename);
		setIcon(healthIcon);
		setDisabledIcon(healthIcon);
	}
}
