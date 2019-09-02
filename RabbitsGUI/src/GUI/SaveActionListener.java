package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;

public class SaveActionListener implements ActionListener, Serializable {

	private GameViewFileHandler gameViewFileHandler;
	private GameView gameView;

	public SaveActionListener(GameViewFileHandler gameViewFileHandler, GameView gameView) {
		super();
		this.gameViewFileHandler = gameViewFileHandler;
		this.gameView = gameView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			gameViewFileHandler.saveGameView(gameView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
