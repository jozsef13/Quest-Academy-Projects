package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFoxActionListener implements ActionListener {

	private int rows;
	private int columns;
	private ParcelFrameRole[][] fieldGrid;

	public AddFoxActionListener(int rows, int columns, ParcelFrameRole[][] fieldGrid) {
		super();
		this.rows = rows;
		this.columns = columns;
		this.fieldGrid = fieldGrid;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ItemTypeRole foxItem = new FoxItem();
		
		for (int i = 2; i < rows; i++) {
			for (int j = 2; j < columns; j++) {
				((InsideParcelFrame) fieldGrid[i][j]).removeActionListener();
			}
		}

		for (int i = 1; i < rows + 1; i++) {
			if(((InsideParcelFrame) fieldGrid[i][1]).isEmpty() || ((InsideParcelFrame) fieldGrid[i][columns]).isEmpty()) {
				((InsideParcelFrame) fieldGrid[i][1]).setItemType(foxItem);
				((InsideParcelFrame) fieldGrid[i][columns]).setItemType(foxItem);
			}
		}

		for (int j = 1; j < columns + 1; j++) {
			if(((InsideParcelFrame) fieldGrid[1][j]).isEmpty() || ((InsideParcelFrame) fieldGrid[rows][j]).isEmpty()) {
				((InsideParcelFrame) fieldGrid[1][j]).setItemType(foxItem);
				((InsideParcelFrame) fieldGrid[rows][j]).setItemType(foxItem);
			}
		}
	}

}
