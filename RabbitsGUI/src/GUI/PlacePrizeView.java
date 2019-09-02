package GUI;

import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import main.Game;

public class PlacePrizeView extends JFrame {

	private JPanel panel;
	private JLabel setPrizeValue;
	private JTextField prizeValueText;
	private JButton addEggsButton;
	private GUIController controller;
	private Component setPrizeX;
	private JTextField prizeXText;
	private JLabel setPrizeY;
	private JTextField prizeYText;
	private JButton startGameButton;
	private GameView gameView;

	public PlacePrizeView(GUIController controller, GameView gameView) throws HeadlessException {
		super();
		this.controller = controller;
		this.gameView = gameView;
	}

	public void createPrizeView(int rows, int columns) {

		setTitle("Add prizes");
		setBounds(300, 200, 500, 150);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		panel = new JPanel();

		getContentPane().add(panel);

		setPrizeValue = new JLabel("Enter the egg value : ");
		panel.add(setPrizeValue);

		prizeValueText = new JTextField(25);
		prizeValueText.setHorizontalAlignment(JTextField.CENTER);
		panel.add(prizeValueText);

		setPrizeX = new JLabel("Enter the x coordinate of the egg: ");
		panel.add(setPrizeX);

		prizeXText = new JTextField(25);
		prizeXText.setHorizontalAlignment(JTextField.CENTER);
		panel.add(prizeXText);

		setPrizeY = new JLabel("Enter the y coordinate of the egg: ");
		panel.add(setPrizeY);

		prizeYText = new JTextField(25);
		prizeYText.setHorizontalAlignment(JTextField.CENTER);
		panel.add(prizeYText);

		addEggsButton = new JButton("Add eggs");

		addEggsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int prizeValue = Integer.parseInt(prizeValueText.getText());
				int prizeX = Integer.parseInt(prizeXText.getText());
				int prizeY = Integer.parseInt(prizeYText.getText());
				controller.addEggsAt(prizeX, prizeY, prizeValue);
				prizeValueText.setText("");
				prizeXText.setText("");
				prizeYText.setText("");
				gameView.setVisible(true);
			}
		});

		panel.add(addEggsButton);

		startGameButton = new JButton("Start game");

		startGameButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (controller.isTheGamePlayable()) {
					setVisible(false);
				}
			}
		});

		panel.add(startGameButton);
		add(panel);
		setVisible(true);
	}

}
