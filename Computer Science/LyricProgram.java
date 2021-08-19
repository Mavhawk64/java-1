import java.util.Scanner;
/**
 * I am Maverick Berkland and I made this program by myself and with the resources of
 * this semester.
 * Maverick Berkland
 * 25 January, 2017
 */
public class LyricProgram
{
    public static void main ()
    {
        System.out.println("Hello, welcome to the:");
        System.out.println(" ");
        System.out.println("   *******************************");
        System.out.println("   ****THE LYRIC GUESSING GAME****");
        System.out.println("   *******************************");
        System.out.println(" ");
        System.out.println("Walkin' through a _____, the village is a glow.");
        System.out.println("Guess what is in the blank");
        Scanner sa = new Scanner (System.in);
        String a = sa.nextLine();
        int score = 0;
        if (a.equalsIgnoreCase ("crowd"))
        {
            score=score+1;
            System.out.println("Great job, you guessed the lyric!");
            System.out.println("Your socre is " + score + "/5");
        }
        
        else
        {
            System.out.println("Oops, better luck next time!");
            System.out.println("Your sad score is at " + score + "/5");
            System.out.println("The corret answer is, crowd");
        }
        System.out.println("Pull the sheets right off the corner of the ________ that you stole");
        System.out.println("Guess that lyric!");
        String b = sa.nextLine();
        if (b.equalsIgnoreCase ("mattress"))
        {
            score=score+1;
            System.out.println("Excellent!");
            System.out.println("Your score is " + score + "/5");
        }
        else
        {
            System.out.println("Oh no!");
            System.out.println("Your score is now at " + score + "/5");
            System.out.println("The correct answer is, mattress");
        }
        System.out.println("All my life has been a series of _____ in my face...");
        System.out.println("What is in the blank?");
        String c = sa.nextLine();
        if (c.equalsIgnoreCase ("doors"))
        {
            score=score+1;
            System.out.println("Buen Trabajo (Good Work)");
            System.out.println("Your score now is " + score + "/5");
        }
        else
        {
            System.out.println("HOW DID YOU NOT GET THAT!?!");
            System.out.println("Your horrible score is " + score + "/5");
            System.out.println("The correct answer is, doors");
        }
        System.out.println("We're so happy, even when we're smilin' out of ____. Let's go down to the tennis court and talk it up like yeah (yeah)!");
        System.out.println("GUESS THAT LYRIC!");
        String d = sa.nextLine();
        if (d.equalsIgnoreCase ("fear"))
        {
            score=score+1;
            System.out.println("WOW!");
            System.out.println("Your score is now at " + score + "/5");
        }
        else
        {
            System.out.println("Great... *Rolls eyes*");
            System.out.println("You are now at the score of " + score + "/5");
            System.out.println("The correct answer is, fear");
        }
        System.out.println("Headin' into twilight, spreadin' out her wings tonight, she got you jumpin' off the _____, and shovin' into overdrive!");
        System.out.println("If you don't get this last lyric, you are DEAD!!!");
        String e = sa.nextLine();
        if (e.equalsIgnoreCase ("deck"))
        {
            score=score+1;
            System.out.println("HOORAY!!! YOU GUESSED MY SONG!!!");
            System.out.println("Your score is " + score + "/5");
        }
        else
        {
            System.err.println("YOU ARE DEAD!!!");
            System.err.println("Your score is " + score + "/5");
            System.err.println("The correct answer is, DECK!");
        }
        if (score>=3)
        {
            System.out.println("Excellent! Your final score is " + score + "/5"); 
        }
        else
        {
            System.out.println("GO LEARN HOW TO SING!!!");
        }
        System.out.println("Song list in order is:");
        System.out.println(" ");
        System.out.println("Welcome to New York - Taylor Swift");
        System.out.println("Closer - Chainsmokers");
        System.out.println("Love is an Open Door - Kristen Bell, Santino Fontana");
        System.out.println("Tennis Court - Lorde");
        System.out.println("Danger Zone - Kenny Loggins");
    }
}

