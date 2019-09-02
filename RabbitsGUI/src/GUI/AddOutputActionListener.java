package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JOptionPane;

import inout.OutputRole;
import main.Game;

public class AddOutputActionListener implements ActionListener, Serializable {

	private Game game;

	public AddOutputActionListener(Game game) {
		super();
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		OutputRole output = game.getOutput();
		JOptionPane.showMessageDialog(null, output.getMessages(), "Game outputs", JOptionPane.INFORMATION_MESSAGE);

	}

}
