package GUI;

import java.awt.Color;

import javax.swing.JRadioButton;
import javax.swing.border.Border;

public interface ParcelFrameRole {

	void setBorder(Border border);

	void addPlayers(String imageFile, Color randomColor);

	void clearPlayer();

}
