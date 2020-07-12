package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

    // Create private var to track existence of GameService
    private static GameService newGameService;

    // Default constructor
    private GameService() {

    }

    /**
     * Check for existing instance of GameService
     * @return
     */
	public static GameService getNewGameService() {

        // Does GameService exist?
	    if (newGameService == null) {
            // If not, create a new instance in heap memory
	        newGameService = new GameService();
	        System.out.println("New Game Service created.");
        } else {
            // If it already exists, just let us know
            System.out.println("Game Service already instantiated.");
        }

        // Return new or existing, but only the single instance
        return newGameService;
    }


	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

        // Instance iterator of type Game
        Iterator<Game> gamesIterator = games.iterator();

        // Iterate over list of games
        while (gamesIterator.hasNext()) {

            // Set local Game var to next item in list
            Game gameInstance = gamesIterator.next();

            // Does game name already exist?
            if (gameInstance.getName().equalsIgnoreCase(name)) {
                // If game name already exists, return the game instance
                return gameInstance;
            }
        }

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

        // Instance iterator
        Iterator <Game> gamesIterator = games.iterator();

        // Iterate over list of games
        while (gamesIterator.hasNext()) {

            // Set local Game var to next item in list
            Game gameInstance = gamesIterator.next();

            // Does game id already exist?
            if (gameInstance.getId() == id) {
                // If game id already exists, return the game instance
                return gameInstance;
            }
        }


		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

        // Instance iterator
        Iterator<Game> gamesIterator = games.iterator();

        // Iterate over games list
        while (gamesIterator.hasNext()) {

            // Set local Game var to next item in list
            Game gameInstance = gamesIterator.next();

            // Does game name already exist?
            if (gameInstance.getName().equalsIgnoreCase(name)) {
                // If game name already exists, return the game instance
                game = gameInstance;
            }
        }

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
