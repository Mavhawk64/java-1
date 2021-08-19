import java.util.*;
/**
 * Write a description of class TestyThingy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestyThingy
{
    static boolean[][] thingsThatMatter = {
            {true, true, true},
            {false, true, false},
            {true, true, true}
        };
        
    static ArrayList<Integer> totals = new ArrayList<Integer>();

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<int[]> n = new ArrayList<int[]>();
        while(input.hasNextLine()){
            n.add(createArray(input.nextLine().trim()));
        }
        int[][] returnMe = new int[n.size()][];
        for(int i=0; i<n.size(); i++){
            returnMe[i] = n.get(i);
        }
        dumbbellTotals(returnMe, 0, 0);
        int maximumNumber = 0;
        for(int i=0; i<totals.size(); i++){
            if(maximumNumber < totals.get(i)){
                maximumNumber = totals.get(i);
            }
        }
        
        System.out.println(maximumNumber);
    }

    public static int[] createArray(String x){
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(x.indexOf(" ") != -1){
            list.add(Integer.parseInt(x.substring(0, x.indexOf(" "))));
            x = x.substring(x.indexOf(" ")+1, x.length());
        }
        list.add(Integer.parseInt(x.substring(0, x.length())));
        int[] returnMe = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            returnMe[i] = list.get(i);
        }
        return returnMe;
    }

    /** Assumes input is 3 by 3 */
    public static int addDumbbell(int[][] x){
        int total = 0;
        for(int i=0; i<x.length; i++){
            for(int j=0; j<x[i].length; j++){
                if(thingsThatMatter[i][j]){
                    total+=x[i][j];
                }
            }
        }
        return total;
    }

    public static int dumbbellTotals(int[][] x, int minX, int minY){
        if(minX + 3 >= x.length){
            return 0;
        }
        if(minY + 3 >= x[0].length){
            return dumbbellTotals(x, minX+1, 0);
        }
        int[][] list = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                list[i][j] = x[minX + i][minY + j];
            }
        }
        totals.add(addDumbbell(list));
        return dumbbellTotals(x, minX, minY+1);
    }
}
