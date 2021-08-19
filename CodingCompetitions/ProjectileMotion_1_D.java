import java.util.*;
import java.math.*;
public class ProjectileMotion_1_D
{
    public static void main ()
    {
        //s
        //u
        //v
        //a
        //t
        System.out.println("\nWhat are the units?\nFirst type the units of length.");
        Scanner f = new Scanner(System.in);
        String len = f.nextLine();
        System.out.println("Now type the units of time");
        String tim = f.nextLine();
        System.out.println("What are your knowns?\nPosition, Initial Velocity, Velocity, Acceleration, and Time are your options.\nPlease Enter like this: Position, Acceleration, Time\nYou need at least 3\nNOTE: DO NOT ENTER 'AND'!");
        Scanner scan = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayList <String> words = new ArrayList <String>();
        for(int i = 0; i < input.length(); i++)
        {
            if(input.charAt(i) == ',')
            {
                words.add(((input.substring(0, i)).trim()).toUpperCase());
                int temp = input.length();
                input = input.substring(i+1,temp).trim();
                i = 0;
            }
            else if(!input.contains(","))
            {
                words.add((input.trim()).toUpperCase());
                break;
            }
        }
        //Now that we have all of the knowns, we have to check them
        boolean [] Bs = {words.contains("POSITION"),words.contains("INITIAL VELOCITY"),words.contains("VELOCITY"),words.contains("ACCELERATION"),words.contains("TIME")};
        double s = 0;
        double u = 0;
        double v = 0;
        double a = 0;
        double t = 0;
        for(int j = 0; j < words.size(); j++)
        {
            for(int i = 0; i < Bs.length; i++)
            {
                if(Bs[i])
                {
                    System.out.println("Please enter the " + words.get(j));
                    if((words.get(j)).equals("POSITION"))
                        s = sc.nextDouble();
                    else if((words.get(j)).equals("INITIAL VELOCITY"))
                        u = sc.nextDouble();
                    else if((words.get(j)).equals("VELOCITY"))
                        v = sc.nextDouble();
                    else if((words.get(j)).equals("ACCELERATION"))
                        a = sc.nextDouble();
                    else if((words.get(j)).equals("TIME"))
                        t = sc.nextDouble();
                    j++;
                }
            }
        }

        System.out.println("What are you solving for? Ex: POSITION");
        String find = ((scan.nextLine()).trim()).toUpperCase();

        //s = ut + 0.5*a*t^2
        //v = u + at
        //v^2 = u^2 + 2as
        //s = 0.5*(u+v)*t
        if(find.equals("POSITION"))
        {
            if(Bs[1] && Bs[2] && Bs[4])
            {
                //s = 1/2 (u+v)t
                s = (1/2)*(u+v)*t;
            }
            else if(Bs[1] && Bs[3] && Bs[4])
            {
                //s = ut + 1/2 * a * t^2
                s = u*t + (1/2)*a*Math.pow(t,2);
            }
            else
            {
                while(true)
                {
                    System.err.println("IMPOSSIBLE: DESTROYING COMPUTER");
                }
            }
            System.out.println("The change in the object's position is: " + s + " " + len);
        }
        else if(find.equals("INITIAL VELOCITY"))
        {
            if(Bs[0] && Bs[3] && Bs[4])
            {
                //u = (2s-at^2)/2t
                u = (2*s - a*Math.pow(t,2))/(2*t);
                System.out.println("The Initial Velocity is: " + u + " " + len + "/" + tim);
            }
            else if(Bs[2] && Bs[3] && Bs[4])
            {
                //u = v - at
                u = v - a*t;
                System.out.println("The Initial Velocity is: " + u + " " + len + "/" + tim);
            }
            else if(Bs[0] && Bs[2] && Bs[3])
            {
                //u = +/-sqrt(v^2-2as)
                u = Math.sqrt(Math.pow(v,2)-2*a*s);
                if(Double.isNaN(u))
                    System.out.println("Sorry, one of the variables is either too large or too small: try again later");

                if(s > 0)
                    System.out.println("The Initial Velocity is: " + u + " " + len + "/" + tim);
                else
                    System.out.println("The Initial Velocity is: - " + u + " " + len + "/" + tim);
            }
            else if(Bs[0] && Bs[2] && Bs[4])
            {
                //2s/t - v = u
                u = 2 * s / t - v;
                System.out.println("The Initial Velocity is: " + u + " " + len + "/" + tim);
            }
            else
            {
                while(true)
                {
                    System.err.println("IMPOSSIBLE: DESTROYING COMPUTER");
                }
            }
        }
        else if(find.equals("VELOCITY"))
        {
            if(Bs[1] && Bs[3] && Bs[4])
            {
                //v = u + at
                v = u + a*t;
                System.out.println("The (Final) Velocity is: " + v + " " + len + "/" + tim);
            }
            else if(Bs[1] && Bs[3] && Bs[0])
            {
                //v^2 = u^2 + 2as
                v = Math.sqrt(Math.pow(u,2) + 2*a*s);
                if(Double.isNaN(v))
                {
                    System.out.println("Sorry, the position is invalid (or the initial velocity is too small), so the calculation did not go through (properly).");
                }
                if(s > 0)
                    System.out.println("The (Final) Velocity is: " + v + " " + len + "/" + tim);
                else
                    System.out.println("The (Final) Velocity is: - " + v + " " + len + "/" + tim);
            }
            else
            {
                while(true)
                {
                    System.err.println("IMPOSSIBLE: DESTROYING COMPUTER");
                }
            }
        }
        else if(find.equals("ACCELERATION"))
        {
            //s = ut + 0.5*a*t^2
            //v = u + at
            //v^2 = u^2 + 2as
            if(Bs[0] && Bs[1] && Bs[4])
            {
                //a = (2(s-t*u))/t^2
                a = (2*(s-t*u))/(Math.pow(t,2));
            }
            else if(Bs[1] && Bs[2] && Bs[4])
            {
                //a = (v-u)/2
                a = (v-u)/2;
            }
            else if(Bs[0] && Bs[1] && Bs[2])
            {
                //a = (v^2 - u^2)/2s
                a = (Math.pow(v,2)-Math.pow(u,2))/(2*s);
            }
            else
            {
                while(true)
                {
                    System.err.println("IMPOSSIBLE: DESTROYING COMPUTER");
                }
            }
            System.out.println("The Acceleration is: " + a + " " + len + "/" + tim + "/" + tim);
        }
        else if(find.equals("TIME"))
        {
            //s = ut + 0.5*a*t^2
            //v = u + at
            //s = 0.5*(u+v)*t
            if(Bs[0] && Bs[1] && Bs[3])
            {
                //t = (sqrt(2as-u^2)-u)/a
                t = (Math.sqrt(Math.abs(2*a*s - Math.pow(u,2)))-u)/a;
            }
            else if(Bs[1] && Bs[2] && Bs[3])
            {
                //t = (v-u)/a
                t = (v-u)/a;
            }
            else if(Bs[0] && Bs[1] && Bs[2])
            {
                //t = 2s/(u+v)
                t = (2*s)/(u+v);
            }
            else
            {
                while(true)
                {
                    System.err.println("IMPOSSIBLE: DESTROYING COMPUTER");
                }
            }
            System.out.println("The Time is: " + t + " " + tim);
        }
        else
        {
            while(true)
            {
                System.err.println("INVALID OPTION: DESTROYING COMPUTER");
            }
        }
    }
}