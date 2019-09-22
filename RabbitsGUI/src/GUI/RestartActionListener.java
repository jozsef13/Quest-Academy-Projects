package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.Serializable;

import main.Application;

public class RestartActionListener implements ActionListener, Serializable {

	private GameView gameView;
	private GUIController controller;

	public RestartActionListener(GameView gameView, GUIController otherController) {
		super();
		this.gameView = gameView;
		this.controller = otherController;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Application app = new Application();
		
		try {
			app.run();
			gameView.setVisible(false);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
