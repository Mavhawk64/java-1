import java.util.Scanner;
import java.util.Random;
/**
 * Maverick Berkland
 * Assignment ONE
 * Fun String Class
 * 5 September, 2017
 */
public class FunStringMaverick
{
    private static String secretWord = "LOVE";
    //I just could not get this to stay in bounds, it worked one time and that was it... I couldn't get you to help me, Mr. Ringenberg...
    //Run the cod in the, and it will still be Out Of Bounds /** */
    /**public static String SillyString(String x)
    {
        //Code that jumbles up Example
        System.out.println("Enter your word that you would like to be jumbled");
        Scanner scan = new Scanner(System.in);
        String unJumbled = scan.nextLine();
        int unlength = unJumbled.length();
        System.out.println("Entering " + unlength + " letters into the StringJumbler...");
        String jumbled = "";
        int [] randarray = new int[unlength];
        int rand = 0;
        for(int i = 0; i < unlength; i++)
        {
            if(randarray[rand] == 1)
            {
                double ran = Math.random();
                ran = ran*100;
                if(ran >= 90)
                {
                    rand = 0;
                }
                else if(ran < 90 && ran > 80)
                {
                    rand = 1;
                }
                else if(ran <=80 && ran > 60)
                {
                    rand = 2;
                }
                else if(ran <= 60 && ran > 40)
                {
                    rand = 3;
                }
                else if(ran <= 40 && ran > 20)
                {
                    rand = 4;
                }
                else
                {
                    rand = unlength;
                }
            }
            else
            {
                randarray[rand] = 1;
            }
            jumbled = unJumbled.substring(rand , randarray[rand]);
            System.out.print(jumbled);
        }
        return jumbled;
    }
        */
    public static String GuessThatString ()
    {
        //Perform checks on the guess;
        // + is in string, but wrong spot;
        // * not in string;
        // Letter is in the string in right spot;
        //Use .contains;
        System.err.println("THE CODE FROM SILLYSTRING IS OUT OF BOUNDS, SO YOU HAVE TO PLAY THE OTHER TWO GAMES.");
        String hint = "";
        System.out.println("THIS IS THE STRING GUESSING GAME!!!");
        System.out.println("If + is printed, the letter is in the word, but in the wrong spot, but if it is a *, that letter isn't in the word.");
        Scanner scan = new Scanner(System.in);
        boolean correct = false;
        while(!correct)
        {
            String guess = scan.nextLine();
            if(guess.contains("L"))
            {
                if(guess.contains("LO"))
                {
                    if(guess.contains("LOV"))
                    {
                        if(guess.equalsIgnoreCase("LOVE"))
                        {
                            System.out.println("LOVE");
                            correct = true;
                        }
                        else
                        {
                            System.out.println("LOV*");
                        }
                    }
                    else if(guess.equalsIgnoreCase("LOEV"))
                    {
                        System.out.println("LO++");
                    }
                    else if(guess.equalsIgnoreCase("LOEE"))
                    {
                        System.out.println("LO+E");
                    }
                    else if(guess.contains("LO") && !guess.contains("V") && guess.contains("E"))
                    {
                        System.out.println("LO+*");
                    }
                    else if(guess.contains("LO")&& guess.contains("V"))
                    {
                        System.out.println("LO*+");
                    }
                    else
                    {
                        System.out.println("LO**");
                    }
                }
                else if(guess.contains("L") && !guess.contains("O") && guess.contains("V") && guess.contains("E"))
                {
                    System.out.println("L*VE");
                }
                else if(guess.equalsIgnoreCase("LVOE"))
                    {
                        System.out.println("L++E");
                    }
                    else if(guess.contains("L") && guess.contains("V") && !guess.contains("O") && guess.contains("E"))
                    {
                        System.out.println("L+*E");
                    }
                    else if(guess.contains("L") && !guess.contains("V") && guess.contains("O") && guess.contains("E"))
                    {
                        System.out.println("L*+E");
                    }
                    else if(guess.equalsIgnoreCase("LEVO"))
                    {
                        System.out.println("L+V+");
                    }
                    else if(guess.contains("L") && guess.contains("E") && guess.contains("V") && !guess.contains("O"))
                    {
                        System.out.println("L+V*");
                    }
                    else if(guess.contains("L") && !guess.contains("E") && guess.contains("V") && !guess.contains("O"))
                    {
                        System.out.println("L*V*");
                    }
                else if(guess.equalsIgnoreCase("LVEO"))
                    {
                        System.out.println("L+++");
                    }
                    
                    else if(guess.contains("L") && guess.contains("V") && guess.contains("O") && !guess.contains("E"))
                    {
                        System.out.println("L++*");
                    }
                    else if(guess.contains("L") && guess.contains("V") && !guess.contains("O") && !guess.contains("E"))
                    {
                        System.out.println("L+**");
                    }
                    else if(guess.contains("L") && !guess.contains("E") && guess.contains("O") && !guess.contains("V"))
                    {
                        System.out.println("L*+*");
                    }
                    else if((guess.contains("L")&& !guess.contains("E") && !guess.contains("V") && guess.contains("O")) || (guess.contains("L") && !guess.contains("V") && !guess.contains("E") && guess.contains("V")))
                    {
                        System.out.println("L**+");
                    }
                    else
                    {
                        System.out.println("L***");
                    }
            }
            else if(!guess.contains("L") && guess.contains("O") && guess.contains("V") && guess.contains("E"))
            {
                System.out.println("*OVE");
            }
            else if(!guess.contains("L") && guess.contains("O") && guess.contains("V") && guess.contains("E"))
            {
                System.out.println("*O++");
            }
            else if(!guess.contains("L") && guess.contains("O") && !guess.contains("E") && guess.contains("V"))
            {
                System.out.println("*O+*");
            }
            else if(!guess.contains("L") && guess.contains("O") && !guess.contains("V") && !guess.contains("E"))
            {
                System.out.println("*O**");
            }
            else if(guess.contains("O") && !guess.contains("L") && guess.contains("V") && guess.contains("E"))
            {
                System.out.println("*+VE");
            }
            else if(!guess.contains("L") && !guess.contains("O") && guess.contains("V") && guess.contains("E"))
            {
                System.out.println("**VE");
            }
            else if(!guess.contains("L") && guess.contains("O") && guess.contains("V") && guess.contains("E"))
            {
                System.out.println("*+V+");
            }
            else if(guess.equalsIgnoreCase("VLOE") || guess.equalsIgnoreCase("OVLE"))
            {
                System.out.println("+++E");
            }
            else if(!guess.contains("L") && !guess.contains("O") && !guess.contains("V") && guess.contains("E"))
            {
                System.out.println("***E");
            }
            else if(guess.equalsIgnoreCase("VLEO") || guess.equalsIgnoreCase("OVEL") || guess.equalsIgnoreCase("EVOL") || guess.equalsIgnoreCase("EVLO") || guess.equalsIgnoreCase("ELOV") || guess.equalsIgnoreCase("VELO") || guess.equalsIgnoreCase("VEOL"))
            {
                System.out.println("++++");
            }
            else
            {
                System.out.println("****");
            }
            
            
        }
        isTwoInOneWord();
        return secretWord;
    }
    
    //Finished
    public static void setHiddenWord (String hiddenWord)
    {
        secretWord = hiddenWord;
    }
    
    public static String isTwoInOneWord ()
    {
        //Perform a check to see if the string TwoInOne is a word both forwards and backwards
        //Ignore case and space, so
        //Red Rum = murder
        //returns true or Yes
        Scanner scan1 = new Scanner(System.in);
        System.out.println("This is a Palindrome Checker");
        boolean pali = false;
        String isPali = "";
        while(!pali)
        {
            isPali = scan1.nextLine();
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            String flipped = new StringBuilder(isPali).reverse().toString(); //Stackoverflow help
            System.out.println(flipped);
            System.out.println(isPali);
            System.out.println("Are they the same?");
            String potato = scan1.nextLine();
            if(potato.equalsIgnoreCase("True") || potato.equalsIgnoreCase("Yes") || potato.equalsIgnoreCase("Y"))
            {
                System.out.println("Yes, " + isPali + " is a palindrome.");
                pali = true;
            }
            else
            {
                System.out.println("No, " + isPali + " is not a palindrome.");
            }
        }
        return "Yes, " + isPali + " is a forwards/backwards Word!";
    }
}
