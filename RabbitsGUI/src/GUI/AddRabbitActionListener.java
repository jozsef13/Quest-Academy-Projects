package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class AddRabbitActionListener implements ActionListener, Serializable {

	private int rows;
	private int columns;
	private ParcelFrameRole[][] fieldGrid;

	public AddRabbitActionListener(int rows, int columns, ParcelFrameRole[][] fieldGrid) {
		super();
		this.rows = rows;
		this.columns = columns;
		this.fieldGrid = fieldGrid;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ItemTypeRole rabbitItem = new RabbitItem();

		for (int i = 2; i < rows; i++) {
			for (int j = 2; j < columns; j++) {
				((InsideParcelFrame) fieldGrid[i][j]).removeActionListener();
			}
		}

		for (int i = 1; i < rows + 1; i++) {
			((InsideParcelFrame) fieldGrid[i][1]).setItemType(rabbitItem);
			((InsideParcelFrame) fieldGrid[i][columns]).setItemType(rabbitItem);
		}

		for (int j = 1; j < columns + 1; j++) {
			((InsideParcelFrame) fieldGrid[1][j]).setItemType(rabbitItem);
			((InsideParcelFrame) fieldGrid[rows][j]).setItemType(rabbitItem);
		}
	}

}
