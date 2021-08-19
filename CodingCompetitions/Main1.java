import java.util.*;
/**
 * Write a description of class Main1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main1
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<String>();
        while(scan.hasNextLine())
        {
            inputs.add(scan.nextLine().trim());
        }
        int x = Integer.parseInt(inputs.get(0));
        int[] convertedValues = new int[x];
        for(int p = 1; p <= x; p++)
        {
            //String input = (new Scanner(System.in)).nextLine().trim();
            int base = Integer.parseInt(inputs.get(p).substring(0, inputs.get(p).indexOf(" ")));
            char [] num = (inputs.get(p).substring(inputs.get(p).indexOf(" ")+1, inputs.get(p).length())).toCharArray();
            int converted = 0;
            int [] vals = new int[num.length];
            for(int i=0; i<num.length; i++){
                vals[i] = (int)num[i] -48;
            }

            for(int i = 1; i<=vals.length; i++)
            {
                converted += vals[vals.length-i] * Math.pow(base, i-1);
            }
            convertedValues[p-1] = converted;
        }
        for(int k = 0; k < x; k++){
            System.out.println(convertedValues[k]);
        }
    }
}
