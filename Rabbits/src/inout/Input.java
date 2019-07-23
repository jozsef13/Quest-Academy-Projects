package inout;
import java.util.Scanner;

public class Input implements InputRole {

	private Scanner scanner;

	public Input(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	@Override
	public boolean hasMoreData() {
		return scanner.hasNext();
	}

	@Override
	public int getValue() {
		return scanner.nextInt();
	}

}
