package core;

public class Demo {

	public static void main(String[] args) {
		
		Player player = new Player("Player");
		Player dealer = new Player("Dealer");
		Game game1 = new Game(player,dealer);
		
		game1.initialize(0);
		game1.start(0);
		
		
	}

}
