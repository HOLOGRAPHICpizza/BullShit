package org.peak15.bullshit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is an ordered set of playing cards, such as a deck or hand.
 */
public class Deck {
	/**
	 * This was the last thing added to the list.
	 */
	public List<Card> lastAdded;
	
	/**
	 * This is the backing list of the deck.
	 */
	public List<Card> list = new ArrayList<Card>();
	
	/**
	 * Add a card to the list.
	 * @param card Card to add.
	 */
	public void add(Card card) {
		list.add(card);
		lastAdded = new ArrayList<Card>();
		lastAdded.add(card);
	}
	
	/**
	 * Add several cards.
	 * @param cards Cards to add.
	 */
	public void addAll(List<Card> cards) {
		list.addAll(cards);
		lastAdded = cards;
	}
	
	/**
	 * Shuffle the deck.
	 */
	public void shuffle() {
		Collections.shuffle(list);
	}
	
	/**
	 * Generates a standard playing deck.
	 * @return A standard playing deck.
	 */
	public static Deck getStandardDeck() {
		Deck newDeck = new Deck();
		newDeck.add(new Card("A", "Spades"));
		newDeck.add(new Card("A", "Hearts"));
		newDeck.add(new Card("A", "Diamonds"));
		newDeck.add(new Card("A", "Clubs"));
		newDeck.add(new Card("2", "Spades"));
		newDeck.add(new Card("2", "Hearts"));
		newDeck.add(new Card("2", "Diamonds"));
		newDeck.add(new Card("2", "Clubs"));
		newDeck.add(new Card("3", "Spades"));
		newDeck.add(new Card("3", "Hearts"));
		newDeck.add(new Card("3", "Diamonds"));
		newDeck.add(new Card("3", "Clubs"));
		newDeck.add(new Card("4", "Spades"));
		newDeck.add(new Card("4", "Hearts"));
		newDeck.add(new Card("4", "Diamonds"));
		newDeck.add(new Card("4", "Clubs"));
		newDeck.add(new Card("5", "Spades"));
		newDeck.add(new Card("5", "Hearts"));
		newDeck.add(new Card("5", "Diamonds"));
		newDeck.add(new Card("5", "Clubs"));
		newDeck.add(new Card("6", "Spades"));
		newDeck.add(new Card("6", "Hearts"));
		newDeck.add(new Card("6", "Diamonds"));
		newDeck.add(new Card("6", "Clubs"));
		newDeck.add(new Card("7", "Spades"));
		newDeck.add(new Card("7", "Hearts"));
		newDeck.add(new Card("7", "Diamonds"));
		newDeck.add(new Card("7", "Clubs"));
		newDeck.add(new Card("8", "Spades"));
		newDeck.add(new Card("8", "Hearts"));
		newDeck.add(new Card("8", "Diamonds"));
		newDeck.add(new Card("8", "Clubs"));
		newDeck.add(new Card("9", "Spades"));
		newDeck.add(new Card("9", "Hearts"));
		newDeck.add(new Card("9", "Diamonds"));
		newDeck.add(new Card("9", "Clubs"));
		newDeck.add(new Card("10", "Spades"));
		newDeck.add(new Card("10", "Hearts"));
		newDeck.add(new Card("10", "Diamonds"));
		newDeck.add(new Card("10", "Clubs"));
		newDeck.add(new Card("J", "Spades"));
		newDeck.add(new Card("J", "Hearts"));
		newDeck.add(new Card("J", "Diamonds"));
		newDeck.add(new Card("J", "Clubs"));
		newDeck.add(new Card("Q", "Spades"));
		newDeck.add(new Card("Q", "Hearts"));
		newDeck.add(new Card("Q", "Diamonds"));
		newDeck.add(new Card("Q", "Clubs"));
		newDeck.add(new Card("K", "Spades"));
		newDeck.add(new Card("K", "Hearts"));
		newDeck.add(new Card("K", "Diamonds"));
		newDeck.add(new Card("K", "Clubs"));
		return newDeck;
	}
}
