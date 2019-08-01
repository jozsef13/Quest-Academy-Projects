package GUI;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class PlacePlayersView extends JFrame{

	private JPanel panel;
	private JLabel setX;
	private JTextField xText;
	private JLabel setY;
	private JTextField yText;
	private JButton addButton;
	private GUIController controller;
	private JButton nextButton;
	private PlacePrizeView placePrizeView;
	private GameView gameView;

	public PlacePlayersView(GUIController controller, GameView gameView) throws HeadlessException {
		super();
		this.controller = controller;
		this.gameView = gameView;
	}

	public void createPlayersView(int rows, int columns)
	{
		setTitle("Add players");
		setBounds(300, 200, 500, 150);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		panel = new JPanel();
		
		getContentPane().add(panel);
		//setSize(500, 150);
		
		setX = new JLabel("Enter x coordinate: ");
		panel.add(setX);
		
		xText = new JTextField(25);
		xText.setHorizontalAlignment(JTextField.CENTER);
		panel.add(xText);
		
		setY = new JLabel("Enter y coordinate: ");
		panel.add(setY);
		
		yText = new JTextField(25);
		yText.setHorizontalAlignment(JTextField.CENTER);
		panel.add(yText);
		
		addButton = new JButton("Add player");
		
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int x = Integer.parseInt(xText.getText());
					int y = Integer.parseInt(yText.getText());
					xText.setText("");
					yText.setText("");
					controller.addPlayersAt(x, y);
					gameView.setVisible(true);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		panel.add(addButton);
		
		nextButton = new JButton("Next");
		
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				placePrizeView = new PlacePrizeView(controller, gameView);
				placePrizeView.createPrizeView(rows, columns);
				setVisible(false);
			}
		});
		
		panel.add(nextButton);
		add(panel);
	}
}
