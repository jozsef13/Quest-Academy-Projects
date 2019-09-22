package position;

public class DiagonallyPositionStateFactory implements PositionStateFactoryRole {

	@Override
	public PositionStateRole build(PositionRole innerPosition) {
		PositionStateRole moveToNorthWestState = new MoveToNorthWestState(innerPosition);
		PositionStateRole moveToNorthEastState = new MoveToNorthEastState(innerPosition);
		PositionStateRole moveToSouthWestState = new MoveToSouthWestState(innerPosition);
		PositionStateRole moveToSouthEastState = new MoveToSouthEastState(innerPosition);
		
		wireStates(moveToNorthWestState, moveToNorthEastState, moveToSouthWestState, moveToSouthEastState);
		return findInitialState(moveToSouthEastState);
	}

	private PositionStateRole findInitialState(PositionStateRole randomPositionState) {
		
		PositionStateRole currentPositionState = randomPositionState;
		while(true) {
			if(currentPositionState.isInitialState())
			{
				return currentPositionState;
			}
				
			currentPositionState = currentPositionState.next();
		}
	
	}

	private void wireStates(PositionStateRole moveToNorthWestState, PositionStateRole moveToNorthEastState, PositionStateRole moveToSouthWestState, PositionStateRole moveToSouthEastState) {
		
		moveToNorthWestState.setNextState(moveToNorthEastState);
		moveToNorthEastState.setNextState(moveToSouthEastState);
		moveToSouthEastState.setNextState(moveToSouthWestState);
		moveToSouthWestState.setNextState(moveToNorthWestState);
		
		
	}

}
