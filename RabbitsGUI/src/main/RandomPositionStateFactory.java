package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import position.MoveToEastState;
import position.MoveToNorthState;
import position.MoveToSouthState;
import position.MoveToWestState;
import position.PositionRole;
import position.PositionStateFactoryRole;
import position.PositionStateRole;

public class RandomPositionStateFactory implements PositionStateFactoryRole {

	private List<PositionStateRole> randomList;
	
	public RandomPositionStateFactory() {
		randomList = new ArrayList<PositionStateRole>();
	}

	@Override
	public PositionStateRole build(PositionRole innerPosition) {
		PositionStateRole moveToNorthState = new MoveToNorthState(innerPosition);
		PositionStateRole moveToEastState = new MoveToEastState(innerPosition);
		PositionStateRole moveToWestState = new MoveToWestState(innerPosition);
		PositionStateRole moveToSouthState = new MoveToSouthState(innerPosition);
		
		wireStates(moveToNorthState, moveToEastState, moveToWestState, moveToSouthState);
		
		addStatesToList(moveToNorthState, moveToEastState, moveToWestState, moveToSouthState);
		
		return selectRandomPositionState();
	}

	private void addStatesToList(PositionStateRole moveToNorthState, PositionStateRole moveToEastState,
			PositionStateRole moveToWestState, PositionStateRole moveToSouthState) {
		randomList.add(moveToSouthState);
		randomList.add(moveToWestState);
		randomList.add(moveToEastState);
		randomList.add(moveToNorthState);
	}

	private PositionStateRole selectRandomPositionState() {
		Random rand = new Random();
		return randomList.get(rand.nextInt(4));
	}
	
	private void wireStates(PositionStateRole moveToNorthState, PositionStateRole moveToEastState, PositionStateRole moveToWestState, PositionStateRole moveToSouthState) {
		
		moveToNorthState.setNextState(moveToEastState);
		moveToEastState.setNextState(moveToSouthState);
		moveToSouthState.setNextState(moveToWestState);
		moveToWestState.setNextState(moveToNorthState);
		
	}

}
