import java.util.*;
/**
 * Maverick Berkland
 * Convert back and forth
 */
public class MorseCode
{
    public static String [] keym = new String []{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "---..", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"};
    public static String [] keye = new String []{"A" , "B"   , "C"   , "D"  , "E", "F"   , "G"  , "H"   , "I" , "J"   , "K"  , "L"   , "M" , "N" , "O"  , "P"   , "Q"   , "R"  , "S"  , "T", "U"  , "V"   , "W"  , "X"   , "Y"   , "Z"    , "1"    , "2"    , "3"    , "4"    , "5"    , "6"    , "7"    , "8"    , "9"    , "0"   };
    public static void main ()
    {
        print("Welcome to the Morse Code Translator!!!");
        print("Would you like to convert to Morse code or to english?");
        print("A. English -> Morse Code");
        print("B. Morse Code -> English");
        print("C. Stop");
        Scanner scan = new Scanner(System.in);
        String xe = scan.nextLine();
        String me = xe;
        me = me.toLowerCase();
        if(me.contains("a"))
        {
            EnglishMorse();
        }
        else if(me.contains("b"))
        {
            MorseEnglish();
        }
        else if(me.contains("c"))
        {
            print("Are you sure?");
            String stopd = scan.nextLine();
            stopd = stopd.toLowerCase();
            if(stopd.contains("y"))
            {
                print("Ok");
                scan.close();
            }
            else
            {
                main();
            }
        }
        else
        {
            print("I do not understand the String: " + xe);
            main();
        }
    }

    public static void EnglishMorse()
    {
        print("Please enter your English word or phrase");
        Scanner sc = new Scanner(System.in);
        String Eng = sc.nextLine();
        Eng = Eng.toUpperCase();
        //Getting chars and converting to morse code...
        for(int i = 0; i < Eng.length(); i++)
        {
            for(int j = 0; j < keym.length; j++)
            {
                if(Eng.substring(i, i+1).equals(" "))
                {
                    printls("/ ");
                    break;
                }
                if(Eng.substring(i, i+1).equals (keye[j]))
                {
                    printls(keym[j] + " ");
                    break;
                }
            }
        }
        System.out.println("\n\n\n");
        main();
    }

    public static void MorseEnglish()
    {
        print("Please enter your Morse Code with spaces in between each letter (or else system will get gunked up) and use slashes / for a space");
        print("Example of Apple in Morse Code: .- .--. .--. .-.. .");
        Scanner sc = new Scanner(System.in);
        String Mor = sc.nextLine();
        Mor = Mor.toUpperCase() + ' ';
        //Getting dots and converting to english code...
        for(int i = 0; i < Mor.length(); i++)
        {
            for(int j = 0; j < keye.length; j++)
            {
                if(Mor.substring(i, Mor.indexOf(' ', i)).equals("/"))
                {
                    printls(" ");
                    i = Mor.indexOf(' ', i);
                    break;
                }
                if(Mor.substring(i, Mor.indexOf(' ', i)).equals(keym[j]))
                {
                    printls(keye[j]);
                    i = Mor.indexOf(' ', i);
                    break;
                }
            }
        }
        System.out.println("\n\n\n");
        main();
    }

    public static void print (String x)
    {
        System.out.println(x);
    }

    public static void printls (String x)
    {
        System.out.print(x);
    }
}
