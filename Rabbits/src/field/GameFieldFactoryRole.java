package field;

import java.io.FileNotFoundException;

public interface GameFieldFactoryRole {

	GameField build() throws FileNotFoundException;

}
