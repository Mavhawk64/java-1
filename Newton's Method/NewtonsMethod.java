import java.util.*;
/**
 * Write a description of class NewtonsMethod here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NewtonsMethod
{
    double Fx;
    double fx;
    double x;
    double y;
    double ans1;
    double ans2;
    int count = 1;//0;
    Scanner scan;
    Scanner sc;
    Scanner sca;
    int num;
    int it;
    double c; //coefficient
    double p; //power
    double p1; //derivative's power
    double con; //constant
    double pcon; //turns constant positive if it is negative
    String enter;
    void calculate()
    {
        ans1 = 0;
        ans2 = 1; //arbitrary; rereferenced
        for(int i = 0; i < it; i++)//while(!isSame())
        {
            /*if(count == 0)
            {
            if(i == 0)
            {
            System.out.println("Type your guess for f(x) = x - 1");
            x = scan.nextDouble();
            }
            Fx = x - 1;
            fx = 1;
            }
            else*/
            if(count == 1)
            {
                if(i == 0)
                {
                    System.out.println("Type your guess for f(x) = -32x + 700");
                    x = scan.nextDouble();
                }
                Fx = -32*x + 700;
                fx = -32;
            }
            else if(count == 2)
            {
                if(i == 0)
                {
                    System.out.println("Type your guess for f(x) = x^2 - 3");
                    x = scan.nextDouble();
                }
                Fx = x*x -3;
                fx = 2*x;
            }
            else if(count == 3)
            {
                if(i == 0)
                {
                    System.out.println("Type your guess for f(x) = 3x^3 - 10");
                    x = scan.nextDouble();
                }
                Fx = 3*x*x*x -10;
                fx = 9*x*x;
            }
            else if(count == 4)
            {
                if(i == 0)
                {
                    System.out.println("Type your guess for f(x) = -2x^4 + 20");
                    x = scan.nextDouble();
                }
                Fx = -2*x*x*x*x + 20;
                fx = -8*x*x*x;
            }
            else if(count == 5)
            {
                if(i == 0)
                {
                    System.out.println("Type your guess for f(x) = 8x^5 - 10");
                    x = scan.nextDouble();
                }
                Fx = 8*(Math.pow(x, 5)) - 10;
                fx = 40*(Math.pow(x, 4));
            }
            else if(count > 5)
            {
                if(i == 0)
                {
                    System.out.println("Alright, I have run out of problems... you make some simple problems:");
                    System.out.println("What is the first coefficient?");
                    c = scan.nextDouble();
                    System.out.println("What is the power of x?");
                    p = scan.nextDouble();
                    System.out.println("What is the constant at the end? (negative or positive)");
                    con = scan.nextDouble();
                    if(con >= 0)
                        System.out.println("Your function looks like this: " + c + "x^" + p + " + " + con);
                    else
                    {
                        pcon = -con;
                        System.out.println("Your function looks like this: " + c + "x^" + p + " - " + pcon);
                    }
                    p1 = p - 1;
                    System.out.println("Your derivative looks like this: " + c*p + "x^" + p1);
                        System.out.println("Press Enter to continue");
                    enter = sca.nextLine();
                    if(con >= 0)
                        System.out.println("Type your guess for f(x) = " + c + "x^" + p + " + " + con);
                    else
                    {
                        pcon = -con;
                        System.out.println("Type your guess for f(x) = " + c + "x^" + p + " - " + pcon);
                    }
                    x = scan.nextDouble();
                }
                Fx = c*(Math.pow(x, p)) + con;
                fx = c*p*(Math.pow(x, p-1));
            }
            x = x - Fx/fx;
            // System.out.println("Fx = " + Fx);
            //System.out.println("fx = " + fx);
            //System.out.println(x);
            //count++;
            /* if(isEven())
            ans2 = x;
            else
            ans1 = x;*/
        }
        System.out.println("The answer after " + it + " iterations: " + x);
        count++;
    }

    boolean isEven()
    {
        return count%2 == 0;
    }

    boolean isSame()
    {
        return ans1 == ans2;
    }

    //    float ReturnNum()
    //  {
    //    if(fx.contains("x") || Fx.contains("x"))
    //      return x;
    // else if(fx.contains("y") || Fx.contains("y"))
    //   return y;
    // else
    //   return 0;
    //}

    NewtonsMethod()
    {
        scan = new Scanner(System.in); //doubles
        sc = new Scanner(System.in); //ints
        sca = new Scanner(System.in); //Strings
        System.out.println("How many problems would you like?");
        num = sc.nextInt();
        System.out.println("How many iterations would you like? (reasonable: 1 - 100)");
        it = scan.nextInt();
        while(count <= num)
            calculate();
    }
}
