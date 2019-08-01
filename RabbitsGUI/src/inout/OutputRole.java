package inout;

import java.util.ArrayList;

public interface OutputRole {
	
	public void addMessage(String message);
	
	public void displayConsole();

	ArrayList<String> getMessages();
}
