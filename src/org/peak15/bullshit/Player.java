package org.peak15.bullshit;

import org.peak15.stringserver.Connection;

/**
 * Represents a player in the game.
 */
public class Player {
	private String name;
	private Connection connection;
	
	/**
	 * Has the player set ready?
	 */
	public boolean ready = false;
	
	public boolean chosen = false;
	
	/**
	 * Construct a player with a given name.
	 * @param name Name to assign the player.
	 * @param connection Connection to reach the player on.
	 */
	public Player(String name, Connection connection) {
		this.name = name;
		this.connection = connection;
	}
	
	/**
	 * Get the player's name;
	 * @return The name of the player.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get the player's connection;
	 * @return The connection of the player.
	 */
	public Connection getConnection() {
		return connection;
	}
	
	/**
	 * The player's hand.
	 */
	public Deck hand = new Deck();
}
