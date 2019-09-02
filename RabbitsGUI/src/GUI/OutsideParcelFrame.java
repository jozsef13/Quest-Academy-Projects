package GUI;

import java.awt.Color;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class OutsideParcelFrame extends JButton implements ParcelFrameRole, Serializable {

	
	public OutsideParcelFrame()
	{
		setBackground(Color.red);
	}
	
	@Override
	public void addPlayers(String imageFile, Color randomColor) {
		// does nothing
	}

	@Override
	public void clearPlayer() {
		setBackground(Color.red);
		setIcon(null);
		setVisible(true);
	}

}
