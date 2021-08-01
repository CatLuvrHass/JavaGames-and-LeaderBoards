package final_project;
import java.util.*;

public class RockPaperScissors {
	
	// assign the strings to game gestures.
    public static final String ROCK = "R";
    public static final String PAPER = "P";
    public static final String SCISSORS = "S";
    private Player player;
	public String name;
    
    
    public RockPaperScissors(Player player) {
    	this.name= "RockPaperScissors";
    	this.player = player;
	}
    
	@SuppressWarnings("resource")
	// Starts a rock paper scissors game till user decides to quit.
    void startGame()
    {
    	// give player the options
    	System.out.println("Enter any one of the following inputs:  ");
    	System.out.println("R - For Rock");
    	System.out.println("P - For Paper");
    	System.out.println("S - for Scissors");
    	System.out.println("Enter -1 to quit to main menu");
    	System.out.println();

      //Rules of the Game Applied Below:
      /*if both playerMove and computerMove
        produces the same formation, then 
        Game is a tie*/
  while(true) {
	  
  	Scanner in = new Scanner(System.in);
  	String input = in.next();
  	String playermove = input.toUpperCase();
  	
  	//computer input
  	String computermove;
  	Random random = new Random();
  	
  	int input1 = random.nextInt(3)+1;
  	if (input1 == 1)
	  	computermove = RockPaperScissors.ROCK;
  	else if(input1 == 2)
  		computermove = RockPaperScissors.PAPER;
  	else
  		computermove = RockPaperScissors.SCISSORS; 
  	
	if(playermove.equals("-1")) {
  	  return;
  	  
	}else if (playermove.equals(computermove)) {
  		System.out.println("Game is Tie !!");
  
  		// you are paper and they are rock
      }else if (playermove.equals(RockPaperScissors.PAPER) && computermove.equals(RockPaperScissors.ROCK)) {
    	  System.out.println("Player Wins: +10 points");
    	  this.player.setScore(10);
    	  
    	  // you are paper and they are scissors
      }else if (playermove.equals(RockPaperScissors.PAPER) && computermove.equals(RockPaperScissors.SCISSORS)) {
    	  System.out.println("Player loss: -5 points");
    	  this.player.setScore(-5);
    	  
    	  // you are rock and they are paper
      }else if (playermove.equals(RockPaperScissors.ROCK) && computermove.equals(RockPaperScissors.PAPER)) {
    	  System.out.println("Player loss: -5 points"); 
    	  this.player.setScore(-5);

    	  // you are rock and they are scissors
	  }else if (playermove.equals(RockPaperScissors.ROCK) && computermove.equals(RockPaperScissors.SCISSORS)) {
		  System.out.println("Player Wins: +10 points");
    	  this.player.setScore(10);
		  
		  // you are scissors and they are paper
	  }else if (playermove.equals(RockPaperScissors.SCISSORS) && computermove.equals(RockPaperScissors.PAPER)) {
		  System.out.println("Player Wins: +10 points");
    	  this.player.setScore(10);
		  
		  // you are scissors and they are rock
	  }else if (playermove.equals(RockPaperScissors.SCISSORS) && computermove.equals(RockPaperScissors.ROCK)) {
		  System.out.println("Player loss: -5 points");
		  this.player.setScore(-5);

      }else {
          System.out.println("Wrong choice! Try again!");
          continue;
      }
        
      }
  
    }
	
    }
