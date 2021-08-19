package FinalReview;



public class Runner
{
    public void main (String [] args)
    {
        Review May2017Final = new Review();
        String temp = May2017Final.getAnswers();
        temp = "BBBBB";
        System.out.println(temp);
        System.out.println(May2017Final.getAnswers());
        May2017Final.setAnswers("ABCDABC");
        System.out.println(May2017Final.getAnswers());
    }
}
