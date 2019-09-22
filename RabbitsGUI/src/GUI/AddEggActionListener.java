package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class AddEggActionListener implements ActionListener, Serializable {

	private int rows;
	private int columns;
	private ParcelFrameRole[][] fieldGrid;

	public AddEggActionListener(int rows, int columns, ParcelFrameRole[][] fieldGrid) {
		super();
		this.rows = rows;
		this.columns = columns;
		this.fieldGrid = fieldGrid;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ItemTypeRole eggItem = new EggItem();

		for (int i = 1; i < rows + 1; i++) {
			for (int j = 1; j < columns + 1; j++) {
					((InsideParcelFrame) fieldGrid[i][j]).removeActionListener();
			}
		}

		for (int i = 1; i < rows + 1; i++) {
			for (int j = 1; j < columns + 1; j++) {
				if(((InsideParcelFrame) fieldGrid[i][j]).isEmpty()) {
					((InsideParcelFrame) fieldGrid[i][j]).addActionListener();
					((InsideParcelFrame) fieldGrid[i][j]).setItemType(eggItem);
				}
			}
		}
	}

}
