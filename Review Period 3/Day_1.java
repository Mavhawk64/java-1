
/**
 * Maverick Berkland
 * Millard North 2017
 * Review Day 1 Data Types and GPIO
 */
public class Day_1
{
    public static void main (String [] args)
    {
        //Data Types
        int x =   1234567890;
        long y =  1234567890;
        short z = 1234;
        String name = "WORD";
        char letter = 'A';
        boolean ans = true;
        double u = 9.34934098784931789;
        //Reassign variable h
        long h = 3;
        h = y + z;
        name = name + " 5";
        ans = false;
        int num = 9;
        System.out.println(num);
        int sum = num + 3;
        System.out.println(sum);
        num = 3;
        System.out.println(num);
        sum = sum + num;
        System.out.println(sum);
        num = num + sum;
        System.out.println(num);
        double pi = 3.141592653;
        int testnum = 6;
        double result = pi + testnum;
        System.out.println(result);
        double div = testnum/pi;
        System.out.println(div);
        double divi = testnum/4.0;
        System.out.println(divi);
        //Type Casting Notes
        System.out.println("INT DIVISION");
        System.out.println("------------");
        int division = 3/4;
        System.out.println(division);
        System.out.println("INT DIVISION saved as a DOUBLE");
        System.out.println("------------------------------");
        double divDouble = 3/4;
        System.out.println(divDouble);
        System.out.println("Double Division");
        System.out.println("---------------");
        double divis = 3.0/4.0;
        System.out.println(divis);
        System.out.println("Variable Division with Type Casting");
        System.out.println("-----------------------------------");
        int in1 = 3;
        int in2 = 4;
        double div2 = (double)in1/(double)in2;
        System.out.println(div2);
        //////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        System.out.println("The CHAR");
        System.out.println("--------");
        char mystery = 0;
        System.out.println(mystery);
        char squiggle = 126;
        System.out.println(squiggle);
        char symbol = 254;
        System.out.println(symbol);
        System.out.println(mystery);
        for(int i = 0; i <= 2550; i++)
        {
            mystery = (char)(mystery+1);
            System.out.println(mystery + " Number: " + i);
        }
        String name3 = 2 + 3 + " John " + 7 + 3 + " Cat " + 5 + " Hello ";
        System.out.println(name3);
        System.out.println("Be careful, this will add the all the numbers until it reaches a String, then it will just tack it on, like 2+3=5, but 7+3=73.");
        
    }
}
