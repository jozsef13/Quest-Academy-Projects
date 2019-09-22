package GUI;

import java.awt.Color;
import javax.swing.border.Border;

public interface ParcelFrameRole {

	void setBorder(Border border);

	void clearPlayer();

	boolean isInsideParcel();

	void addPlayers(String imageFile, Color randomColor, int playerNumber);

	void addEnemy(String enemyIcon);

}
