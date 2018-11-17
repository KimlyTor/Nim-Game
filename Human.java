/*****************************************
 * Human Nim player
 * 
 * @author ktkay
 
 ****************************************/ 
import java.util.Scanner;

public class Human{
    
   
    private int choice;
    private Scanner input;
    private int marbLeft;
    
    public Human(){
        input=new Scanner(System.in);
        choice = -1;
        }
    public void move(){//method for first move
        //random Pile
        int randomPile;
        randomPile= (int)(Math.random()*100-10+1)+10;
        System.out.println("The pile size :" + randomPile); 
        //ask user to pick marbles
        System.out.println("How many marbles do you want to pick?");
        choice = input.nextInt();
        //generate error
        while(choice<1 || choice>randomPile/2){
          System.out.println("Error. Please re-enter a valid value");
          choice = input.nextInt(); 
          }
        System.out.println ("You pick:"+ choice + "marble(S)"); 
        //find marbles left
        marbLeft = randomPile-choice;
        System.out.println("Amount of marbles left:" + marbLeft);
        }
    
    public void humanMove(){//method after the first move; human
        System.out.println("How many marbles do you want to pick?");
        choice = input.nextInt();
        while(choice<1 || choice>marbLeft/2){//generate errors for invalid input
          System.out.println("Error. Please re-enter a valid value");
          choice = input.nextInt();
          }
          System.out.println ("You pick:"+ choice + "marble(S)");
          marbLeft = marbLeft - choice;//find marbles left
          System.out.println("Amount of marbles left:"+ marbLeft+ "marble(s)");
       }   
    
    public void stupidComp(){ //method after first move; stupid mode
      choice = (int)(Math.random()* marbLeft*0.5)+1;//random choice 1 to n/2
      System.out.println ("Amount of marbles picked:"+ choice + "marble(S)");  
      marbLeft = marbLeft - choice;//find marblesLeft
      System.out.println("Amount of marbles left:"+ marbLeft+ "marble(s)");
      }
    
     public void smartComp(){//method after first move; smart mode
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
    
   public int getChoice(){
        return choice; 
        }  
   public int getMarbLeft(){
       return marbLeft;
       }
 
}//end of class


