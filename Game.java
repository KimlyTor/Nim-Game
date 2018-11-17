/*****************************************
 * A template for a Nim game
 * 
 * @author ktkay
 
 ****************************************/ 
import java.util.Scanner;
    
public class Game{
    private int diffi;
    private int randomPile;
    private Human humanPlayer;
    private Computer computerPlayer;
    private int randomPlayer;
    private int choice;
    
    public Game(int difficulty){
      diffi= difficulty;
      //generat random players
      randomPlayer= (int)(Math.random()*2);
      if(randomPlayer==1)//if 1, human moves first
        humanPlayer= new Human();
      if(randomPlayer==0)//if 0, computer moves first
        computerPlayer= new Computer(difficulty);
      }
    public void play(){
      //moves when human goes first and compete with stupidComp
      if (randomPlayer==1 && diffi==1){
        humanPlayer.move();//human move
        while (humanPlayer.getMarbLeft()>1){
          humanPlayer.stupidComp();//stupidComp moves
          if (humanPlayer.getMarbLeft()==1){
            System.out.println("Computer Win!");
            break;
            }
          else 
            humanPlayer.humanMove();//human moves
            if (humanPlayer.getMarbLeft()==1)
              System.out.println("You Win!"); 
          }
        }
      //moves when human goes first and compete with smartComp
      if (randomPlayer==1 && diffi==2){
         humanPlayer.move();//Human move
        while (humanPlayer.getMarbLeft()>1){
          humanPlayer.smartComp();//smartComp moves
          if (humanPlayer.getMarbLeft()==1){
            System.out.println("Computer Win!");
            break;
            }
          else 
            humanPlayer.humanMove();//human move
            if (humanPlayer.getMarbLeft()==1)
              System.out.println("You Win!"); 
          }
        }
      //moves when stupidComp goes first 
      if (randomPlayer==0 && diffi==1){
        computerPlayer.move(1);//stupidComp move
        while (computerPlayer.getMarbLeft()>1){
          computerPlayer.humanMove();//human move
          if (computerPlayer.getMarbLeft()==1){
            System.out.println("You Win!");
            break;
            }
          else
            computerPlayer.stupidComp();//stupidComp move
            if (computerPlayer.getMarbLeft()==1)
            System.out.println("Computer Win!");
          }
        }
      //moves when smartComp goes first
      if (randomPlayer==0 && diffi==2){
        computerPlayer.move(2);//smartComp move
        while (computerPlayer.getMarbLeft()>1){
          computerPlayer.humanMove();//human move
          if (computerPlayer.getMarbLeft()==1){
            System.out.println("You Win!");
            break;
            } 
          else
            computerPlayer.smartComp();//smartComp move
            if (computerPlayer.getMarbLeft()==1)
            System.out.println("Computer Win!");
          }
        }
  
      }//end of play
        
}//end of class
    



