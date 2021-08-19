
/**
 * Write a description of class MergeSortNoHelp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MergeSortNoHelp
{
    public static void main (String [] args)
    {
        System.out.println("The Merge Sort is an algorithm that divides the list in two and \n" + 
        "each half in two, and so on until it is in units of one.");
        System.out.println("It will sort each one in that system, and compare the next system");
        //Original
        //       9 3 2 8 6 1 4 7 5 0
        //Division
        //   9 3 2 8 6         1 4 7 5 0
        // 9 3  2 8  6         1 4  7 5  0
        //9  3  2  8  6        1  4  7  5  0
        //Comparison...
        //3 9 2 8 6         1 4 5 7 0
        //3 9 2 6 8         1 4 5 0 7
        //3 9 2 6 8         1 4 0 5 7
        //2 3 9 6 8         0 1 4 5 7
        //2 3 6 8 9         0 1 4 5 7
        //
    }
}
