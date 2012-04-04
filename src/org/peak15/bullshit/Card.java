package org.peak15.bullshit;

/**
 * Represents a playing card.
 */
public class Card {
	/**
	 * Construct an empty card.
	 */
	public Card() {
		// :D
	}
	
	/**
	 * Construct a specific card.
	 * @param rank Rank of card.
	 * @param suit Suit of card.
	 */
	public Card(String rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	/**
	 * Rank of the card.
	 */
	public String rank;
	
	/**
	 * Suit of the card.
	 */
	public String suit;
}
