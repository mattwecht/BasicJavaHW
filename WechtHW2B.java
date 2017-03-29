/*
Matthew Wecht 
6/23/16
Tax calc 
 */
package wechthw2b;
import java.util.Scanner;

public class WechtHW2B {

    public static void main(String[] args) {
        double tax = 0;//declares tax
        
        System.out.println("We will now calculate your tax.");
        System.out.println("Please type your income from the previous year");
        Scanner keyboard = new Scanner (System.in);
        double income = keyboard.nextDouble();
        
        if (income <= 50000)//makes tax equal to 1% of income if anything below 50000
            tax = .01* income;
        else if (income <=75000)//2% for any amount between 50 and 75 k and adds on max amount from previous bracket 
            tax = .02 * (income - 50000) + 500;
        else if (income <=100000)
            tax = .03 * (income - 750000) + 1000;
        else if (income <= 250000)
            tax = .04 * (income - 100000) + 1750;
        else if (income <= 500000)
            tax = .05 * (income - 250000) + 7750;
        else
            tax = .06 * (income - 500000) + 20250;// if income is above any bracket uses this amount 
        
        System.out.println("this is your tax bill: " + tax); 
        System.out.println("Uncle Sam is coming, better get that checkbook");
            
    }
    
}
