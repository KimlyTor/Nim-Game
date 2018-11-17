/*****************************************
 * A template for a computer Nim player
 * 
 * @author ktkay
 ****************************************/ 
import java.util.Scanner;
public class Computer{
  
    private int choice;
    private int mode;
    private int marbLeft;
 
    public Computer(int m){
        mode = m;
        choice = -1;
    }
  
    public void move(int marblesLeft){
      int randomPile;
      //stupid mode
      //Random legal move 1 or n/2
      if(mode==1){//stupid goes first
        randomPile= (int)(Math.random()*100-10+1)+10;//random pile
        System.out.println("The pile size:" + randomPile); 
          choice = (int)(Math.random()* randomPile*0.5)+1;//random choice 1 to n/2
          System.out.println ("Amount of marbles picked:"+ choice + "marble(S)");  
          marbLeft = randomPile - choice;//find marbles left
          System.out.println("Amount of marbles left:"+ marbLeft+ "marble(s)");
        }
        
      //smart mode
      //make the marbleleft= (2^n)-1
      //if the mableleft is already equal to (2^n)-1, go to stupid mode
      if(mode==2){//smart mode goes first
        randomPile= (int)(Math.random()*100-10+1)+10;// random pile
        System.out.println("The pile size :" + randomPile); 
        double desirePile;
        double n;
        n = Math.floor(Math.log(randomPile)/Math.log(2));
        desirePile= Math.pow(2,n)-1;//find desire pile
        int intDesire = (int)Math.round(desirePile);//convert double to int
        if (!(randomPile==desirePile)&& desirePile<=100){
          choice = randomPile - intDesire;//find choice
          System.out.println ("Amount of marbles picked:"+ choice+ "marble(S)");
          }
        marbLeft = randomPile - choice;// find marbles left 
        System.out.println("Amount of marbles left:"+ marbLeft+ "marble(s)");
        if (randomPile==desirePile){
          mode =1;
          }
        }
      }//end of method
    
    public void stupidComp(){ //method after first player moved; stupid mode
      choice = (int)(Math.random()* marbLeft*0.5)+1;//random choice 1 to n/2
      System.out.println ("Amount of marbles picked:"+ choice + "marble(S)");  
      marbLeft = marbLeft - choice;//find marblesLeft
      System.out.println("Amount of marbles left:"+ marbLeft+ "marble(s)");
      }//end of method
    
    public void smartComp(){//method after first player moved; smart mode
      double desirePile;
      double n;
      n = Math.floor(Math.log(marbLeft)/Math.log(2));
      desirePile= Math.pow(2,n)-1;//find desire pile
      int intDesire = (int)Math.round(desirePile);//convert double to int
      if (!(marbLeft==desirePile)&& desirePile<=100){
        choice = marbLeft - intDesire;//find choice
        System.out.println ("Amount of marbles picked:"+ choice+ "marble(S)");
        }
      marbLeft = marbLeft - choice;//find marbles left
      System.out.println("Amount of marbles left:"+ marbLeft+ "marble(s)");
      }//end of method
    
    public void humanMove(){//method moves after first player moved; human
      Scanner input = new Scanner(System.in);
      System.out.println("How many marbles do you want to pick?");
      choice = input.nextInt();
      while(choice<1 || choice>marbLeft/2){// generate errors for invalid input
        System.out.println("Error. Please re-enter a valid value");
        choice = input.nextInt();
        }
        System.out.println ("You pick:"+ choice + "marble(S)");
        marbLeft = marbLeft - choice;// find marbles left
        System.out.println("Amount of marbles left:"+ marbLeft+ "marble(s)");
        }   
    
    public int getChoice(){
      return choice;
      }
    public int getMarbLeft(){
      return marbLeft;
      }//end of method
}//end of class

