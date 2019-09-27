package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import player.InvincibilityFactory;
import player.InvincibilityFactoryRole;
import player.PlayerFactoryRole;
import player.RabbitWithHealth;
import player.RabbitWithHealthFactory;
import prize.BasketFactory;
import prize.BasketFactoryRole;
import prize.EggFactory;
import prize.HealthFactory;
import prize.HealthFactoryRole;
import prize.LifeFactory;
import prize.LifeFactoryRole;
import prize.PrizeFactoryRole;

public class RabbitWithHealthItem extends JFrame implements ItemTypeRole, Serializable {

	private int x;
	private int y;
	private int numberOfLives;

	@Override
	public void set(int x1, int y1, GUIController controller) {
		x = x1;
		y = y1;
		setTitle("Add value to the prize");
		setBounds(300, 200, 500, 150);
		JPanel panel = new JPanel();

		getContentPane().add(panel);

		JLabel setNumberOfLifesValue = new JLabel("Enter the number of lifes for this rabbit : ");
		panel.add(setNumberOfLifesValue);

		JTextField numberOfLifesValueText = new JTextField("", 25);
		numberOfLifesValueText.setHorizontalAlignment(JTextField.CENTER);
		panel.add(numberOfLifesValueText);
		
		JButton addValueButton = new JButton("Add");
		JFrame rabbitHealthView = this;
		addValueButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					numberOfLives = Integer.parseInt(numberOfLifesValueText.getText());
					numberOfLifesValueText.setText("");
					BasketFactoryRole basketFactory = new BasketFactory(0);
					PrizeFactoryRole eggFactory = new EggFactory(0);
					LifeFactoryRole lifeFactory = new LifeFactory(numberOfLives);
					HealthFactoryRole healthFactory = new HealthFactory(100, lifeFactory );
					InvincibilityFactoryRole invincibilityFactory = new InvincibilityFactory();
					PlayerFactoryRole rabbitWithHealthFactory = new RabbitWithHealthFactory(basketFactory, eggFactory, healthFactory, invincibilityFactory);
					controller.addPlayersOnGame(x, y, numberOfLives, "src/rabbitHealth.gif", rabbitWithHealthFactory  );
					setVisible(false);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(rabbitHealthView, "Please type only digits in the fields!", "Number input error!", JOptionPane.ERROR_MESSAGE);
					setVisible(true);
				}
				
			}
		});
		
		panel.add(addValueButton);
		add(panel);
		setVisible(true);
		
		
	}

}
