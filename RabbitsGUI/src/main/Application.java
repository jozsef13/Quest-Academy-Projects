package main;

import java.awt.EventQueue;
import java.io.FileNotFoundException;

import GUI.GameViewFileHandler;
import GUI.GUIController;
import GUI.StartGameView;

public class Application {

	private void run() throws FileNotFoundException {
		
		GameViewFileHandler gameViewFileHandler = new GameViewFileHandler();
		GUIController controller = new GUIController(gameViewFileHandler);
		StartGameView startGameView = new StartGameView(controller, gameViewFileHandler);
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				System.out.println("running");
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
