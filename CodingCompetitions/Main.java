import java.util.*;
/*
 * Inputs:
 * 
2
3
5
Jeffery Jefferson
Uther Pendragon
Theodore Roosevelt
Anny Skywalker
Jack Black
1
6
Gunther Anderson
Viviane Banderson
Morgaine Canderson
Mordred Danderson
Dandilion Rex
King Johan
 */
public class Main
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<String>();
        while(scan.hasNextLine())
        {
            inputs.add(scan.nextLine().trim());
        }
        int n = Integer.parseInt(inputs.get(0));
        inputs.remove(0);
        getVals(inputs, n);
    }

    public static void getVals(ArrayList<String> inputs, int n)
    {
        int m  = Integer.parseInt(inputs.get(0)); //Rooms open
        inputs.remove(0);
        int x = Integer.parseInt(inputs.get(0));
        inputs.remove(0);
        String [] names = new String[x];
        for(int i = 0; i < x; i++)
        {
            names[i] = inputs.get(i);
        }
        char [] l = getChars(inputs, x);
        int [] small = getSmaller(l, x);
        boolean swap = true;
        while(swap)
        {
            swap = false;
            for(int i = 0; i < small.length-1; i++)
            {
                if(small[i] < small[i+1])
                {
                    String tempS = names[i];
                    names[i] = names[i+1];
                    names[i+1] = tempS;
                    int tempI = small[i];
                    small[i] = small[i+1];
                    small[i+1] = tempI;
                    swap = true;
                }
                i++;
            }
        }
        for(int i = 0; i < x; i++)
            inputs.remove(0);
        System.out.println(names[m+1]);
        n--;
        if(n > 0)
            getVals(inputs, n);
    }

    public static int [] getSmaller(char [] l, int x)
    {
        int [] f = new int[x];
        int k = 0;
        for(int i = 0; i < l.length-1; i++)
        {
            if((int)l[i] <= (int)l[i+1])
            {
                f[k] = l[i];
                k++;
            }
            i++;
        }
        return f;
    }

    public static char[] getChars(ArrayList <String> inputs, int x)
    {
        char [] y = new char[x*2];
        for(int i = 0; i < x; i++)
        {
            String temp = inputs.get(i);
            for(int j = 0; j < temp.length(); j++)
            {
                if(j == 0)
                    y[j] = temp.charAt(j);
                else if(temp.charAt(j-1) == ' ')
                    y[j] = temp.charAt(j);
            }
        }
        return y;
    }
}
