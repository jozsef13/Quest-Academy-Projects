package GUI;

import java.io.Serializable;

import player.EnemyFactoryRole;
import player.FoxFactory;

public class FoxItem implements ItemTypeRole, Serializable {

	@Override
	public void set(int x, int y, GUIController controller) {
		EnemyFactoryRole foxFactory = new FoxFactory();
		controller.addEnemyAt(x, y, "src/fox.gif", foxFactory );
	}

}
