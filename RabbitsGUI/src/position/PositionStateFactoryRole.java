package position;

import java.io.FileNotFoundException;

public interface PositionStateFactoryRole {

	PositionStateRole build(PositionRole innerPosition) throws FileNotFoundException;
	
}
