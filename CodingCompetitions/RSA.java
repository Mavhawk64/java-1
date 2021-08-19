import java.math.*;
/**
 * Write a description of class RSA here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RSA
{
    public static void main ()
    {
        //BigInteger x = new BigInteger("6357294171489311547190987615544575133581967886499484091352661406414044440475205342882841236357665973431462491355089413710392273380203038793241564304774271529108729717");
        //BigDecimal y = new BigDecimal("256931246631782714357241556582441991993437399854161372646318659020994329843524306570818293602492485385337029697819837182169818816821461486018802894936801257629375428544752970630870631166355711254848465862207765051226282541748174535990314552471546936536330397892907207943448897073772015986097770443616540466471245438117157152783246654401668267323136450122287983612851171545784168132230208726238881861407976917850248110805724300421712827401063963117423718797887144760360749619552577176382615108244813");
        //System.out.println("Number 1: " + x.pow(3));

        //BigInteger q1 = new BigInteger("92092076805892533739724722602668675840671093008520241548191914215399824020372076186460768206814914423802230398410980218741906960527104568970225804374404612617736579286959865287226538692911376507934256844456333236362669879347073756238894784951597211105734179388300051579994253565459304743059533646753003894558");
        //BigInteger p1 = new BigInteger("97846775312392801037224396977012615848433199640105786119757047098757998273009741128821931277074555731813289423891389911801250326299324018557072727051765547115514791337578758859803890173153277252326496062476389498019821358465433398338364421624871010292162533041884897182597065662521825095949253625730631876636");
        //BigInteger e = new BigInteger("65537"); //NEED d
        //de%((p-1)(q-1)) = 1
        //BigDecimal phi = q1.multiply(p1);
        //de%phi = 1
        //de = phi + 1
        //d = (phi + 1)/e & is whole
        //String phiS = phi.toString();
        //BigDecimal phiO = phi;
        //BigDecimal d = (new BigDecimal(1)).divide(e, new MathContext(5000)).remainder(phi);
        //String dS = d.toString();
        //int i = 0;
        //BigInteger d = e.modInverse(q1.multiply(p1));
        /*while(dS.contains(".") && !dS.substring(dS.indexOf("."), dS.indexOf(".") + 10).contains("00000000"))
        {
        i++;
        //phi = phiO.multiply(new BigDecimal(i));
        //d = (phi.add(new BigDecimal(1))).divide(e, new MathContext(500));
        d = d.multiply(new BigDecimal(i));
        dS = d.toString();

        System.out.println("d is now " + d);
        }*/
        //System.out.println("Number 2: " + d);

        BigInteger p = new BigInteger("153143042272527868798412612417204434156935146874282990942386694020462861918068684561281763577034706600608387699148071015194725533394126069826857182428660427818277378724977554365910231524827258160904493774748749088477328204812171935987088715261127321911849092207070653272176072509933245978935455542420691737433");
        BigInteger e = new BigInteger("65537");
        BigInteger c = new BigInteger("23016653876847472700856653975636134833816267659423093220825802730311792688015526031010185862796820464000740538663367868273628190558574669769926145909966799940743138330542504400318814444877763931323239980099404303323064601116168860363364840864265724602533013776878867287027908763538326145208488830881872675088750689066949453757107611076477999369848061893166820131477255959664458909576462597878213732662606021276850039344887619097192724271061026030900796808157479658550935169474101799591059725002019677640101543801616541273658841153594862740548434726220958512298690110880142486139412015047636595600919146971517653734739");
        BigInteger n = new BigInteger("23952937352643527451379227516428377705004894508566304313177880191662177061878993798938496818120987817049538365206671401938265663712351239785237507341311858383628932183083145614696585411921662992078376103990806989257289472590902167457302888198293135333083734504191910953238278860923153746261500759411620299864395158783509535039259714359526738924736952759753503357614939203434092075676169179112452620687731670534906069845965633455748606649062394293289967059348143206600765820021392608270528856238306849191113241355842396325210132358046616312901337987464473799040762271876389031455051640937681745409057246190498795697239");
        //BigInteger m = new BigInteger("0");
        //m = c^(e(%^-1)(n-p-n/p+1))%n
        BigInteger phiIn = n.subtract(p);
        phiIn = phiIn.subtract(n.divide(p));
        phiIn = phiIn.add(new BigInteger("1"));
        //System.out.println(phiIn);
        BigInteger d = e.modInverse(phiIn);
        //m = (c.pow(d)).mod(n);
        BigInteger m = c.modPow(d, n);
        System.out.println(m);
    }

    public static long ITER = 1000;
    public static BigDecimal cuberoot(BigDecimal b) {
        // Specify a math context with 40 digits of precision.

        MathContext mc = new MathContext(40);

        BigDecimal x = new BigDecimal("1", mc);

        // Search for the cube root via the Newton-Raphson loop. Output each // successive iteration's value.

        for (int i = 0; i < ITER; i++) {
            x = x.subtract(
                x.pow(3, mc)
                .subtract(b, mc)
                .divide(new BigDecimal("3", mc).multiply(
                        x.pow(2, mc), mc), mc), mc);
        }
        return x;
    }

    public static BigDecimal pow(BigDecimal savedValue, BigDecimal value) {
        BigDecimal result = null;
        result = exp(ln(savedValue, 32).multiply(value), 32);
        return result;
    }

    /**
     * Compute e^x to a given scale.
     * Break x into its whole and fraction parts and
     * compute (e^(1 + fraction/whole))^whole using Taylor's formula.
     * @param x the value of x
     * @param scale the desired scale of the result
     * @return the result value
     */
    public static BigDecimal exp(BigDecimal x, int scale) {
        // e^0 = 1
        if (x.signum() == 0) {
            return BigDecimal.valueOf(1);
        }

        // If x is negative, return 1/(e^-x).
        else if (x.signum() == -1) {
            return BigDecimal.valueOf(1).divide(exp(x.negate(), scale),
                scale, BigDecimal.ROUND_HALF_EVEN);
        }

        // Compute the whole part of x.
        BigDecimal xWhole = x.setScale(0, BigDecimal.ROUND_DOWN);

        // If there isn't a whole part, compute and return e^x.
        if (xWhole.signum() == 0)
            return expTaylor(x, scale);

        // Compute the fraction part of x.
        BigDecimal xFraction = x.subtract(xWhole);

        // z = 1 + fraction/whole
        BigDecimal z = BigDecimal.valueOf(1)
            .add(xFraction.divide(xWhole, scale,
                    BigDecimal.ROUND_HALF_EVEN));

        // t = e^z
        BigDecimal t = expTaylor(z, scale);

        BigDecimal maxLong = BigDecimal.valueOf(Long.MAX_VALUE);
        BigDecimal result = BigDecimal.valueOf(1);

        // Compute and return t^whole using intPower().
        // If whole > Long.MAX_VALUE, then first compute products
        // of e^Long.MAX_VALUE.
        while (xWhole.compareTo(maxLong) >= 0) {
            result = result.multiply(intPower(t, Long.MAX_VALUE, scale))
            .setScale(scale, BigDecimal.ROUND_HALF_EVEN);
            xWhole = xWhole.subtract(maxLong);

            Thread.yield();
        }
        return result.multiply(intPower(t, xWhole.longValue(), scale))
        .setScale(scale, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * Compute the natural logarithm of x to a given scale, x > 0.
     */
    public static BigDecimal ln(BigDecimal x, int scale) {
        // Check that x > 0.
        if (x.signum() <= 0) {
            throw new IllegalArgumentException("x <= 0");
        }

        // The number of digits to the left of the decimal point.
        int magnitude = x.toString().length() - x.scale() - 1;

        if (magnitude < 3) {
            return lnNewton(x, scale);
        }

        // Compute magnitude*ln(x^(1/magnitude)).
        else {

            // x^(1/magnitude)
            BigDecimal root = intRoot(x, magnitude, scale);

            // ln(x^(1/magnitude))
            BigDecimal lnRoot = lnNewton(root, scale);

            // magnitude*ln(x^(1/magnitude))
            return BigDecimal.valueOf(magnitude).multiply(lnRoot)
            .setScale(scale, BigDecimal.ROUND_HALF_EVEN);
        }
    }

    /**
     * Compute e^x to a given scale by the Taylor series.
     * @param x the value of x
     * @param scale the desired scale of the result
     * @return the result value
     */
    private static BigDecimal expTaylor(BigDecimal x, int scale) {
        BigDecimal factorial = BigDecimal.valueOf(1);
        BigDecimal xPower = x;
        BigDecimal sumPrev;

        // 1 + x
        BigDecimal sum = x.add(BigDecimal.valueOf(1));

        // Loop until the sums converge
        // (two successive sums are equal after rounding).
        int i = 2;
        do {
            // x^i
            xPower = xPower.multiply(x).setScale(scale,
                BigDecimal.ROUND_HALF_EVEN);

            // i!
            factorial = factorial.multiply(BigDecimal.valueOf(i));

            // x^i/i!
            BigDecimal term = xPower.divide(factorial, scale,
                    BigDecimal.ROUND_HALF_EVEN);

            // sum = sum + x^i/i!
            sumPrev = sum;
            sum = sum.add(term);

            ++i;
            Thread.yield();
        } while (sum.compareTo(sumPrev) != 0);

        return sum;
    }

    /**
     * Compute x^exponent to a given scale.  Uses the same
     * algorithm as class numbercruncher.mathutils.IntPower.
     * @param x the value x
     * @param exponent the exponent value
     * @param scale the desired scale of the result
     * @return the result value
     */
    public static BigDecimal intPower(BigDecimal x, long exponent, int scale) {
        // If the exponent is negative, compute 1/(x^-exponent).
        if (exponent < 0) {
            return BigDecimal.valueOf(1).divide(
                intPower(x, -exponent, scale), scale,
                BigDecimal.ROUND_HALF_EVEN);
        }

        BigDecimal power = BigDecimal.valueOf(1);

        // Loop to compute value^exponent.
        while (exponent > 0) {

            // Is the rightmost bit a 1?
            if ((exponent & 1) == 1) {
                power = power.multiply(x).setScale(scale,
                    BigDecimal.ROUND_HALF_EVEN);
            }

            // Square x and shift exponent 1 bit to the right.
            x = x.multiply(x).setScale(scale, BigDecimal.ROUND_HALF_EVEN);
            exponent >>= 1;

            Thread.yield();
        }

        return power;
    }

    /**
     * Compute the natural logarithm of x to a given scale, x > 0.
     * Use Newton's algorithm.
     */
    private static BigDecimal lnNewton(BigDecimal x, int scale) {
        int sp1 = scale + 1;
        BigDecimal n = x;
        BigDecimal term;

        // Convergence tolerance = 5*(10^-(scale+1))
        BigDecimal tolerance = BigDecimal.valueOf(5).movePointLeft(sp1);

        // Loop until the approximations converge
        // (two successive approximations are within the tolerance).
        do {

            // e^x
            BigDecimal eToX = exp(x, sp1);

            // (e^x - n)/e^x
            term = eToX.subtract(n)
            .divide(eToX, sp1, BigDecimal.ROUND_DOWN);

            // x - (e^x - n)/e^x
            x = x.subtract(term);

            Thread.yield();
        } while (term.compareTo(tolerance) > 0);

        return x.setScale(scale, BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * Compute the integral root of x to a given scale, x >= 0.
     * Use Newton's algorithm.
     * @param x the value of x
     * @param index the integral root value
     * @param scale the desired scale of the result
     * @return the result value
     */
    public static BigDecimal intRoot(BigDecimal x, long index, int scale) {
        // Check that x >= 0.
        if (x.signum() < 0) {
            throw new IllegalArgumentException("x < 0");
        }

        int sp1 = scale + 1;
        BigDecimal n = x;
        BigDecimal i = BigDecimal.valueOf(index);
        BigDecimal im1 = BigDecimal.valueOf(index - 1);
        BigDecimal tolerance = BigDecimal.valueOf(5).movePointLeft(sp1);
        BigDecimal xPrev;

        // The initial approximation is x/index.
        x = x.divide(i, scale, BigDecimal.ROUND_HALF_EVEN);

        // Loop until the approximations converge
        // (two successive approximations are equal after rounding).
        do {
            // x^(index-1)
            BigDecimal xToIm1 = intPower(x, index - 1, sp1);

            // x^index
            BigDecimal xToI = x.multiply(xToIm1).setScale(sp1,
                    BigDecimal.ROUND_HALF_EVEN);

            // n + (index-1)*(x^index)
            BigDecimal numerator = n.add(im1.multiply(xToI)).setScale(sp1,
                    BigDecimal.ROUND_HALF_EVEN);

            // (index*(x^(index-1))
            BigDecimal denominator = i.multiply(xToIm1).setScale(sp1,
                    BigDecimal.ROUND_HALF_EVEN);

            // x = (n + (index-1)*(x^index)) / (index*(x^(index-1)))
            xPrev = x;
            x = numerator.divide(denominator, sp1, BigDecimal.ROUND_DOWN);

            Thread.yield();
        } while (x.subtract(xPrev).abs().compareTo(tolerance) > 0);

        return x;
    }
}

