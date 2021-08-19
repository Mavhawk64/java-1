package ShapesMaverick;
import java.util.Scanner;
public class Triangle extends Shape
{
    /**
     * Finished!!!
     */
    Triangle()
    {
        super(); //This is the first line of the constructor

        //Enter Specific Details here... 
        Scanner sc = new Scanner(System.in);
        Scanner F = new Scanner(System.in);
        System.out.println("What size?");
        size = F.nextInt();
        System.out.println("What symbol would you like to use?");
        symbol = sc.nextLine();
        for(int alfredo = 0; alfredo < 4; alfredo++)
        {
            System.out.println();
        }
        //System.out.println("TEST");
        Draw(/**symbol, shapesize*/);
        //System.out.println(symbol);
        //System.out.println(size);
    }

    @Override
    public void Draw ()
    {
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < i; j++)
            {
                System.out.print(symbol);
            }
            System.out.println(symbol);
        }
        //System.out.println("Draw in Triangle Test");
    }
}
