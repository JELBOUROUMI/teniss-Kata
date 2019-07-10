package com.onepoint.kata.test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.onepoint.kata.Partie;

/**
 * 
 * @author Jamal EL BOUROUMI
 *
 */

@RunWith(Parameterized.class)
public class PartieTest {
	private int scorePlayer1;
	private int scorePlayer2;
	private int indiceJoueur;
	private int joueurGagne;
	private boolean deuce;
	private int joueurGagneePartie;
	private String score;

	Partie partie;

	@Before
	public void init() {
		partie = new Partie();
	}

	public PartieTest(int scorePlayer1, int scorePlayer2, int indiceJoueur, int joueurGagne, boolean deuce,
			int joueurGagneePartie, String score) {
		super();
		this.scorePlayer1 = scorePlayer1;
		this.scorePlayer2 = scorePlayer2;
		this.indiceJoueur = indiceJoueur;
		this.joueurGagne = joueurGagne;
		this.deuce = deuce;
		this.joueurGagneePartie = joueurGagneePartie;
		this.score = score;
	}

	@Test
	public void testIncrementScore() {
		partie.setScorePartiePlayer1(scorePlayer1);
		partie.setScorePartiePlayer2(scorePlayer2);
		int result = partie.incrementScore(indiceJoueur);
		Assert.assertEquals(joueurGagne, result);
	}

	@Test
	public void testActiveDeuce() {
		partie.setScorePartiePlayer1(scorePlayer1);
		partie.setScorePartiePlayer2(scorePlayer2);
		Assert.assertEquals(new Boolean(deuce), new Boolean(partie.activeDeuce()));
	}

	@Test
	public void testGagnantPartie() {

		partie.setScorePartiePlayer1(scorePlayer1);
		partie.setScorePartiePlayer2(scorePlayer2);
		Integer result = partie.gagnantPartie();
		Assert.assertEquals(new Integer(joueurGagneePartie), result);
	}

	@Test
	public void testScoreIntToString() {

		Assert.assertEquals(score, partie.scoreIntToString(scorePlayer1));

	}

	@Parameterized.Parameters
	public static Collection<Object[]> primeNumbers() {
		return Arrays.asList(new Object[][] { { 0, 0, 1, 3, false, 3, "0" }, { 2, 3, 2, 2, false, 3, "30" },
				{ 3, 2, 1, 1, false, 3, "40" }, { 4, 2, 1, 1, false, 1, "ADV" }, { 1, 4, 2, 2, false, 2, "15" },
				{ 3, 3, 1, 3, true, 3, "40" }, { 5, 5, 1, 3, true, 3, "Numero Invalid" }

		});
	}

}
