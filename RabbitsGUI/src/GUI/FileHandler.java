package GUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import main.Game;

public class FileHandler implements FileHandlerRole, Serializable {

	@Override
	public void saveGame(Game game) throws IOException {
		String fileName = "src\\save.txt";
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(game);
		oos.close();
	}

	@Override
	public Game loadGame() throws IOException, ClassNotFoundException {
		String fileName = "src\\save.txt";
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Game game = (Game) ois.readObject();
		ois.close();
		return game;
	}

}
