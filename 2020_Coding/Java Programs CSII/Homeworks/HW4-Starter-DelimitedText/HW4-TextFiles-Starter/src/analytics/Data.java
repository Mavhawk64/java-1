// COURSE: CSCI1620
// TERM: FALL 2020
// 
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: Classmate assistance was used in the creation of this java program.

package analytics;

/**
 * Set of useful reusable tools for analyzing sets of data.
 * @author mberkland and abdoullatoundji
 */
public class Data
{
	/**
	 * Finds the minimum value in the passed array.
	 * NOTE: The array does not need to be completely populated.
	 * All relevant data to be processed starts at index 0.
	 * Unused elements will be null and should not be considered in computations.
	 * Once the first null is encountered it is assumed remaining elements are unused.
	 * @param <E> - Type of data passed. The type must implement the Comparable interface.
	 * @param data - Collection of data to find minimum value of.
	 * @return Minimum value in passed data.
	 */
	public static <E extends Comparable<E>> E minimum(E[] data)
	{
		if (data.length == 0 || data[0] == null)
		{
			return null;
		}
		E x = data[0];
		for (int i = 0; i < data.length; i++)
		{
			if (data[i] == null)
			{
				break;
			}
			if (data[i].compareTo(x) < 0)
			{
				x = data[i];
			}
		}
		return x;
	}
	
	/**
	 * This is a quick helper method to get the length of the non-null data.
	 * @param <N> - The General Data Type.
	 * @param data - The data that is passed in through the 'super'-methods.
	 * @return - The length of the non-null data.
	 */
	private static <N extends Number> int getNullLength(N[] data)
	{
		int len = data.length;
		for (int i = 0; i < data.length; i++)
		{
			if (data[i] == null)
			{
				len = i;
				break;
			}
		}
		return len;
	}

	/**
	 * Finds the maximum value in the passed array.
	 * NOTE: The array does not need to be completely populated.
	 * All relevant data to be processed starts at index 0.
	 * Unused elements will be null and should not be considered in computations.
	 * Once the first null is encountered it is assumed remaining elements are unused.
	 * @param <E> - Type of data passed. The type must implement the Comparable interface.
	 * @param data - Collection of data to find maximum value of.
	 * @return Maximum value in passed data.
	 */
	public static <E extends Comparable<E>> E maximum(E[] data)
	{
		if (data.length == 0 || data[0] == null)
		{
			return null;
		}
		E x = data[0];
		for (int i = 1; i < data.length; i++)
		{
			if (data[i] == null)
			{
				break;
			}
			if (data[i].compareTo(x) > 0)
			{
				x = data[i];
			}
		}
		return x;
	}
	
	/**
	 * Finds the average of values in the passed array.
	 * NOTE: The array does not need to be completely populated.
	 * All relevant data to be processed starts at index 0.
	 * Unused elements will be null and should not be considered in computations.
	 * Once the first null is encountered it is assumed remaining elements are unused.
	 * @param <N> - Type of data passed. The type must extend the Number class.
	 *  See the assignment supplemental for useful information on the Number class.
	 * @param data - Collection of data to find average of.
	 * @return Average of passed data. Regardless of type passed will always return a Double.
	 *  This means if no results are in data it will return Double's "Divide By 0" value, NaN,
	 *  which it should do automatically.
	 */
	public static <N extends Number> Double average(N[] data)
	{
		Double denominator = Double.valueOf(getNullLength(data));
		if (denominator.equals(Double.valueOf(0)))
		{
			return Double.NaN;
		}
		Double numerator = data[0].doubleValue();
		for (int i = 1; i < getNullLength(data); i++)
		{
			numerator = data[i].doubleValue() + numerator;
		}
		return numerator / denominator;
	}
	
	
	/**
	 * Finds the population standard deviation of values in the passed array.
	 * NOTE: The array does not need to be completely populated.
	 * All relevant data to be processed starts at index 0.
	 * Unused elements will be null and should not be considered in computations.
	 * Once the first null is encountered it is assumed remaining elements are unused.
	 * @param <N> - Type of data passed. The type must extend the Number class.
	 *  See the assignment supplemental for useful information on the Number class.
	 * @param data - Collection of data to find standard deviation of.
	 * @return Population Standard Deviation of passed data. Regardless of type passed will always return a Double.
	 *  This means if no results are in data it will return Double's "Divide By 0" value, NaN,
	 *  which it should do automatically.

	 */
	public static <N extends Number> Double standardDeviation(N[] data)
	{
		Double sigma = 0.0;
		Double mean = average(data);
		int len = getNullLength(data);
		if (len < 1)
		{
			return Double.NaN;
		}
		for (int i = 0; i < len; i++)
		{
			sigma += Math.pow(data[i].doubleValue() - mean, 2);
		}
		sigma = sigma / len;
		sigma = Math.sqrt(sigma);
		return sigma;
	}
}
