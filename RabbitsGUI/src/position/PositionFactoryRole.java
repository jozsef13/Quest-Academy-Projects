package position;

import java.io.FileNotFoundException;

public interface PositionFactoryRole {

	PositionRole build(int x, int y);

}
