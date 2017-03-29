/*
Matthew Wecht HW 4
String tester 
User inputs string and it goes through several tests
 */
package wechthw4;
import java.util.*;
public class WechtHW4 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner (System.in);
        int counter= 0;
        char letter= 'f';
        
        System.out.println("Please type a word:");
        String input = keyboard.next();//creates user input string 
        
        //tests how many vowles there are in the string and prints first
        
       String test = input.toUpperCase();//creates a test string that is uppercase      
       for (int i =0; i<=test.length()-1; i++){//runs for length of string and compares to all vowels
           if (test.charAt(i)=='A'|| test.charAt(i)=='E'||test.charAt(i)=='I'||test.charAt(i)=='O'||test.charAt(i)=='U'){
                counter++;
                letter = test.charAt(i);//puts vowel into a char
                if (counter == 1)//if at the first vowel than prints it
                     System.out.println("this is the first vowel: "+ letter);
           }
       }
       System.out.println("this is the last vowel: "+ letter);
       System.out.println("There are "+ counter + " vowles");
       
       //this tests for reverse value of the string
       
       test = "";//reset test 
       for (int i = input.length()-1; i>= 0; --i)//reverses the string
            test+=(input.charAt(i));//adds last letter to the test string
        
       if (test.equals(input))//tests if string is same in reverese
            System.out.println(input + " is the same in reverse");
        else
            System.out.println(input + " is not the same in reverse");
       
       //asks user for input and sees how many times that input is in the first string
       
       System.out.println("please type a string to locate in the previous string:");
       String input2 = keyboard.next();
       counter = 0;
       
        for (int i = 0; i < input.length(); i++) {//runs for length of first string
            if (input.length() - i >= input2.length()) {//runs if main string still has possibility of containing other string
                if (input.substring(i, i + input2.length()).equals(input2) && !"".equals(input2)) {//tests if it contains substring
                    counter++;
                }
            }
        }
    System.out.println("the string was found " + counter + " times.");
    }        
    }