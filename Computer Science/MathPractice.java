public class MathPractice
{
    public static void main(String[] args)
    {
        int a=0;
        double b=1.5;
        //To create a random number between 0-1
        System.out.println(Math.random());
        //To create a random number between 1-4
        System.out.println(1 + Math.random() * 4);
        //For Powers (First number is base, Second is power)
        System.out.println(Math.pow(2, 3));
        //To get a whole number, Cast it
        System.out.println((int)Math.pow(2, 3));
        //Use casting with (int) to round down
        System.out.println((int)(b +.5));
        //Add .5 to round; .3+.5=.8, so it rounds down to 0.
        //.6+.5=1.1, so it rounds down to 1
        
        //For Square root
        System.out.println(Math.sqrt(144));
        //For absolute value
        System.out.println(Math.abs(-6));
        //For Pi=3.14... and E=2.7
        System.out.println("For Pi: " + ( Math.PI));
        System.out.println("For E: " + (Math.E));
        //To compare two numbers and returns the value of the
        //Greater number
        System.out.println(Math.max(10, 17));
    }
    }

