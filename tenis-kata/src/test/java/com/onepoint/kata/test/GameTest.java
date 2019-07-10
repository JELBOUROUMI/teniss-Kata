package com.onepoint.kata.test;




import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.onepoint.kata.Game;
import com.onepoint.kata.Partie;
import com.onepoint.kata.Player;

/**
 * 
 * @author Jamal EL BOUROUMI
 *
 */


@RunWith(Parameterized.class)
public class GameTest {
	private boolean termine;
	private int joueur;
	private String result;
	private int scoreGamePlayer1;
	private int scoreGamePlayer2;
	private int scorePartiePlayer1;
	private int scorePartiePlayer2;
	private int gagnant;
	private String scoreGame;
	private String resultPartie;

	Game game;

	public GameTest(boolean terminee, int joueur, String result, int scoreGamePlayer1, int scoreGamePlayer2, int gagnat,
			String scoreGame, int scorePartiePlayer1, int scorePartiePlayer2, String resultPartie) {
		this.termine = terminee;
		this.joueur = joueur;
		this.result = result;
		this.scoreGamePlayer1 = scoreGamePlayer1;
		this.scoreGamePlayer2 = scoreGamePlayer2;
		this.gagnant = gagnat;
		this.scoreGame = scoreGame;
		this.scorePartiePlayer1 = scorePartiePlayer1;
		this.scorePartiePlayer2 = scorePartiePlayer2;
		this.resultPartie = resultPartie;
	}

	@Before
	public void init() {

		game = new Game(new Player("jamal"), new Player("Hervy"));

	}

	@Test
	public void testPlayerMarque() {
		game.setTerminee(termine);		
		game.setCurrentpartie(new Partie());
		Assert.assertEquals(result,  game.playerMarque(joueur));

	}

	@Test
	public void testGagnantGame() {
		game.setScoreGamePlayer1(scoreGamePlayer1);
		game.setScoreGamePlayer2(scoreGamePlayer2);
		Integer result = game.gagnantGame();
		Assert.assertEquals(result, new Integer(gagnant));
	}

	@Test
	public void testGetScoreCurentPartie() {
		game.getCurrentpartie().setScorePartiePlayer1(scorePartiePlayer1);
		game.getCurrentpartie().setScorePartiePlayer2(scorePartiePlayer2);
		String result = game.getScoreCurentPartie();
		Assert.assertEquals(resultPartie, result);
	}

	@Test
	public void testGetScoreGame() {
		game.setScoreGamePlayer1(scoreGamePlayer1);
		game.setScoreGamePlayer2(scoreGamePlayer2);
		Assert.assertEquals(scoreGame, game.getScoreGame());
	}

	@Parameterized.Parameters
	public static Collection<Object[]> primeNumbers() {
		return Arrays.asList(
				new Object[][] { { true, 1, "GAME OVER", 1, 1, 3, "jamal 1 - 1 Hervy", 1, 3, "jamal 15 - 40 Hervy" },
						{ false, 1, "jamal 15 - 0 Hervy", 6, 3, 1, "jamal 6 - 3 Hervy", 3, 3, "jamal 40 - 40 Hervy" },
						{ false, 2, "jamal 0 - 15 Hervy", 2, 6, 2, "jamal 2 - 6 Hervy", 4, 3, "jamal ADV - 40 Hervy" },
						{ false, 3, "jamal 0 - 0 Hervy", 6, 6, 3, "jamal 6 - 6 Hervy", 0, 0, "jamal 0 - 0 Hervy" }

				});
	}

}
