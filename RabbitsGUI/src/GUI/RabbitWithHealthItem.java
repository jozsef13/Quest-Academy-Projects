package GUI;

public class RabbitWithHealthItem implements ItemTypeRole {

	@Override
	public void set(int x, int y, GUIController controller) {
		controller.addPlayersWithHealthOnGame(x, y);
	}

}
