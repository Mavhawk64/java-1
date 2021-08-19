import java.util.*;
/**
 * Write a description of class ForEach here.
 * Enhanced For Loop
 */
public class ForEach
{
    public static void main(String [] args)
    {
        System.out.println("------Day Simulator------");
        Scanner scan = new Scanner(System.in);
        System.out.println("What day is it?");
        String day = scan.nextLine();
        day = day.toLowerCase();
        if(day.contains("mon"))
        {
            System.out.println("--Monday--");
            ArrayList <String> monday = new ArrayList<String>();
            monday.add("Boredom");
            monday.add("Sleepy");
            monday.add("Life Wonder");
            monday.add("Lost");
            monday.add("Grade");
            monday.add("Pencil-less");
            monday.add("Tired");
            monday.add("Lazy");
            /**
             * For Each or Enhanced For Loop
             * Iterator is hidden so that less can go wrong
             * It will visit every element inside the array
             */
            for(String emotion : monday)
            {
                emotion = emotion + " :(";
                System.out.println(emotion);
            }
            System.out.println("It is raining... that is why we are so slow today.");
        }
        else if(day.contains("tues"))
        {
            ArrayList <String> tuesday = new ArrayList<String>();
            tuesday.add("Sleepy");
            tuesday.add("Happy");
            tuesday.add("Choir");
            tuesday.add("1:30 hours earlier");
            for(String emotion : tuesday)
            {
                emotion = emotion + " :)";
                System.out.println(emotion);
            }
        }
        else if(day.contains("wed"))
        {
            System.out.println("ENTER WEDNESDAY HERE");
            ArrayList <String> wednesday = new ArrayList<String>();
            for(String emotion : wednesday)
            {
                emotion = emotion + " :)";
                System.out.println(emotion);
            }
        }
        else if(day.contains("thurs"))
        {
            System.out.println("ENTER THURSDAY HERE");
            ArrayList <String> thursday = new ArrayList<String>();
            for(String emotion : thursday)
            {
                emotion = emotion + " :)";
                System.out.println(emotion);
            }
        }
        else if(day.contains("fri"))
        {
            System.out.println("ENTER FRIDAY HERE");
            ArrayList <String> friday = new ArrayList<String>();
            for(String emotion : friday)
            {
                emotion = emotion + " :)";
                System.out.println(emotion);
            }
        }
        else
        {
            System.out.println("Sorry, there are no emotions for " + day);
        }
    }
}
