package prize;

import java.io.FileNotFoundException;

public interface PrizelessStateFactoryRole extends GeneralPrizeStateFactoryRole {
	
	PrizeStateRole build();
	
}
