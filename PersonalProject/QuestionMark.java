
/**
 * Write a description of class QuestionMark here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class QuestionMark
{
    public static void main ()
    {
        int [] a = {-1,-1,-1,1,-1,2,3,-1,-1,4,5};
        int count = 0;
        for(int i = 0; i < a.length; i++)
        {
            count = a[i] != -1 ? count+1 : count;
        }
        System.out.println(count);
    }
}
