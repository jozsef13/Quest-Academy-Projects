package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

	public GameView(int columns, int rows) throws HeadlessException {
		super();
		this.columns = columns;
		this.rows = rows;
	}

	@Override
	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public void createGameView() {
		setTitle("Rabbits the Game");
		setBounds(800, 200, 800, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		controlPanel = new JPanel();
		panel = new JPanel();
		fieldGrid = new ParcelFrameRole[rows+2][columns+2];
		getContentPane().add(controlPanel);
		panel.setLayout(new GridLayout(rows+2, columns+2));
		panel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		for (int i = 0; i < rows+2 ; i++) {
			for (int j = 0; j < columns+2 ; j++) {
				if(i == 0 || j == 0 || i == rows + 1  || j == columns + 1 ) {
					fieldGrid[i][j] = new OutsideParcelFrame();
				}
				else
				{
					fieldGrid[i][j] = new InsideParcelFrame();
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
		startTurn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game.play();
				if(!game.isPlayable())
				{
					startTurn.setEnabled(false);
					getOutput.setEnabled(true);
				}
		}		
		});
		getOutput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OutputRole output = game.getOutput();
				JOptionPane.showMessageDialog(null, output.getMessages(), "Game outputs", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, controlPanel, panel);
		
		add(splitPane);
	}
	
	
	@Override
	public void addPlayerAt(int x, int y)
	{
		fieldGrid[x][y].addPlayers("src/rabbit.gif");
	}
	
	
	@Override
	public void addPrizesAt(int prizeX, int prizeY, int prizeValue)
	{
		((InsideParcelFrame) fieldGrid[prizeX][prizeY]).addPrizes(Integer.toString(prizeValue), "src/egg.gif");
	}


	@Override
	public void clearPlayerAt(int x, int y) {
		fieldGrid[x][y].clearPlayer();
	}


	@Override
	public void clearPrizeAt(int x, int y) {
		((InsideParcelFrame) fieldGrid[x][y]).clearPrize();
	}
	
}
