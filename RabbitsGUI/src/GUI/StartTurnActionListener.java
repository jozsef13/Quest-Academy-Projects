package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import main.Game;

public class StartTurnActionListener implements ActionListener, Serializable{

	private Game game;
	private JButton eggButton;
	private JButton rabbitButton;
	private int rows;
	private int columns;
	private ParcelFrameRole[][] fieldGrid;
	private JButton startTurn;
	private JButton getOutput;
	private JButton rabbitWithHealthButton;
	private JButton healthButton;


	public StartTurnActionListener(Game game, JButton eggButton, JButton rabbitButton, int rows, int columns,
			ParcelFrameRole[][] fieldGrid, JButton startTurn, JButton getOutput, JButton rabbitWithHealthButton, JButton healthButton) {
		super();
		this.game = game;
		this.eggButton = eggButton;
		this.rabbitButton = rabbitButton;
		this.rows = rows;
		this.columns = columns;
		this.fieldGrid = fieldGrid;
		this.startTurn = startTurn;
		this.getOutput = getOutput;
		this.rabbitWithHealthButton = rabbitWithHealthButton;
		this.healthButton = healthButton;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		game.play();
		
		eggButton.setEnabled(false);
		rabbitButton.setEnabled(false);
		rabbitWithHealthButton.setEnabled(false);
		healthButton.setEnabled(false);
		for (int i = 1; i < rows + 1; i++) {
			for (int j = 1; j < columns + 1; j++) {
				((InsideParcelFrame) fieldGrid[i][j]).removeActionListener();
				((InsideParcelFrame) fieldGrid[i][j]).setEnabledTrue();
			}
		}
		if (!game.isPlayable()) {
			startTurn.setEnabled(false);
			getOutput.setEnabled(true);
		}
		
	}

}
