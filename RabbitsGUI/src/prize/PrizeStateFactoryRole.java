package prize;

import java.io.FileNotFoundException;

public interface PrizeStateFactoryRole{
	
	PrizeStateRole build(int value) throws FileNotFoundException;

}
