import java.util.Random;

public class Luck implements LuckRole{
	
	private int maxLuck;

	public Luck(int maxLuck) {
		this.maxLuck = maxLuck;
	}

	@Override
	public boolean iAmLucky(int luckLevel) {
		Random randomNumber = new Random();
		
		if(luckLevel > randomNumber.nextInt(maxLuck)) {
			return true;
		}
		return false;
	}
	
}
