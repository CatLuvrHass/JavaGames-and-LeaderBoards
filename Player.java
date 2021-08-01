package final_project;

import java.io.Serializable;

public class Player implements Serializable, Comparable<Player> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String name;
	protected int score=0;
	
	// Construct a default player object
	public Player() {
		this("Player_name");
	}
	
	// Construct a player object with the specified name 
	//  and score
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score += score;
	}
	@Override
	public String toString() {
		return this.name +"\t:\t" + this.score;
	}
	
	public int compareTo(Player o) {
		if (this.getScore() > o.getScore()) {
			return 1;
		} else if (this.getScore() < o.getScore()) {
			return -1;
		} else {
			return 0;
		}
	}
	
}
