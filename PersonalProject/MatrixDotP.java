import java.util.*;
/**
 * Write a description of class MatrixDotP here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MatrixDotP
{
    public static void main (String [] args)
    {
        System.out.println("How big is your matrix? rowsxcols");
        String in = (new Scanner(System.in)).nextLine();
        int r = Integer.parseInt(in.substring(0,in.indexOf("x")));
        int c = Integer.parseInt(in.substring(in.indexOf("x")+1,in.length()));
        int [][] m = new int[r][c];
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                int t = i+1;
                int t2 = j+1;
                System.out.println("Enter " + t + ", " + t2);
                m[i][j] = (new Scanner(System.in)).nextInt();
            }
        }

        for(int i = 0; i < r; i++)
        {
            System.out.print("{");
            for(int j = 0; j < c; j++)
            {
                if(j != c-1)
                System.out.print(m[i][j] + ", ");
                else
                System.out.print(m[i][j]);
            }
            System.out.println("}");
        }
    }
}
