package main;

import java.io.FileNotFoundException;

public interface GameFactoryRole {

	Game build();

	void addPalyers(int x, int y);

	void addEggs(int prizeX, int prizeY, int prizeValue);

	void addPalyersWithHealth(int x, int y);

	void addHealth(int x, int y, int prizeValue);

}
