import java.util.*;
public class DayCalc
{
    public static void main ()
    {
        System.out.println("Hello! Welcome to the day calculator!");
        System.out.println("There are multiple ways to enter a date, and I will spit out the day (ex Friday, November 1, 2019).");
        System.out.println("Choose one of the following options:");
        System.out.println("1. MM/DD/YYYY");
        System.out.println("2. DD/MM/YYYY");
        System.out.println("3. DD Month, YYYY");
        System.out.println("4. DD-Mon-YYY");
        String input = (new Scanner(System.in)).nextLine();
        input = input.trim();
        input = input.substring(0,1); //first character
        if(input.equals("1"))
            mmddyyyy();
        else if(input.equals("2"))
            ddmmyyyy();
        else if(input.equals("3"))
            ddMonthyyyy();
        else
            ddMonYYYY();

        System.out.println("Would you like to input another date?");
        String in = (new Scanner(System.in)).nextLine();
        if(in.toLowerCase().contains("y"))
            main();
    }

    public static void mmddyyyy()
    {
        System.out.println("Enter your date in the format: MM/DD/YYYY");
        System.out.println("Just for safe measure please input like 03/14/2002"); //Thursday
        String date = (new Scanner(System.in)).nextLine();
        int mm = Integer.parseInt(date.substring(0, date.indexOf("/")));
        int dd = Integer.parseInt(date.substring(date.indexOf("/")+1, date.indexOf("/", date.indexOf("/")+1))); //Works
        int yyyy = Integer.parseInt(date.substring(date.indexOf("/", date.indexOf("/")+1)+1, date.length())); //Works
        System.out.println("MM: " + mm + " DD: " + dd + " YYYY: " + yyyy + "\nInputting...");
        int D = yyyy%100;
        int C = (yyyy - D)/100;
        System.out.println("C: " + C + " D: " + D);
        zeller(dd, mm, C, D, yyyy);
    }

    public static void zeller(int k, int m, int C, int D, int yyyy)
    {
        //f = k + ((13*m-1)/5)+D+(D/4)+(C/4)-2*C
        m = m - 2;
        if(m < 1) //Sets Jan to 11 and Feb to 12
        {
            m = 12 + m;
            D--;
        }
        int f = k + ((13*m-1)/5)+D+(D/4)+(C/4)-2*C;
        String [] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        String [] months = {"March","April","May","June","July","August","September","October","November","December","January","February"};
        f = f%7;
        if(f < 0)
            f+=7;

        System.out.println("The result is...");
        try
        {
            Thread.sleep(2000); //2 seconds
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
        System.out.println(days[f] + ", " + months[m-1] + " " + k + ", " + yyyy);
    }

    public static void ddmmyyyy()
    {
        System.out.println("Enter your date in the format: DD/MM/YYYY");
        System.out.println("Just for safe measure please input like 14/03/2002"); //Thursday
        String date = (new Scanner(System.in)).nextLine();
        int dd = Integer.parseInt(date.substring(0, date.indexOf("/")));
        int mm = Integer.parseInt(date.substring(date.indexOf("/")+1, date.indexOf("/", date.indexOf("/")+1))); //Works
        int yyyy = Integer.parseInt(date.substring(date.indexOf("/", date.indexOf("/")+1)+1, date.length())); //Works
        System.out.println("MM: " + mm + " DD: " + dd + " YYYY: " + yyyy + "\nInputting...");
        int D = yyyy%100;
        int C = (yyyy - D)/100;
        System.out.println("C: " + C + " D: " + D);
        zeller(dd, mm, C, D, yyyy);
    }

    public static void ddMonthyyyy()
    {
        System.out.println("Enter your date in the format: DD Month, YYYY");
        System.out.println("Just for safe measure please input like 14 March, 2002 (NOTE: YOU HAVE TO SPELL IT CORRECTLY)"); //Thursday
        String date = (new Scanner(System.in)).nextLine();
        String month = date.substring(date.indexOf(" ")+1,date.indexOf(","));
        String [] mons = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        int mm = 0;
        for(int i = 0; i < mons.length; i++)
        {
            if(month.toLowerCase().trim().equals(mons[i].toLowerCase()))
                mm = i+1;
        }
        int dd = Integer.parseInt(date.substring(0, date.indexOf(" ")));
        int yyyy = Integer.parseInt(date.substring(date.indexOf(",")+1,date.length()).trim());
        System.out.println("MM: " + mm + " DD: " + dd + " YYYY: " + yyyy + "\nInputting...");
        int D = yyyy%100;
        int C = (yyyy - D)/100;
        System.out.println("C: " + C + " D: " + D);
        zeller(dd, mm, C, D, yyyy);
    }

    public static void ddMonYYYY()
    {
        System.out.println("Enter your date in the format: DD-Mon-YYYY");
        System.out.println("Just for safe measure please input like 14-Mar-2002 (NOTE:YOU HAVE TO SPELL IT LIKE THE FOLLOWING:)"); //Thursday
        String [] mons = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        for(int i = 0; i < mons.length-1; i++)
        {
            System.out.print(mons[i] + ", ");
        }
        System.out.print(mons[11]+"\n");
        String date = (new Scanner(System.in)).nextLine();
        String month = date.substring(date.indexOf("-")+1,date.indexOf("-",date.indexOf("-")+1));
        int mm = 0;
        for(int i = 0; i < mons.length; i++)
        {
            if(month.toLowerCase().trim().equals(mons[i].toLowerCase()))
                mm = i+1;
        }
        int dd = Integer.parseInt(date.substring(0, date.indexOf("-"))); //Works
        int yyyy = Integer.parseInt(date.substring(date.indexOf("-", date.indexOf("-")+1)+1, date.length())); //Works
        System.out.println("MM: " + mm + " DD: " + dd + " YYYY: " + yyyy + "\nInputting...");
        int D = yyyy%100;
        int C = (yyyy - D)/100;
        System.out.println("C: " + C + " D: " + D);
        zeller(dd, mm, C, D, yyyy);
    }
}
