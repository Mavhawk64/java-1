public class Employee
{
    //Attributes
    private boolean complaining;
    public boolean workEthic;
    private double salary;
    public float workSpeed;
    public String name;
    Employee()
    {
        complaining = false;
        workEthic = false;
        salary = 9.50;
        workSpeed = 3;
        name = "Bill";
        //printInfo();
        //getRaise(true);
    }
    
    public void printInfo()
    {
        System.out.println("Name: " + name + " Salary: " + salary);
    }
    
    public void getRaise(boolean isItTime)
    {
        if(isItTime && workEthic)
            salary += 2;
    }
}
