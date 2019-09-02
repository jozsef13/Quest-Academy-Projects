package GUI;

import java.io.FileNotFoundException;
import java.io.Serializable;

public class RabbitItem implements ItemTypeRole, Serializable{
	
	@Override
	public void set(int x, int y, GUIController controller){
		controller.addPlayersOnGame(x, y);	
	}

}
