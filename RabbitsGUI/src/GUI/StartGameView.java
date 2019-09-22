package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

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
		setBounds(700, 400, 500, 150);

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
		
		JFrame startView = this;
		
		create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					setVisible(false);
					int columns = Integer.parseInt(noColumns.getText());
					int rows = Integer.parseInt(noRows.getText());
					gameView = controller.createGameView(rows, columns);
					gameView.setController(controller);
					gameView.createGameView();
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(startView, "Please type only digits in the fields!", "Number input error!", JOptionPane.ERROR_MESSAGE);
					setVisible(true);
				}

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
					JOptionPane.showMessageDialog(startView, "Successfully loaded!", "Load Game", JOptionPane.INFORMATION_MESSAGE);
					gameView.setVisible(true);
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
