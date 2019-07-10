package com.onepoint.kata.test;


import org.junit.Assert;
import org.junit.Test;

import com.onepoint.kata.Game;
import com.onepoint.kata.Player;

/**
 * 
 * @author Jamal EL BOUROUMI
 *
 */

public class PlayerTest {

	@Test
	public void testMarquer() {

		String result = "jamal 15 - 0 Hervy";
		Player player1 = new Player("jamal");
		Player player2 = new Player("Hervy");
		new Game(player1, player2);
		Assert.assertEquals(result, player1.marquer());
	}

	@Test(expected = NullPointerException.class)
	public void testMarquerNullGame() {

		String result = "jamal 15 - 0 Hervy";
		Player player1 = new Player("jamal");
		Player player2 = new Player("Hervy");
		player1.marquer();
	}

}
