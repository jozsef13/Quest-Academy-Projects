package inout;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputFactory implements InputFactoryRole {

	@Override
	public InputRole build() throws FileNotFoundException {
		File file = new File("src\\inout\\input.txt");
		Scanner scanner = new Scanner(file );
		return new Input(scanner );
	}

}
