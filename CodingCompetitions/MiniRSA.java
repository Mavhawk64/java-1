import java.math.*;
import java.util.*;
/**
 * Write a description of class MiniRSA here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MiniRSA
{
    public static ArrayList <BigDecimal> p = new ArrayList<BigDecimal>();
    public static int count = 0;
    public static BigInteger one = new BigInteger("1");
    public static void main ()
    {
        BigInteger n = new BigInteger("29331922499794985782735976045591164936683059380558950386560160105740343201513369939006307531165922708949619162698623675349030430859547825708994708321803705309459438099340427770580064400911431856656901982789948285309956111848686906152664473350940486507451771223435835260168971210087470894448460745593956840586530527915802541450092946574694809584880896601317519794442862977471129319781313161842056501715040555964011899589002863730868679527184420789010551475067862907739054966183120621407246398518098981106431219207697870293412176440482900183550467375190239898455201170831410460483829448603477361305838743852756938687673");
        //n is not prime
        BigInteger e = new BigInteger("3");
        BigInteger c = new BigInteger("2205316413931134031074603746928247799030155221252519872649594750678791181631768977116979076832403970846785672184300449694813635798586699205901153799059293422365185314044451205091048294412538673475392478762390753946407342073522966852394341");

        BigInteger p = cbrt(c);
        BigInteger q = n.divide(p);
        BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));
        //m = c^dmodn
        //d = emodInvphi
        BigInteger d = e.modInverse(phi);
        BigInteger m = c.modPow(d,n);
        System.out.println("P: " + p.toString(16) +"\n" + m.toString(16));
    }

    /**
     * Returns the cube root for big integers.
     * 
     * @param val
     *            Value to compute the cube root of.
     * @return (Rounded down) cube root of argument. That is, a value x such
     *         that x*x*x = val.
     */
    static public BigInteger cbrt(BigInteger val) {
        return root(3, new BigDecimal(val)).toBigInteger();
    }

    /**
     * The integer root.
     * 
     * @param n
     *            the positive argument.
     * @param x
     *            the non-negative argument.
     * @return The n-th root of the BigDecimal rounded to the precision implied
     *         by x, x^(1/n).
     */
    static private BigDecimal root(final int n, final BigDecimal x) {
        if (x.compareTo(BigDecimal.ZERO) < 0) {
            throw new ArithmeticException("negative argument " + x.toString()
                + " of root");
        }
        if (n <= 0) {
            throw new ArithmeticException("negative power " + n + " of root");
        }
        if (n == 1) {
            return x;
        }
        /* start the computation from a double precision estimate */
        BigDecimal s = new BigDecimal(Math.pow(x.doubleValue(), 1.0 / n));
        /*
         * this creates nth with nominal precision of 1 digit
         */
        final BigDecimal nth = new BigDecimal(n);
        /*
         * Specify an internal accuracy within the loop which is slightly larger
         * than what is demanded by Ã‚epsÃ‚ below.
         */
        final BigDecimal xhighpr = scalePrec(x, 2);
        MathContext mc = new MathContext(2 + x.precision());
        /*
         * Relative accuracy of the result is eps.
         */
        final double eps = x.ulp().doubleValue() / (2 * n * x.doubleValue());
        for (;;) {
            /*
             * s = s -(s/n-x/n/s^(n-1)) = s-(s-x/s^(n-1))/n; test correction
             * s/n-x/s for being smaller than the precision requested. The
             * relative correction is (1-x/s^n)/n,
             */
            BigDecimal c = xhighpr.divide(s.pow(n - 1), mc);
            c = s.subtract(c);
            MathContext locmc = new MathContext(c.precision());
            c = c.divide(nth, locmc);
            s = s.subtract(c);
            if (Math.abs(c.doubleValue() / s.doubleValue()) < eps) {
                break;
            }
        }
        return s.round(new MathContext(err2prec(eps)));
    } /* BigDecimalMath.root */

    /**
     * Append decimal zeros to the value. This returns a value which appears to
     * have a higher precision than the input.
     * 
     * @param x
     *            The input value
     * @param d
     *            The (positive) value of zeros to be added as least significant
     *            digits.
     * @return The same value as the input but with increased (pseudo)
     *         precision.
     */
    static private BigDecimal scalePrec(final BigDecimal x, int d) {
        return x.setScale(d + x.scale());
    }

    /**
     * Convert a relative error to a precision.
     * 
     * @param xerr
     *            The relative error in the variable. The value returned depends
     *            only on the absolute value, not on the sign.
     * @return The number of valid digits in x. The value is rounded down, and
     *         on the pessimistic side for that reason.
     */
    static private int err2prec(double xerr) {
        /*
         * Example: an error of xerr=+-0.5 a precision of 1 (digit), an error of
         * +-0.05 a precision of 2 (digits)
         */
        return 1 + (int) (Math.log10(Math.abs(0.5 / xerr)));
    }
}
