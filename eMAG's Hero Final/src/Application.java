
public class Application {

	public static void main(String[] args) {
		
		Application application = new Application();
		
		application.run();

	}

	private void run() {
		
		FightRole fight;
		FightFactoryRole fightFactory = new FightFactory();
		fight = fightFactory.build(20);
		
		fight.proceed();
		
	}

}
