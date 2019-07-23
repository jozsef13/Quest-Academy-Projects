package main;

import field.GameFieldRole;
import inout.OutputRole;

public class Game {
	
	private int numberOfTurns;
	private GameFieldRole field;
	private OutputRole output;

	public Game(int numberOfTurns, GameFieldRole field, OutputRole output) {
		super();
		this.numberOfTurns = numberOfTurns;
		this.field = field;
		this.output = output;
	}

	public void play() {
		
		while(field.playersAreOnField()) {
			field.playTurn();
			numberOfTurns++;
		}
		
		output.addMessage(field.getEggs() + " " + field.getHighestBasket() + " " + numberOfTurns);
		
		output.displayFile();
		
	}
	
}
