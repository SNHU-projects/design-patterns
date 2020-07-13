package com.gamingroom;

import java.util.ArrayList;
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
	 * @return the id
	 */
	public long getId() {
		return super.getId();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return super.getName();
	}

	@Override
	public String toString() {

		return "Team [id=" + super.getId() + ", name=" + super.getName() + "]";
	}
}
