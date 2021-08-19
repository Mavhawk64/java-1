public class SpinWords {
    public static void main ()
    {
        System.out.println(spinWords("Welcome"));
        System.out.println(spinWords("Hey fellow warriors"));
        System.out.println(spinWords("The quick brown fox jumps over a lazy dog"));
        System.out.println(spinWords("What in the tarnation"));
    }

    public static String spinWords(String sentence) {
        String reversed = "";
        String [] words = sentence.trim().split("\\s");
        for(String w: words)
        {
            if(w.length() >= 5)
            {
                w = esreverMe(w);
            }
            reversed+=w + " ";
        }
        return reversed.trim();
    }
    
    public static String esreverMe(String x)
    {
        char [] y = x.toCharArray();
        for(int i = 0; i < y.length/2; i++)
        {
            char temp = y[i];
            y[i] = y[(y.length - i) - 1];
            y[(y.length - i) - 1] = temp;
        }
        x = "";
        for(int i = 0; i < y.length; i++)
        {
            x += y[i];
        }
        return x;
    }
}