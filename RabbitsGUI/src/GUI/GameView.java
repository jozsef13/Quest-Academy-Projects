package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;

import inout.OutputRole;
import main.Game;

public class GameView extends JFrame implements GameViewRole {

	private ParcelFrameRole[][] fieldGrid;
	private int columns;
	private int rows;
	private JPanel controlPanel;
	private JButton startTurn;
	private JSplitPane splitPane;
	private JPanel panel;
	private Game game;
	private JButton getOutput;
	private JButton rabbitButton;
	private JButton eggButton;
	private GUIController controller;
	private JButton saveButton;
	private GameViewFileHandler gameViewFileHandler;
	private ActionListener startTurnAction;
	private ActionListener addRabbitAction;
	private ActionListener addEggAction;
	private ActionListener getOuputAction;
	private ActionListener saveAction;
	private JButton rabbitWithHealthButton;
	private ActionListener addRabbitWithHealthAction;
	private JButton healthButton;
	private ActionListener addHealthAction;

	public GameView(int columns, int rows, GameViewFileHandler gameViewFileHandler) throws HeadlessException {
		super();
		this.columns = columns;
		this.rows = rows;
		this.gameViewFileHandler = gameViewFileHandler;
	}

	@Override
	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public void createGameView() {
		setTitle("Rabbits the Game");
		setBounds(500, 200, 1000, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		controlPanel = new JPanel();
		panel = new JPanel();
		fieldGrid = new ParcelFrameRole[rows + 2][columns + 2];
		getContentPane().add(controlPanel);
		panel.setLayout(new GridLayout(rows + 2, columns + 2));
		panel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		for (int i = 0; i < rows + 2; i++) {
			for (int j = 0; j < columns + 2; j++) {
				if (i == 0 || j == 0 || i == rows + 1 || j == columns + 1) {
					fieldGrid[i][j] = new OutsideParcelFrame();
				} else {
					fieldGrid[i][j] = new InsideParcelFrame();
					((InsideParcelFrame) fieldGrid[i][j]).setXAndY(i, j);
					((InsideParcelFrame) fieldGrid[i][j]).setController(controller);
				}

				fieldGrid[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				panel.add((Component) fieldGrid[i][j]);
				add(controlPanel);
			}
		}
		startTurn = new JButton("Start Turn");
		controlPanel.add(startTurn);

		getOutput = new JButton("Get Output");
		controlPanel.add(getOutput);
		getOutput.setEnabled(false);

		rabbitButton = new JButton("R");
		controlPanel.add(rabbitButton);
		
		addRabbitAction = new AddRabbitActionListener(rows, columns, fieldGrid);
		rabbitButton.addActionListener(addRabbitAction);
		
		rabbitWithHealthButton = new JButton("RH");
		controlPanel.add(rabbitWithHealthButton);
		
		addRabbitWithHealthAction = new AddRabbitWithHealthActionListener(rows, columns, fieldGrid);
		rabbitWithHealthButton.addActionListener(addRabbitWithHealthAction);

		eggButton = new JButton("E");
		controlPanel.add(eggButton);
		
		addEggAction = new AddEggActionListener(rows, columns, fieldGrid);
		eggButton.addActionListener(addEggAction);
		
		healthButton = new JButton("H");
		controlPanel.add(healthButton);
		
		addHealthAction = new AddHealthActionListener(rows, columns, fieldGrid);
		healthButton.addActionListener(addHealthAction);
		
		startTurnAction = new StartTurnActionListener(game, eggButton, rabbitButton, rows, columns, fieldGrid, startTurn, getOutput, rabbitWithHealthButton, healthButton);
		startTurn.addActionListener(startTurnAction);
		
		getOuputAction = new AddOutputActionListener(game);
		getOutput.addActionListener(getOuputAction);

		saveButton = new JButton("Save Game");
		controlPanel.add(saveButton);

		GameView gameView = this;
		saveAction = new SaveActionListener(gameViewFileHandler, gameView);
		saveButton.addActionListener(saveAction);
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, controlPanel, panel);

		add(splitPane);
		setVisible(true);
	}

	@Override
	public void addPlayerAt(int x, int y, Color randomColor) {
		fieldGrid[x][y].addPlayers("src/rabbit.gif", randomColor);
		setVisible(true);
	}

	@Override
	public void addEggsAt(int prizeX, int prizeY, int prizeValue) {
		((InsideParcelFrame) fieldGrid[prizeX][prizeY]).addPrizes(Integer.toString(prizeValue), "src/egg.gif");
		setVisible(true);
	}

	@Override
	public void clearPlayerAt(int x, int y) {
		fieldGrid[x][y].clearPlayer();

		setVisible(true);
	}

	@Override
	public void clearPrizeAt(int x, int y) {
		((InsideParcelFrame) fieldGrid[x][y]).clearPrize();
		setVisible(true);
	}

	public void setController(GUIController controller2) {
		controller = controller2;
	}

	public void addHealthAt(int x, int y, int prizeValue) {
		((InsideParcelFrame) fieldGrid[x][y]).addPrizes(Integer.toString(prizeValue), "src/health.gif");
		setVisible(true);	
	}

}
