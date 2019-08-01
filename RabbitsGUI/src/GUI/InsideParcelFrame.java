package GUI;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InsideParcelFrame extends JPanel implements ParcelFrameRole, ParcelFieldActionRole {

	private JLabel playerText;
	private JLabel prizeText;
	private JLabel prizeIcon;
	
	public InsideParcelFrame() {
		setBackground(Color.white);
	}

	@Override
	public void addPlayers(String imageFile) {
		setBackground(Color.pink); 
		ImageIcon icon = new ImageIcon(imageFile);
		playerText = new JLabel(icon);
		this.add(playerText);
	}

	@Override
	public void addPrizes(String prizeValue, String imageFile) {	
		setBackground(Color.white);
		ImageIcon icon = new ImageIcon(imageFile);
		prizeIcon = new JLabel(icon);
		prizeText = new JLabel(prizeValue);
		this.add(prizeIcon);
		this.add(prizeText);
	}

	@Override
	public void clearPlayer() {
		setBackground(Color.white);
		playerText.setIcon(null);
		this.add(playerText);
	}
	
	@Override
	public void clearPrize() {
		setBackground(Color.white);
		prizeText.setText("X");
		prizeIcon.setIcon(null);
		this.add(prizeText);
		this.add(prizeIcon);
	}
	
}
