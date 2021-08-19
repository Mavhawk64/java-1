
/**
 * Write a description of class CrossWord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrossWord
{
    public static void main (String [] args)
    {
        int [][] x = new int [3][3];
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                x[i][j] = j+i;
                System.out.print(x[i][j]);
            }
            System.out.println();
        }
        
    }
}
