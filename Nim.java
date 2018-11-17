/*****************************************
 * Test class for Nim game
 * 
 * @author Kimly Tor
 
 ****************************************/ 
import java.util.Scanner;

public class Nim{
    public static void main(String[] args){
        
        System.out.println("Welcome to Nim death match!");
        
        Scanner input = new Scanner(System.in);
        System.out.println("What difficulty level do you want to play 1/2?");
        int level = input.nextInt();
        Game g = new Game(level);
        g.play();
        
        System.out.println("Thanks for playing!");
    }
}
