import java.util.ArrayList;
public class test
{
    public static void main (String [] args)
    {
        ArrayList <Integer> z = new ArrayList<Integer>();
        String x = "a1b4ca6b645b3";
        int sum = 0;
        for(int i = 0; i < x.length(); i++)
        {
            char temp = x.charAt(i);
            if(temp >= 48 && temp <= 57)//ASCII
            {
                int y = (int)temp;
                y = y-48;
                z.add(y);
                sum = y + sum;
            }
        } 
        System.out.println(z);
        System.out.println("Sum: " + sum);
        double num = 123.141533333993;
        System.out.printf("Hello: %010.2f", num);
        System.out.printf("\nHello: %010d" ,3 );
        System.out.printf("\nHello: %d" , sum);
        System.out.printf("\nString: %s", x);
    }
}
