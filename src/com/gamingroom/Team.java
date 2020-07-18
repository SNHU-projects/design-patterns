package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity{

	/**
	 * A list of the active teams
	 */
	private List<Player> players = new ArrayList<Player>();
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id, name);
	}

	/**
	 * Uses iterator pattern to find existing player with same name or
     * adds unique named player to list
	 *
	 * @param name
	 * @return Player instance
	 */
	public Player addPlayer(String name) {

		// a local teams instance
		Player player = null;

		// Instance iterator
		Iterator<Player> playersIterator = players.iterator();

		// Iterate over players list
		while (playersIterator.hasNext()) {

			// Set local Player var to next item in list
			Player playerInstance = playersIterator.next();

			// Does player name already exist?
			if (playerInstance.getName().equalsIgnoreCase(name)) {
				// If player name already exists, return the player instance
				player = playerInstance;
			} else {
				// else add the player to the players list
				players.add(player);
			}
		}

		return player;
	}

	@Override
	public String toString() {
		return "Team [id=" + super.getId() + ", name=" + super.getName() + "]";
	}
}
