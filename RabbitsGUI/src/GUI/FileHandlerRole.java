package GUI;

import java.io.FileNotFoundException;
import java.io.IOException;

import main.Game;

public interface FileHandlerRole {

	void saveGame(Game game) throws IOException;

	Game loadGame() throws IOException, ClassNotFoundException;

}
