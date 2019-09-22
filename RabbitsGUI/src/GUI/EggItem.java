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

import prize.EggStateFactory;
import prize.PrizeStateFactoryRole;

public class EggItem extends JFrame implements ItemTypeRole, Serializable {

	private int prizeValue;
	private int x;
	private int y;

	@Override
	public void set(int x1, int y1, GUIController controller) {
		x = x1;
		y = y1;
		setTitle("Add value to the prize");
		setBounds(300, 200, 500, 150);
		JPanel panel = new JPanel();

		getContentPane().add(panel);

		JLabel setPrizeValue = new JLabel("Enter the egg value : ");
		panel.add(setPrizeValue);

		JTextField prizeValueText = new JTextField("", 25);
		prizeValueText.setHorizontalAlignment(JTextField.CENTER);
		panel.add(prizeValueText);
		
		JButton addValueButton = new JButton("Add");
		JFrame eggView = this;
		addValueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					prizeValue = Integer.parseInt(prizeValueText.getText());
					prizeValueText.setText("");
					PrizeStateFactoryRole eggStateFactory = new EggStateFactory();
					controller.addPrizeAt(x, y1, prizeValue, "src/egg.gif", eggStateFactory);
					setVisible(false);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(eggView, "Please type only digits in the fields!", "Number input error!", JOptionPane.ERROR_MESSAGE);
					setVisible(true);
				}
				
			}
		});
		
		panel.add(addValueButton);
		add(panel);
		setVisible(true);
	}

}
