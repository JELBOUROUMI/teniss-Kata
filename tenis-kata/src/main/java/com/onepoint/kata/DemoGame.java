package com.onepoint.kata;



public class DemoGame {

	public static void main(String[] args) {
		Player player1 = new Player("jamal");
		Player player2 = new Player("Hervy");
		Game game = new Game(player1, player2);
		int i;
		
		 
		while (!game.isTerminee()) {

			 i = (int) (Math.random() * 10) + 1;
			if (i % 2 == 0)
				System.out.println(player2.marquer());
			else
				System.out.println(player1.marquer());
		}
		

		System.out.println(game.getScoreGame());
		//pour tester GAME OVER
		System.out.println(player2.marquer());
		System.out.println(player2.marquer());
	}

}
