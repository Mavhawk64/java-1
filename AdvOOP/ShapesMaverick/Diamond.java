package ShapesMaverick;
import java.util.Scanner;
public class Diamond extends Shape
{
    Diamond()
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
        //Beauty loop
        int userInput = size;
        int amtSpace = 1;
        int amtFirstSpacebeforeShift6 = amtSpace;
        int amtLastSpacesbeforeShiftV = amtSpace;
        int amtSpacebeforeBslash = 1;
        for(int i = 0; i < userInput; i++)
        {
            amtSpace += 1;
            amtFirstSpacebeforeShift6 = amtSpace;
        }
        /**
         * Front End
         */
        //This adjusts the first space(s) before ^
        for(int i = 0; i < amtFirstSpacebeforeShift6; i++)
        {
            System.out.print(" ");
        }
        System.out.println(symbol);
        int shift6 = amtFirstSpacebeforeShift6;
        int temp = (amtFirstSpacebeforeShift6);
        while(amtFirstSpacebeforeShift6 > 0)
        {
            amtFirstSpacebeforeShift6 -= 1;
            for(int i = 0; i < amtFirstSpacebeforeShift6; i++)
            {
                System.out.print(" ");
            }

            if(amtFirstSpacebeforeShift6 == 0)
            {
                System.out.print(symbol);
            }
            else
            {
                System.out.print(symbol);
            }

            for(int i = 0; i < amtSpacebeforeBslash; i++)
            {
                System.out.print(symbol);
                //Is this inside or outside?
            }
            amtSpacebeforeBslash+= 2;
            if(amtFirstSpacebeforeShift6 == 0)
            {
                for(int i = 0; i < temp - (userInput+1); i++)
                {
                    System.out.print(symbol);
                }
                System.out.print(symbol);
            }
            else
            {
                System.out.println(symbol);
            }
        }
        amtSpace = 0;
        for(int i = 0; i < temp; i++)
        {
            amtSpace+= 0;
        }
        amtLastSpacesbeforeShiftV = amtFirstSpacebeforeShift6;
        System.out.println("");
        /**
         * Back End
         */
        amtSpacebeforeBslash -= 2;
        while(amtLastSpacesbeforeShiftV < (userInput))
        {
            amtLastSpacesbeforeShiftV += 1;
            for(int i = 0; i < amtLastSpacesbeforeShiftV; i++)
            {
                System.out.print(" ");
            }

            System.out.print(symbol);
            amtSpacebeforeBslash -= 2;
            for(int i = 0; i < amtSpacebeforeBslash; i++)
            {
                System.out.print(symbol);
            }
            System.out.println(symbol);
        }

        for(int i = 0; i < shift6; i++)
        {
            System.out.print(" ");
        }
        System.out.println(symbol);

    }
}
