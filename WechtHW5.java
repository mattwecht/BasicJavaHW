/*
Matthew Wecht
July 13

*/
package wechthw5;
import java.util.Scanner;
public class WechtHW5 {

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
     
        System.out.println("Please enter a test word:");
        String s = scan.next();
        System.out.println("Vowel is at position: "+ indexOfFirstVowel(s));
       
        System.out.println("please enter a position to start a vowel search:");
        int startPosition = scan.nextInt();
        System.out.println("vowel starting at " + startPosition + " is at: " +indexOfFirstVowel(s,startPosition));
        
        System.out.println("this is the last vowel location: "+ indexOfLastVowel(s));
       
        System.out.println("this is your string reversed: " + reversed(s));
        
        System.out.println("Your string is same in reverse: " + sameInReverse(s));
        
        System.out.println("Input a smaller string to find in first string:");
        String subString = scan.next();
        System.out.println("substring occured: "+ numOccurrences(s, subString) + " times");
        
        System.out.println("This is the string with no vowels: " + devoweled(s));
        
        System.out.println("Type a word to mix with the other word:");
        String word2 = scan.next();
        System.out.println("This is the mixed word: "+ zipped(s, word2));
        
        System.out.println("Please enter a string");
        scan.nextLine();//for some reason needed to make the next scanner work
        s = scan.nextLine();
        System.out.println("How many spaces would you like to replace each tab with? ");
        int spaces = scan.nextInt();
        System.out.println("This is the corrected string: \n" + tabToSpace(s,spaces));
    }
   
    /* returns true if c is an upper case or lower case vowel
     * or false otherwise */
    public static boolean isVowel(char c) {
        char Up = Character.toUpperCase(c);//converts to uppercase to test only once
        if(Up=='A'|| Up=='E'|| Up=='I'|| Up=='O'|| Up=='U')
            return true;
        else
            return false;
    }
    
    /* returns the index of the first vowel in s or -1
     * if s contains no vowels */
    public static int indexOfFirstVowel(String s) {
       for (int i =0; i<s.length(); i++)//runs for length of string and calls isVowel to locate first vowel 
           if(isVowel(s.charAt(i)))    
                return i;
	return -1;//runs only when if statement fails to run
    }
    
    /* returns the index of the first occurrence of a vowel
     * in s starting from index startPosition or -1 if
     * there are no vowels in s at index startPosition or later */
    public static int indexOfFirstVowel(String s, int startPosition) {
	for (int i =startPosition; i<s.length(); i++)//runs for length of string and calls isVowel to locate first vowel 
           if(isVowel(s.charAt(i)))    
                return i;
        return -1;
    }

    /* returns the index of the last occurrence of a vowel in
     * s or -1 if s contains no vowels */
    public static int indexOfLastVowel(String s) {
        for (int i =s.length()-1; i>=0; i--)//runs for length of string and calls isVowel to locate first vowel 
            if(isVowel(s.charAt(i)))    
              return i;
        return -1;//returns only if no vowel is found
    }

    /* returns s in reverse. For example, if s is "Apple", the method
     * returns the String "elppA" */
    public static String reversed(String s) {
       String test = "";
       for (int i = s.length()-1; i>= 0; --i)//reverses the string
            test+=(s.charAt(i));//adds last letter to the test string
	return test;
    }

    /* returns the number of times that n occurs
     * in h. For example, if h is "Mississippi" and n is "ss"
     * the method returns 2. */
    public static int numOccurrences(String h, String n) {
        int counter = 0;
 
        for (int i = 0; i < h.length(); i++) {//runs for length of first string
            if (h.length() - i >= n.length()) {//runs if main string still has possibility of containing other string
                if (h.substring(i, i + n.length()).equals(n) && !"".equals(n)) {//tests if it contains substring
                    counter++;
                }
            }
        }
	return counter;
    }

    /* returns true if s is the same backwards and forwards
     * and false otherwise */
    public static boolean sameInReverse(String s) {
        if (reversed(s).equals(s))//tests if string is same in reverese
            return true;
        return false;
    }

    /* returns a new String which is the same as s, but with
     * all of the vowels removed. For example, if s is "summer vacation"
     * the method returns "smmr vctn" */
    public static String devoweled(String s) {
        String string = "";//creates empty string 
        for (int i = 0; i < s.length(); i++){
            if(!isVowel(s.charAt(i)))
                string += s.charAt(i);//adds non vowel to new string
        }
	return string;
    }

    /* Returns a new string consisting of all of the characters of s1
     * and s2 interleaved with each other. For example, if s1 is
     * "Spongebob" and s2 is "Patrick", the
     * function returns the string "SPpaotnrgiecbkob" */
    public static String zipped(String s1, String s2) {
        String string ="";//empty string to be returned 
        //if string one is shorter than puts string 2 in string one so that loop can run
        if(s1.length()<s2.length()){
            string = s1;//creates extra copy of string 1
            s1 = s2; // makes s1 same as s2
            s2 = string; // puts old s1 into s2
            string = "";// resets string to blank
        }
            
        for (int i = 0; i < s1.length(); i++)
        {
            if ( i<s2.length())
                string += s2.charAt(i);//puts in char only if string is that long
            string += s1.charAt(i);
        }
	return string;
    }

    /* returns a new String consisting of all of the letters
     * of s, but where tab characters ('\t') are replaced
     * with n spaces */
    public static String tabToSpace(String s, int n) {
        String fixed = "";
        String spaces = "";
        for (int x = 0; x < n; x++)//puts n spaces in a string
            spaces += " ";
        for (int i =0; i< s.length(); i++){
            if(s.charAt(i)=='\t')//if a tab puts n spaces in new string
                fixed += spaces;
            else
                fixed += s.charAt(i);//if not tab adds to string
        }
	return fixed;
    }
}
