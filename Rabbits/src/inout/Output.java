package inout;

import java.util.ArrayList;

public class Output implements OutputRole{
	
	private ArrayList<String> messages;

	public Output() {
		messages = new ArrayList<String>();
	}

	@Override
	public void addMessage(String message) {
		messages.add(message);
		
	}

	@Override
	public void displayFile() {
		for(String message : messages) {
			System.out.println(message);
		}
		
	}

}
