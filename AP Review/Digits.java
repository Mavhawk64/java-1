import java.util.*;
/**
 * Write a description of class Digits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Digits
{
    private ArrayList<Integer> digitList;
    Digits(int c)
    {
        digitList = new ArrayList<Integer>();
        /**Integer cu = (Integer)c;
        char [] cup = cu.toString().toCharArray();
        Integer g;
        for(int i = 0; i < cup.length; i++)
        {
        g = (Integer)(Integer.valueOf(cup[i]));
        //digitList.add(g);
        System.out.println(g);
        }
        //System.out.println(digitList);
         */
        int amt = String.valueOf(c).length();
        //System.out.println(amt);
        for(int i = 0; i < amt; i++)
        {
            /**String x = Integer.toString(c);
            x = x.substring(i, i+1);
            Integer y = new Integer(x);
            digitList.add(y);*/ //This works, but under is all in one line
            digitList.add(Integer.valueOf((Integer.toString(c)).substring(i, i+1)));
        }
        //System.out.println(digitList);
    }

    public boolean isStrictlyIncreasing()
    {
        boolean n = false;
        for(int i = 0; i < digitList.size(); i++)
        {
            if(i == digitList.size() - 1)
                n = true;
            else if(digitList.get(i) > digitList.get(i + 1))
            {
                n = false;
                break;
            }
            else
                n = true;   
        }
        return n;
    }

    public static void main (String [] args)
    {
        /**Testing*/
        //  String x = "3";
        // Integer y = new Integer(x);
        //  System.out.println(Integer.valueOf(x));
        Digits d1 = new Digits(15704);
        d1.isStrictlyIncreasing();
    }
}
