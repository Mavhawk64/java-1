public class PrintF
{
    public static void main(String [] args)
    {
        /**
        - : left-justify ( default is to right-justify )
        + : output a plus ( + ) or minus ( - ) sign for a numerical value
        0 : forces numerical values to be zero-padded ( default is blank padding )
        , : comma grouping separator (for numbers > 1000)
          : space will display a minus sign if the number is negative or a space if it is positive
         */
        /**
        d : decimal integer [byte, short, int, long]
        f : floating-point number [float, double]
        c : character Capital C will uppercase the letter
        s : String Capital S will uppercase all the letters in the string
        h : hashcode A hashcode is like an address. This is useful for printing a reference
        n : newline Platform specific newline character- use %n instead of \n for greater compatibility
        x : hexadecimal integer
        */

        /**
        System.out.printf("Total is: $%,.2f%n", dblTotal);
        System.out.printf("Total: %-10.2f: ", dblTotal);
        System.out.printf("% 4d", intValue);
        System.out.printf("%20.10s\n", stringVal);
        String s = "Hello World";
        System.out.printf("The String object %s is at hash code %h%n", s, s);
        String grandTotal = String.format("Grand Total: %,.2f", dblTotal);
         */

        System.out.printf("Age: %d", 9, "%n");
        //System.out.println("");
        System.out.printf("\nAnimal: %S", "cow");

        System.out.printf("\nCow: %0s", "moo");
    }
}
