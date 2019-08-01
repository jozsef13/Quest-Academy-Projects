package main;

import java.awt.EventQueue;
import java.io.FileNotFoundException;

import GUI.GUIController;
import GUI.StartGameView;

public class Application {

	private void run() throws FileNotFoundException {
		
		GUIController controller = new GUIController();
		StartGameView startGameView = new StartGameView(controller);
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				startGameView.createStartGameView();
				startGameView.setVisible(true);
			}
		});
		
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Application application = new Application();
		
		application.run();
	}
}
