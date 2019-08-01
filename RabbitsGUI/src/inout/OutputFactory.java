package inout;

public class OutputFactory implements OutputFactoryRole {

	@Override
	public OutputRole build() {
		return new Output();
	}

}
