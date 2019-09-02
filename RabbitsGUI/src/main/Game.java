package main;

import java.io.Serializable;

import field.GameFieldRole;
import field.ParcelFieldRole;
import field.PlayerFieldRole;
import inout.OutputRole;

public class Game implements Serializable{
	
	//private static final long serialVersionUID = 1L;
	
	private int numberOfTurns = 0;
	private GameFieldRole gameField;
	private OutputRole output;
	private PlayerFieldRole playerField;

	public Game(GameFieldRole gameField, OutputRole output, PlayerFieldRole playerField) {
		super();
		this.gameField = gameField;
		this.output = output;
		this.playerField = playerField;
	}
	
	public OutputRole getOutput() {
		return output;
	}

	public void play() {
		
		gameField.playTurn();
		numberOfTurns++;
		
		if(!gameField.playersAreOnField())
			output.addMessage("The rabbits collected " + playerField.getEggs() + " egg(s)! " + "\nThe highest value of eggs collected by one rabbit is " + playerField.getHighestBasket() + "\n" + "Total number of turns played is " + numberOfTurns);
	}


	public boolean isPlayable() {
		return gameField.playersAreOnField();
	}
	
}
