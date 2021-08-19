
/**
 * Maverick Berkland
 * Review for "JAVA BASIC SKILLS EXAM"
 * Test on Friday
 * 23 August, 2017
 */
public class If_Statements
{
    public static void main (String [] args)
    {
        if(true)
        {
            System.out.println("It works");
        }
        
        int temp = 150;
        if(temp > 200) //THIS IS FALSE
        {
            System.out.println("THE CORE IS MELTING... TEMPERATURE: " + temp + "*");
        }
        else if(temp < 32)
        {
            System.out.println("THE CORE IS FREEZING... TEMPERATURE: " + temp + "*");
        }
        else
        {
            System.out.println("The Core is at normal temperature: " + temp + "*");
        }
        double ran = Math.random(); //Generates between 0 - 1 only
        int res = (int)(ran * 48);
        int age = 0;
        boolean Learners = false;
        boolean parent = false;
        if(res > 25)
        {
           age = 15;
            if(res > 30)
           {
               parent = true;
           }
           else
           {
               parent = false;
           }
        }
        else if(res < 15)
        {
            age = 16;
        }
        else
        {
            age = 4;
        }
        double rand = Math.random(); //Generates between 0 - 1 only
        int resu = (int)(ran * 48);
        
        
            if(resu > 30)
           {
               Learners = true;
           }
           else
           {
               Learners = false;
           }
        
        if(age >= 16)
        {
            System.out.println("You Can Drive");
        }
        else if(age == 15)
        {
            if(Learners = true)
            {
                if(parent = true)
                {
                    System.out.println("You Can Drive With Your Parent");
                }
                else
                {
                    System.out.println("Ask your mom or dad to drive with you");
                }
            }
            else
            {
                System.out.println("Go to the DMV to get your permit!!!");
            }
        }
        else
        {
            System.out.println("You can't drive!");
        }
        //ONLY PRINTS YES 1 TIME
        System.out.println("If-Else Chain");
        if(3 < 7)
        {
            System.out.println("Yes");
        }
        else if(8 > 7)
        {
            System.out.println("Yes");
        }
        else if(3 < 80)
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("Nothing");
        }
        
        System.out.println("If-Else Broken Chain");
        if(3 < 7)
        {
            System.out.println("Yes");
        }
        if(8 > 7)
        {
            System.out.println("Yes");
        }
        if(3 < 80)
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("Nothing");
        }
    }
}
