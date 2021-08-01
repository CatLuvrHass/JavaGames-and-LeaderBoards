package final_project;

import java.util.Random;
import java.util.Scanner;

public class Cointoss {
	
	public String name; // Game name
	private Player player;
	Scanner scanner = new Scanner(System.in);
	
    private enum Coin {
        Head, Tail
    };
    
    public Cointoss(Player player) {
    	this.name= "Cointoss";
    	this.player = player;
    }
    
    // Starts a coin flip game till user decides to quit.
    @SuppressWarnings("resource")
	public void startGame() { 
        Coin guess = null;
        
        while (true) {
            System.out.print("Enter you guess (0 for heads, 1 for tails, -1 to quit):");
          	Scanner in = new Scanner(System.in);
          	String input = in.next();
          	String choice = input.toUpperCase();
            
            if (choice.equals("-1")) {
            	return;
            } else if (choice.equals("0")) {
                guess = Coin.Head;
            } else if (choice.equals("1")) {
                guess = Coin.Tail;
            } else {
                System.out.println("Wrong choice! Try again!");
                continue;
            }
            
            Coin toss = tossCoin();
            if (guess == toss) {
                System.out.println("You won the toss!");
                System.out.println("Player Wins: +10 points");
                this.player.setScore(10);
            } else {
                System.out.println("You lost the toss.");
                System.out.println("Player loss: -5 points");
                this.player.setScore(-5);
            }
        }
    }
 
    // Flip a coin and return result
    private Coin tossCoin() {
        Random r = new Random();
        int i = r.nextInt(2);
        if (i == 0) {
            return Coin.Head;
        } else {
            return Coin.Tail;
        }
    }


}