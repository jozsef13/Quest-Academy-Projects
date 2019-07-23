package inout;

import java.io.FileNotFoundException;

public interface InputFactoryRole {

	InputRole build() throws FileNotFoundException;

}
