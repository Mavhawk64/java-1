import java.util.*;
import java.math.*;
/**
 * Write a description of class EulersMethod here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EulersMethod
{
    public static void main(String [] args)
    {
        System.out.println("Please enter your differential in the form y' = f(x, y) --- Write c*x*y, not cxy if it is in your function.");
        Scanner scan = new Scanner(System.in);
        //EX: y' = x^2 + 3y - 2
        String f = scan.nextLine();
        System.out.println("What is your step-size (h)?");
        // 0.01
        String h = scan.nextLine();
        System.out.println("What is your initial condition? (y(x0) = y0)");
        //y(0) = 1
        String y0s = scan.nextLine();
        System.out.println("And finally, what is your final x value (b)?");
        // 1
        String b = scan.nextLine();

        double hd = new Double(h);
        //double y0d = new Double(y0);
        double x0 = new Double(y0s.substring(2,y0s.indexOf(")")));
        double y0 = new Double(y0s.substring(y0s.indexOf("=") + 1, y0s.length()));
        double bd = new Double(b);
        //double fa = mathMe(f);
        int count = 0;
        f = f.substring(f.indexOf("=") + 1, f.length());
        double yn = euMe(f, hd, x0, y0, bd, count);
        double n = bd / hd;
        System.out.println("Final value: y" + (int)n + " = y("+(int)bd+") = " + yn);
    }

    public static double euMe(String f, double h, double x, double y, double b, int c)
    {
        c++;
        int n = (int)(b / h); //10
        String newF = f;
        newF = replace(newF, 'x', x);
        // System.out.println("NEW F (before y) " + newF);
        newF = replace(newF, 'y', y);
        // System.out.println("NEW F (after y) " + newF);
        double fn = eval(newF);
        double yn = y + h * fn;
        x+=h;
        y=yn;
        if(c != n)
        {
            System.out.println("y"+c+" = "+yn);
            return euMe(f, h, x, y, b, c);
        }
        else
            return yn;
    }

    public static String replace(String f, char get, double take)
    {
        char [] g = f.toCharArray();
        String t = "("+take+")";
        ArrayList <Integer> count = new ArrayList <Integer>();
        String newF = f;
        for(int i = 0; i < g.length; i++)
        {
            if(g[i] == get)
            {
                count.add(new Integer(i+""));
            }
        }
        //  System.out.println("replace before " + newF  + " " + count.size());
        newF = newF.substring(0, (count.get(0)).intValue())  + t + newF.substring((count.get(0)).intValue() + 1, newF.length());
        count.remove(0);
        // System.out.println("replace after " + newF + " " + count.size());
        if(count.size() >= 1)
        {
            return replace(newF, get, take);
        }
        // System.out.println("OOF" + newF);
        return newF;
    }

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }

}