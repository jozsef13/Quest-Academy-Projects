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

public class TrapItem extends JFrame implements ItemTypeRole, Serializable {

	private int x;
	private int y;
	private int trapValue;

	@Override
	public void set(int x1, int y1, GUIController controller) {
		x = x1;
		y = y1;
		setTitle("Add damage for the trap");
		setBounds(300, 200, 500, 150);
		JPanel panel = new JPanel();

		getContentPane().add(panel);

		JLabel setTrapValue = new JLabel("Enter the damage for this trap : ");
		panel.add(setTrapValue);

		JTextField trapValueText = new JTextField("", 25);
		trapValueText.setHorizontalAlignment(JTextField.CENTER);
		panel.add(trapValueText);
		
		JButton addValueButton = new JButton("Add");
		JFrame trapView = this;
		addValueButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					trapValue = Integer.parseInt(trapValueText.getText());
					trapValueText.setText("");
					controller.addTrapsAt(x, y, trapValue);
					setVisible(false);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(trapView, "Please type only digits in the fields!", "Number input error!", JOptionPane.ERROR_MESSAGE);
					setVisible(true);
				}
				
			}
		});
		
		panel.add(addValueButton);
		add(panel);
		setVisible(true);
	}

}
