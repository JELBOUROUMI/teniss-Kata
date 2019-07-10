package com.onepoint.kata;

import java.util.List;
/**
 * 
 * @author Jamal EL BOUROUMI
 *
 */


public class Player {

	private List<Game> games;
	private Game currentGame;
	private String nom;
	private int numero;
	/**
	 * permet de marquer un point
	 * return le resultat apres ce point 
	 * @return
	 */

	public String marquer() {
		return currentGame.playerMarque(numero);
	}

	public Player() {

	}

	public Player(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public Game getCurrentGame() {
		return currentGame;
	}

	public void setCurrentGame(Game currentGame) {
		this.currentGame = currentGame;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	

}
