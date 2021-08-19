package ShapesMaverick;
import java.util.Scanner;
public class Square extends Shape
{
    Square ()
    {
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
        Draw();
    }
    
    @Override
    public void Draw ()
    {
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
}
