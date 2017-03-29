/*
Matthew Wecht
HW 6 
Simple game
 */
package wechthw6;
import java.util.*;
public class WechtHW6 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice;
        int wins =0;//tracks user wins
        int rounds = 0; //tracks rounds
        System.out.println("Would you like to play a game? \"yes\" to play, anything else if your afraid of starting WW3");
        String play = scan.next();
        while (play.equalsIgnoreCase("yes")){//runs until sentinal and prints menu and takes in choice
            menu();
            choice = scan.nextInt();
            System.out.println("You picked: " + move(choice));  
           while (move(choice).equals("improper input")){//runs while user choice is invalid 
               System.out.println("Please try again.");
               menu();
               choice = scan.nextInt();
               System.out.println("You picked: " + move(choice));
           }
            wins += evaluate(choice);//prints results and adds one to wins if human wins
            rounds++;//adds one extra play to counter
            System.out.println("\nplay again? \"yes\"to play anything else to leave");
            play = scan.next();
        }
       System.out.println("Better luck next time. You played "+ rounds +" times and won "+ wins +
               " times, the computer won " + (rounds-wins) + " rounds");//prints out final results 
    }
    
    //prints game menu 
   public static void menu(){
       System.out.println("Pick a move! \n" + "Flurg beats Stuga and Kvartal" +
               "\nStuga beats Kvartal \n" + "Kvartal beats Lerberg \n" +
               "Lerberg beats Flurg and Stuga \n" + "Tie means computer wins");
       System.out.println("\nWhat shall you be? Type 1 for: Flurg, 2 for: Stuga, 3 for: Lerberg, or 4 for: Kvartal");
   }
   //uses random number to pick computers choice of move 
   public static int randomNum (){
        Random r = new Random();//set up random number 
        return r.nextInt(4)+1;//returns number 1 - 4
    }
   //takes in num 1-4 to return a move or error message 
   public static String move (int x){
       String move = "";
       switch (x){
           case 1:
               move = "Flurg";
               break;
           case 2:
               move = "Stuga";
               break;
           case 3:
               move = "Lerberg";
               break;
           case 4:
               move = "Kvartal";
               break;
           default: 
               move = "improper input";
                       
       }
       return move;
   }
   //evaluates moves and picks computer move, returns results message and 1 if user wins
   public static int evaluate (int human){
       int computer = randomNum();
       int counter =0;
       System.out.println("The computer was: " + move(computer));
       if (computer ==1 && (human == 2||human==4))
               System.out.println("Computer wins!");
       else if (computer == 2 && human ==4)
           System.out.println("Computer wins!");
       else if (computer == 3 && (human == 1 || human == 2))
           System.out.println("Computer wins!");
       else if (computer == 4 && human == 3)
           System.out.println("Computer wins!");
       else if (computer == human)
           System.out.println("Its a tie so the computer wins!");
       else {
           System.out.println("You win! This time...");
           counter ++;
       }
       return counter;
   }
}
