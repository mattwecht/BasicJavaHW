/*
 Matt Wecht
HW 3
user inputs initial amount of money and program shows them how much it would 
grow over years, months, and days
 */
package wechthw3;
import java.util.*;
public class WechtHW3 {

    public static void main(String[] args) {
        double AmountYear;
        double AmountDay = 0;
        double interestRate;
        int years = 0;
        int runtime = 0;
        
        System.out.println("Hello! \nPlease type integer value for how much money to put in:");
        Scanner keyboard = new Scanner(System.in);
        double AmountMonth = keyboard.nextDouble();//grabs starting value
        AmountYear = AmountDay = AmountMonth;//makes all starting values the same
        
        System.out.println("What is the predicted interest rate? please type just the number. ");
        System.out.println("example: .05 would be 5%");
        interestRate = keyboard.nextDouble();//grabs user interest rate
        
        System.out.println("How many years will you leave the money?");
        runtime = keyboard.nextInt();//grabs how many years to run
        
        System.out.println(" Year  |Yearly   |Monthly  |Daily    |");//chart header
       
        while (years < runtime){ //runs for as many years as they type
            AmountYear += AmountYear * interestRate;//finds new amount after one year
            for (int month =1; month<= 12; month++)//finds new amount if calculated 12 times a year
                AmountMonth+= AmountMonth * (interestRate/12.0);
            for (int day = 0; day < 365; day++)//finds new amount if calculated 365 times a year
                AmountDay += AmountDay * (interestRate/365.0);
            System.out.format("|%6d|$%.2f|$%.2f|$%.2f|\n", years+1,AmountYear, AmountMonth, AmountDay);
            years++;//goes to next year
        }
        
    }
    
}
