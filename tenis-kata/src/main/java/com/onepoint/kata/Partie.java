package com.onepoint.kata;

/**
 * 
 * @author Jamal EL BOUROUMI
 *
 */

public class Partie {

	private int scorePartiePlayer1;
	private int scorePartiePlayer2;
	private boolean deuce = false;
	private boolean tieBreak = false;

	/**
	 * permet d'incrementer le score du joueur dont l'indice est passé en parametre
	 * renvoie l'indice du joueur gagnant et 3 le cas echeant
	 * 
	 * @param indiceDuJoureur
	 * @return
	 */
	public int incrementScore(int indiceDuJoureur) {

		switch (indiceDuJoureur) {
		case 1:
			incrementScorePlayer1();
			break;
		case 2:
			incrementScorePlayer2();
			break;
		}

		return gagnantPartie();
	}

	/**
	 * permet d'incrementer le score du joueur 2
	 */
	private void incrementScorePlayer2() {

		if (isDeuce())
			scorePartiePlayer2 = scorePartiePlayer1 == 4 ? scorePartiePlayer1-- : ++scorePartiePlayer2;
		else {
			scorePartiePlayer2++;
			activeDeuce();
		}
	}

	/**
	 * permet d'incrementer le score du joueur 1
	 */
	private void incrementScorePlayer1() {
		if (isDeuce())
			scorePartiePlayer1 = scorePartiePlayer2 == 4 ? scorePartiePlayer2-- : ++scorePartiePlayer1;
		else {
			scorePartiePlayer1++;
			activeDeuce();
		}
	}

	/**
	 * permet d'activer le mode DEUCE
	 * 
	 * @return
	 */
	public boolean activeDeuce() {
		if (!isTieBreak())// s'il ne sont pas dans teiBreak
			if (scorePartiePlayer1 >= 3 && scorePartiePlayer2 >= 3)
				deuce = true;
		return deuce;
	}

	/**
	 * permet de renvoyer l'indice du joueur gagnant de cette partie et 3 le cas echeant
	 * 
	 * @return
	 */
	public int gagnantPartie() {
		if (isTieBreak())
			return ruleTeiBreak();
		else {
			if (scorePartiePlayer1 >= 4 && (scorePartiePlayer1 - scorePartiePlayer2) > 1)
				return 1;
			if (scorePartiePlayer2 >= 4 && (scorePartiePlayer2 - scorePartiePlayer1) > 1)
				return 2;

			return 3;
		}
	}

	/**
	 * permet d'appliquer le calcul du gagnat si le mode tei-break est activé
	 * 
	 * @return
	 */
	private int ruleTeiBreak() {
		if (scorePartiePlayer1 > 6 && (scorePartiePlayer1 - scorePartiePlayer2) > 1)
			return 1;
		if (scorePartiePlayer2 > 6 && (scorePartiePlayer2 - scorePartiePlayer1) > 1)
			return 2;
		return 3;
	}

	/**
	 * revoie le score a partir d'un int 0-->0, 1-->15,2-->30,3-->40,4-->ADV, autre
	 * --> Numero Invalid
	 * 
	 * @param score
	 * @return
	 */

	public String scoreIntToString(int score) {
		if (scorePartiePlayer1 == scorePartiePlayer2 && isDeuce())
			return "DAUCE'";
		switch (score) {
		case 0:
			return "0";
		case 1:
			return "15";
		case 2:
			return "30";
		case 3:
			return "40";
		case 4:
			return "ADV";
		default:
			return "Numero Invalid";
		}
	}

	public int getScorePlayer1() {
		return scorePartiePlayer1;
	}

	public void setScorePlayer1(int scorePlayer1) {
		this.scorePartiePlayer1 = scorePlayer1;
	}

	public int getScorePlayer2() {
		return scorePartiePlayer2;
	}

	public void setScorePlayer2(int scorePlayer2) {
		this.scorePartiePlayer2 = scorePlayer2;
	}

	public boolean isDeuce() {
		return deuce;
	}

	public void setDeuce(boolean deuce) {
		this.deuce = deuce;
	}

	public int getScorePartiePlayer1() {
		return scorePartiePlayer1;
	}

	public void setScorePartiePlayer1(int scorePartiePlayer1) {
		this.scorePartiePlayer1 = scorePartiePlayer1;
	}

	public int getScorePartiePlayer2() {
		return scorePartiePlayer2;
	}

	public void setScorePartiePlayer2(int scorePartiePlayer2) {
		this.scorePartiePlayer2 = scorePartiePlayer2;
	}

	public boolean isTieBreak() {
		return tieBreak;
	}

	public void setTieBreak(boolean tieBreak) {
		this.tieBreak = tieBreak;
	}
	

}
