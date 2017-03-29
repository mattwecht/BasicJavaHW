/*
Wecht HW8
Testing program 
Includes extra credit file IO
 */
package wechthw9;
import java.io.*;
import java.util.*;
public class WechtHW9 {

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter outfile = new PrintWriter (args[0]);//takes first word from command line argument as name of new file 
        ObjectiveQuestion q1 = new ObjectiveQuestion("Who Who, Who Who", 5, 5, 3, "Who are you?");//sample new question
        Question[] test2 = makeQuiz(1,1,1,1);//creates array test2 that contains one of each type of question 
        Test test1 = new Test(test2);//creates object with ^ array of chosen questions
        
        outfile.println(test1.toQuiz());    //creates a test on the file chosen at runtime
        outfile.println("\n*******************************************\n");
        outfile.println(test1.toKey());    //creates a key
        outfile.println("Total possible points: " + test1.totalPoints());//prints out total point value of test1
        outfile.println(q1.toKey());
        //outfile.close();
       
        System.out.println(test1.toQuiz());    //prints sample to screen 
        System.out.println("\n*******************************************\n");
        System.out.println(test1.toKey());    
        System.out.println("Total possible points: " + test1.totalPoints());//prints out total point value of test1
        System.out.println(q1.toKey());//prints indivudal question to demonstrate indivudal methods
        
        //reads WechtHW9Test (a test bank) to create a question. 
        Scanner in = new Scanner(new File("WechtHW9Test.text"));//creates scanner from test bank called WechtHW9Test
        Scanner kbd = new Scanner(System.in);
        int points =0;
        int difficulty = 0;
        int answerSpace = 0;
        String questionText =""; 
        String answer = "";
        System.out.println("Please type how many questions you would like to pull from the test bank. Max of 11 as of now.");
        int numQuestions =kbd.nextInt();
        Question[] test3Array = new Question[numQuestions];//new array of input size that will be filled with question bank questions 

	for(int i =0; i<numQuestions; i++) {//runs through test bank grabing questions for the new test array
            points = in.nextInt();
            difficulty = in.nextInt();
            answerSpace = in.nextInt();
            in.nextLine();
            questionText = in.nextLine();
            answer = in.nextLine();
            test3Array[i] = new ObjectiveQuestion (answer, points,difficulty,answerSpace,questionText);
	}
        Test test3 = new Test(test3Array);//creates object with ^ array of chosen questions
        System.out.println(test3.toQuiz());
        outfile.println(test3.toKey());
        System.out.println(test3.totalPoints());//prints new test/point value to screen and key to file file .
        outfile.close();
    }
    
    //method to return an array of the given number of each type of question
    //each question is the default, however they can be overwritten to include other questions 
    public static Question[] makeQuiz(int numOfquestion, int numOfobjectivequestion, int numOffillintheblankquestion, int numOfmultiplechoicequestion  ){
        int totalQuestions = numOfquestion + numOfobjectivequestion + numOffillintheblankquestion + numOfmultiplechoicequestion;//total num of questions
        Question [] test1 = new Question [totalQuestions];//array of questions 
        for(int i =0; i<=totalQuestions; i++){//runs for how many questions to be turned
            if(numOfquestion > 0){
                test1[i] = new Question();//initilizes array[0] to a default question
                numOfquestion--;//takes one question off num needed to make
            }
            else if(numOfobjectivequestion > 0){
                test1[i] = new ObjectiveQuestion();//default objective question
                numOfobjectivequestion--;
            }
            else if(numOffillintheblankquestion > 0){
                test1[i] = new FillInTheBlankQuestion();
                numOffillintheblankquestion--;
            }
            else if(numOfmultiplechoicequestion > 0){
                test1[i] = new MultipleChoiceQuestion();
                numOfmultiplechoicequestion--;
            }
        }
        return test1;
    }   
}