package FinalReview;


public class Review
{
    //Attributes
    int PastExamQuestions;
    private String Answers;
    boolean StudyGuide;
    //Constructor
    public Review ()
    {
        PastExamQuestions = 10;
        Answers = "AAAAA";
        StudyGuide = true;
    }
    //Getters and Setters
    
    //Getter
    public String getAnswers ()
    {
        return Answers;
    }
    
    //Setter
    public void ssetAnswers (String ans)
    {
        Answers = ans;
    }
}