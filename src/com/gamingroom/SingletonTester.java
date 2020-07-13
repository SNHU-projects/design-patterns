package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author coce@snhu.edu
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");

		// Set a local reference to the singleton GameService instance
		GameService service = GameService.getInstance();
		
		// a simple for loop to print the games
		for (int i = 1; i <= service.getGameCount(); i++) {
			System.out.println(service.getGame(i));
		}

	}
	
}
