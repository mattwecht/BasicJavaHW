/*
Matthew Wecht
6/23/16
Tip calculator 
 */
package wechthw2a;
import java.util.Scanner;
public class WechtHW2A {

    public static void main(String[] args) {
     final double GREAT_SERVICE_TIP = .2;
     final double OK_SERVICE_TIP = .15;
     final double BAD_SERVICE_TIP = .10;
     double tip = 0;
       System.out.println("Why hello there! Could you please rate your service tonight on a scale from 1 to 3");
       System.out.println("1 means you hate it 3 means you love us and will tip well. Intergers only");
       Scanner keyboard = new Scanner(System.in);//calls scanner keyboard
       int happiness = keyboard.nextInt();
      
       System.out.println("Thanks! How many people were here?");
       
       int party = keyboard.nextInt();
       
       System.out.println("Last but not least, how much is your bill");
       
       double bill = keyboard.nextDouble();
       
       System.out.println("here is how much you should tip:");
       
       if(happiness >= 3)//if statements that gets the total tip 
           tip = GREAT_SERVICE_TIP*bill + party; //adds $1 per person and then prints total
       else if (happiness == 2)
           tip = OK_SERVICE_TIP*bill + party; 
       else
           tip = BAD_SERVICE_TIP*bill + party;//numbers above are counted as good tip, below as bad 
      
       
       System.out.println("$" + tip);
    }
    
}

