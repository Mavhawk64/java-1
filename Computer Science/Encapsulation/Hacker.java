package Encapsulation;
public class Hacker
{
    public static void main (String [] args)
    {
        Bank b1 = new Bank();
        b1.balance = 1000000000;
        for(int i = 1; i < 50; i++)
        {
            b1.Tax();
        }
        System.out.println(b1.hiddenFees);    
        System.out.println("This is Maverick's balance: $" + b1.balance);
    }
}
