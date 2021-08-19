import java.util.*;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main3
{
    public static void main (String [] args)
    {
        ArrayList<Integer> a = new ArrayList<Integer>();
        int x = Integer.parseInt((new Scanner(System.in)).nextLine().trim());
        for( int i= 0; i<x; i++){
            a.add(fib(i+1));
        }
        for( int i= 0; i<x; i++){
            if(a.get(i)%2 == 0){
                System.out.println(a.get(i));
            }
        }
    }

    public static int fib(int x)
    {
        if( x < 0){
            return 0;
        }
        switch(x){
            case 0:
            return 0;
            case 1:
            return 1;
            default:
            return fib(x-1) + fib(x-2);
        }
    }
}
