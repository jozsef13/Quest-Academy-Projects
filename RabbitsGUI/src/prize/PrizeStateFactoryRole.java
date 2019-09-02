package prize;

import java.io.FileNotFoundException;

import GUI.GUIController;

public interface PrizeStateFactoryRole{

	PrizeStateRole build(int value);

}
