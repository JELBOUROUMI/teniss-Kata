package com.onepoint.kata;

import java.util.ArrayList;

import java.util.List;

/**
 * 
 * @author Jamal EL BOUROUMI
 *
 */

public class Game {


	private Player player1;
	private Player player2;
	private List<Partie> parties;
	private Partie currentpartie;
	private int scoreGamePlayer1;
	private int scoreGamePlayer2;
	private boolean terminee = false;

	public Game(Player player1, Player player2) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.player1.setNumero(1);
		this.player2.setNumero(2);
		this.player1.setCurrentGame(this);
		this.player2.setCurrentGame(this);
		parties = new ArrayList<Partie>();
		currentpartie = new Partie();
	}

	/**
	 * permet de marquer un point du joueur dont l'indice est passé en parametres
	 * return le resultat apres ce point
	 * 
	 * @param indicedujour
	 * @return
	 */
	public String playerMarque(int indicedujour) {
		if (isTerminee())
			return "GAME OVER";
		int result = currentpartie.incrementScore(indicedujour);
		if (result != 3) {
			parties.add(currentpartie);
			currentpartie = new Partie();
			incrementScoreGame(result);
			return getScoreGame();
		}
		return getScoreCurentPartie();
	}

	/**
	 * permet d'incrementer le score du jeu (nombre de parties gagné) du joueur
	 * passe en parametre
	 * 
	 * @param indiceDuJoureur
	 */
	private void incrementScoreGame(int indiceDuJoureur) {
		
		if(indiceDuJoureur == 1) {
			incrementScoreGamePlayer1();
	
		}
		else {
			if(indiceDuJoureur == 2) {
				incrementScoreGamePlayer2();

			}
		}
	}

	/**
	 * permet d'incrementer le score du match du joueur 2
	 */
	private void incrementScoreGamePlayer2() {
		scoreGamePlayer2++;
		gagnantGame();

	}

	/**
	 * permet d'incrementer le score du match du joueur 1
	 */
	private void incrementScoreGamePlayer1() {
		scoreGamePlayer1++;
		gagnantGame();
	}

	/**
	 * permet de renvoyer l'indice du joueur gagnant de ce match et 3 le cas echeant
	 * 
	 * @return
	 */
	public int gagnantGame() {
		int gagnant = 3;
		if (scoreGamePlayer1 == scoreGamePlayer2 && scoreGamePlayer2 == 6)
			currentpartie.setTieBreak(true);
		if (scoreGamePlayer1 == 6 && (scoreGamePlayer1 - scoreGamePlayer2) > 1 || scoreGamePlayer1 == 7)
			gagnant = 1;
		if (scoreGamePlayer2 == 6 && (scoreGamePlayer2 - scoreGamePlayer1) > 1 || scoreGamePlayer2 == 7)
			gagnant = 2;

		if (gagnant < 3)
			terminee = true;
		return gagnant;
	}
	/**
	 * permet de renvoyer le resultat du partie en cours
	 * @return
	 */

	public String getScoreCurentPartie() {
		StringBuilder builder = new StringBuilder();
		builder.append(player1.getNom() + " ");
		builder.append(currentpartie.scoreIntToString(currentpartie.getScorePartiePlayer1()));
		builder.append(" - ");
		builder.append(currentpartie.scoreIntToString(currentpartie.getScorePartiePlayer2()));
		builder.append(" " + player2.getNom());
		return builder.toString();
	}
	/**
	 * permet de renvoyer le resultat du match
	 * @return
	 */

	public String getScoreGame() {
		StringBuilder builder = new StringBuilder();
		builder.append(player1.getNom() + " ");
		builder.append(scoreGamePlayer1);
		builder.append(" - ");
		builder.append(scoreGamePlayer2);
		builder.append(" " + player2.getNom());
		return builder.toString();
	}


	public Partie getCurrentpartie() {
		return currentpartie;
	}

	public void setCurrentpartie(Partie currentpartie) {
		this.currentpartie = currentpartie;
	}


	public void setScoreGamePlayer1(int scoreGamePlayer1) {
		this.scoreGamePlayer1 = scoreGamePlayer1;
	}


	public void setScoreGamePlayer2(int scoreGamePlayer2) {
		this.scoreGamePlayer2 = scoreGamePlayer2;
	}

	public boolean isTerminee() {
		return terminee;
	}

	public void setTerminee(boolean terminee) {
		this.terminee = terminee;
	}


	
}