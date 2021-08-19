import java.util.*;
public class ListMethods
{
    public static void main (String [] args)
    {
        ArrayList <Boolean> choices = new ArrayList<Boolean>();
        choices.add(true);
        choices.add(false);
        choices.add(true);
        choices.add(true);
        choices.add(false);
        choices.add(false);
        int k = choices.size()-1;
        while(!choices.isEmpty()) //isEmpty = true when no data is left
        {
            System.out.println(choices);
            choices.remove(k);
            k--;
        }
        System.out.println(choices);
        
        ArrayList <Employee> business = new ArrayList<Employee>();
        System.out.println("How many employees?");
        Scanner sc = new Scanner(System.in);
        int emp = sc.nextInt();
        for(int i = emp; i >= 0; i--)
        {
            business.add(new Employee());
        }
        
        business.get(2).workEthic = true;
        business.get(2).name = "Timmy Bob";
        business.get(2).getRaise(true);
        for(Employee x : business)
        {
            x.getRaise(true);
            x.printInfo();
        }
        
        ArrayList <Integer> num = new ArrayList <Integer>();
        num.add(6); //0
        num.add(7); //1
        num.add(5); //2
        //add(Integer) is overloaded by add(Integer, Integer)... Putting 9 in the 0 index
        num.add(0, 9);
        num.remove(1);
        num.add(2, 3);
        num.set(3, 4); //this will override the third index, and set it to 4
        System.out.println(num);
        boolean has4 = num.contains(4);
        System.out.println(has4);
    }
}
