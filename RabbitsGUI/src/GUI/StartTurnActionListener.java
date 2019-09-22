package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.AbstractButton;
import javax.swing.JButton;

import main.Game;

public class StartTurnActionListener implements ActionListener, Serializable{

	private int rows;
	private int columns;
	private ParcelFrameRole[][] fieldGrid;
	private JButton startTurn;
	private JButton getOutput;
	private JButton rabbitButton;
	private JButton rabbitWithHealthButton;
	private JButton eggButton;
	private JButton trapButton;
	private JButton healthButton;
	private JButton saveButton;
	private GUIController controller;
	private JButton foxButton;

	public StartTurnActionListener(int rows, int columns, ParcelFrameRole[][] fieldGrid, JButton startTurn,
			JButton getOutput, JButton rabbitButton, JButton rabbitWithHealthButton, JButton eggButton,
			JButton trapButton, JButton healthButton, JButton saveButton, GUIController controller, JButton foxButton) {
		super();
		this.rows = rows;
		this.columns = columns;
		this.fieldGrid = fieldGrid;
		this.startTurn = startTurn;
		this.getOutput = getOutput;
		this.rabbitButton = rabbitButton;
		this.rabbitWithHealthButton = rabbitWithHealthButton;
		this.eggButton = eggButton;
		this.trapButton = trapButton;
		this.healthButton = healthButton;
		this.saveButton = saveButton;
		this.controller = controller;
		this.foxButton = foxButton;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		controller.clearEnemies();
		controller.clearPlayers();
		controller.play();
		controller.updateGameView();
		controller.updateInfoTable();
		
		if (controller.theGameIsNotPlayable()) {
			disableButtons();
		}

		for (int i = 1; i < rows + 1; i++) {
			for (int j = 1; j < columns + 1; j++) {
				if(fieldGrid[i][j].isInsideParcel()) {
					((InsideParcelFrame) fieldGrid[i][j]).setEnabledTrue();
				}
			}
		}	
	}


	private void disableButtons() {
		startTurn.setEnabled(false);
		getOutput.setEnabled(true);
		rabbitButton.setEnabled(false);
		rabbitWithHealthButton.setEnabled(false);
		eggButton.setEnabled(false);
		trapButton.setEnabled(false);
		healthButton.setEnabled(false);
		saveButton.setEnabled(false);
		foxButton.setEnabled(false);
	}

}
