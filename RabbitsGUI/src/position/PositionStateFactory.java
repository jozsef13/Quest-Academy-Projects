package position;

import java.io.FileNotFoundException;

public class PositionStateFactory implements PositionStateFactoryRole {

	@Override
	public PositionStateRole build(PositionRole innerPosition) throws FileNotFoundException {
		PositionStateRole moveToNorthState = new MoveToNorthState(innerPosition);
		PositionStateRole moveToEastState = new MoveToEastState(innerPosition);
		PositionStateRole moveToWestState = new MoveToWestState(innerPosition);
		PositionStateRole moveToSouthState = new MoveToSouthState(innerPosition);
		
		wireStates(moveToNorthState, moveToEastState, moveToWestState, moveToSouthState);
		
		return findInitialState(moveToNorthState);	
	}

	private PositionStateRole findInitialState(PositionStateRole randomPositionState) {
		PositionStateRole currentPositionState = randomPositionState;
		while(true) {
			if(currentPositionState.isInitialState())
				return currentPositionState;
			currentPositionState = currentPositionState.next();
		}
	
	}

	private void wireStates(PositionStateRole moveToNorthState, PositionStateRole moveToEastState, PositionStateRole moveToWestState, PositionStateRole moveToSouthState) {
		
		moveToNorthState.setNextState(moveToEastState);
		moveToEastState.setNextState(moveToSouthState);
		moveToSouthState.setNextState(moveToWestState);
		moveToWestState.setNextState(moveToNorthState);
		
	}

}
