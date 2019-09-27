package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import main.Game;

public class GameView extends JFrame {

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
	private JButton trapButton;
	private ActionListener addTrapAction;
	private JButton restartButton;
	private ActionListener restartAction;
	private DefaultTableModel defaultTable;
	private JTable table;
	private JSplitPane splitTableControlPanel;
	private JScrollPane scrollPane;
	private JButton foxButton;
	private ActionListener addFoxButton;
	private JButton carrotButton;
	private ActionListener addCarrotAction;

	public GameView(int columns, int rows, GameViewFileHandler gameViewFileHandler) throws HeadlessException {
		super();
		this.columns = columns;
		this.rows = rows;
		this.gameViewFileHandler = gameViewFileHandler;
	}

	
	public void setGame(Game game) {
		this.game = game;
	}

	
	public void createGameView() {
		
		setTitle("Rabbits the Game");
		setBounds(500, 200, 1200, 600);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		controlPanel = new JPanel();
		controlPanel.setLayout(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		
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
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 0;
		constraint.gridy = 0;
		controlPanel.add(startTurn, constraint);

		getOutput = new JButton("Get Output");
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 1;
		constraint.gridy = 0;
		controlPanel.add(getOutput,constraint);
		getOutput.setEnabled(false);

		rabbitButton = new JButton("Rabbit");
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 2;
		constraint.gridy = 0;
		controlPanel.add(rabbitButton, constraint);
		addRabbitAction = new AddRabbitActionListener(rows, columns, fieldGrid);
		rabbitButton.addActionListener(addRabbitAction);
		
		rabbitWithHealthButton = new JButton("Rabbit With Health");
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 3;
		constraint.gridy = 0;
		controlPanel.add(rabbitWithHealthButton,constraint);
		addRabbitWithHealthAction = new AddRabbitWithHealthActionListener(rows, columns, fieldGrid);
		rabbitWithHealthButton.addActionListener(addRabbitWithHealthAction);
		
		foxButton = new JButton("Fox");
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 4;
		constraint.gridy = 0;
		controlPanel.add(foxButton, constraint);
		addFoxButton = new AddFoxActionListener(rows, columns, fieldGrid);
		foxButton.addActionListener(addFoxButton);

		eggButton = new JButton("Egg");
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 0;
		constraint.gridy = 1;
		controlPanel.add(eggButton,constraint);
		addEggAction = new AddEggActionListener(rows, columns, fieldGrid);
		eggButton.addActionListener(addEggAction);
		
		healthButton = new JButton("Life");
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 1;
		constraint.gridy = 1;
		controlPanel.add(healthButton,constraint);
		addHealthAction = new AddHealthActionListener(rows, columns, fieldGrid);
		healthButton.addActionListener(addHealthAction);
		
		trapButton = new JButton("Trap");
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 2;
		constraint.gridy = 1;
		controlPanel.add(trapButton,constraint);
		addTrapAction = new AddTrapActionListener(rows, columns, fieldGrid);
		trapButton.addActionListener(addTrapAction);
		
		carrotButton = new JButton("Carrot");
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 3;
		constraint.gridy = 1;
		controlPanel.add(carrotButton, constraint);
		addCarrotAction = new AddCarrotActionListener(rows, columns, fieldGrid);
		carrotButton.addActionListener(addCarrotAction);
		
		saveButton = new JButton("Save Game");
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 0;
		constraint.gridy = 2;
		controlPanel.add(saveButton,constraint);
		saveAction = new SaveActionListener(gameViewFileHandler, this);
		saveButton.addActionListener(saveAction);
		
		restartButton = new JButton("Restart");
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.gridx = 1;
		constraint.gridy = 2;
		controlPanel.add(restartButton, constraint);
		restartAction = new RestartActionListener(this, controller);
		restartButton.addActionListener(restartAction);
		
		startTurnAction = new StartTurnActionListener(rows, columns, fieldGrid, startTurn, getOutput, rabbitButton, rabbitWithHealthButton, eggButton, trapButton, healthButton, saveButton, controller, foxButton, carrotButton);
		startTurn.addActionListener(startTurnAction);
		
		getOuputAction = new AddOutputActionListener(game);
		getOutput.addActionListener(getOuputAction);
		
		constraint.weighty = 1;
		constraint.gridy++;
		controlPanel.add(new JLabel(" "), constraint);
		
		String[] tableHead = {"Player", "Prizes", "Points" , "Lives", "Health", "Status", "Invincible"};
		defaultTable = new DefaultTableModel(tableHead , 0);
		table = new JTable(defaultTable);
		scrollPane = new JScrollPane(table);
		splitTableControlPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, controlPanel, scrollPane);
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitTableControlPanel, panel);

		add(splitPane);
		setVisible(true);
	}

	
	public void addPlayerAt(int x, int y, Color randomColor, String filename, int playerNumber) {
		fieldGrid[x][y].addPlayers(filename, randomColor, playerNumber);
		setVisible(true);
	}
	
	public void clearPlayerAt(int x, int y) {
		fieldGrid[x][y].clearPlayer();

		setVisible(true);
	}

	public void setController(GUIController controller2) {
		controller = controller2;
	}

	public void addTrapAt(int x, int y, String damage, String imageIcon) {
		((InsideParcelFrame) fieldGrid[x][y]).addTrap(damage, imageIcon);
		setVisible(true);
	}

	public void addRowsToTable(String[] infoData) {
		defaultTable.addRow(infoData);
	}

	public void updateInfo(String[] infoData) {
		defaultTable.setValueAt(infoData[0], Integer.parseInt(infoData[0]), 0);
		defaultTable.setValueAt(infoData[1], Integer.parseInt(infoData[0]), 1);
		defaultTable.setValueAt(infoData[2], Integer.parseInt(infoData[0]), 2);
		defaultTable.setValueAt(infoData[3], Integer.parseInt(infoData[0]), 3);
		defaultTable.setValueAt(infoData[4], Integer.parseInt(infoData[0]), 4);
		defaultTable.setValueAt(infoData[5], Integer.parseInt(infoData[0]), 5);
		defaultTable.setValueAt(infoData[6], Integer.parseInt(infoData[0]), 6);
	}

	public void addPrizeAt(int x, int y, int prizeValue, String prizeIcon) {
		((InsideParcelFrame) fieldGrid[x][y]).addPrizes(Integer.toString(prizeValue), prizeIcon);
		setVisible(true);			
	}


	public void addEnemyAt(int x, int y, String enemyIcon) {
		fieldGrid[x][y].addEnemy(enemyIcon);
		setVisible(true);			
	}


	public void clearEnemyAt(int x, int y) {
		fieldGrid[x][y].clearPlayer();

		setVisible(true);
	}

}
