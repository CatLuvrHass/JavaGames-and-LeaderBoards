package final_project;

import java.util.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int loop = 0;
		String choice = "";

		Player player = null;
		
		while (loop==0) {
			in = new Scanner(System.in);
			System.out.println("Enter number 1 or 2 please");
			System.out.print("1. New Player \n2. Quit\n");
			
		  	String input = in.next();
		  	choice = input.toUpperCase();
			if(choice.equals("1") || choice.equals("2")) {
				
				if(choice.equals("1")) {
		            System.out.print("Enter Player Name\n");
		            String playerName = in.next();
		            if (playerName.length()>5) {
		                player = new VIPPlayer(playerName);
		            } else {
		                player = new Player(playerName);
		            }
		        }
		        
		        // exit option
		        else if (choice.equals("2")){
		        	System.out.println("You're out of the game");
		        	System.exit(0);
		        }
				loop = 1;
			}else
				System.out.println("you entered the wrong number! \nPlease try again... \n");
			
		}
		//welcome and give the game choices
        System.out.println("Hello "+player.getName()
  		+". Please choose a game, or -1 to Quit: ");
        //System.out.print("1. Coin flip \n2. Rock Paper Scissors\n-1. Quit\n");
        
		while (true) {
			System.out.print("1. Coin flip \n2. Rock Paper Scissors\n-1. Quit to leader board\n");
			
			String gameChoice = in.next();
			gameChoice = gameChoice.toUpperCase();
			if(gameChoice.equals("1")) {
					Cointoss game1 = new Cointoss(player);
					game1.startGame(); // starts coin toss
			} else if (gameChoice.equals("2")) {
					RockPaperScissors game2 = new RockPaperScissors(player);
					game2.startGame(); // starts rock paper scissors

			} else if (gameChoice.equals("-1")) {
					break;
			
			}else {
				System.out.println("Input must be 1, 2, -1");
			}
			
		}
		in.close();
		
		// create a list for leaders of the board
		ArrayList<Player> leaders = new ArrayList<Player>();
		// append the player to the list
		leaders.add(player);
		
		// create a txt
		String file = "leaderboard.txt";
		try {
			FileInputStream fi = new FileInputStream(new File(file));
		    ObjectInputStream oi = new ObjectInputStream(fi);
		    Player playerFile = (Player) oi.readObject();
		    
		    // read objects in the file of player object
		    while (playerFile != null) {
		    	leaders.add(playerFile);
		    	if (fi.available() != 0) {
		    		playerFile = (Player) oi.readObject();
		    	} else {
		    		break;
		    	}
		    }
		    
		    oi.close();
		    fi.close();
		    
		    try {	
			    FileOutputStream f = new FileOutputStream(new File(file));
			    ObjectOutputStream o = new ObjectOutputStream(f);
			
			    // Write objects to file from the list of leaders when there is more than 3 players
			    for (int i = 0; i < leaders.size(); i++) {
			        o.writeObject(leaders.get(i));
				}
			    
			    o.close();
			    f.close();
			} catch (FileNotFoundException ex) {
			    System.out.println("File not found");
			} catch (IOException ex) {
			    System.out.println("Error initializing stream");
			}
		    
		} catch (FileNotFoundException e) {
		    System.out.println("File not found");
		    
		    //if there is no file or leader board populate with the first object
			try {
			    FileOutputStream f = new FileOutputStream(new File(file));
			    ObjectOutputStream o = new ObjectOutputStream(f);
			
			    // Write objects to file
			    o.writeObject(player);
			    
			    o.close();
			    f.close();
			    
			} catch (FileNotFoundException ex) {
				System.out.println("File not found");
			} catch (IOException ex) {
			    System.out.println("Error initializing stream");
			}
		} catch (IOException e) {
		    System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		} 
		
		// sort the list of players 
		Collections.sort(leaders, Collections.reverseOrder());
		displayLeaderBoard(leaders);
	
	}
	// Your displayNumbers method should go here.
	public static void displayLeaderBoard(ArrayList<Player> leaders) {
		System.out.println("***********LEADERS***********");
		System.out.println("Name\t:\t" + "Score ");
		for (int i = 0; i < leaders.size(); i++) {
			if(leaders.get(i) instanceof Player) {
				System.out.println(((Player)leaders.get(i)).toString()); 
			}
		}
		System.out.println("***********LEADERS***********");
	}
}
