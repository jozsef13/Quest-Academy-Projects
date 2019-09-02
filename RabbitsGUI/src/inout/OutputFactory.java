package inout;

import java.io.Serializable;

public class OutputFactory implements OutputFactoryRole,Serializable {

	@Override
	public OutputRole build() {
		return new Output();
	}

}
