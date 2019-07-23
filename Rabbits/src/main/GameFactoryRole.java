package main;

import java.io.FileNotFoundException;

public interface GameFactoryRole {

	Game build() throws FileNotFoundException;

}
