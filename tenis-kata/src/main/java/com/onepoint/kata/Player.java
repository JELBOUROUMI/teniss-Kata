package com.onepoint.kata;

import java.util.List;

/**
 * 
 * @author Jamal EL BOUROUMI
 *
 */


public class Player {

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


	public Player(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setCurrentGame(Game currentGame) {
		this.currentGame = currentGame;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
