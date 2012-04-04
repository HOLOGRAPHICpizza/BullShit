package org.peak15.bullshit;

import java.util.HashMap;
import java.util.Map;
import org.peak15.stringserver.Connection;
import org.peak15.stringserver.Listener;

public class BSListener implements Listener {
	// Are we in lobby or game mode?
	private boolean gameMode = false;
	
	// Players sorted by connection.
	private Map<Connection, Player> players = new HashMap<Connection, Player>();
	
	private Deck deck;
	private Connection currentTurn;
	private String currentRank;
	
	
	@Override
	public void connected(Connection connection) {
		if(!gameMode) {
			// We are in the lobby, greet them.
			connection.send("Welcome to the " + BullShit.configuration.getProperty("name") + "!\n");
			connection.send("What is your name? ");
			connection.comment = "NAME";
		}
		else {
			// Game is in progress, they will spectate.
			//TODO: Add spectator mode.
			connection.send("SPECTATOR MODE!!!");
		}
	}

	@Override
	public void disconnected(Connection connection) {
		// :D

	}

	@Override
	public void received(Connection connection, String string) {
		// Player just told us their name, add them to the game if we are in lobby.
		if(connection.comment.equals("NAME")) {
			if(!gameMode) {
				Player ply = new Player(string, connection);
				players.put(connection, ply);
				
				connection.send("Say READY when you are ready to start!\n");
				connection.comment = "READY";
				
				BullShit.server.sendToAll("\n" + ply.getName() + " has joined the game!\n");
				System.out.println(ply.getName() + " has joined the game.");
			}
			else {
				// Condemn them to spectator mode!
				//TODO: Spectator mode.
				connection.send("SPECTATOR MODE!!!");
			}
		}
		// Player is responding to a ready request.
		else if(connection.comment.equals("READY")) {
			if(string.equals("READY")) {
				Player ply = players.get(connection);
				ply.ready = true;
				BullShit.server.sendToAllExcept(connection.id, "\n" + ply.getName() + " is ready!\n");
				System.out.println(ply.getName() + " is ready.");
				
				if(allAreReady()) {
					gameMode = true;
					// Begin game mode!
					System.out.println("Game mode has began.");
					BullShit.server.sendToAll("\nThe game has started!\n");
					
					deck = Deck.getStandardDeck();
					deck.shuffle();
					
					// Distribute the cards
					for(Player pl : players.values()) {
						pl.hand.list = deck.list.subList(0, (52/players.size())-1);
					}
					
					currentTurn = getNextConnection();
					currentRank = "A";
					
					BullShit.server.sendToAll("It is now " + players.get(currentTurn) + "'s turn! The rank is: " + currentRank + "\n");
					System.out.println("It is now " + players.get(currentTurn) + "'s turn. The rank is: " + currentRank + "\n");
					
					// Show the person their deck.
				}
			}
		}
	}
	
	private Connection getNextConnection() {
		for(Connection c : players.keySet()) {
			if(!players.get(c).chosen) {
				players.get(c).chosen = true;
				return c;
			}
		}
		
		// They have all been chosen. Clear and try again.
		for(Player p : players.values()) {
			p.chosen = false;
		}
		return getNextConnection();
	}
	
	private boolean allAreReady() {
		for(Player ply : players.values()) {
			if(!ply.ready)
				return false;
		}
		return true;
	}
}
