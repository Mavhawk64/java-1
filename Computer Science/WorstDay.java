import java.util.Scanner;
/**
 * 18 January, 2017
 * MadLib Program by Maverick Berkland
 * I am Maverick, and I created this program with my knowledge from this semester.
 * 
 */
public class WorstDay
{
    public static void main (String [] args)
    {
        //Set up the scanner
        Scanner sc = new Scanner(System.in);
        //Set up the prompts
        System.out.println("MadLib story by Maverick Berkland");
        System.out.println("Please enter a verb in the past-tense.");
        //Check
        String verb1 = sc.nextLine();
        System.out.println("Please enter another verb in the past-tense.");
        Scanner sb = new Scanner(System.in);
        //Check
        String verb2 = sb.nextLine();
        System.out.println("Please enter a noun.");
        Scanner sg = new Scanner(System.in);
        //Check
        String noun1 = sg.nextLine();
        System.out.println("Please enter another noun");
        Scanner sd = new Scanner(System.in);
        //Check
        String noun2 = sd.nextLine();
        System.out.println("Please enter TWO adjectives");
        System.out.println("Enter the words on separate lines");
        Scanner se = new Scanner(System.in);
        //Check
        String adj1 = se.nextLine();
        
        String adj2 = se.nextLine();
        System.out.println("Please enter TWO adverbs");
        System.out.println("Enter the words on separate lines");
        System.out.println("For example: Swiftly");
        Scanner sf = new Scanner(System.in);
        //Check
        String adv1 = sf.nextLine();
        //Check
        String adv2 = sf.nextLine();
        System.out.println("Please enter a number under 9999");
        Scanner sz = new Scanner(System.in);
        int num = sz.nextInt();
        System.out.println("        **************************");
        System.out.println("        ****The Worst Day Ever****");
        System.out.println("        **************************");
        System.out.println(" ");
        System.out.println("One day, I was late for school, so I " + verb1 + " " + adv1 + " to get to school.");
        System.out.println("When I arrived, I " + verb2 + " on a " + noun1 + " while attempting  to get to my first class.");
        System.out.println("'I'm so " + adj1 + ",'" + " I thought to myself.");
        System.out.println("I was such a mess, so I looked in the mirror and found some sort of " + noun2 + " in my hair!");
        System.out.println("'I can't belive this, I need to " + adv2 + " walk to the councelor!");
        System.out.println(" I hope I don't have this " + adj2 + " of a day for another " + num + " days!");
        System.out.println("This was my Worst Day Ever!");
    }
}
