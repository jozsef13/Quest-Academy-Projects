import java.util.Random;

public class FightFactory implements FightFactoryRole{

	@Override
	public FightRole build(int maxRounds) {
		
		FighterRole fighter1 = new Fighter(new Health(randomGenerator(60, 90)), randomGenerator(40, 60), randomGenerator(25, 40), randomGenerator(60, 90), 
				new Defense(randomGenerator(40, 60)), new Luck(101));
		FighterRole fighter2 = new Hero(new Fighter(new Health(randomGenerator(70, 100)), randomGenerator(40, 50), randomGenerator(10, 30), randomGenerator(70, 80), 
				new HeroDefense(new Defense(randomGenerator(45, 55)), new Luck(101), 20, new ShieldDefense(new Defense(randomGenerator(45, 55)), 2)), new Luck(101)), 
				new Luck(101), 10);
		return new Fight(fighter1  , fighter2  , maxRounds);
	}
	
	private int randomGenerator(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min) + min;
	}	
}
