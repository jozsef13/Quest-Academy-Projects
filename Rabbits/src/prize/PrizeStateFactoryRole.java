package prize;

import java.io.FileNotFoundException;

public interface PrizeStateFactoryRole extends GeneralPrizeStateFactoryRole{
	
	PrizeStateRole build(int value) throws FileNotFoundException;

}
