package GUI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import main.Game;

public class GameViewFileHandler implements Serializable{
	
	public void saveGameView(GameView gameView) throws IOException {
		String fileName = "src\\saveGameView.ser";
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(gameView);
		oos.close();
	}

	public GameView loadGameView() throws IOException, ClassNotFoundException {
		String fileName = "src\\saveGameView.ser";
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		GameView gameView = (GameView) ois.readObject();
		ois.close();
		return gameView;
	}
	
}
