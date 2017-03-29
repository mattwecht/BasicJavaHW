/*
Matthew Wecht
6/20
CIS 1068
HW 1
Greetings
Grab first and last name from user input than put that together in one string
 */
package wechthw1;
import java.util.Scanner;

public class WechtHW1 {

    public static void main(String[] args) {
        System.out.println("Hi there, please type your first name:");
        Scanner scan = new Scanner(System.in);//calls scanner "scan"
        String firstname = scan.nextLine();//grabs first name from input 
        System.out.println("You did it! Congrats! Now please type your last name: ");
        String Lastname = scan.nextLine();//grabs last name from input
        
        String Name = firstname + (" ") + Lastname;//puts your name together and adds a space
        System.out.println("hello there " + Name );
        System.out.println("Or should I say: " + Lastname + ", " + Name);
        
    }
    
}
