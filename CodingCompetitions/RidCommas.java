
/**
 * Write a description of class RidComm here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RidCommas
{
    public static void main ()
    {
        String xComm = "256,931,246,631,782,714,357,241,556,582,441,991,993,437,399,854,161,372,646,318,659,020,994,329,843,524,306,570,818,293,602,492,485,385,337,029,697,819,837,182,169,818,816,821,461,486,018,802,894,936,801,257,629,375,428,544,752,970,630,870,631,166,355,711,254,848,465,862,207,765,051,226,282,541,748,174,535,990,314,552,471,546,936,536,330,397,892,907,207,943,448,897,073,772,015,986,097,770,443,616,540,466,471,245,438,117,157,152,783,246,654,401,668,267,323,136,450,122,287,983,612,851,171,545,784,168,132,230,208,726,238,881,861,407,976,917,850,248,110,805,724,300,421,712,827,401,063,963,117,423,718,797,887,144,760,360,749,619,552,577,176,382,615,108,244,813";
        char [] xCharcom = xComm.toCharArray();
        for(int i = 0; i < xCharcom.length; i++)
        {
            if(!(xCharcom[i] == (',')))
            System.out.print(xCharcom[i]);
        }
    }
}