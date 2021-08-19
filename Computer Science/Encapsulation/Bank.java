package Encapsulation;
public class Bank
{
    //Attributes
    double withdrawAmount = 0.00;
    double hiddenFees = 0.00;
    double balance = 0.00;
    //Behaviors
    public void Tax()
    {
        hiddenFees++;
    }
    
    private void taxIncrease()
    {
        Tax();
    }
    
    public void Withdraw()
    {
        balance -= withdrawAmount;
    }
}
