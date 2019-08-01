package main;

import java.io.FileNotFoundException;

public interface GameFactoryRole {

	Game build() throws FileNotFoundException;

	void addPalyers(int x, int y) throws FileNotFoundException;

	void addEggs(int prizeX, int prizeY, int prizeValue) throws FileNotFoundException;

}
