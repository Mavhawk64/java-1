
/**
 * Write a description of class SubstringCheck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SubstringCheck
{
    public static void main(String args[])
    {
        int len1 = ("/bot ticker: TSLA ").length();
        String yyy1 = "/bot ticker: TSLA 2015-03-14 2020-01-31".substring(len1, len1 + 4);
        len1 += 5;
        String mm1 = "/bot ticker: TSLA 2015-03-14 2020-01-31".substring(len1, len1 + 2);
        len1 += 3;
        String dd1 = "/bot ticker: TSLA 2015-03-14 2020-01-31".substring(len1, len1 + 2);
        len1 += 3;
        String yyy2 = "/bot ticker: TSLA 2015-03-14 2020-01-31".substring(len1, len1 + 4);
        len1 += 5;
        String mm2 = "/bot ticker: TSLA 2015-03-14 2020-01-31".substring(len1, len1 + 2);
        len1 += 3;
        String dd2 = "/bot ticker: TSLA 2015-03-14 2020-01-31".substring(len1, len1 + 2);
        System.out.println(yyy1 + " " + mm1 + " " + dd1 + " " + yyy2 + " " + mm2 + " " + dd2);
        System.out.println("/bot ticker: T 2015-03-14 2020-01-31".length());
    }
}
