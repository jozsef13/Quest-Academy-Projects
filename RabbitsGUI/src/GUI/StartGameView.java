package GUI;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import main.Game;

public class StartGameView extends JFrame{
	
	private JPanel panel;
	private JTextField noColumns;
	private JLabel setNoColumns;
	private JTextField noRows;
	private JLabel setNoRows;
	private JButton create;
	private GameView gameView;
	private GUIController controller;
	private JButton loadButton;
	private GameViewFileHandler gameViewFileHandler;

	public StartGameView(GUIController controller, GameViewFileHandler gameViewFileHandler){
		this.controller = controller;
		this.gameViewFileHandler = gameViewFileHandler;
	}

	public void createStartGameView()
	{
		setTitle("Initializing field");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		panel = new JPanel();
		
		getContentPane().add(panel);
		setSize(500, 150);

		setNoRows = new JLabel("Enter number of rows: ");
		panel.add(setNoRows);
		
		noRows = new JTextField(20);
		noRows.setHorizontalAlignment(JTextField.CENTER);
		panel.add(noRows);
		
		setNoColumns = new JLabel("Enter number of columns: ");
		panel.add(setNoColumns);
		
		noColumns = new JTextField(20);
		noColumns.setHorizontalAlignment(JTextField.CENTER);
		panel.add(noColumns);
		
		create = new JButton("Create field");
		panel.add(create);
		setVisible(true);
		create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				int columns = Integer.parseInt(noColumns.getText());
				int rows = Integer.parseInt(noRows.getText());
				gameView = controller.createGameView(rows, columns);
				gameView.setController(controller);
				gameView.createGameView();
				//placePlayersView = new PlacePlayersView(controller, gameView);
				//placePlayersView.createPlayersView(rows, columns);
				//gameView.setVisible(true);
				//placePlayersView.setVisible(true);

			}
		});
		
		loadButton = new JButton("Load Game");
		panel.add(loadButton);
		loadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					GameView gameViewNew;
					gameViewNew = gameViewFileHandler.loadGameView();
					gameView = gameViewNew;
					gameView.setVisible(true);
					//gameView.createGameView();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		add(panel);	
	}
}
