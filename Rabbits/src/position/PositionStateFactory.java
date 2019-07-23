package position;

import java.io.FileNotFoundException;

public class PositionStateFactory implements PositionStateFactoryRole {

	@Override
	public PositionStateRole build(PositionRole innerPosition) throws FileNotFoundException {
		PositionStateRole moveToNorthState = new MoveToNorthState(innerPosition);
		PositionStateRole moveToEastState = new MoveToEastState(innerPosition);
		PositionStateRole moveToWestState = new MoveToWestState(innerPosition);
		PositionStateRole moveToSouthState = new MoveToSouthState(innerPosition);
		
		moveToNorthState.setNextState(moveToEastState);
		moveToEastState.setNextState(moveToSouthState);
		moveToSouthState.setNextState(moveToWestState);
		moveToWestState.setNextState(moveToNorthState);
		
		PositionStateRole currentPositionState = moveToNorthState;
		while(!currentPositionState.isInitialState()) {
			currentPositionState = currentPositionState.next();
		}	
		
		return currentPositionState;
	}

}
