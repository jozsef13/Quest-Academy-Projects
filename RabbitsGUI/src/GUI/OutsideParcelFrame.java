package GUI;

import java.awt.Color;
import java.io.Serializable;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class OutsideParcelFrame extends JButton implements ParcelFrameRole, Serializable {

	
	public OutsideParcelFrame()
	{
		setBackground(Color.red);
	}

	@Override
	public void clearPlayer() {
		setBackground(Color.red);
		setIcon(null);
		setVisible(true);
	}

	@Override
	public boolean isInsideParcel() {
		return false;
	}

	@Override
	public void addPlayers(String imageFile, Color randomColor, int playerNumber) {
		//nothing
	}

	@Override
	public void addEnemy(String enemyIcon) {
		setBackground(Color.white);
		Icon enemyIconImage = new ImageIcon(enemyIcon);
		setIcon(enemyIconImage);
		setDisabledIcon(enemyIconImage);
		setVisible(true);
	}
}
