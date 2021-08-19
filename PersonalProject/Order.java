import java.util.*;
public class Order {
    public static void main ()
    {
        System.out.println(order("is2 Thi1s T4est 3a"));
    }
    
    public static String order(String words) {
        int [] a = new int[words.length()];
        boolean isEmpty = true;
        for(int i = 0; i < words.length(); i++)
        {
            a[i] = getInt(words.substring(i,i+1));
            isEmpty = isEmpty && a[i] != -1;
        }

        if(isEmpty)
            return "";

        int count = 0;
        for(int i = 0; i < a.length; i++)
        {
            count = a[i] != -1 ? count+1 : count;
        }
        System.out.println("Count: " + count);
        ArrayList<String> wordList = new ArrayList<String>();
        for(int i = 0; i < words.length(); i++)
        {
            if(words.substring(i,i+1).equals(" "))
            {
                if(wordList.size() != 0)
                    wordList.add(words.substring(1+words.indexOf(wordList.get(wordList.size()-1)) + wordList.get(wordList.size()-1).length(), i));
                else
                    wordList.add(words.substring(0,i));
            }
            else if(i == words.length() - 1)
            {
                wordList.add(words.substring(1+words.indexOf(wordList.get(wordList.size()-1)) + wordList.get(wordList.size()-1).length(), words.length()));
            }
            System.out.println("I: " + i + " LIST: " + wordList);
        }
        System.out.println("Now we have the list of the words. " + wordList);
        //Now we have the list of the words.
        int [] b = new int [wordList.size()];
        for(int i = 0; i < wordList.size(); i++)
        {
            for(int j = 0; j < wordList.get(i).length(); j++)
            {
                if(getInt(wordList.get(i).substring(j,j+1)) != -1)
                    b[i] = getInt(wordList.get(i).substring(j,j+1));
                System.out.println("B: " + b[i] + " I: " + i + " J: " + j);
            }
        }
        
        int poop = 0;
        
        for(int i = 0; i < b.length - 1; i++)
        {
            if(b[i] > b[i+1])
            {
                int tampon = b[i];
                b[i] = b[i+1];
                b[i+1] = tampon;

                String temporary = wordList.get(i);
                wordList.set(i, wordList.get(i+1));
                wordList.set(i+1, temporary);
                i = -1;
                poop++;
                System.out.println("SWAP " + poop + ": " + wordList);
            }
        }
        String ret = "";
        for(int i = 0; i < wordList.size(); i++)
        {
            if(i != wordList.size() - 1)
                ret += wordList.get(i) + " ";
            else
                ret += wordList.get(i);
                System.out.println("I: " + i + " RETURN: " + ret);
        }
        System.out.println("FINAL RETURN: " + ret);
        return ret;
    }

    public static int getInt(String n) {
        int x = -1;
        try {
            x = Integer.parseInt(n);
        } catch (NumberFormatException nfe) {
            x = -1;
            System.out.println("NOT A NUMBER (NaN) - Value = -1");
        }
        System.out.println("X: " + x);
        return x;
    }
}