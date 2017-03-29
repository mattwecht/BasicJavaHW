//top level of all possible test components 
package wechthw9;

class Question {
    int points;
    int difficulty;
    int answerSpace;
    String questionText;

    //general constructor 
    public Question(int points, int difficulty, int answerSpace, String questionText) {
        this.points = points;
        this.difficulty = difficulty;
        this.answerSpace = answerSpace;
        this.questionText = questionText;
    }
    
    //default constructor 
    public Question(){
        points = 5;
        difficulty = 1;
        answerSpace = 5;
        questionText = "What is the answer to life the universe and everything?";
    }

    //prints all aspects of the string 
    public String toString() {
        return "points = " + points + ", difficulty=" + difficulty + ", answerSpace=" + answerSpace + ", questionText=" + questionText;
    }
    
    //prints the question in quiz format
    public String toQuiz(){
       String a = questionText;//sets one string as the question
       for(int i = 0; i <= answerSpace; i++)
           a += "\n";//adds one new line per answerSpace to leave room to write
       return a;
    }
    
    //prints the key for this question, which tells teachers to grade 
    public String toKey(){
        String a = this.toQuiz();
        a += "\n****Correct response needs grading**** \n";
        return a;
    }
}

class ObjectiveQuestion extends Question {
    String correctAnswer;

    //standard constructor 
    public ObjectiveQuestion(String correctAnswer, int points, int difficulty, int answerSpace, String questionText) {
        super(points, difficulty, answerSpace, questionText);
        this.correctAnswer = correctAnswer;
    }
    
    //default constructor 
    public ObjectiveQuestion(){
        this.correctAnswer = "42";
    }

    //prints the question with the correct response below
    public String toKey() {
        String a = this.toQuiz();
        a += "\nCorrect response: " + correctAnswer + "\n";
        return a; 
    }
}

class FillInTheBlankQuestion extends ObjectiveQuestion {
   
    //new default question 
    public FillInTheBlankQuestion(){
        this.questionText = "I feel        .";
        this.correctAnswer = " pretty";
    }

    //prints out key with word in the blank if blank is larger than the correct response
    public String toKey(){
        String spaces = "";
        String questionCopy= "";
        
        for(int i = 0; i< correctAnswer.length(); i++)//adds the length of the answer to a blank string
            spaces += " ";
        
        for (int i = 0; i <questionText.length(); i++)//creates copy of string
            questionCopy += questionText.charAt(i);
        
        return questionCopy.replace(spaces, correctAnswer) + "\n";  //replaces spaces with the response and returns 
    }
}

class MultipleChoiceQuestion extends ObjectiveQuestion {
    String [] possibleAnswers; 
    
    //default constructor 
    public MultipleChoiceQuestion(){
        this.possibleAnswers = new String[] {"42", "Me","Blue","I give up"};
    }
    
    //new constructor 
    public MultipleChoiceQuestion(String[] possibleAnswers, String correctAnswer, int points, int difficulty, int answerSpace, String questionText) {
        super(correctAnswer, points, difficulty, answerSpace, questionText);
        this.possibleAnswers = possibleAnswers;
    }
    
    //new print quiz
    public String toQuiz(){
       String a = questionText + "\n";//sets one string as the question
       for(int i = 0; i <= possibleAnswers.length-1; i++)
           a += "\n" + "     " + (i+1) + ": " + possibleAnswers[i];//adds one new line and possible choice 
       
       return a;
    } 
}

class Test {
    Question [] fullQuiz;//passes an array of questions into format them to a quiz or key or points value
    
    //constructor 
    public Test (Question [] fullQuiz){
        this.fullQuiz = fullQuiz;
    }
    
    //returns string of a quiz for the array passed in 
    public String toQuiz(){
        String a = "";
        for(int i =0; i <fullQuiz.length; i++)
            a += (i+1) + ": " + fullQuiz[i].toQuiz();//runs its toQuiz function
        return a;
    }
    
    //returns string of key 
    public String toKey(){
        String key = "";
        for(int i =0; i <fullQuiz.length; i++)
            key += (i+1) + ": " + fullQuiz[i].toKey();//runs its toQuiz function            
        return key;
    }
    //returns total point value
    public int totalPoints(){
        int x = 0;
        for(int i =0; i <fullQuiz.length; i++)
            x+= fullQuiz[i].points;
        return x;
    }
}